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
        for (int i = 0; i < index - 1; i++) {
            if (cursor == null) {
                throw new IndexOutOfBoundsException();
            }
            cursor = cursor.nextNode;
        }
        if (cursor.nextNode != null) {
            cursor.nextNode = cursor.nextNode.nextNode;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //gets value of node at index in the argument
    public int get(int index) {
         Node cursor = list;
         for (int i = 0; i < index; i++) {
             if (cursor == null) {
                 throw new IndexOutOfBoundsException();
             }
             cursor = cursor.nextNode;
         }
         if (cursor != null) {
             return cursor.val;
         } else {
             throw new IndexOutOfBoundsException();
         }
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

    public void print() {
        Node cursor = list;
        while (cursor != null) {
            System.out.printf("%d", cursor.val);
            System.out.printf(" ");
            cursor = cursor.nextNode;
        }
        System.out.println();
    }
}
