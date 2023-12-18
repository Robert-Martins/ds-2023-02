package com.ufg.swift.chat.Swift.Chat.domain.models;

import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "swift_chat_room_user")
public class ChatRoomUser extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRoleInChat userRole;

    @ManyToOne
    @JoinColumn(name = "chat_room_id", referencedColumnName = "id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
