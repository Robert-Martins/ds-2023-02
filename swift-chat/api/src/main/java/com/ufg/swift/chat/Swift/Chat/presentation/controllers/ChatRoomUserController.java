package com.ufg.swift.chat.Swift.Chat.presentation.controllers;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.ChatRoomUserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat-room-user")
@RequiredArgsConstructor
public class ChatRoomUserController {

    private final IChatRoomUserService chatRoomUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChatRoomUserDto create(
            @RequestParam(name = "userId") String userId,
            @RequestBody String name
    ) {
        return this.chatRoomUserService.create(name, UUID.fromString(userId));
    }

    @GetMapping("/{chatRoomId}")
    @ResponseStatus(HttpStatus.OK)
    public ChatRoomUserDto read(
            @PathVariable(name = "chatRoomId") String chatRoomId,
            @RequestParam(name = "userId") String userId
    ) {
        return this.chatRoomUserService.read(UUID.fromString(chatRoomId), UUID.fromString(userId));
    }

    @PutMapping("/{chatRoomId}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void update(
            @PathVariable(name = "chatRoomId") String chatRoomId,
            @PathVariable(name = "name") String name,
            @RequestParam(name = "userId") String userId
    ) {
        this.chatRoomUserService.update(name, UUID.fromString(chatRoomId), UUID.fromString(userId));
    }

    @PostMapping("/close/{chatRoomId}")
    @ResponseStatus(HttpStatus.OK)
    public void close(
            @PathVariable(name = "chatRoomId") String chatRoomId,
            @RequestParam(name = "userId") String userId
    ) {
        this.chatRoomUserService.close(UUID.fromString(chatRoomId), UUID.fromString(userId));
    }

    @PostMapping("/join/{chatRoomId}")
    @ResponseStatus(HttpStatus.OK)
    public ChatRoomUserDto join(
            @PathVariable(name = "chatRoomId") String chatRoomId,
            @RequestParam(name = "userId") String userId
    ) {
        return this.chatRoomUserService.join(UUID.fromString(chatRoomId), UUID.fromString(userId));
    }

    @PostMapping("/left/{chatRoomId}")
    @ResponseStatus(HttpStatus.OK)
    public void left(
            @PathVariable(name = "chatRoomId") String chatRoomId,
            @RequestParam(name = "userId") String userId
    ) {
        this.chatRoomUserService.left(UUID.fromString(chatRoomId), UUID.fromString(userId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChatRoomUserDto> getUserById(
            @RequestParam(name = "userId") String userId
    ) {
        return this.chatRoomUserService.getByUserId(UUID.fromString(userId));
    }

}
