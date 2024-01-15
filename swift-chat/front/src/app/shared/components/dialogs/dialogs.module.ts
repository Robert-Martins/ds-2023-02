import { NgModule } from '@angular/core';
import { CommonModule, NgComponentOutlet } from '@angular/common';
import { ShareChatDialogComponent } from './share-chat-dialog/share-chat-dialog.component';
import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';
import { QrcodeComponent } from './share-chat-dialog/qrcode/qrcode.component';
import { DialogComponent } from './dialog.component';
import { ContainersModule } from '../containers/containers.module';
import { DirectivesModule } from '../../directives/directives.module';



@NgModule({
  declarations: [
    ShareChatDialogComponent,
    ConfirmationDialogComponent,
    QrcodeComponent,
    DialogComponent,
  ],
  imports: [
    CommonModule,
    NgComponentOutlet,
    ContainersModule,
    DirectivesModule
  ],
  exports: [
    DialogComponent
  ]
})
export class DialogsModule { }
