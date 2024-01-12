import { DatePipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateformat'
})
export class DateformatPipe implements PipeTransform {

  transform(value: any, format: string = 'dd/MM/yyyy HH:mm'): string {
    const datePipe = new DatePipe('en-US');
    return datePipe.transform(value, format);
  }

}
