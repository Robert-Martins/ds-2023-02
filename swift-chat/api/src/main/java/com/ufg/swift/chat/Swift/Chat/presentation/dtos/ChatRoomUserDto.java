package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoomUser;
import com.ufg.swift.chat.Swift.Chat.infrastructure.base.EntityDto;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChatRoomUserDto extends EntityDto<ChatRoomUser> {

    private UserRoleInChat userRole;

    private ChatRoomDto chatRoom;

    private UserDto user;

    private LocalDateTime createdAt;

    @Override
    public ChatRoomUser mapDtoToEntity() {
        ChatRoomUser chatRoomUser = new ChatRoomUser();
        chatRoomUser.setId(this.getId());
        chatRoomUser.setUserRole(this.getUserRole());
        chatRoomUser.setChatRoom(this.getChatRoom().mapDtoToEntity());
        chatRoomUser.setUser(this.getUser().mapDtoToEntity());
        chatRoomUser.setCreatedAt(this.getCreatedAt());
        return chatRoomUser;
    }

}
