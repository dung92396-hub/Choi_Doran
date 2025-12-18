package Leetcode;

import java.util.*;

public class Problem17 {
    public static void recursion(List<String> store, List<Integer> indexes, char[][] phoneNumber, String digits, String currentString, int digitIndex) {
        if (digitIndex == digits.length()) return;
        for (int i = 0; i < phoneNumber[indexes.get(digitIndex)].length; ++i) {
            char nextChar = phoneNumber[indexes.get(digitIndex)][i];
            if (digitIndex < digits.length() - 1) {
                recursion(store, indexes, phoneNumber, digits, currentString + nextChar, digitIndex + 1);
            } else {
                System.out.println(currentString + nextChar);
                store.add(currentString + nextChar);
            }
        }
    }


    public static List<String> letterCombination(String digits) {
       char[][] phoneNumber = {
               {},
               {},
               { 'a', 'b', 'c' },
               { 'd', 'e', 'f' },
               { 'g', 'h', 'i' },
               { 'j', 'k', 'l' },
               { 'm', 'n', 'o' },
               { 'p', 'q', 'r', 's' },
               { 't', 'u', 'v' },
               { 'w', 'x', 'y', 'z' },
       };
       List<String> store = new ArrayList<>();
       List<Integer> indexes = new ArrayList<>();
       for (char ch : digits.toCharArray()) {
           indexes.add(Integer.parseInt(ch + ""));
       }
       recursion(store, indexes, phoneNumber, digits, "", 0);

       return store;
    }

    public static void main(String[] args) {
        System.out.println(letterCombination("234"));
    }
}
