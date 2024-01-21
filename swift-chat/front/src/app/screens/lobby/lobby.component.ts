import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, Injector, OnDestroy } from '@angular/core';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';
import { ChatRoomService } from '../../core/services/chat-room.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ChatRoom } from '../../core/models/chat-room.model';
import { BehaviorSubject } from 'rxjs';
import { ChatRoomUserService } from '../../core/services/chat-room-user.service';
import { UserService } from '../../core/services/user.service';

@Component({
  selector: 'app-lobby',
  standalone: true,
  imports: [CommonModule, SharedModule],
  templateUrl: './lobby.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class LobbyComponent extends UtilComponent implements OnDestroy {

  public chatRoom$: BehaviorSubject<ChatRoom> = new BehaviorSubject(null);

  constructor(
    private chatRoomService: ChatRoomService,
    private chatRoomUserService: ChatRoomUserService,
    private userService: UserService,
    private route: ActivatedRoute,
    injector: Injector
  ) {
    super(injector);
    this.getRouteData();
  }

  ngOnDestroy(): void {
    this.chatRoom$.unsubscribe();   
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
        this.loading.stop();
        this.router.navigate([`/chat/${chatRoomId}`]);
      },
      error: error => {
        this.chatRoom$.next(null);
        this.handleError(error);
        this.onLoadChatError();
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
        this.onLoadChatError();
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
        error: (error) => {
          this.handleError(error);
          this.onLoadChatError();
        }
      });
  }
  
}
