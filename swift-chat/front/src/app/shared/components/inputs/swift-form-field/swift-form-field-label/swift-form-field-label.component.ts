import { Component } from '@angular/core';

@Component({
  selector: 'swift-form-field-label',
  template: `
    <label class="swift-form-field-label">
      <ng-content></ng-content>
    </label>
  `,
  styleUrl: './swift-form-field-label.component.css'
})
export class SwiftFormFieldLabelComponent {

}
