package com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums;

public enum UserRoleInChat {

    ADMIN("Admin"),
    PARTICIPANT("Participant");

    private final String description;

    UserRoleInChat(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
