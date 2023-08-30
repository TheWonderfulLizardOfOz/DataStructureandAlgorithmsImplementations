package BinaryTrees;

public class BinaryTree {
    public Integer value;
    private BinaryTree leftSubtree;
    private BinaryTree rightSubtree;

    public BinaryTree(int value, BinaryTree leftSubtree, BinaryTree rightSubtree) {
        this.value = value;
        this.leftSubtree = leftSubtree;
        this.rightSubtree = rightSubtree;
    }

    public BinaryTree(int value) {
        this.value = value;
        this.leftSubtree = null;
        this.rightSubtree = null;
    }

    public BinaryTree() {
        this.value = null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean isLeaf() {
        return this.leftSubtree == null && this.rightSubtree == null;
    }

    public int root() throws Exception {
        if (this.value != null) {
            return value;
        }
        throw new Exception("EmptyTreeException");
    }

    public BinaryTree left() throws Exception {
        if (!this.isEmpty()) {
            return this.leftSubtree;
        }
        throw new Exception("EmptyTreeException");
    }

    public BinaryTree right() throws Exception {
        if (!this.isEmpty()) {
            return this.rightSubtree;
        }
        throw new Exception("EmptyTreeException");
    }
}
