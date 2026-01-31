package FactoryStrategy;

import java.util.List;

public class SelectionSort<T extends Number> extends Swap<T> implements Sorting<T> {
    @Override
    public void sort(List<T> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i).doubleValue() > nums.get(j).doubleValue()) {
                    super.swap(nums, i, j);
                }
            }
        }
    }
}
