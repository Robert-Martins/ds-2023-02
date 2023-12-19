package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.MessageDto;

import java.util.UUID;

public interface IMessageService {

    MessageDto create(String message, UUID authorId);

}
