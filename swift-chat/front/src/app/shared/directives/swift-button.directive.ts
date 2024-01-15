import { Directive, ElementRef, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[swiftButton]'
})
export class SwiftButtonDirective {

  @Input()
  public swiftButtonType: 'flat' | 'icon' = 'flat';

  @Input()
  public swiftButtonGhost: boolean = false;

  @Input()
  public swiftButtonIcon?: string = '';

  constructor(
    private renderer: Renderer2,
    private elementRef: ElementRef
  ) { 
    this.renderer.setAttribute(this.elementRef.nativeElement, 'class', this.buildClasses().trim());
  }

  private buildClasses(): string {
    return `swift-button ${this.swiftButtonType} ${this.swiftButtonType === 'icon' ? this.swiftButtonIcon : ''} ${this.swiftButtonGhost ? 'ghost' : ''}`;
  }

}
