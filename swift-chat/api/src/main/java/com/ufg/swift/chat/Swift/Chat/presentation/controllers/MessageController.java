package com.ufg.swift.chat.Swift.Chat.presentation.controllers;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final IMessageService messageService;

    @PostMapping("/{message}")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(
            @PathVariable(name = "message") String message,
            @RequestBody ChatRoomUserDto chatRoomUserDto
    ) {
        this.messageService.send(message, chatRoomUserDto);
    }

}
