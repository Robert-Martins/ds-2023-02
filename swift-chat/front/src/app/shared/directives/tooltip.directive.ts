import { DOCUMENT } from '@angular/common';
import { Directive, ElementRef, HostListener, Inject, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[swiftTooltip]'
})
export class TooltipDirective {

  private tooltip: HTMLSpanElement;

  private readonly TOOLTIP_CLASS: string = "swift-tooltip";

  private readonly TOOLTIP_SHOW_CLASS: string = "show";

  private readonly TOOLTIP_HIDE_CLASS: string = "hide";

  private readonly TOOLTIP_PARENT_CLASS: string = "tooltip-parent";

  @Input()
  public swiftTooltip: string;

  @HostListener("window:mouseover")
  public showTooltip(): void {
    const tooltipElement: HTMLSpanElement = this.tooltip;
    this.renderer.removeClass(tooltipElement, this.TOOLTIP_HIDE_CLASS);
    this.renderer.addClass(tooltipElement, this.TOOLTIP_SHOW_CLASS);
  }

  @HostListener("window:mouseout")
  public hideTooltip(): void {
    const tooltipElement: HTMLSpanElement = this.tooltip;
    this.renderer.removeClass(tooltipElement, this.TOOLTIP_SHOW_CLASS);
    this.renderer.addClass(tooltipElement, this.TOOLTIP_HIDE_CLASS);
  }

  constructor(
    private renderer: Renderer2,
    private elementRef: ElementRef,
    @Inject(DOCUMENT) private document: Document
  ) { 
    this.createTooltip();
  }

  private createTooltip(): void {
    const parentElement: any = this.elementRef.nativeElement;
    const tooltip: HTMLSpanElement = this.document.createElement('span');
    this.renderer.addClass(tooltip, `${this.TOOLTIP_CLASS} ${this.TOOLTIP_HIDE_CLASS}`);
    this.renderer.addClass(parentElement, this.TOOLTIP_PARENT_CLASS);
    this.renderer.appendChild(parentElement, tooltip);
    this.tooltip = tooltip;
  }

}
