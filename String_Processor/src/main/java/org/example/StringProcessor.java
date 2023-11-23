package org.example;

import org.apache.commons.lang3.math.NumberUtils;
import org.mozilla.javascript.Scriptable;

import javax.naming.Context;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StringProcessor {

    /**
     * Checks if the provided password is strong.
     * A strong password must contain at least one uppercase letter,
     * one lowercase letter, one digit, and one special symbol.
     * Returns true if the password is strong; otherwise, returns false.
     */
    public boolean isStrongPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Password must be at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one uppercase letter, one lowercase letter, one digit, and one special symbol
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (isSpecialChar(ch)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    // Helper method to check if a character is a special symbol
    private boolean isSpecialChar(char ch) {
        String specialChars = "!@#$%^&*()-+";
        return specialChars.contains(String.valueOf(ch));
    }

    /**
     * Counts the number of digits in the given sentence.
     * Returns the count of digits.
     */
    public int calculateDigits(String sentence) {
        int digitCount = 0;
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
            }
        }
        return digitCount;
    }

    /**
     * Calculates the number of words in the given sentence.
     * Words are considered separated by spaces.
     * Returns the count of words.
     */
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        // Split the sentence by spaces and count the words
        String[] words = sentence.split("\\s+");
        return words.length;
    }

}