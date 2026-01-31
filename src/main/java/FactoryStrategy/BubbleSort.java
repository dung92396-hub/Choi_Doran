package FactoryStrategy;

import java.util.List;

public class BubbleSort<T extends Number> extends Swap implements Sorting<T> {
    @Override
    public void sort(List<T> nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size() - i; j++) {
                if (nums.get(j).doubleValue() > nums.get(j + 1).doubleValue()) {
                    super.swap(nums, j, j + 1);
                }
            }
        }
    }
}
