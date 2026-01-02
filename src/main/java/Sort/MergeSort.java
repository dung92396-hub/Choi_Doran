package Sort;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] Left = new int[n1];
        int[] Right = new int[n2];

        for (int i = 0; i < n1; ++i) Left[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) Right[j] = arr[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                ++i;
            } else {
                arr[k] = Right[j];
                ++j;
            }
            ++k;
        }

        while (i < n1) {
            arr[k] = Left[i];
            ++i;
            ++k;
        }

        while (j < n2) {
            arr[k] = Right[j];
            ++j;
            ++k;
        }
    }


    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle - 1);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }


    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 4, 9, 8};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
