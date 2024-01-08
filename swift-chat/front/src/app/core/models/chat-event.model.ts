import { Message } from "./message.model";

export class ChatEvent {

    public type: string;
    public message: Message;
    public username: string;

}