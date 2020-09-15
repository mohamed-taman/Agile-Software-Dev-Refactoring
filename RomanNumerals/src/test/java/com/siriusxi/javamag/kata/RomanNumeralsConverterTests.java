package com.siriusxi.javamag.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanNumeralsConverterTests {
    @Test
    public void isJunitWorks(){
        assertTrue(true);
    }

    @Test
    public void convertsSingleRomanDigit(){
        int arabic = convert("I");
        assertEquals(1, arabic);
    }

    private static int convert(String romanNumeral) {
        return 1;
    }
}
