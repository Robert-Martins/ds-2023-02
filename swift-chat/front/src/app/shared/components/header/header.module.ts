import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChatHeaderComponent } from './chat-header/chat-header.component';



@NgModule({
  declarations: [
    ChatHeaderComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ChatHeaderComponent
  ]
})
export class HeaderModule { }
