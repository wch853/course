package com.wch.course.util;

import java.util.Random;

public class CodeUtil {

    private static final String RANDOM_BASE_CODE = "0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 生成32位token
     */
    private static final int TOKEN_SIZE = 32;

    private static final int VERIFICATION_CODE_SIZE = 4;

    private static String getRandomCode(int codeSize, String baseCode) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < codeSize; i++) {
            int location = random.nextInt(baseCode.length());
            builder.append(baseCode.charAt(location));
        }
        return builder.toString();
    }

    public static String getToken() {
        return getRandomCode(TOKEN_SIZE, RANDOM_BASE_CODE);
    }

    public static String getVerificationCode() {
        return getRandomCode(VERIFICATION_CODE_SIZE, RANDOM_BASE_CODE);
    }
}
