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
        assertEquals(1, RomanNumeralsConverter.convert("I"));
        assertEquals(5, RomanNumeralsConverter.convert("V"));
        assertEquals(10, RomanNumeralsConverter.convert("X"));
    }

}
