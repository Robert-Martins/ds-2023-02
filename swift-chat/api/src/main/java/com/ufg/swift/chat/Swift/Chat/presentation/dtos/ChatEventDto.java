package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.ChatEventType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChatEventDto {

    public UUID chatId;

    public ChatEventType type;

    public MessageDto messageDto;

    public String username;

    public static ChatEventDto buildUserRelatedEvent(UUID chatId, ChatEventType type, String username) {
        ChatEventDto chatEventDto = new ChatEventDto();
        chatEventDto.setChatId(chatId);
        chatEventDto.setType(type);
        chatEventDto.setUsername(username);
        return chatEventDto;
    }

    public static ChatEventDto buildMessageEvent(UUID chatId, MessageDto messageDto) {
        ChatEventDto chatEventDto = new ChatEventDto();
        chatEventDto.setChatId(chatId);
        chatEventDto.setType(ChatEventType.NEW_MESSAGE);
        chatEventDto.setMessageDto(messageDto);
        return chatEventDto;
    }

    public static ChatEventDto buildChatRelatedEvent(UUID chatId, ChatEventType type) {
        ChatEventDto chatEventDto = new ChatEventDto();
        chatEventDto.setChatId(chatId);
        chatEventDto.setType(type);
        return chatEventDto;
    }

}
