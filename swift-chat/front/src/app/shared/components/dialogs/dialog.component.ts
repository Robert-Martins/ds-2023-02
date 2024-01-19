import { ChangeDetectionStrategy, Component, OnDestroy } from '@angular/core';
import { DialogsService } from './dialogs.service';
import { BehaviorSubject } from 'rxjs';
import { DialogComponentData } from './dialog.types';

@Component({
  selector: 'swift-dialog',
  templateUrl: './dialog.component.html',
  styleUrl: './dialog.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DialogComponent implements OnDestroy {

  public open$: BehaviorSubject<boolean> = new BehaviorSubject(null);

  public dialogComponentData$: BehaviorSubject<DialogComponentData> = new BehaviorSubject(null);

  constructor(
    private dialogsService: DialogsService
  ) {
    this.open$ = this.dialogsService.open$;
    this.dialogComponentData$ = this.dialogsService.dialogComponentData$;
  }

  ngOnDestroy(): void {
    this.open$.unsubscribe();
    this.dialogComponentData$.unsubscribe();
  }

  public onClickDialogWrapper(): void {
    this.dialogsService.close();
  }

}
