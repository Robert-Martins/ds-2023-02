package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomDto;

import java.util.UUID;

public interface IChatRoomService {

    ChatRoomDto create(String name);

    ChatRoomDto read(UUID uuid);

    UUID readIdByCode(String code);

    ChatRoomDto update(UUID uuid, String name);

    void delete(UUID id);

}
