package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.repositories.ChatRoomUserRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatRoomUserService implements IChatRoomUserService {

    private final ChatRoomUserRepository chatRoomUserRepository;

    @Override
    public ChatRoomUserDto create(String name, UUID userId) {
        return null;
    }

    @Override
    public ChatRoomUserDto read(UUID chatRoomId, UUID userId) {
        return null;
    }

    @Override
    public void update(String name, UUID chatRoomId, UUID userId) {

    }

    @Override
    public void close(UUID chatRoomId, UUID userId) {

    }

    @Override
    public ChatRoomUserDto join(UUID chatRoomId, UUID userId) {
        return null;
    }

    @Override
    public void left(UUID chatRoomId, UUID userId) {

    }
}
