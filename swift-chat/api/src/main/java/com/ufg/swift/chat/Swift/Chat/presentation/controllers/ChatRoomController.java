package com.ufg.swift.chat.Swift.Chat.presentation.controllers;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/chat-room")
@RequiredArgsConstructor
public class ChatRoomController {

    private final IChatRoomService chatRoomService;

    @GetMapping("/{chatRoomId}")
    @ResponseStatus(HttpStatus.OK)
    public ChatRoomDto read(@PathVariable(name = "chatRoomId") String id) {
        return this.chatRoomService.read(UUID.fromString(id));
    }

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    public UUID readIdByCode(@PathVariable(name = "code") String code) {
        return this.chatRoomService.readIdByCode(code);
    }

}
