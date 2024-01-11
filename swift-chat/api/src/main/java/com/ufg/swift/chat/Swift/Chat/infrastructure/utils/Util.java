package com.ufg.swift.chat.Swift.Chat.infrastructure.utils;

import java.util.Random;

public class Util {

    public static String generateRandomSixDigitsCode() {
        Random generator = new Random();
        return Integer.toString(generator.nextInt(899999) + 100000);
    }

}
