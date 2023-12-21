package com.ufg.swift.chat.Swift.Chat.presentation.controllers;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.EnumDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IEnumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {

    private final IEnumService enumService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return "Swift Chat API Online";
    }

    @GetMapping("/enum/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<EnumDto> loadEnumByType(@PathVariable(name = "type") String type) {
        return this.enumService.loadEnumByType(type);
    }

}
