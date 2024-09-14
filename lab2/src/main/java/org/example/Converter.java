package org.example;

/*
    @author Nibe
    @project lab2
    @class Converter
    @version 1
    @SE 14.09.2024 - 4:34
*/

public class Converter {

    public static int convertRomanToArabic(String roman) {

        if (!validateRoman(roman)) {
            throw new IllegalArgumentException("Invalid roman");
        }

        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] numerals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int result = 0;
        int pos = 0;

        while (pos < roman.length()) {
            boolean found = false;

            if (pos + 1 < roman.length()) {
                for (int i = 0; i < numerals.length; i++) {
                    if (roman.substring(pos, pos + 2).equals(numerals[i])) {
                        pos += 2;
                        result += values[i];
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                for (int i = 0; i < numerals.length; i++) {
                    if (roman.substring(pos, pos + 1).equals(numerals[i])) {
                        pos += 1;
                        result += values[i];
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static boolean validateRoman(String roman) {
        if (roman == null || roman.isEmpty()) {
            return false;
        }

        String romanRegex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return roman.matches(romanRegex);
    }

}
