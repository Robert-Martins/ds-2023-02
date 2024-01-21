package com.ufg.swift.chat.Swift.Chat.presentation.controllers;

import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import com.ufg.swift.chat.Swift.Chat.domain.services.UserService;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.UserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IChatRoomService;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody String name) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") UUID id) {
        UserDto user = userService.read(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") UUID id,
                                              @RequestBody String name) {
        UserDto user = userService.read(id);
        if (user != null) {
            userService.update(id, name);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}