import { Component } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ChatRoomService } from '../../core/services/chat-room.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-code',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './code.component.html',
  styleUrl: './code.component.css'
})
export class CodeComponent {

  constructor(
    private chatRoomService: ChatRoomService,
    private router: Router
  ) {

  }

  public onCodeComplete(code: string): void {
    this.chatRoomService.getIdByCode(code)
      .subscribe(
        {
          next: (id: string) => {
            this.router.navigate([`lobby/${id}`]);
          },
          error: (error) => {
            
          }
        }
      );
  }

}
