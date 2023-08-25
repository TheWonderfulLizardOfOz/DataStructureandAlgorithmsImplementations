package HeapTree;

import BinaryTrees.BinaryHeapTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTreeTest {

    @Test
    void checkIfValidHeapTreeOnCreation() {
        BinaryHeapTree heapTree = new BinaryHeapTree(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue(checkIfBHT(heapTree));
    }

    Boolean checkIfBHT(BinaryHeapTree heapTree) {
        Boolean bht = true;
        int halfLength = heapTree.length()/2;
        for (int i = 1; i <= halfLength; i++) {
            if (heapTree.get(i) < heapTree.get((i*2))) {
                bht = false;
            }
            if ((i*2) + 1 < halfLength/2) {
                if (heapTree.get(i) < heapTree.get((i*2) + 1)) {
                    bht = false;
                }
            }
        }
        return bht;
    }

    @Test
    void insert() throws Exception {
        BinaryHeapTree heapTree = new BinaryHeapTree(12, new int[]{2, 3, 4, 5, 7, 8, 9, 10});
        //insert smallest
        heapTree.insert(1);
        assertTrue(checkIfBHT(heapTree));

        //insert largest
        heapTree.insert(11);
        assertTrue(checkIfBHT(heapTree));

        //insert middle
        heapTree.insert(6);
        assertTrue(checkIfBHT(heapTree));
    }

    @Test
    void delete() throws Exception {
        BinaryHeapTree heapTree = new BinaryHeapTree(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        //delete leaf
        heapTree.delete(10);
        assertTrue(checkIfBHT(heapTree));

        //delete root
        heapTree.delete(1);
        assertTrue(checkIfBHT(heapTree));

        //delete middle level
        heapTree.delete(3);
        assertTrue(checkIfBHT(heapTree));
    }
}