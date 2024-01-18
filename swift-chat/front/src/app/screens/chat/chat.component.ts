import { Component, Injector } from '@angular/core';
import { UtilComponent } from '../../shared/components/util/util.component';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css',
})
export class ChatComponent extends UtilComponent {

  constructor(
    private injector: Injector
  ) {
    super(injector);
  }
  
}
