import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Enum } from '../types/types';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private readonly APP_PATH: string =  'app';

  private readonly ENUM_PATH: string = 'enum';

  private url: string = '';

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.APP_PATH}`;
  }

  public health(): Observable<void> {
    return this.http.get<void>(this.url);
  }

  public loadEnumByType(type: string): Observable<Enum[]> {
    return this.http.get<Enum[]>(`${this.url}/${this.ENUM_PATH}/${type}`);
  }

}
