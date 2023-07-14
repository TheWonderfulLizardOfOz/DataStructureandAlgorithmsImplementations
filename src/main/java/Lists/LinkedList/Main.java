package Lists.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(null);
        list.insertStart(1);
        list.print();

        list.insertStart(2);
        list.print();

        list.deleteStart();
        list.print();

        list.deleteEnd();
        list.print();

        int[] nums = {1, 2, 3};
        list.insert(nums);
        list.print();

        list.insert(nums);
        list.print();

        list.deleteEnd();
        list.print();

        list.remove(3);
        list.print();

        list.remove(3);
        list.print();

        System.out.println(list.get(1));

        list.insertAt(3, 10);
        list.print();

        System.out.println(list.length());
    }
}
