package FactoryStrategy;

import lombok.Data;

import java.util.List;

@Data
public class SortingAlgorithm<T extends Number> {
    private Sorting<T> sorting;

    public SortingAlgorithm() {
        this.sorting = new BubbleSort<>();
    }

    public void setSorting(SortType type) {
        this.sorting = switch (type) {
            case BUBBLE -> new BubbleSort<>();
            case SELECTION -> new SelectionSort<>();
        };
    }

    public void sort(List<T> nums) {
        System.out.println("Sort with " + sorting.getClass().getSimpleName());
        sorting.sort(nums);
    }

    public void setSortingAndSort(SortType t, List<T> nums) {
        this.setSorting(t);
        this.sort(nums);
    }
}
