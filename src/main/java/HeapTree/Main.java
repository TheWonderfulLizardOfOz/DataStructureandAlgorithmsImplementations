package HeapTree;

public class Main {
    public static void main(String[] args) throws Exception {
        BinaryHeapTree heap = new BinaryHeapTree(30,new int[]{1,2,3,4,5,6,7,8,9,10});
        heap.print();
        heap.insert(11);
        heap.print();
        heap.delete(1);
        heap.print();
    }
}