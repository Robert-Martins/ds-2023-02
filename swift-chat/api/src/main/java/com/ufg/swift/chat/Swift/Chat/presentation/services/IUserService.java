package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.UserDto;

import java.util.UUID;

public interface IUserService {

    UserDto create(String name);

    UserDto read(UUID id);

    void update(UUID id, String name);
}
