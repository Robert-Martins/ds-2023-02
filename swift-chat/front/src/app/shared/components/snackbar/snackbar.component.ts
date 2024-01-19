import { ChangeDetectionStrategy, Component, OnDestroy } from '@angular/core';
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
            top: '120%',
            opacity: '0.1'
          })
        ),
        state(
          'up',
          style({
            top: '88%',
            opacity: '1.0'
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
    <div *ngIf="snack$ | async as snack" [@popUp]="(isUp$ | async) ? 'up' : 'down'" class="snackbar">
      <p>{{snack?.message}}</p>
    </div>
  `,
  styleUrl: './snackbar.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SnackbarComponent implements OnDestroy {

  public isUp$: BehaviorSubject<boolean> = new BehaviorSubject(false);

  public snack$: BehaviorSubject<Snack>;

  private readonly animationTimeout: number = 5000;

  constructor(
    private snackbarService: SnackbarService
  ) {
    this.snack$ = this.snackbarService.snack$;
    this.snackbarService.onSnackAssign = this.performAnimation;
  }

  ngOnDestroy(): void {
    this.isUp$.unsubscribe();
    this.snack$.unsubscribe();
  }

  private performAnimation = (): void => {
    this.isUp$.next(true);
    setTimeout(
      () => this.isUp$.next(false),
      this.animationTimeout
    );
  }

}
