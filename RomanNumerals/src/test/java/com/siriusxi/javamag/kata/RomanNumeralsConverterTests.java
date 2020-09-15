package com.siriusxi.javamag.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanNumeralsConverterTests {
  @Test
  public void isJunitWorks() {
    assertTrue(true);
  }

  @Test
  public void convertsSingleRomanDigit() {
    assertEquals(1, RomanNumeralsConverter.convert("I"));
    assertEquals(5, RomanNumeralsConverter.convert("V"));
    assertEquals(10, RomanNumeralsConverter.convert("X"));
    assertEquals(50, RomanNumeralsConverter.convert("L"));
    assertEquals(100, RomanNumeralsConverter.convert("C"));
    assertEquals(500, RomanNumeralsConverter.convert("D"));
    assertEquals(1000, RomanNumeralsConverter.convert("M"));
  }

  @Test public void romanNumeralAddition(){
    assertEquals(2, RomanNumeralsConverter.convert("II"));
    assertEquals(3, RomanNumeralsConverter.convert("III"));
    assertEquals(6, RomanNumeralsConverter.convert("VI"));
  }
}
