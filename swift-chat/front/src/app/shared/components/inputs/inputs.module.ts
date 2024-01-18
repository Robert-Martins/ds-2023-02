import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CodeInputComponent } from './code-input/code-input.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SwiftFormFieldComponent } from './swift-form-field/swift-form-field.component';
import { SwiftFormFieldErrorComponent } from './swift-form-field/swift-form-field-error/swift-form-field-error.component';
import { SwiftFormFieldLabelComponent } from './swift-form-field/swift-form-field-label/swift-form-field-label.component';



@NgModule({
  declarations: [
    CodeInputComponent,
    SwiftFormFieldComponent,
    SwiftFormFieldErrorComponent,
    SwiftFormFieldLabelComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    CodeInputComponent,
    SwiftFormFieldComponent,
    SwiftFormFieldErrorComponent,
    SwiftFormFieldLabelComponent
  ]
})
export class InputsModule { }
