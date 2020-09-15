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
        int arabic = RomanNumeralsConverter.convert("I");
        assertEquals(1, arabic);

        arabic = RomanNumeralsConverter.convert("V");
        assertEquals(5, arabic);

        arabic = RomanNumeralsConverter.convert("X");
        assertEquals(10, arabic);
    }

}
