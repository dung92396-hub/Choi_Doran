package Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int index = i;
            while (index > 0 && nums[index] < nums[index - 1]) {
                Swap.swap(nums, index, index - 1);
                --index;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 6, 3, 9, 1, 2, 5 };
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
