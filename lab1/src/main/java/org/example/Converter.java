package org.example;

/*
    @author Nibe
    @project lab1
    @class Converter
    @version 1
    @since 13.09.2024 - 15:32
*/

public class Converter {
    public static String convertArabicToRoman(int number) {

        if (number < 1 || number > 3999) {
            return null;
        }

        int[] arabic = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder res = new StringBuilder();

        int i = arabic.length - 1;
        while (i >= 0) {
            if (arabic[i] <= number) {
                res.append(roman[i]);
                number -= arabic[i];
            } else {
                i--;
            }
        }

        return res.toString();
    }
}
