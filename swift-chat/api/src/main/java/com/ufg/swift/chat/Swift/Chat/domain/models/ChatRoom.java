package com.ufg.swift.chat.Swift.Chat.domain.models;

import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "swift_chat_room")
public class ChatRoom extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany
    private Set<Message> messages;

    @Override
    public ChatRoomDto mapEntityToDto() {
        ChatRoomDto chatRoomDto = new ChatRoomDto();
        chatRoomDto.setId(this.getId());
        chatRoomDto.setName(this.getName());
        chatRoomDto.setMessages(
                this.getMessages().stream()
                        .map(Message::mapEntityToDto)
                        .collect(Collectors.toSet())
        );
        chatRoomDto.setCreatedAt(this.getCreatedAt());
        return chatRoomDto;
    }

}
