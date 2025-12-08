package Lab9;

import java.util.*;

public class MyLIFO_App {
    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        stack.addAll(List.of(array));
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public boolean isCorrect(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
            return false;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            if (!st.isEmpty()) {
                if (s.charAt(i) == ')') {
                    if (st.peek() != '(') {
                        return false;
                    } else {
                        st.pop();
                    }
                }
                if (s.charAt(i) == '}') {
                    if (st.peek() != '{') {
                        return false;
                    } else {
                        st.pop();
                    }
                }
                if (s.charAt(i) == ']') {
                    if (st.peek() != '[') {
                        return false;
                    } else {
                        st.pop();
                    }
                }
            } else
                return false;
        }

        if (!st.isEmpty())
            return false;

        return true;
    }

    public static int evaluateExpression(String expression) {
        Stack < Integer > values = new Stack < > ();
        Stack < Character > operators = new Stack < > ();

        int i = 0;
        while (i < expression.length()) {
            char currentChar = expression.charAt(i);

            if (currentChar == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(currentChar)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                values.push(num);
            } else if (currentChar == '(') {
                operators.push(currentChar);
                i++;
            } else if (currentChar == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
                i++;
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operators.isEmpty() && hasPrecedence(currentChar, operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(currentChar);
                i++;
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

    public static boolean hasPrecedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')') {
            return false;
        }
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
