import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DateformatPipe } from './dateformat.pipe';
import { NamecasePipe } from './namecase.pipe';
import { AcronymPipe } from './acronym.pipe';



@NgModule({
  declarations: [
    DateformatPipe,
    NamecasePipe,
    AcronymPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    DateformatPipe,
    NamecasePipe,
    AcronymPipe
  ]
})
export class PipesModule { }
