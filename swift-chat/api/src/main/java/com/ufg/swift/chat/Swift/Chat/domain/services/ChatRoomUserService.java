package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.repositories.ChatRoomUserRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomUserService implements IChatRoomUserService {

    private final ChatRoomUserRepository chatRoomUserRepository;

}
