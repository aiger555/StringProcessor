package org.example;

import org.junit.Test;

import static org.testng.AssertJUnit.*;

public class Main {

//    public static void main(String[] args) {
//        runTests();
//    }

    @Test
    public void testIsStrongPassword() {
        // Test cases for isStrongPassword
        StringProcessor stringProcessor = new StringProcessor();
        assertTrue(stringProcessor.isStrongPassword("Strong@123"));
        assertFalse(stringProcessor.isStrongPassword("weakpassword"));
        assertFalse(stringProcessor.isStrongPassword("Short!1"));
        assertFalse(stringProcessor.isStrongPassword("NoDigitOrSymbol"));
        assertFalse(stringProcessor.isStrongPassword("NoUppercaseorSymbol1"));
    }

    @Test
    public void testCalculateDigits() {
        // Test cases for calculateDigits
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(3, stringProcessor.calculateDigits("Hello123"));
        assertEquals(0, stringProcessor.calculateDigits("NoDigits"));
        assertEquals(5, stringProcessor.calculateDigits("12345"));
        assertEquals(2, stringProcessor.calculateDigits("Digit1Digit2"));
        assertEquals(0, stringProcessor.calculateDigits(""));
    }

    @Test
    public void testCalculateWords() {
        // Test cases for calculateWords
        StringProcessor stringProcessor = new StringProcessor();
        assertEquals(2, stringProcessor.calculateWords("Hello World"));
        assertEquals(3, stringProcessor.calculateWords("Java is fun"));
        assertEquals(1, stringProcessor.calculateWords("SingleWord"));
        assertEquals(0, stringProcessor.calculateWords(""));
        assertEquals(4, stringProcessor.calculateWords("This is a test"));
    }

}