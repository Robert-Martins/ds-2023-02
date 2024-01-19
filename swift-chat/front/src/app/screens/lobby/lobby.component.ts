import { ChangeDetectionStrategy, Component, Injector } from '@angular/core';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';
import { ChatRoomService } from '../../core/services/chat-room.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ChatRoom } from '../../core/models/chat-room.model';
import { BehaviorSubject } from 'rxjs';
import { ChatRoomUserService } from '../../core/services/chat-room-user.service';
import { ChatService } from '../../core/services/chat.service';
import { UserService } from '../../core/services/user.service';

@Component({
  selector: 'app-lobby',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './lobby.component.html',
  styleUrl: './lobby.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class LobbyComponent extends UtilComponent {

  public chatRoom$: BehaviorSubject<ChatRoom> = new BehaviorSubject(null);

  constructor(
    private chatRoomService: ChatRoomService,
    private chatRoomUserService: ChatRoomUserService,
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute,
    injector: Injector
  ) {
    super(injector);
    this.getRouteData();
  }

  public join(): void {
    this.loading.start();
    const chatRoomId: string = this.chatRoom$.value?.id;
    const userId: string = this.userService.getUserId();
    this.chatRoomUserService.join(
      chatRoomId,
      userId
    ).subscribe({
      next: () => {
        this.router.navigate([`/chat/${chatRoomId}`]);
      },
      error: error => {
        this.chatRoom$.next(null);
        this.snack.error(error?.message);
        this.snack.info('Você será redirecionado para a Home');
        this.loading.stop();
        this.router.navigate(['']);
      }
    });
  }

  private getRouteData(): void {
    this.loading.start();
    this.route.paramMap.subscribe({
      next: (map: ParamMap) => {
        this.findChatRoomById(map.get('id'));
      },
      error: () => {
        this.snack.error("Acesso inválido");
      }
    });
  }

  private findChatRoomById(id: string): void {
    this.chatRoomService.read(id)
      .subscribe({
        next: (chatRoom: ChatRoom) => {
          this.chatRoomService.persistChatRoomId(chatRoom?.id);
          this.chatRoom$.next(chatRoom);
          this.loading.stop();
        },
        error: error => {
          this.snack.error(error?.message);
          this.loading.stop();
        }
      });
  }
  
}
