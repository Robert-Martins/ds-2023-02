import { Message } from "./message.model";

export class ChatRoom {

    public id: string;
    public name: string;
    public messages: Message[] = [];
    public createdAt: Date;

    constructor(
        id: string = null,
        name: string = null,
        messages: Message[] = [],
        createdAt: Date = null
    ) {
        this.id = id;
        this.name = name;
        this.messages = messages;
        this.createdAt = createdAt;
    }

}