import { AfterViewInit, Component, ElementRef, Input, ViewChild } from '@angular/core';

type alignments = 'center' | 'space-between' | 'flex-start' | 'flex-end';

type axis = 'column' | 'row';

@Component({
  selector: 'swift-flex',
  template: `
    <div #swiftFlex class="swift-flex">
      <ng-content></ng-content>
    </div>
  `,
  styleUrl: './swift-flex.component.css'
})
export class SwiftFlexComponent implements AfterViewInit {

  @ViewChild('swiftFlex')
  private swiftFlex: ElementRef<HTMLElement>;

  @Input()
  public mainAxis: axis = 'row';

  @Input()
  public gap: string = '8';

  @Input()
  public justify: alignments = 'flex-start';

  @Input()
  public align: alignments = 'flex-start';

  ngAfterViewInit(): void {
    this.swiftFlex.nativeElement.style.flexDirection = this.mainAxis;
    if(!Number.isNaN(this.gap))
      this.swiftFlex.nativeElement.style.gap = `${this.gap}px`;
    this.swiftFlex.nativeElement.style.justifyContent = this.justify;
    this.swiftFlex.nativeElement.style.alignItems = this.align;
  }

}
