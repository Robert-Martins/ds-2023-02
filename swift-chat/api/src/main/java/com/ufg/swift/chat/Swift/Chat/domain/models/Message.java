package com.ufg.swift.chat.Swift.Chat.domain.models;

import com.ufg.swift.chat.Swift.Chat.infrastructure.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "swift_message")
public class Message extends BaseEntity {

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

}
