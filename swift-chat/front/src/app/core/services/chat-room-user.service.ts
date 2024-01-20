import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { ChatRoomUser } from '../models/chat-room-user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatRoomUserService {

  private readonly CHAT_ROOM_USER_PATH: string = 'chat-room-user';

  private readonly CLOSE_PATH: string = 'close';

  private readonly JOIN_PATH: string = 'join';

  private readonly LEFT_PATH: string = 'left';

  private url: string = '';

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.CHAT_ROOM_USER_PATH}`;
  }

  public create(name: string, userId: string): Observable<ChatRoomUser> {
    return this.http.post<ChatRoomUser>(`${this.url}${userId ? `?userId=${userId}`: ''}`, name);
  }

  public read(chatRoomId: string, userId: string): Observable<ChatRoomUser> {
    return this.http.get<ChatRoomUser>(`${this.url}/${chatRoomId}${userId ? `?userId=${userId}`: ''}`);
  }

  public update(name: string, chatRoomId: string, userId: string): Observable<void> {
    return this.http.put<void>(`${this.url}/${chatRoomId}/${name}${userId ? `?userId=${userId}`: ''}`, null);
  }

  public close(chatRoomId: string, userId: string): Observable<void> {
    return this.http.post<void>(`${this.url}/${this.CLOSE_PATH}/${chatRoomId}${userId ? `?userId=${userId}`: ''}`, null);
  }

  public join(chatRoomId: string, userId: string): Observable<ChatRoomUser> {
    return this.http.post<ChatRoomUser>(`${this.url}/${this.JOIN_PATH}/${chatRoomId}${userId ? `?userId=${userId}`: ''}`, null);
  }

  public left(chatRoomId: string, userId: string): Observable<void> {
    return this.http.post<void>(`${this.url}/${this.LEFT_PATH}/${chatRoomId}${userId ? `?userId=${userId}`: ''}`, null);
  }

  public getByUserId(userId: string): Observable<ChatRoomUser[]> {
    return this.http.get<ChatRoomUser[]>(`${this.url}${userId ? `?userId=${userId}`: ''}`);
  }

}
