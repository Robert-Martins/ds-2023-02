import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SwiftButtonDirective } from './swift-button.directive';
import { CopyToClipboardDirective } from './copy-to-clipboard.directive';
import { TooltipDirective } from './tooltip.directive';



@NgModule({
  declarations: [
    SwiftButtonDirective,
    CopyToClipboardDirective,
    TooltipDirective
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SwiftButtonDirective,
    CopyToClipboardDirective,
    TooltipDirective
  ]
})
export class DirectivesModule { }
