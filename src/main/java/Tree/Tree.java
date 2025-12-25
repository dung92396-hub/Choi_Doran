package Tree;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    // Thêm phần tử vào cây
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            insertHelper(root, value);
        }
    }

    private void insertHelper(TreeNode node, int value) {
        if (value < node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(value));
            } else {
                insertHelper(node.getLeft(), value);
            }
        } else if (value > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(new TreeNode(value));
            } else {
                insertHelper(node.getRight(), value);
            }
        }
    }

    // Tìm kiếm phần tử
    public boolean search(int value) {
        return searchHelper(root, value);
    }

    private boolean searchHelper(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        } else if (value < node.getValue()) {
            return searchHelper(node.getLeft(), value);
        } else {
            return searchHelper(node.getRight(), value);
        }
    }

    // Xóa phần tử
    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private TreeNode deleteHelper(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.setLeft(deleteHelper(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(deleteHelper(node.getRight(), value));
        } else {
            // Node cần xóa
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Node có 2 con, lấy phần tử nhỏ nhất từ cây con phải
            TreeNode minNode = findMin(node.getRight());
            node.setValue(minNode.getValue());
            node.setRight(deleteHelper(node.getRight(), minNode.getValue()));
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // Duyệt cây theo thứ tự In-order (tăng dần)
    public void inorder() {
        if (root != null) {
            root.inOrder();
        }
        System.out.println();
    }

    // Duyệt cây theo thứ tự Pre-order
    public void preorder() {
        if (root != null) {
            root.preOrder();
        }
        System.out.println();
    }

    // Duyệt cây theo thứ tự Post-order
    public void postorder() {
        if (root != null) {
            root.postOrder();
        }
        System.out.println();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}

