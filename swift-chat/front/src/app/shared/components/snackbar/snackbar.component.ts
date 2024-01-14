import { ChangeDetectionStrategy, Component } from '@angular/core';
import { Snack } from './snackbar.types';
import { BehaviorSubject } from 'rxjs';
import { SnackbarService } from './snackbar.service';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'swift-snackbar',
  animations: [
    trigger(
      'popUp',
      [
        state(
          'down', 
          style({
            top: '120%'
          })
        ),
        state(
          'up',
          style({
            top: '80%'
          })
        ),
        transition(
          '* => *',
          [animate('0.5s')]
        )
      ]
    )
  ],
  template: `
    <div *ngIf="snack$ | async as snack" [@popUp]="isUp ? 'up' : 'down'" class="snackbar">
      <p>{{snack?.message}}</p>
    </div>
  `,
  styleUrl: './snackbar.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SnackbarComponent {

  public isUp: boolean = false;

  public snack$: BehaviorSubject<Snack>;

  private readonly animationTimeout: number = 5000;

  constructor(
    private snackbarService: SnackbarService
  ) {
    this.snack$ = this.snackbarService.snack$;
    this.snackbarService.onSnackAssign = this.performAnimation;
  }

  private performAnimation = (): void => {
    this.isUp = false;
    setTimeout(
      () => this.isUp = false,
      this.animationTimeout
    );
  }

}
