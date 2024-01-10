import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MessagesComponent } from './messages/messages.component';
import { UsersComponent } from './users/users.component';



@NgModule({
  declarations: [
    MessagesComponent,
    UsersComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    MessagesComponent,
    UsersComponent
  ]
})
export class ListsModule { }
