import { Injectable, OnDestroy, Renderer2, RendererFactory2 } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoadingService implements OnDestroy {

  public loading$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  private htmlBody: HTMLBodyElement;

  private renderer: Renderer2;

  private readonly overflowHiddenClass = 'overflow-hidden';

  constructor(
    private rendererFactory: RendererFactory2
  ) { 
    this.renderer = this.rendererFactory.createRenderer(null, null);
    this.htmlBody = document.querySelector('body');
  }

  ngOnDestroy(): void {
      this.loading$.unsubscribe();
  }

  public start(): void {
    this.renderer.addClass(this.htmlBody, this.overflowHiddenClass);
    this.loading$.next(true);
  }

  public stop(): void {
    this.renderer.removeClass(this.htmlBody, this.overflowHiddenClass);
    this.loading$.next(false);
  }

}
