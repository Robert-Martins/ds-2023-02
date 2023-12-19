package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.repositories.ChatRoomRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService implements IChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

}
