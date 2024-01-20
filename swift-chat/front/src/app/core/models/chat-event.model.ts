import { Message } from "./message.model";

export class ChatEvent {

    public type: string;
    public message: Message;
    public username: string;

    public static buildFromMessage = (message: Message): ChatEvent => {
        const event: ChatEvent = new ChatEvent();
        event.type = "NEW_MESSAGE";
        event.message = message;
        event.username = message?.author?.name;
        return event;
    }

}