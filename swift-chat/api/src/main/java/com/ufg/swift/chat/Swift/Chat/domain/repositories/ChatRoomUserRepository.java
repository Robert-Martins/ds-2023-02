package com.ufg.swift.chat.Swift.Chat.domain.repositories;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRoomUserRepository extends JpaRepository<ChatRoomUser, UUID> {
}
