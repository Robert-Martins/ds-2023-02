package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.models.Message;
import com.ufg.swift.chat.Swift.Chat.domain.repositories.MessageRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatEventDto;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatService;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

    private final IChatService chatService;

    @Override
    public void send(String message, ChatRoomUserDto chatRoomUserDto) {
        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setAuthor(
                chatRoomUserDto
                        .mapDtoToEntity()
                        .getUser()
        );
        Message savedMessage = this.messageRepository.save(newMessage);
        this.chatService.publishEvent(
                ChatEventDto.buildMessageEvent(
                        chatRoomUserDto.getChatRoom().getId(),
                        savedMessage.mapEntityToDto()
                )
        );
    }

}
