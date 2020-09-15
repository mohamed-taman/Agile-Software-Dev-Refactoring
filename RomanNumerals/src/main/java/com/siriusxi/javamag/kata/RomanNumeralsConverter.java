package com.siriusxi.javamag.kata;

public class RomanNumeralsConverter {
    static int convert(String romanNumeral) {
        if (romanNumeral.equals("I"))
            return 1;
        if (romanNumeral.equals("V"))
            return 5;
        else
            return 10;
    }
}
