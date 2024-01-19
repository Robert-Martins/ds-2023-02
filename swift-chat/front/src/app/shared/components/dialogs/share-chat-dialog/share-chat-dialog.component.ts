import { ChangeDetectionStrategy, Component, Input, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { SnackbarService } from '../../snackbar/snackbar.service';

@Component({
  selector: 'swift-share-chat-dialog',
  templateUrl: './share-chat-dialog.component.html',
  styleUrl: './share-chat-dialog.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ShareChatDialogComponent implements OnDestroy {

  public chatRoomUrl$: BehaviorSubject<string> = new BehaviorSubject(null);

  public chatRoomCode$: BehaviorSubject<string> = new BehaviorSubject(null);

  public qrCodeUrl$: BehaviorSubject<string> = new BehaviorSubject(null);

  private readonly COPY_TO_CLIPBOARD_MESSAGE: string = "Copiado para a área de transferência";

  @Input()
  public set chatRoomId(id: string) {
    this.chatRoomUrl$.next(this.buildChatRoomUrl(id));
  }

  @Input()
  public set chatRoomCode(code: string) {
    this.chatRoomCode$.next(code);
  }

  constructor(
    private router: Router,
    private snack: SnackbarService
  ) {
  }

  ngOnDestroy(): void {
    this.chatRoomCode$.unsubscribe();
    this.chatRoomUrl$.unsubscribe();
    this.qrCodeUrl$.unsubscribe();
  }

  public onCopy(): void {
    this.snack.info(this.COPY_TO_CLIPBOARD_MESSAGE);
  }

  private buildChatRoomUrl(id: string): string {
    return `${this.router.url.slice(0, this.router.url.lastIndexOf('/'))}/lobby/${id}`;
  }

}
