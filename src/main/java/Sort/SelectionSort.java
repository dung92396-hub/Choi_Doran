package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void  selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] < nums[j]) {
                    Swap.swap(nums, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 6, 3, 9, 1, 2, 5 };
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
//        C:\Users\Admin\Documents\test-java\src\main\java\Sort
    }
}
