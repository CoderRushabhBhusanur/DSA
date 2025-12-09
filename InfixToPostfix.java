package Stack_Example;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    // Return precedence of operators
    private static int prec(char ch) {
        switch (ch) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return -1;
    }

    // Check if char is operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Convert infix to postfix
    public static String infixToPostfix(String expr) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); ++i) {
            char ch = expr.charAt(i);

            // skip whitespace
            if (Character.isWhitespace(ch)) continue;

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // remove '('
                } // else -> mismatched parentheses; assuming valid input per problem
            }
            // If operator
            else if (isOperator(ch)) {
                // While top of stack has operator of higher precedence, or same precedence and
                // the current operator is left-associative (i.e., not '^'), pop it to output.
                while (!stack.isEmpty() && stack.peek() != '('
                        && (prec(stack.peek()) > prec(ch)
                            || (prec(stack.peek()) == prec(ch) && ch != '^'))) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
            // else ignore characters (problem says input will be valid)
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    // Simple main to read from stdin and print postfix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        String postfix = infixToPostfix(line);
        System.out.println(postfix);
    }
}
