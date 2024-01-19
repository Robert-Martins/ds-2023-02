package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatEventDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService implements IChatService {

    private static final String CHAT_SOCKET_DESTINATION_PREFIX = "/room/%s";

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void publishEvent(ChatEventDto chatEventDto) {
        messagingTemplate.convertAndSend(
                String.format(CHAT_SOCKET_DESTINATION_PREFIX, chatEventDto.getChatId()),
                chatEventDto
        );
    }
}
