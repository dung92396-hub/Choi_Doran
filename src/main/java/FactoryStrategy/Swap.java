package FactoryStrategy;

import java.util.List;

public class Swap<T extends Number> {
    public void swap(List<T> nums, int i, int j) {
        T temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
