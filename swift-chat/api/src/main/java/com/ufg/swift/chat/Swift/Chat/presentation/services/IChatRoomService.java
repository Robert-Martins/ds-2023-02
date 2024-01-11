package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomDto;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;

import java.util.UUID;

public interface IChatRoomService {

    ChatRoomDto create(String name, ChatRoomUserDto chatRoomUserDto);

    ChatRoomDto read(UUID uuid);

    ChatRoomDto readByCode(String code);

    ChatRoomDto update(UUID uuid, String name);

    void delete(UUID id);

}
