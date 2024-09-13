package org.example;
import org.junit.jupiter.api.Test;

/*
    @author Nibe
    @project lab1
    @class ConverterTest
    @version 1
    @since 13.09.2024 - 16:21
*/

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    public void testConvert1ToRoman() {
        assertEquals("I", Converter.convertArabicToRoman(1));
    }

    @Test
    public void testConvert2ToRoman() {
        assertEquals("II", Converter.convertArabicToRoman(2));
    }

    @Test
    public void testConvert4ToRoman() {
        assertEquals("IV", Converter.convertArabicToRoman(4));
    }

    @Test
    public void testConvert5ToRoman() {
        assertEquals("V", Converter.convertArabicToRoman(5));
    }

    @Test
    public void testConvert9ToRoman() {
        assertEquals("IX", Converter.convertArabicToRoman(9));
    }

    @Test
    public void testConvert10ToRoman() {
        assertEquals("X", Converter.convertArabicToRoman(10));
    }

    @Test
    public void testConvert14ToRoman() {
        assertEquals("XIV", Converter.convertArabicToRoman(14));
    }

    @Test
    public void testConvert19ToRoman() {
        assertEquals("XIX", Converter.convertArabicToRoman(19));
    }

    @Test
    public void testConvert40ToRoman() {
        assertEquals("XL", Converter.convertArabicToRoman(40));
    }

    @Test
    public void testConvert45ToRoman() {
        assertEquals("XLV", Converter.convertArabicToRoman(45));
    }
    // 10

    @Test
    public void testConvert49ToRoman() {
        assertEquals("XLIX", Converter.convertArabicToRoman(49));
    }

    @Test
    public void testConvert50ToRoman() {
        assertEquals("L", Converter.convertArabicToRoman(50));
    }

    @Test
    public void testConvert90ToRoman() {
        assertEquals("XC", Converter.convertArabicToRoman(90));
    }

    @Test
    public void testConvert95ToRoman() {
        assertEquals("XCV", Converter.convertArabicToRoman(95));
    }

    @Test
    public void testConvert99ToRoman() {
        assertEquals("XCIX", Converter.convertArabicToRoman(99));
    }

    @Test
    public void testConvert100ToRoman() {
        assertEquals("C", Converter.convertArabicToRoman(100));
    }

    @Test
    public void testConvert400ToRoman() {
        assertEquals("CD", Converter.convertArabicToRoman(400));
    }

    @Test
    public void testConvert445ToRoman() {
        assertEquals("CDXLV", Converter.convertArabicToRoman(445));
    }

    @Test
    public void testConvert449ToRoman() {
        assertEquals("CDXLIX", Converter.convertArabicToRoman(449));
    }

    @Test
    public void testConvert495ToRoman() {
        assertEquals("CDXCV", Converter.convertArabicToRoman(495));
    }
    //20

    @Test
    public void testConvert499ToRoman() {
        assertEquals("CDXCIX", Converter.convertArabicToRoman(499));
    }

    @Test
    public void testConvert500ToRoman() {
        assertEquals("D", Converter.convertArabicToRoman(500));
    }

    @Test
    public void testConvert900ToRoman() {
        assertEquals("CM", Converter.convertArabicToRoman(900));
    }

    @Test
    public void testConvert950ToRoman() {
        assertEquals("CML", Converter.convertArabicToRoman(950));
    }

    @Test
    public void testConvert990ToRoman() {
        assertEquals("CMXC", Converter.convertArabicToRoman(990));
    }

    @Test
    public void testConvert995ToRoman() {
        assertEquals("CMXCV", Converter.convertArabicToRoman(995));
    }

    @Test
    public void testConvert999ToRoman() {
        assertEquals("CMXCIX", Converter.convertArabicToRoman(999));
    }

    @Test
    public void testConvert1000ToRoman() {
        assertEquals("M", Converter.convertArabicToRoman(1000));
    }

    @Test
    public void testConvert3900ToRoman() {
        assertEquals("MMMCM", Converter.convertArabicToRoman(3900));
    }

    @Test
    public void testConvert3995ToRoman() {
        assertEquals("MMMCMXCV", Converter.convertArabicToRoman(3995));
    }
    //30

    @Test
    public void testConvertNumberJustUnderLimit() {
        assertEquals("MMMCMXCIX", Converter.convertArabicToRoman(3999));
    }

    @Test
    public void testConvertInvalidNumberZero() {
        assertNull(Converter.convertArabicToRoman(0));
    }

    @Test
    public void testConvertNegativeNumber() {
        assertNull(Converter.convertArabicToRoman(-5));
    }

    @Test
    public void testConvertNumberGreaterThan3999() {
        assertNull(Converter.convertArabicToRoman(4000));
    }

    @Test   // ну технічно це можливо, оскільки берелься просто значення A із ASCII
    public void testConvertInvalidNumberNonNumeric() {
        assertNotNull(Converter.convertArabicToRoman((int) 'A'));
    }

    @Test
    public void testConvertInvalidLargeNegativeNumber() {
        assertNull(Converter.convertArabicToRoman(-5000));
    }

    @Test
    public void testConvertInvalidNonNumberString() {
        try {
            Integer.parseInt("Hello");
            fail("Should throw NumberFormatException");
        } catch (NumberFormatException e) {
            // Test passed
        }
    }

    @Test
    public void testExtremelyLargeNumber() {
        assertNull(Converter.convertArabicToRoman(Integer.MAX_VALUE));
    }

    @Test
    public void testInputNotModified() {
        int originalInput = 1987;
        Converter.convertArabicToRoman(originalInput);
        assertEquals(1987, originalInput);
    }

    @Test
    public void testExtremelySmallNumber() {
        assertNull(Converter.convertArabicToRoman(-1000000));
    }
    //40

/*
    @Test
    public void testFloatInput() {
        try {
            Converter.convertArabicToRoman((int) 5.5);
            fail("Expected ClassCastException");
        } catch (ClassCastException e) {
            // очікувана помилка
        }
    }*/

}