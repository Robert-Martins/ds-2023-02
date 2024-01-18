import { Component, Injector } from '@angular/core';
import { UtilComponent } from '../../shared/components/util/util.component';

@Component({
  selector: 'app-room',
  standalone: true,
  imports: [],
  templateUrl: './room.component.html',
  styleUrl: './room.component.css'
})
export class RoomComponent extends UtilComponent {

  constructor(
    private injector: Injector
  ) {
    super(injector);
  }
  
}