package com.ufg.swift.chat.Swift.Chat.domain.repositories;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {

    Boolean existsByCode(String code);

    Optional<ChatRoom> findByCode(String code);

}
