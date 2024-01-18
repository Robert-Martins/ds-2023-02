import { Component } from '@angular/core';

@Component({
  selector: 'swift-form-field',
  template: `
    <div class="swift-form-field">
      <ng-content select="swift-form-field-label"></ng-content>
      <ng-content select="input"></ng-content>
      <ng-content select="swift-form-field-error"></ng-content>
    </div>
  `,
  styleUrl: './swift-form-field.component.css',
})
export class SwiftFormFieldComponent {}
