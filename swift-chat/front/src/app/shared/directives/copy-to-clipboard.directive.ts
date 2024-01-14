import { Directive, EventEmitter, HostListener, Input, Output } from '@angular/core';

@Directive({
  selector: '[copyToClipboard]'
})
export class CopyToClipboardDirective {

  @Input('copyToClipboard')
  public payload: string;

  @Output()
  public copied: EventEmitter<void> = new EventEmitter();

  @HostListener('click', ['$event'])
  public async onClick(event: MouseEvent): Promise<void> {
    event.preventDefault();
    if (this.payload){
      await navigator.clipboard.writeText(this.payload);
      this.copied.emit();
    }
  }

  constructor() { }

}
