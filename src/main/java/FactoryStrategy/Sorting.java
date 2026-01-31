package FactoryStrategy;

import java.util.List;

public interface Sorting<T extends Number> {
    void sort(List<T> nums);
}
