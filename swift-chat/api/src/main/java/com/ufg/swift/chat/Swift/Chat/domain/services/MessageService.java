package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.repositories.MessageRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

}
