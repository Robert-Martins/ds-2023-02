package com.ufg.swift.chat.Swift.Chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableWebSocketMessageBroker
@EnableWebSocket
public class SwiftChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftChatApplication.class, args);
	}

}
