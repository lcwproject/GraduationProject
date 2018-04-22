package com.graduate.laborManager.common.util;

import java.security.SecureRandom;

public class Rand {
    static final SecureRandom rd = new SecureRandom();
    private static final char[] StrNumber = "0123456789".toCharArray();
    private static final char[] StrNumberAndUpLetters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] StrNumberAndLowLetters = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] StrUpLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] StrLowLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] StrUpAndLowLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    static final char[] StrMixed = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz".toCharArray();
    public static final int TypeNumber = 10;
    public static final int TypeNumberAndUpLetters = 20;
    public static final int TypeNumberAndLowLetters = 30;
    public static final int TypeUpLetters = 40;
    public static final int TypeUpAndLowLetters = 50;
    public static final int TypeLowLetters = 60;
    public static final int TypeMixed = 70;

    public Rand() {
    }

    public static String randString(int len) {
        return randString(len, rd.nextInt());
    }

    public static String randString(int len, int type) {
        if (len < 1) {
            len = 1;
        }

        rd.setSeed(System.nanoTime());
        char[] strBase;
        switch(type) {
            case 10:
                strBase = StrNumber;
                break;
            case 20:
                strBase = StrNumberAndUpLetters;
                break;
            case 30:
                strBase = StrNumberAndLowLetters;
                break;
            case 40:
                strBase = StrUpLetters;
                break;
            case 50:
                strBase = StrUpAndLowLetters;
                break;
            case 60:
                strBase = StrLowLetters;
                break;
            case 70:
            default:
                strBase = StrMixed;
        }

        int lenBase = strBase.length;
        char[] sb = new char[len];

        for(int i = 0; i < len; ++i) {
            int index = rd.nextInt() % lenBase;
            if (index < 0) {
                index += lenBase;
            }

            sb[i] = strBase[index];
        }

        return new String(sb);
    }
}
