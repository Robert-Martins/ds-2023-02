import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'acronym'
})
export class AcronymPipe implements PipeTransform {

  transform(value: string): string {
    if(!value || value.length === 0)
      return "UN";
    else if(value.length === 1)
      return value.repeat(2);
    const splitted: string[] = value?.split(" ");
    return splitted.length > 1 
      ? splitted.map(str => str.charAt(0)).join("").toUpperCase() 
      : splitted[0].slice(0, 2);
  }

}
