package Manager;

public interface Collect {
    default int add(int a, int b) {
        return a + b;
    }
}
