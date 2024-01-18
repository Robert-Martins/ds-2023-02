import { Component, Injector } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ChatRoomService } from '../../core/services/chat-room.service';
import { Router } from '@angular/router';
import { SnackbarService } from '../../shared/components/snackbar/snackbar.service';
import { LoadingService } from '../../shared/components/splash-screen/loading.service';
import { UtilComponent } from '../../shared/components/util/util.component';

@Component({
  selector: 'app-code',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './code.component.html',
  styleUrl: './code.component.css'
})
export class CodeComponent extends UtilComponent {

  constructor(
    private chatRoomService: ChatRoomService,
    private router: Router,
    private injector: Injector
  ) {
    super(injector);
  }

  public onCodeComplete = (code: string): void => {
    console.log(code)
    /* this.chatRoomService.getIdByCode(code)
      .subscribe(
        {
          next: (id: string) => {
            this.router.navigate([`lobby/${id}`]);
          },
          error: (error) => {
            
          }
        }
      ); */
  }

}
