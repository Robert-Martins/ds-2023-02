import { Component } from '@angular/core';

@Component({
  selector: 'swift-form-field-error',
  template: `
    <span class="swift-form-field-error">
      <ng-content></ng-content>
    </span>
  `,
  styleUrl: './swift-form-field-error.component.css'
})
export class SwiftFormFieldErrorComponent {

}
