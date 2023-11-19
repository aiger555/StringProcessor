import javax.script.ScriptException;

public class Main {
    // Test cases
    public static void main(String[] args) {
        StringProcessor stringProcessor = new StringProcessor();

        // Test Cases for isStrongPassword
        System.out.println("Test Cases for isStrongPassword:");
        System.out.println("Test Case 1: " + stringProcessor.isStrongPassword("Strong@Password1")); // true
        System.out.println("Test Case 2: " + stringProcessor.isStrongPassword("WeakPassword")); // false
        System.out.println("Test Case 3: " + stringProcessor.isStrongPassword("NoSpecialSymbol1")); // false
        System.out.println("Test Case 4: " + stringProcessor.isStrongPassword("TooShort1$")); // false
        System.out.println("Test Case 5: " + stringProcessor.isStrongPassword("AllCAPS&123")); // false

        // Test Cases for calculateDigits
        System.out.println("\nTest Cases for calculateDigits:");
        System.out.println("Test Case 1: " + stringProcessor.calculateDigits("Hello123World")); // 3
        System.out.println("Test Case 2: " + stringProcessor.calculateDigits("NoDigitsHere")); // 0
        System.out.println("Test Case 3: " + stringProcessor.calculateDigits("12345")); // 5
        System.out.println("Test Case 4: " + stringProcessor.calculateDigits("DigitsInside123")); // 3
        System.out.println("Test Case 5: " + stringProcessor.calculateDigits("Special@Chars!")); // 0

        // Test Cases for calculateWords
        System.out.println("\nTest Cases for calculateWords:");
        System.out.println("Test Case 1: " + stringProcessor.calculateWords("This is a test sentence.")); // 5
        System.out.println("Test Case 2: " + stringProcessor.calculateWords(" SingleWord ")); // 1
        System.out.println("Test Case 3: " + stringProcessor.calculateWords("")); // 0
        System.out.println("Test Case 4: " + stringProcessor.calculateWords("Multiple    Spaces  Between Words")); // 5
        System.out.println("Test Case 5: " + stringProcessor.calculateWords("   ")); // 0

        // Test Cases for calculateExpression
        System.out.println("\nTest Cases for calculateExpression:");
        System.out.println("Test Case 1: " + stringProcessor.calculateExpression("2+3*4")); // 14.0
        System.out.println("Test Case 2: " + stringProcessor.calculateExpression("(2+3)*4")); // 20.0
        System.out.println("Test Case 3: " + stringProcessor.calculateExpression("5*(2+3)")); // 25.0
        System.out.println("Test Case 4: " + stringProcessor.calculateExpression("(4+8)/2")); // 6.0
        //System.out.println("Test Case 5: " + stringProcessor.calculateExpression("3*(5/0)")); // Throws ArithmeticException
    }
}
