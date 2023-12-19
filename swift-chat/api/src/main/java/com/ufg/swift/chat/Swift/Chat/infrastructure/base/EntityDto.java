package com.ufg.swift.chat.Swift.Chat.infrastructure.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class EntityDto<T> {

    private UUID id;

    public abstract T mapDtoToEntity();

}
