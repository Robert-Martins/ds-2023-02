import { Component, Injector } from '@angular/core';
import { UtilComponent } from '../../shared/components/util/util.component';

@Component({
  selector: 'app-lobby',
  standalone: true,
  imports: [],
  templateUrl: './lobby.component.html',
  styleUrl: './lobby.component.css',
})
export class LobbyComponent extends UtilComponent {

  constructor(
    private injector: Injector
  ) {
    super(injector);
  }
  
}
