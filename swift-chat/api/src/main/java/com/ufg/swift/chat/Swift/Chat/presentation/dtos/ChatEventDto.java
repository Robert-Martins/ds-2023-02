package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.ChatEventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatEventDto {

    public ChatEventType type;

    public MessageDto messageDto;

    public String username;

    public static ChatEventDto buildUserRelatedEvent(ChatEventType type, String username) {
        ChatEventDto chatEventDto = new ChatEventDto();
        chatEventDto.setType(type);
        chatEventDto.setUsername(username);
        return chatEventDto;
    }

    public static ChatEventDto buildMessageEvent(MessageDto messageDto) {
        ChatEventDto chatEventDto = new ChatEventDto();
        chatEventDto.setType(ChatEventType.NEW_MESSAGE);
        chatEventDto.setMessageDto(messageDto);
        return chatEventDto;
    }

    public static ChatEventDto buildChatRelatedEvent(ChatEventType type) {
        ChatEventDto chatEventDto = new ChatEventDto();
        chatEventDto.setType(type);
        return chatEventDto;
    }

}
