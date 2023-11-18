import java.util.regex.*;
import java.util.Stack;

public class StringProcessor {

    /**
     * Checks if the provided password is strong.
     * A strong password must contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol.
     * Returns true if the password is strong; otherwise, returns false.
     */
    public boolean isStrongPassword(String password) {
        // Ensure at least one uppercase letter, one lowercase letter, one digit, and one special symbol
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    /**
     * Counts the number of digits in the given sentence.
     * Returns the count of digits.
     */
    public int calculateDigits(String sentence) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the number of words in the given sentence.
     * Words are considered separated by spaces.
     * Returns the count of words.
     */
    public int calculateWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    /**
     * Given a string containing an expression with numbers, arithmetic operations, and brackets.
     * Calculates and returns the result of the expression.
     * You can assume a valid and well-formed expression.
     *
     * @param expression The mathematical expression to be evaluated.
     * @return The result of the expression.
     * @throws ArithmeticException if division by zero is encountered.
     */
    public double calculateExpression(String expression) {
        // Using a Stack to evaluate the expression with brackets
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        try {
            for (char c : expression.toCharArray()) {
                if (Character.isDigit(c)) {
                    operands.push(Double.parseDouble(String.valueOf(c)));
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (operators.peek() != '(') {
                        operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.pop(); // Remove '(' from the stack
                } else if (isOperator(c)) {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.push(c);
                }
            }

            while (!operators.isEmpty()) {
                operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
            }

            return operands.pop();
        } catch (ArithmeticException e) {
            // Handle division by zero exception
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }


    // Helper method to check if a character is a mathematical operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Helper method to check operator precedence
    private boolean hasPrecedence(char op1, char op2) {
        return (op2 != '(' && op2 != ')' && precedence(op1) <= precedence(op2));
    }

    // Helper method to get operator precedence
    private int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0; // Default for other characters
    }

    // Helper method to apply mathematical operators
    private double applyOperator(char operator, double operand2, double operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


}
