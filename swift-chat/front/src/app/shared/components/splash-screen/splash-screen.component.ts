import { ChangeDetectionStrategy, Component, OnDestroy } from '@angular/core';
import { LoadingService } from './loading.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'swift-splash-screen',
  template: `
    <div 
      *ngIf="isLoading$ | async as isLoading" 
      class="splash-screen"
    >
      <span>
        <svg viewBox="0 0 86 80">
          <polygon points="43 8 79 72 7 72"></polygon>
        </svg>
      </span>
    </div>
  `,
  styleUrl: './splash-screen.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SplashScreenComponent implements OnDestroy {

  public isLoading$: BehaviorSubject<boolean>;

  constructor(
    private loadingService: LoadingService
  ) {
    this.isLoading$ = this.loadingService.loading$;
  }

  ngOnDestroy(): void {
      this.isLoading$.unsubscribe();
  }

}
