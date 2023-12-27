package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import com.ufg.swift.chat.Swift.Chat.infrastructure.base.EntityDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto extends EntityDto<User> {

    private String name;

    @Override
    public User mapDtoToEntity() {
        User user = new User();
        user.setId(this.getId());
        user.setName(this.getName());
        return user;
    }
}

