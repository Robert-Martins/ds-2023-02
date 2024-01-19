package com.ufg.swift.chat.Swift.Chat.domain.repositories;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChatRoomUserRepository extends JpaRepository<ChatRoomUser, UUID> {

    Boolean existsByChatRoomIdAndUserId(
            @Param(value = "chatRoomId") UUID chatRoomId,
            @Param(value = "userId") UUID userId
    );

    @Query("SELECT cru FROM ChatRoomUser cru " +
            "WHERE cru.chatRoom.id = :chatRoomId " +
            "AND cru.user.id = :userId")
    Optional<ChatRoomUser> findByChatRoomIdAndUserId(
            @Param(value = "chatRoomId") UUID chatRoomId,
            @Param(value = "userId") UUID userId
    );

    @Query("SELECT cru FROM ChatRoomUser cru " +
            "WHERE cru.user.id = :userId")
    List<ChatRoomUser> findAllByUserId(
            @Param(value = "userId") UUID userId
    );
}
