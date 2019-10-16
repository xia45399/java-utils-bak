package com.summer.util;

import java.util.Random;


public class RandomUtils {
    private static final String RANDOM_NUM = "0123456789";
    private static final String RANDOM_UP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String RANDOM_LOW = "abcdefghijklmnopqrstuvwxyz";
    private static final String RANDOM_NUM_UP = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String RANDOM_NUM_LOW = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final String RANDOM_UP_LOW = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String RANDOM_ALL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    /**
     * 随机生成数字类型字符串
     */
    public static String randomNum(int length) {
        return getRandomStr(length, RANDOM_NUM);
    }

    /**
     * 随机生成大写字母类型字符串
     */
    public static String randomUp(int length) {
        return getRandomStr(length, RANDOM_UP);
    }

    /**
     * 随机生成小写字母类型字符串
     */
    public static String randomLow(int length) {
        return getRandomStr(length, RANDOM_LOW);
    }

    /**
     * 随机生成字母和大写类型字符串
     */
    public static String randomNumAndUp(int length) {
        return getRandomStr(length, RANDOM_NUM_UP);
    }

    /**
     * 随机生成字母和小写类型字符串
     */
    public static String randomNumAndLow(int length) {
        return getRandomStr(length, RANDOM_NUM_LOW);
    }

    /**
     * 随机生成大小写类型字符串
     */
    public static String randomUpAndLow(int length) {
        return getRandomStr(length, RANDOM_UP_LOW);
    }

    /**
     * 随机生成大小写字母类型字符串
     */
    public static String randomAll(int length) {
        return getRandomStr(length, RANDOM_ALL);
    }

    /**
     * 随机生成自定义数据类型字符串
     */
    public static String randomData(int length, String data) {
        return getRandomStr(length, data);
    }

    private static String getRandomStr(int length, String data) {
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
