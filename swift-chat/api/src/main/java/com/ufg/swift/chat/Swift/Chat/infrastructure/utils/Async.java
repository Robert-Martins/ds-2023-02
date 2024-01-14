package com.ufg.swift.chat.Swift.Chat.infrastructure.utils;

import org.springframework.stereotype.Service;

@Service
public class Async {

    private static final String ASYNC_EXECUTION_ERROR = "Error on Async Method Perform";

    public void performWithTimeout(EmptyAction action, Long sleep) {
        new Thread(
                () -> {
                    try {
                        Thread.sleep(sleep);
                        action.run();
                    } catch (InterruptedException exception) {
                        System.out.println(ASYNC_EXECUTION_ERROR);
                    }
                }
        ).start();
    }

}
