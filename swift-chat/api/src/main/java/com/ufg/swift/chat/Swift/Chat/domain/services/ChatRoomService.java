package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoom;
import com.ufg.swift.chat.Swift.Chat.domain.repositories.ChatRoomRepository;
import com.ufg.swift.chat.Swift.Chat.infrastructure.utils.Functions;
import com.ufg.swift.chat.Swift.Chat.infrastructure.utils.Util;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.exception.exceptions.NotFoundException;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomDto;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ChatRoomService implements IChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    private static final String CHAT_ROOM_DONT_EXISTS_BY_ID = "Chat de ID %s não existe";
    private static final String CHAT_ROOM_DONT_EXISTS_BY_CODE = "Chat de Código %s não existe";

    @Override
    public ChatRoomDto create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        chatRoom.setCode(this.generateRoomUniqueCode());
        ChatRoom savedChatRoom = this.chatRoomRepository.save(chatRoom);
        return savedChatRoom.mapEntityToDto();
    }

    @Override
    public ChatRoomDto read(UUID uuid) {
        return this.findById(uuid).mapEntityToDto();
    }

    @Override
    public UUID readIdByCode(String code) {
        return this.chatRoomRepository.findByCode(code)
                .map(ChatRoom::getId)
                .orElseThrow(
                        () -> new NotFoundException(
                                String.format(CHAT_ROOM_DONT_EXISTS_BY_CODE, code)
                        )
                );
    }

    @Override
    public ChatRoomDto update(UUID uuid, String name) {
        ChatRoom chatRoom = this.findById(uuid);
        chatRoom.setName(name);
        ChatRoom saved = this.chatRoomRepository.save(chatRoom);
        return saved.mapEntityToDto();
    }

    @Override
    public void delete(UUID uuid) {
        Functions.acceptTrueOrElseThrow(
                this.chatRoomRepository.existsById(uuid),
                () -> this.chatRoomRepository.deleteById(uuid),
                () -> new NotFoundException(
                        String.format(CHAT_ROOM_DONT_EXISTS_BY_ID, uuid)
                )
        );
    }

    private ChatRoom findById(UUID uuid) {
        return this.chatRoomRepository.findById(uuid)
                .orElseThrow(
                        () -> new NotFoundException(
                                String.format(CHAT_ROOM_DONT_EXISTS_BY_ID, uuid)
                        )
                );
    }

    private String generateRoomUniqueCode() {
        AtomicReference<String> code = new AtomicReference<>(Util.generateRandomSixDigitsCode());
        Functions.acceptTrue(
                this.chatRoomRepository.existsByCode(code.get()),
                () -> code.set(this.generateRoomUniqueCode())
        );
        return code.get();
    }

}
