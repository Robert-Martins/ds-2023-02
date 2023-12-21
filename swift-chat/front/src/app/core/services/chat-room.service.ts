import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { ChatRoom } from '../models/chat-room.model';

@Injectable({
  providedIn: 'root'
})
export class ChatRoomService {

  private readonly CHAT_ROOM_PATH: string = '/chat-room';

  private url: string;

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.CHAT_ROOM_PATH}`;
  }

  public read(id: string): Observable<ChatRoom> {
    return this.http.get<ChatRoom>(`${this.url}/${id}`);
  }

}
