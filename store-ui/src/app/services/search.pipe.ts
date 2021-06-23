import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {
  transform(value: any, args?: any): any {
    if (!args) {
      return value;
    }
    if (value) {
      return value.filter((val) => {
        if (val.name !== null) {
          return (val.name.includes(args));
        } else {
          return val;
        }
      })
    } else {
      return value
    }
  }
}
