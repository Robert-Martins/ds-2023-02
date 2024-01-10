import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SwiftButtonDirective } from './swift-button.directive';



@NgModule({
  declarations: [
    SwiftButtonDirective
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SwiftButtonDirective
  ]
})
export class DirectivesModule { }
