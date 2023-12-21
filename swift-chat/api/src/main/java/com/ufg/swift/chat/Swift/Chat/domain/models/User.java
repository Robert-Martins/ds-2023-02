package com.ufg.swift.chat.Swift.Chat.domain.models;

import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "swift_user")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public UserDto mapEntityToDto() {
        UserDto userDto = new UserDto();
        userDto.setId(this.getId());
        userDto.setName(this.getName());
        return userDto;
    }

}
