import { Directive, ElementRef, Input, Renderer2, booleanAttribute } from '@angular/core';

@Directive({
  selector: '[swiftButton]'
})
export class SwiftButtonDirective {

  @Input()
  public swiftButtonType: 'flat' | 'flat-ghost' | 'icon' = 'flat';

  @Input()
  public swiftButtonIcon?: string = '';

  constructor(
    private renderer: Renderer2,
    private elementRef: ElementRef
  ) { 
    console.log(this.swiftButtonType)
    this.renderer.setAttribute(this.elementRef.nativeElement, 'class', this.buildClasses().trim());
  }

  private buildClasses(): string {
    return `swift-button ${this.swiftButtonType.split('-').join(' ')} ${this.swiftButtonType === 'icon' ? this.swiftButtonIcon : ''}`;
  }

}
