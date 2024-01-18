import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContainerComponent } from './container/container.component';
import { SwiftFlexComponent } from './swift-flex/swift-flex.component';

@NgModule({
  declarations: [ContainerComponent, SwiftFlexComponent],
  imports: [CommonModule],
  exports: [ContainerComponent, SwiftFlexComponent],
})
export class ContainersModule {}
