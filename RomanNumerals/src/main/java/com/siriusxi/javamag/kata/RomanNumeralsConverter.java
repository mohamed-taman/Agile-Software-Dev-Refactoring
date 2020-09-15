package com.siriusxi.javamag.kata;

public class RomanNumeralsConverter {
  static int convert(String romanNumeral) {
    if (romanNumeral.equals("I")) {
      return 1;
    } else if (romanNumeral.equals("V")) {
      return 5;
    } else if (romanNumeral.equals("X")) {
      return 10;
    } else if (romanNumeral.equals("L")) {
      return 50;
    } else if (romanNumeral.equals("C")) {
      return 100;
    } else if (romanNumeral.equals("D")) {
      return 500;
    } else {
      return 1000;
    }
  }
}
