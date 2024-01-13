import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SwiftInputComponent } from './swift-input/swift-input.component';
import { CodeInputComponent } from './code-input/code-input.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    SwiftInputComponent,
    CodeInputComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SwiftInputComponent,
    CodeInputComponent
  ]
})
export class InputsModule { }
