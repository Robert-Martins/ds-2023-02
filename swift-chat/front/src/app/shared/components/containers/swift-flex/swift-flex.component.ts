import {
  AfterViewInit,
  Component,
  ElementRef,
  Input,
  ViewChild,
} from '@angular/core';

type Alignments = 'center' | 'space-between' | 'flex-start' | 'flex-end';

type Axis = 'column' | 'row';

@Component({
  selector: 'swift-flex',
  template: `
    <div #swiftFlex class="swift-flex">
      <ng-content></ng-content>
    </div>
  `,
  styleUrl: './swift-flex.component.css',
})
export class SwiftFlexComponent implements AfterViewInit {
  @ViewChild('swiftFlex')
  private swiftFlex: ElementRef<HTMLElement>;

  @Input()
  public mainAxis: Axis = 'row';

  @Input()
  public gap: string = '0';

  @Input()
  public justify: Alignments = 'flex-start';

  @Input()
  public align: Alignments = 'flex-start';

  ngAfterViewInit(): void {
    this.swiftFlex.nativeElement.style.flexDirection = this.mainAxis;
    if (!Number.isNaN(this.gap))
      this.swiftFlex.nativeElement.style.gap = `${this.gap}px`;
    this.swiftFlex.nativeElement.style.justifyContent = this.justify;
    this.swiftFlex.nativeElement.style.alignItems = this.align;
  }
}
