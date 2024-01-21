package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoom;
import com.ufg.swift.chat.Swift.Chat.infrastructure.base.EntityDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ChatRoomDto extends EntityDto<ChatRoom> {

    private String name;

    private String code;

    private Set<MessageDto> messages = new HashSet<>();

    private LocalDateTime createdAt;

    @Override
    public ChatRoom mapDtoToEntity() {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setId(this.getId());
        chatRoom.setName(this.getName());
        chatRoom.setCode(this.getCode());
        chatRoom.setMessages(
                this.messages.stream()
                        .map(MessageDto::mapDtoToEntity)
                        .collect(Collectors.toSet())
        );
        chatRoom.setCreatedAt(this.getCreatedAt());
        return chatRoom;
    }

}
