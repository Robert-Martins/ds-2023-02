import { ChangeDetectionStrategy, Component, Input, OnDestroy } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'swift-avatar',
  template: `
    <div *ngIf="username$ | async as name" [swiftTooltip]="name" class="swift-avatar">
      <p>{{ name | acronym }}</p>
    </div>
  `,
  styleUrl: './avatar.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AvatarComponent implements OnDestroy {

  public username$: BehaviorSubject<string> = new BehaviorSubject(null);

  @Input()
  public set username(username: string) {
    this.username$.next(username);
  }

  ngOnDestroy(): void {
    this.username$.unsubscribe();
  }

}
