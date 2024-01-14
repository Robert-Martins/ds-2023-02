import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SwiftButtonDirective } from './swift-button.directive';
import { CopyToClipboardDirective } from './copy-to-clipboard.directive';



@NgModule({
  declarations: [
    SwiftButtonDirective,
    CopyToClipboardDirective
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SwiftButtonDirective,
    CopyToClipboardDirective
  ]
})
export class DirectivesModule { }
