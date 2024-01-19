import { Component } from '@angular/core';

@Component({
  selector: 'swift-container',
  template: `
    <div class="swift-container">
      <ng-content></ng-content>
    </div>
  `,
  styleUrl: './container.component.css',
})
export class ContainerComponent {}
