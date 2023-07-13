package Lists.LinkedList;

public class Node {
    public int val;
    public Node nextNode;

    Node (int val, Node nextNode) {
        this.val = val;
        this.nextNode = nextNode;
    }

    Node (int val) {
        this.val = val;
        this.nextNode = null;
    }
}
