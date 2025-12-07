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

        return 0;
    }

    public static void main(String[] args) {

    }
}
