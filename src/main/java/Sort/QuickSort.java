package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pi = partition(nums, left, right);
            
            quickSort(nums, left, pi - 1);
            quickSort(nums, pi + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                Swap.swap(nums, i, j);
            }
        }
        
        Swap.swap(nums, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 3, 2, 9, 1, 5, 4 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
