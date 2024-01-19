import { CommonModule } from '@angular/common';
import { Component, Injector } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { Message } from '../../core/models/message.model';
import { ChatService } from '../../core/services/chat.service';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterOutlet,
    RouterModule,
    SharedModule,
  ],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
})
export class ChatComponent extends UtilComponent {
  messages: Message[] = [];
  newMessage: string = '';

  constructor(private injector: Injector, private chatService: ChatService) {
    super(injector);

    /* this.chatService.subscribeToMessages().subscribe((message) => {
      this.receiveMessage(message);
    }); */
  }

  ngOnInit() {
    this.addSampleMessages();
  }

  sendMessage() {
    if (this.newMessage.trim() !== '') {
      const chatRoomUserDto = {};

      /* const newMessage = new Message(null, this.newMessage, chatRoomUser);
         this.chatService.sendMessage(newMessage); */

      this.newMessage = '';
    }
  }

  receiveMessage(message: Message) {
    this.messages.push(message);
  }

  isSender(message: Message): boolean {
    return message.author.name === 'User'; //trocar pro sender
  }

  addSampleMessages() {
    const userMessage1 = new Message(null, 'Lorem ipsum dolor sit amet', {
      id: '1',
      name: 'User',
    });
    const otherPersonMessage1 = new Message(null, 'Consectetur adipiscing elit', {
      id: '2',
      name: 'Sender',
    });
    const userMessage2 = new Message(null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', {
      id: '1',
      name: 'User',
    });
    const otherPersonMessage2 = new Message(null, 'Molestie ac feugiat sed lectus vestibulum mattis.', {
      id: '2',
      name: 'Sender',
    });

    this.messages.push(
      userMessage1,
      otherPersonMessage1,
      userMessage2,
      otherPersonMessage2
    );
  }
}
