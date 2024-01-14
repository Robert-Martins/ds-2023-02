import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { DialogsService } from '../dialogs.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'swift-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrl: './confirmation-dialog.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ConfirmationDialogComponent {

  private readonly defaultIconClass: string = 'confirmation-dialog-icon';

  @Input()
  public set icon(iconName: string) {
    this.iconClass = iconName ? `${this.defaultIconClass} ${iconName ?? ''}` : null;
  }

  @Input()
  public set text(confirmationText: string) {
    this.confirmationText$.next(confirmationText);
  }

  public confirmationText$: BehaviorSubject<string> = new BehaviorSubject(null);

  public iconClass: string = this.defaultIconClass;

  constructor(
    private dialogService: DialogsService
  ) {
  }

  public onClickOption(bool: boolean): void {
    this.dialogService.close(bool);
  }

}
