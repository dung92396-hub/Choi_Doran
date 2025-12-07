package Lab9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MyLIFO_App {
    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        stack.addAll(List.of(array));
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isCorrect(String input) {
        HashMap<Character, Integer> hash1 = new HashMap<>();
        hash1.put('(', 1);
        hash1.put(')', 1);
        hash1.put('{', 2);
        hash1.put('}', 2);
        hash1.put('[', 3);
        hash1.put(']', 3);

        HashMap<Character, Boolean> hash2 = new HashMap<>();
        hash2.put('(', true);
        hash2.put(')', false);
        hash2.put('{', true);
        hash2.put('}', false);
        hash2.put('[', true);
        hash2.put(']', false);

        if (!hash2.get(input.charAt(0))) return false;

        Stack<Character> stack = new Stack<>();
        stack.add(input.charAt(0));

        for (int i = 1; i < input.length(); ++i) {

        }

        return false;
    }

    public static int evaluateExpression(String expression) {


        return 0;
    }

    public static void main(String[] args) {

    }
}
