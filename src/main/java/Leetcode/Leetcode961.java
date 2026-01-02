package Leetcode;

import java.util.*;

public class Leetcode961 {
//    public static int repeatedNTimes(int[] nums) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int v : nums) {
//            freq.putIfAbsent(v, 1);
//            freq.compute(v, (k, amount) -> amount + 1);
//        }
//
//        return freq.entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElseThrow();
//    }

    public static int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(freq);
        int result = 0;
        for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
                System.out.println(m.getValue());
            if (m.getValue() == n) {
                result = m.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(1, 1);
        freq.put(2, 1);
        freq.put(3, 2);
//        System.out.println(freq.get(3));
        System.out.println(repeatedNTimes(new int[] { 1, 2, 3, 3 }));
    }

}
