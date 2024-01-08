package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;

public interface IMessageService {

    void send(String message, ChatRoomUserDto chatRoomUserDto);

}
