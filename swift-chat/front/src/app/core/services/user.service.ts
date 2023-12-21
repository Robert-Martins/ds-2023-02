import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly USER_PATH: string = 'user';

  private url: string = '';

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.USER_PATH}`;
  }

  public create(name: string): Observable<User> {
    return this.http.post<User>(`${this.url}/${name}`, null);
  }

  public read(id: string): Observable<User> {
    return this.http.get<User>(`${this.url}/${id}`);
  }

  public update(user: User): Observable<void> {
    return this.http.put<void>(this.url, user);
  }

}
