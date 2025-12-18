package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem1380 {
    public static List<Integer> luckyNumber(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        List<Integer> minIndexRow = new ArrayList<>();

        for (int i = 0; i < matrix.length; ++i) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; ++j) {
                minIndex = matrix[i][j] < min ? j : minIndex;
            }
            minIndexRow.add(minIndex);
        }
        // chua code xong
        return null;
    }

    public static void main(String[] args) {
        luckyNumber(new int[][] {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17},
        });
    }
}
