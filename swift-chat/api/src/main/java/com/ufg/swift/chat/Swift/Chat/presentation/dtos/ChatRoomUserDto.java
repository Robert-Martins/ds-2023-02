package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomUserDto {

    private UserRoleInChat userRole;

    private ChatRoomDto chatRoom;

    private UserDto user;

}
