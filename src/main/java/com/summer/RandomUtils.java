package com.summer;

import java.util.Random;


public class RandomUtils {
    private static final String RANDOM_NUM= "0123456789";
    private static final String RANDOM_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String getRandomNum(int length) {
        return getRandomStr(length, RANDOM_NUM);
    }

    public static String getRandomStr(int length) {
        return getRandomStr(length, RANDOM_STR);
    }

    public static String getRandomStr(int length, String data) {
        if (data == null) {
            return "";
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int dataLength = data.length();
        for (int i = 0; i < length; i++) {
            sb.append(data.charAt(random.nextInt(dataLength)));
        }
        return sb.toString();
    }
}
