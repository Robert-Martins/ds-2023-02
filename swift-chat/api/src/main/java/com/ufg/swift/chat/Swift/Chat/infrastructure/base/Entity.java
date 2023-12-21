package com.ufg.swift.chat.Swift.Chat.infrastructure.base;

public abstract class Entity {

    public abstract EntityDto<? extends Entity> mapEntityToDto();

}
