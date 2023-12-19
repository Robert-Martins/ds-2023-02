package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ChatRoomDto {

    private Set<ChatRoomUserDto> chatRoomUsers;

    private Set<MessageDto> messages;

}
