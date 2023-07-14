package Lists.DoublyLinked;

public class Node {
    public int val;
    public Node nextNode;
    public Node prevNode;

    Node(int val, Node prevNode, Node nextNode) {
        this.val = val;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    Node (int val) {
        this.val = val;
        this.nextNode = null;
        this.prevNode = null;
    }
}
