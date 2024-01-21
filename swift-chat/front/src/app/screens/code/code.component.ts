import { Component, Injector } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ChatRoomService } from '../../core/services/chat-room.service';
import { UtilComponent } from '../../shared/components/util/util.component';

@Component({
  selector: 'app-code',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './code.component.html'
})
export class CodeComponent extends UtilComponent {

  constructor(
    private chatRoomService: ChatRoomService,
    injector: Injector
  ) {
    super(injector);
  }

  public onCodeComplete(code: string): void {
    this.loading.start();
    console.log(this);
    this.chatRoomService.getIdByCode(code)
      .subscribe(
        {
          next: (id: string) => {
            this.loading.stop();
            this.router.navigate([`lobby/${id}`]);
          },
          error: (error) => this.handleError(error)
        }
      );
  }

}
