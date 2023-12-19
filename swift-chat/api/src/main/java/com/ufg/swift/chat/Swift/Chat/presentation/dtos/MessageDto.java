package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {

    private String message;

    private UserDto author;

}
