import { Injectable, OnDestroy } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { environment } from '../../../environments/environment';
import { ChatEvent } from '../models/chat-event.model';

declare var SockJS;
declare var Stomp;

@Injectable({
  providedIn: 'root',
})
export class ChatService implements OnDestroy {

  private subscription: any;

  private stompClient: any;

  private url: string = '';

  private event$: BehaviorSubject<ChatEvent> = new BehaviorSubject(null);

  private readonly SWIFT_CHAT_SOCKET_PATH = 'chat';

  private readonly CHAT_ROOM_TOPIC_PATH = '/room';

  constructor() {
    this.subscription = null;
    this.stompClient = null;
    this.url = `${environment.apiUrl}/${this.SWIFT_CHAT_SOCKET_PATH}`;
  }

  ngOnDestroy(): void {
    this.event$.unsubscribe();
  }

  public async connect(id: string): Promise<void> {
    return new Promise(() => {
      this.startClient();
      this.stompClient.connect(
        {},
        this.onConnected(id),
        this.onConnectionError
      );
    });
  }

  public setEventReceivedCallback(onEventReceived: (event: ChatEvent) => void): void {
    this.event$.subscribe(onEventReceived);
  }

  public close(): void {
    this.stompClient.close();
    this.subscription = null;
    this.stompClient = null;
  }

  private startClient(): void {
    if (!this.stompClient) {
      let socket = new SockJS(this.url);
      this.stompClient = Stomp.over(socket);
    }
  }

  private onConnected = (id: string): void => {
    if (this.subscription) this.subscription.unsubscribe();
    this.event$.next(null);
    this.subscription = this.stompClient.subscribe(
      `${this.CHAT_ROOM_TOPIC_PATH}/${id}`,
      this.onEventPublished
    );
  };

  private onConnectionError = (): void => {
    Promise.reject();
  };

  private onEventPublished = (publishedEvent: any): void => {
    const event: ChatEvent = publishedEvent?.body as ChatEvent;
    this.event$.next(event);
  };
}
