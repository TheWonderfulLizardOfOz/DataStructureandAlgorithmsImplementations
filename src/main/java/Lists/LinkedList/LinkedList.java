package Lists.LinkedList;

public class LinkedList {
    Node list;

    LinkedList(Node startNode) {
        this.list = startNode;
    }

    LinkedList() {
        this.list = null;
    }

    public void insertStart(int number) {
        list = new Node(number, list);
    }

    public void deleteStart() {
        if (list == null) {
            throw new IndexOutOfBoundsException();
        } else {
            list = list.nextNode;
        }
    }

    public void deleteEnd() {
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        if (list.nextNode == null) {
            list = null;
        } else {
            Node cursor = list;
            while(cursor.nextNode.nextNode != null) {
                cursor = cursor.nextNode;
            }
            cursor.nextNode = null;
        }
    }

    //removes node at index in argument
    public void remove(int index) {
        Node cursor = list;

        if (index < 0 || index >= this.length()) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index - 1; i++) {
            cursor = cursor.nextNode;
        }

        cursor.nextNode = cursor.nextNode.nextNode;
    }

    //gets value of node at index in the argument
    public int get(int index) {
        if (index < 0 || index >= this.length()) {
            throw new IndexOutOfBoundsException();
        }

        Node cursor = list;
        for (int i = 0; i < index; i++) {
            cursor = cursor.nextNode;
        }
        return cursor.val;
    }

    public void insert(int val) {
        if (list == null) {
            list = new Node(val);
        } else {
            Node cursor = list;
            while (cursor.nextNode != null) {
                cursor = cursor.nextNode;
            }
            cursor.nextNode = new Node(val);
        }
    }

    public void insert(int[] args) {
        Node cursor;
        if (list == null) {
            list = new Node(args[0]);
            cursor = list;
        } else {
            cursor = list;
            while (cursor.nextNode != null) {
                cursor = cursor.nextNode;
            }
            cursor.nextNode = new Node(args[0]);
            cursor = cursor.nextNode;
        }

        for (int i = 1; i < args.length; i++) {
            cursor.nextNode = new Node(args[i]);
            cursor = cursor.nextNode;
        }
    }

    public void insertAt(int index, int val) {
        Node cursor = list;
        int length = this.length();
        if (index == 0) {
            insertStart(val);
        } else if (index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == length) {
            this.insert(val);
        } else {
            for (int i = 0; i < index - 1; i++) {
                cursor = cursor.nextNode;
            }
            cursor.nextNode = new Node(val, cursor.nextNode);
        }
    }

    public int length() {
        Node cursor = list;
        int length = 0;

        while (cursor != null) {
            length++;
            cursor = cursor.nextNode;
        }

        return length;
    }

    public void print() {
        Node cursor = list;
        while (cursor != null) {
            System.out.printf("%d", cursor.val);
            System.out.print(" ");
            cursor = cursor.nextNode;
        }
        System.out.println();
    }
}
