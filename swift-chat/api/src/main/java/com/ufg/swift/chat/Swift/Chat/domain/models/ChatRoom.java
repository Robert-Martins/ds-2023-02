package com.ufg.swift.chat.Swift.Chat.domain.models;

import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "swift_chat_room")
public class ChatRoom extends BaseEntity {

    @OneToMany
    private Set<ChatRoomUser> chatRoomUsers;

    @OneToMany
    private Set<Message> messages;

}
