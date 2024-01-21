package com.ufg.swift.chat.Swift.Chat.infrastructure.vo.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ExceptionDetails {

    private String title;

    private int status;

    private String details;

    private String developerMessage;

    private String className;

    private LocalDateTime timestamp;

}
