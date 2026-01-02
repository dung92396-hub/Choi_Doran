package Leetcode;

public class Leetcode133 {

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            count = row.length - binarySearch(row);
        }
        return count;
    }

    public static int binarySearch(int[] arr) {
        int idx = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= 0) {
                left = mid + 1;
            } else {
                idx = mid;
                right = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { 10, 9, 5, 3, -3, -2, -10 }));
    }
}
