package ThiCuoiKi;

import java.util.LinkedList;

public class Main {

    public static int max(int[] nums, int idx) {
        if (idx == 0) return nums[idx];
        return Math.max(nums[idx], max(nums, idx - 1));
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 7, 9, 6, 4, 1};
        System.out.println(max(nums, nums.length - 1));
    }
}
