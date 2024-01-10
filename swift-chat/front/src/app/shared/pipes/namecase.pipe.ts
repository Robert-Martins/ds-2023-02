import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'namecase'
})
export class NamecasePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
