package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoom;
import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;

import java.util.Set;
import java.util.UUID;

public interface IChatRoomUserService {

    ChatRoomUserDto create(ChatRoom chatRoom, User user, UserRoleInChat userRoleInChat);

    Set<ChatRoomUserDto> findAllByChatRoomId(UUID chatRoomId);

}
