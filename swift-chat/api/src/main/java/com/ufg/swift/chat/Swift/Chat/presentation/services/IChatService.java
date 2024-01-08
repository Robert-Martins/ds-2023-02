package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatEventDto;

public interface IChatService {

    void publishEvent(ChatEventDto chatEventDto);

}
