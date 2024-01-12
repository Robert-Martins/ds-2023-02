import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'namecase'
})
export class NamecasePipe implements PipeTransform {

  transform(value: string): string {
    const names = value.split(' ');
    if (names.length >= 2) {
      const firstName = names[0].charAt(0).toUpperCase() + names[0].slice(1);
      const lastName = names[names.length - 1].charAt(0).toUpperCase() + names[names.length - 1].slice(1);
      return firstName + ' ' + lastName;
    }
    return value;
  }

}
