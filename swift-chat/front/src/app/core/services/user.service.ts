import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { environment } from '../../../environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnDestroy {

  private readonly USER_PATH: string = 'user';

  private readonly USER_ID_KEY: string = 'user-id';

  private userId$: BehaviorSubject<string> = new BehaviorSubject(null);

  private url: string = '';

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.USER_PATH}`;
  }

  ngOnDestroy(): void {
    this.userId$.unsubscribe();
  }

  public create(name: string): Observable<User> {
    return this.http.post<User>(this.url, name);
  }

  public read(): Observable<User> {
    return this.http.get<User>(`${this.url}/${this.userId$.value}`);
  }

  public update(name: string): Observable<void> {
    return this.http.put<void>(`${this.url}/${this.userId$.value}`, name);
  }

  public isUser(): boolean {
    this.retrieveUserId();
    return this.userId$.value !== null;
  }

  public getUserId(): string {
    const userId: string = this.userId$.value;
    if(userId)
      return userId;
    this.retrieveUserId();
    return this.userId$.value;
  }

  public persistUser(userId: string): void {
    this.userId$.next(userId);
    localStorage.setItem(this.USER_ID_KEY, userId);
  }

  public retrieveUserId(): void {
    const id = localStorage.getItem(this.USER_ID_KEY);
    if(id)
      this.userId$.next(id);
  }

  public clearUserId(): void {
    localStorage.removeItem(this.USER_ID_KEY);
  }

}
