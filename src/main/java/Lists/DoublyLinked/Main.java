package Lists.DoublyLinked;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(2);
        list.add(3);
        list.print();

        list.addBeginning(4);
        list.addBeginning(6);
        list.print();

        list.removeFirst();
        list.print();

        list.removeLast();
        list.print();

        list.removeFirst();
        list.removeFirst();
        list.add(11);
        list.add(12);
        list.remove(1);
        list.print();

        list.add(12);
        list.add(13);
        list.print();
        list.addAt(1, 2);
        list.print();
        list.addAt(0, 6);
        list.print();

        System.out.println(list.get(3));
    }
}
