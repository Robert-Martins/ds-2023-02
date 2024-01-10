import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChatSidebarComponent } from './chat-sidebar/chat-sidebar.component';



@NgModule({
  declarations: [
    ChatSidebarComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ChatSidebarComponent
  ]
})
export class SidebarModule { }
