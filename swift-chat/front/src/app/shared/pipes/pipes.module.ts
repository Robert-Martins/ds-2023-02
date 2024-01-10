import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DateformatPipe } from './dateformat.pipe';
import { NamecasePipe } from './namecase.pipe';



@NgModule({
  declarations: [
    DateformatPipe,
    NamecasePipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    DateformatPipe,
    NamecasePipe
  ]
})
export class PipesModule { }
