package Sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length - 1 - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    Swap.swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 6, 3, 9, 1, 2, 5 };
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
