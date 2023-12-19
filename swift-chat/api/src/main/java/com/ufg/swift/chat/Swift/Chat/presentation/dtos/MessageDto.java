package com.ufg.swift.chat.Swift.Chat.presentation.dtos;

import com.ufg.swift.chat.Swift.Chat.domain.models.Message;
import com.ufg.swift.chat.Swift.Chat.infrastructure.base.EntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto extends EntityDto<Message> {

    private String message;

    private UserDto author;

    @Override
    public Message mapDtoToEntity() {
        Message message = new Message();
        message.setId(this.getId());
        message.setMessage(this.getMessage());
        message.setAuthor(this.getAuthor().mapDtoToEntity());
        return message;
    }
}
