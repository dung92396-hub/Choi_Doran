package FactoryStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        List<Integer> nums = new ArrayList<>(List.of(8, 6, 9, 3, 5, 1, 2));
        sortingAlgorithm.setSorting(SortType.SELECTION);
        sortingAlgorithm.sort(nums);
        System.out.println(nums);
    }
}
