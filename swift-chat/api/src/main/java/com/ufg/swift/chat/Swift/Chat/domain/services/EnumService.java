package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.ChatEventType;
import com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums.UserRoleInChat;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.EnumDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IEnumService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EnumService implements IEnumService {

    @Override
    public List<EnumDto> loadEnumByType(String type) {
        return switch (type) {
            case "userRoleInChat" -> Arrays.stream(UserRoleInChat.values()).map(e -> new EnumDto(e.name(), e.getDescription())).toList();
            case "chatEventType" -> Arrays.stream(ChatEventType.values()).map(e -> new EnumDto(e.name(), e.getDescription())).toList();
            default -> List.of();
        };
    }

}
