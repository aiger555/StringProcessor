# StringProcessor
isStrongPassword Method: This method checks if a provided password is strong. A strong password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol.

isSpecialChar Method:This is a helper method used by isStrongPassword to check if a given character is a special symbol.

calculateDigits Method:This method counts the number of digits in the given sentence and returns the count.

calculateWords Method: This method calculates the number of words in the given sentence, considering words as separated by spaces.


testIsStrongPassword Method:This method contains test cases for the isStrongPassword method. It uses assertions from the org.testng.AssertJUnit class to check if the actual results match the expected results.

testCalculateDigits Method:This method contains test cases for the calculateDigits method, checking if the actual digit count matches the expected count.

testCalculateWords Method:This method contains test cases for the calculateWords method, checking if the actual word count matches the expected count.
