package Lists.DoublyLinked;

public class DoublyLinkedList {
    public Node firstNode;
    public Node lastNode;

    DoublyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public void add(int val) {
        Node newNode;
        if (this.firstNode == null) {
            newNode = new Node(val);
            this.firstNode = newNode;
        } else {
            newNode = new Node(val, this.lastNode, null);
            this.lastNode.nextNode = newNode;
        }
        this.lastNode = newNode;
    }

    public void addBeginning(int val) {
        Node newNode = new Node(val, null, this.firstNode);
        this.firstNode.prevNode = newNode;
        this.firstNode = newNode;

        if (this.lastNode == null) {
            this.lastNode = newNode;
        }
    }

    public void addAt(int index, int val) {
        int length = this.length();
        if (index == 0) {
            this.addBeginning(val);
        } else if (index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == length) {
            this.add(val);
        } else {
            Node cursor = this.firstNode;
            for (int i = 0; i < index; i++) {
                cursor = cursor.nextNode;
            }
            Node newNode = new Node(val, cursor.prevNode, cursor);
            cursor.prevNode.nextNode = newNode;
            cursor.prevNode = newNode;

        }
    }

    public void removeFirst() {
        if (this.firstNode == null) {
            throw new IndexOutOfBoundsException();
        }

        Node secondNode = this.firstNode.nextNode;

        if (secondNode == null) {
            this.lastNode = null;
        } else {
            secondNode.prevNode = null;
        }

        this.firstNode = secondNode;
    }

    public void removeLast() {
        Node penultimateNode = this.lastNode.prevNode;
        if (penultimateNode != null) {
            penultimateNode.nextNode = null;
        } else {
            this.firstNode = null;
        }
        this.lastNode = penultimateNode;
    }

    public void remove(int index) {
        Node cursor = firstNode;
        for (int i = 0; i < index; i++) {
            if (cursor == null) {
                throw new IndexOutOfBoundsException();
            }
            cursor = cursor.nextNode;
        }
        if (cursor == null) {
            throw new IndexOutOfBoundsException();
        }
        if (cursor.prevNode == null && cursor.nextNode == null) {
            this.firstNode = null;
            this.lastNode = null;
        } else if (cursor.prevNode == null) {
            cursor.nextNode.prevNode = null;
            this.firstNode = cursor.nextNode;
        } else if (cursor.nextNode == null) {
            cursor.prevNode.nextNode = null;
            this.lastNode = cursor.prevNode;
        } else {
            cursor.prevNode.nextNode = cursor.nextNode;
            cursor.nextNode.prevNode = cursor.prevNode;
        }
    }

    public int get(int index) {
        int length = this.length();
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node cursor = this.firstNode;
        for (int i = 0; i < index; i++) {
            cursor = cursor.nextNode;
        }
        return cursor.val;
    }

    public void print() {
        Node cursor = this.firstNode;
        while (cursor != null) {
            System.out.printf("%d", cursor.val);
            System.out.print(" ");
            cursor = cursor.nextNode;
        }
        System.out.println();
    }

    public int length() {
        Node cursor = this.firstNode;
        int length = 0;
        while (cursor != null) {
            length++;
            cursor = cursor.nextNode;
        }
        return length;
    }
}
