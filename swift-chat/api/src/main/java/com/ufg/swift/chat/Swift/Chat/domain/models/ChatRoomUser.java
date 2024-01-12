package com.ufg.swift.chat.Swift.Chat.domain.models;

import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "swift_chat_room_user")
public class ChatRoomUser extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, updatable = false)
    private UserRoleInChat userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id", referencedColumnName = "id")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public ChatRoomUserDto mapEntityToDto() {
        ChatRoomUserDto chatRoomUserDto = new ChatRoomUserDto();
        chatRoomUserDto.setId(this.getId());
        chatRoomUserDto.setUserRole(this.getUserRole());
        chatRoomUserDto.setUser(this.getUser().mapEntityToDto());
        chatRoomUserDto.setChatRoom(this.getChatRoom().mapEntityToDto());
        return chatRoomUserDto;
    }

}
