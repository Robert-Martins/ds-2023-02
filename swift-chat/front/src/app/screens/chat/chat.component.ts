import { CommonModule } from '@angular/common';
import { Component, Injector } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, ParamMap, RouterModule } from '@angular/router';
import { Message } from '../../core/models/message.model';
import { ChatService } from '../../core/services/chat.service';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';
import { ChatRoomUserService } from '../../core/services/chat-room-user.service';
import { BehaviorSubject } from 'rxjs';
import { ChatEvent } from '../../core/models/chat-event.model';
import { UserService } from '../../core/services/user.service';
import { ChatRoomUser } from '../../core/models/chat-room-user.model';
import { AppService } from '../../core/services/app.service';
import { Enum } from '../../core/types/types';
import { ConfirmationDialogComponent } from '../../shared/components/dialogs/confirmation-dialog/confirmation-dialog.component';
import { MessageService } from '../../core/services/message.service';
import { ShareChatDialogComponent } from '../../shared/components/dialogs/share-chat-dialog/share-chat-dialog.component';
import { ChatRoom } from '../../core/models/chat-room.model';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    SharedModule,
  ],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
})
export class ChatComponent extends UtilComponent {

  public chatRoomUser$: BehaviorSubject<ChatRoomUser> = new BehaviorSubject(null);

  public events$: BehaviorSubject<ChatEvent[]> = new BehaviorSubject([]);

  public roles$: BehaviorSubject<Enum[]> = new BehaviorSubject([]);

  messages: Message[] = [];
  newMessage: string = '';

  constructor(
    private chatRoomUserService: ChatRoomUserService,
    private chatService: ChatService,
    private userService: UserService,
    private messageService: MessageService,
    private appService: AppService,
    private route: ActivatedRoute,
    injector: Injector
    ) {
    super(injector);
    this.chatService.setEventReceivedCallback(this.onEventReceived);
  }

  ngOnInit() {
    this.onChatAccess();
    this.addSampleMessages();
  }

  sendMessage() {
    if (this.newMessage.trim() !== '') {
      const chatRoomUserDto = {};

      /* const newMessage = new Message(null, this.newMessage, chatRoomUser);
         this.chatService.sendMessage(newMessage); */

      this.newMessage = '';
    }
  }

  receiveMessage(message: Message) {
    this.messages.push(message);
  }

  isSender(message: Message): boolean {
    return message.author.name === 'User'; //trocar pro sender
  }

  addSampleMessages() {
    const userMessage1 = new Message(null, 'Lorem ipsum dolor sit amet', {
      id: '1',
      name: 'User',
    });
    const otherPersonMessage1 = new Message(null, 'Consectetur adipiscing elit', {
      id: '2',
      name: 'Sender',
    });
    const userMessage2 = new Message(null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', {
      id: '1',
      name: 'User',
    });
    const otherPersonMessage2 = new Message(null, 'Molestie ac feugiat sed lectus vestibulum mattis.', {
      id: '2',
      name: 'Sender',
    });

    this.messages.push(
      userMessage1,
      otherPersonMessage1,
      userMessage2,
      otherPersonMessage2
    );
  }

  public onClickExit(): void {
    this.dialog.open(
      ConfirmationDialogComponent,
      {
        inputs: {
          text: 'Deseja sair do Chat?'
        },
        onClose: this.handleConfirmationOption
      }
    );
  } 

  public onClickShare(): void {
    const chatRoom: ChatRoom = this.chatRoomUser$.value?.chatRoom;
    this.dialog.open(
      ShareChatDialogComponent,
      {
        inputs: {
          chatRoomId: chatRoom?.id,
          chatRoomCode: chatRoom?.code
        }
      }
    );
  }

  public submitMessage(): void {

  }

  private handleConfirmationOption = (bool: any): void => {
    if(bool)
      this.onLeave();
  }

  private onLeave(): void {
    this.loading.start();
    const chatRoomUser: ChatRoomUser = this.chatRoomUser$.value;
    const userId: string = chatRoomUser?.user?.id;
    const chatRoomId: string = chatRoomUser?.chatRoom?.id;
    this.chatRoomUserService.left(
      chatRoomId,
      userId
    ).subscribe({
      next: () => {
        this.chatService.close();
        this.loading.stop();
        this.router.navigate([""]);
      },
      error: error => {
        this.snack.error(error?.message);
        this.loading.stop();
      }
    })
  }

  private onChatAccess(): void {
    this.loading.start();
    this.loadRoles();
    this.route.paramMap.subscribe({
      next: (map: ParamMap) => {
        this.findChatRoomUserById(map.get('id'));
      },
      error: () => {
        this.snack.error("Acesso inválido");
        this.onLoadChatError();
      }
    });
  }

  private findChatRoomUserById(chatRoomId: string): void {
    const userId: string = this.userService.getUserId();
    this.chatRoomUserService.read(chatRoomId, userId)
      .subscribe({
        next: async (chatRoomUser: ChatRoomUser) => {
          await this.chatService.connect(chatRoomId);
          this.chatRoomUser$.next(chatRoomUser);
          this.events$.next(
            chatRoomUser?.chatRoom?.messages
              ?.map(ChatEvent.buildFromMessage)
          );
          this.loading.stop();
        },
        error: error => {
          this.snack.error(error?.message);
          this.snack.info("Retornando para o lobby");
          this.router.navigate([`/lobby${chatRoomId}`]);
        }
      });
  }

  private loadRoles(): void {
    this.appService.loadEnumByType("")
      .subscribe({
        next: (enums: Enum[]) => {
          this.roles$.next(enums);
        },
        error: (error: any) => {
          this.snack.error(error?.message);
          this.onLoadChatError();
        }
      })
  }

  private onEventReceived = (event: ChatEvent): void => {
    const events: ChatEvent[] = this.events$.value;
    events.push(event);
    this.events$.next(events);
  }

}
