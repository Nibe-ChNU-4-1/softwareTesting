package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    @author Nibe
    @project Main.java
    @class ConverterTest
    @version 1
    @SE 14.09.2024 - 10:49
*/

class ConverterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenRomanIsNullThenReturnFalse() {
        assertFalse(Converter.validateRoman(null));
    }

    @Test
    void whenRomanIsEmptyThenReturnFalse() {
        assertFalse(Converter.validateRoman(""));
    }

    @Test
    void whenRomanContainsArabicNumbersThenReturnFalse() {
        assertFalse(Converter.validateRoman("XIV123"));
    }

    @Test
    void whenRomanContainsInvalidSymbolsThenReturnFalse() {
        assertFalse(Converter.validateRoman("XIV%M"));
    }

    @Test
    void whenRomanContainsCyrillicSymbolsThenReturnFalse() {
        assertFalse(Converter.validateRoman("ХІСМ"));
    }

    @Test
    void whenRomanIsLowerCaseThenReturnFalse() {
        assertFalse(Converter.validateRoman("xiv"));
    }

    @Test
    void whenRomanContainsNonRomanCharactersThenReturnFalse() {
        assertFalse(Converter.validateRoman("XIV;LM"));
    }

    @Test
    void whenRomanContainsInvalidCombinationsThenReturnFalse() {
        assertFalse(Converter.validateRoman("IIXII"));
    }

    @Test
    void whenRomanIsValidThenReturnTrue() {
        assertTrue(Converter.validateRoman("XIV"));
    }

    @Test
    void whenRomanIsValidLargeNumberThenReturnTrue() {
        assertTrue(Converter.validateRoman("MCMXCIV")); // 1994
    }
}