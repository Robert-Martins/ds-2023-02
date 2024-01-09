import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { ChatRoomUser } from '../models/chat-room-user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private readonly MESSAGE_PATH: string = 'message';

  private url: string;

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.MESSAGE_PATH}`;
  }

  public send(message: string, chatRoomUser: ChatRoomUser): Observable<void> {
    return this.http.post<void>(`${this.url}/${message}`, chatRoomUser);
  }

}
