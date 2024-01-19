import { ChatRoomUser } from "./chat-room-user.model";
import { Message } from "./message.model";

export class ChatRoom {

    public id: string;
    public name: string;
    public messages: Message[] = [];
    public chatRoomUsers: ChatRoomUser[] = [];
    public createdAt: Date;

    constructor(
        id: string = null,
        name: string = null,
        messages: Message[] = [],
        chatRoomUsers: ChatRoomUser[] = [],
        createdAt: Date = null
    ) {
        this.id = id;
        this.name = name;
        this.messages = messages;
        this.chatRoomUsers = chatRoomUsers;
        this.createdAt = createdAt;
    }

}