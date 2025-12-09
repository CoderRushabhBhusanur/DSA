package Stack_Example;
import java.util.Stack;
import java.util.Scanner;

public class PrefixEvaluation {

    // Function to evaluate prefix expression
    public static int evaluatePrefix(String expr) {
        Stack<Integer> stack = new Stack<>();

        // Scan from right to left
        for (int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);

            // Skip spaces if present
            if (Character.isWhitespace(ch)) continue;

            // If operand, push to stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // convert char to int
            }
            // If operator, pop two values and apply operator
            else {
                int a = stack.pop();
                int b = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        sc.close();

        System.out.println(evaluatePrefix(expr));
    }
}
