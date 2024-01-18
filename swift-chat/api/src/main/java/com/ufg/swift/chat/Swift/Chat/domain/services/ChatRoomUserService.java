package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoom;
import com.ufg.swift.chat.Swift.Chat.domain.models.ChatRoomUser;
import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import com.ufg.swift.chat.Swift.Chat.domain.repositories.ChatRoomUserRepository;
import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.ChatEventType;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.exception.exceptions.NotFoundException;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatEventDto;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomService;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomUserService;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatService;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatRoomUserService implements IChatRoomUserService {

    private final ChatRoomUserRepository chatRoomUserRepository;

    private final IChatService chatService;

    private final IChatRoomService chatRoomService;

    private final IUserService userService;

    private static final String CHAT_DONT_EXISTS = "Chat não existe";

    @Override
    public ChatRoomUserDto create(String name, UUID userId) {
        return this.create(
                this.chatRoomService.create(name).mapDtoToEntity(),
                userId,
                UserRoleInChat.ADMIN
        ).mapEntityToDto();
    }

    @Override
    public ChatRoomUserDto read(UUID chatRoomId, UUID userId) {
        return this.findByChatRoomIdAndUserId(chatRoomId, userId).mapEntityToDto();
    }

    @Override
    public void update(String name, UUID chatRoomId, UUID userId) {
        ChatRoomUser chatRoomUser = this.findByChatRoomIdAndUserId(chatRoomId, userId);
        Optional.ofNullable(chatRoomUser.getChatRoom())
                .map(BaseEntity::getId)
                .ifPresent(uuid -> this.chatRoomService.update(uuid, name));
    }

    @Override
    public void close(UUID chatRoomId, UUID userId) {

    }

    @Override
    public ChatRoomUserDto join(UUID chatRoomId, UUID userId) {
        ChatRoomUser chatRoomUser = this.chatRoomUserRepository.findByChatRoomIdAndUserId(chatRoomId, userId)
                .orElse(
                        this.create(
                                this.chatRoomService.read(chatRoomId).mapDtoToEntity(),
                                userId,
                                UserRoleInChat.PARTICIPANT
                        )
                );
        this.chatService.publishEvent(
                ChatEventDto.buildUserRelatedEvent(
                        chatRoomId,
                        ChatEventType.USER_JOINED,
                        Optional.ofNullable(chatRoomUser.getUser())
                                .map(User::getName)
                                .orElse("Usuário não-identificado")
                )
        );
        return chatRoomUser.mapEntityToDto();
    }

    @Override
    public void left(UUID chatRoomId, UUID userId) {
        ChatRoomUser chatRoomUser = this.findByChatRoomIdAndUserId(chatRoomId, userId);
        this.chatService.publishEvent(
                ChatEventDto.buildUserRelatedEvent(
                        chatRoomId,
                        ChatEventType.USER_LEFT,
                        Optional.ofNullable(chatRoomUser.getUser())
                                .map(User::getName)
                                .orElse("Usuário não-identificado")
                )
        );
    }

    @Override
    public List<ChatRoomUserDto> getByUserId(UUID userId) {
        return this.chatRoomUserRepository.findAllByUserId(userId)
                .stream()
                .map(ChatRoomUser::mapEntityToDto)
                .toList();
    }

    private ChatRoomUser create(ChatRoom chatRoom, UUID userId, UserRoleInChat userRoleInChat) {
        ChatRoomUser chatRoomUser = new ChatRoomUser();
        chatRoomUser.setUser(this.userService.read(userId).mapDtoToEntity());
        chatRoomUser.setChatRoom(chatRoom);
        chatRoomUser.setUserRole(userRoleInChat);
        return this.chatRoomUserRepository.save(chatRoomUser);
    }

    private ChatRoomUser findByChatRoomIdAndUserId(UUID chatRoomId, UUID userId) {
        return this.chatRoomUserRepository.findByChatRoomIdAndUserId(chatRoomId, userId)
                .orElseThrow(() -> new NotFoundException(CHAT_DONT_EXISTS));
    }

}
