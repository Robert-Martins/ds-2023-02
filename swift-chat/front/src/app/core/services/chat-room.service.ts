import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { environment } from '../../../environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { ChatRoom } from '../models/chat-room.model';

@Injectable({
  providedIn: 'root'
})
export class ChatRoomService  implements OnDestroy {

  private readonly CHAT_ROOM_PATH: string = 'chat-room';

  private readonly CODE_PATH: string = 'code';

  private readonly CHAT_ROOM_ID_KEY: string = 'chat-room-id';

  private chatRoomId$: BehaviorSubject<string> = new BehaviorSubject(null);

  private url: string;

  constructor(
    private http: HttpClient
  ) { 
    this.url = `${environment.apiUrl}/${this.CHAT_ROOM_PATH}`;
  }

  ngOnDestroy(): void {
    this.chatRoomId$.unsubscribe();
  }

  public read(id: string): Observable<ChatRoom> {
    return this.http.get<ChatRoom>(`${this.url}/${id}`);
  }

  public getIdByCode(code: string): Observable<string> {
    console.log("toque toque")
    return this.http.get<string>(`${this.url}/${this.CODE_PATH}/${code}`);
  }

  public persistChatRoomId(chatRoomId: string): void {
    localStorage.setItem(this.CHAT_ROOM_ID_KEY, chatRoomId);
  }

  public retrieveChatRoomId(): void {
    const id = localStorage.getItem(this.CHAT_ROOM_ID_KEY);
    if(id)
      this.chatRoomId$.next(id);
  }

  public clearChatRoomId(): void {
    localStorage.removeItem(this.CHAT_ROOM_ID_KEY);
  }

}
