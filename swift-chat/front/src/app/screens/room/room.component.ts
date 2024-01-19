import { Component, Injector, OnInit } from '@angular/core';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';
import { FormBuilder, FormControl, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ChatRoomUserService } from '../../core/services/chat-room-user.service';
import { UserService } from '../../core/services/user.service';
import { ChatRoomUser } from '../../core/models/chat-room-user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-room',
  standalone: true,
  imports: [SharedModule, FormsModule, ReactiveFormsModule],
  templateUrl: './room.component.html',
  styleUrl: './room.component.css'
})
export class RoomComponent extends UtilComponent implements OnInit {

  public roomNameControl: FormControl;

  constructor(
    private chatRoomUserService: ChatRoomUserService,
    private userService: UserService,
    private fb: FormBuilder,
    private router: Router,
    injector: Injector
  ) {
    super(injector);
  }

  ngOnInit(): void {
    this.createRoomNameControl();
  }

  public onClickCreate(): void {
    if(this.userService.isUser) {
      this.loading.start();
      this.chatRoomUserService.create(
        this.roomNameControl.value,
        this.userService.getUserId()
      ).subscribe({
        next: (chat: ChatRoomUser) => {
          this.loading.stop();
          this.router.navigate([`/chat/${chat?.chatRoom?.id}?role=ADMIN`]);
        },
        error: error => {
          this.loading.stop();
          this.snack.error(error?.message);
        }
      });
    }
  }

  private createRoomNameControl(): void {
    this.roomNameControl = this.fb.control('', [Validators.required, Validators.maxLength(20)]);
  }
  
}