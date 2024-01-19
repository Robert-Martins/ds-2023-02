import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'swift-avatar',
  templateUrl: './avatar.component.html',
  styleUrl: './avatar.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AvatarComponent {

  public username$: BehaviorSubject<string> = new BehaviorSubject(null);

  @Input()
  public set username(username: string) {
    this.username$.next(username);
  }

}
