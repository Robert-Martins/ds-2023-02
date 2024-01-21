import { Component, Injector, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ChatRoomUser } from '../../core/models/chat-room-user.model';
import { ChatRoomUserService } from '../../core/services/chat-room-user.service';
import { UserService } from '../../core/services/user.service';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-room',
  standalone: true,
  imports: [SharedModule, FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './room.component.html'
})
export class RoomComponent extends UtilComponent implements OnInit {
  
  public roomNameControl: FormControl;

  constructor(
    private chatRoomUserService: ChatRoomUserService,
    private userService: UserService,
    private fb: FormBuilder,
    injector: Injector
  ) {
    super(injector);
  }

  ngOnInit(): void {
    this.createRoomNameControl();
  }

  public onClickCreate(): void {
    if (this.userService.isUser) {
      this.loading.start();
      this.chatRoomUserService
        .create(this.roomNameControl.value, this.userService.getUserId())
        .subscribe({
          next: (chat: ChatRoomUser) => {
            this.loading.stop();
            this.router.navigate([`/chat/${chat?.chatRoom?.id}`]);
          },
          error: (error) => this.handleError(error),
        });
    }
  }

  private createRoomNameControl(): void {
    this.roomNameControl = this.fb.control('', [
      Validators.required,
      Validators.maxLength(20),
    ]);
  }
}
