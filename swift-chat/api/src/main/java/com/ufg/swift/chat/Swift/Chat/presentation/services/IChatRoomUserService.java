package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;

import java.util.List;
import java.util.UUID;

public interface IChatRoomUserService {

    ChatRoomUserDto create(String name, UUID userId);

    ChatRoomUserDto read(UUID chatRoomId, UUID userId);

    void update(String name, UUID chatRoomId, UUID userId);

    void close(UUID chatRoomId, UUID userId);

    ChatRoomUserDto join(UUID chatRoomId, UUID userId);

    void left(UUID chatRoomId, UUID userId);

    List<ChatRoomUserDto> getByUserId(UUID userId);

}
