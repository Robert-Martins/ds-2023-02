package com.ufg.swift.chat.Swift.Chat.infrastructure.vo.enums;

public enum ChatEventType {

    NEW_MESSAGE("Nova mensagem"),
    USER_JOINED("Usuário entrou"),
    USER_LEFT("Usuário saiu"),
    CHAT_ENDING("Chat será encerrado"),
    CHAT_ENDED("Chat encerrado");

    private final String description;

    ChatEventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
