package Tree;

public class BinarySearchTree<T> {
    private T value;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public BinarySearchTree(T value) {
        this.value = value;
    }

    public BinarySearchTree() {};

    public void insert(T value) {
        this.internalInsert(value);
    }

    private void internalInsert(T value) {

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinarySearchTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree<T> left) {
        this.left = left;
    }

    public BinarySearchTree<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchTree<T> right) {
        this.right = right;
    }
}
