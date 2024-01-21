import { ChatRoom } from "./chat-room.model";
import { User } from "./user.model";

export class ChatRoomUser {

    public id: string;
    public userRole: string;
    public chatRoom: ChatRoom;
    public user: User;
    public createdAt: Date;

    constructor(
        id: string = null,
        chatRoom: ChatRoom = null,
        user: User = null,
        userRole: string = null,
        createdAt: Date = null
    ) {
        this.id = id;
        this.userRole = userRole;
        this.chatRoom = chatRoom;
        this.user = user;
        this.createdAt = createdAt;
    }

}