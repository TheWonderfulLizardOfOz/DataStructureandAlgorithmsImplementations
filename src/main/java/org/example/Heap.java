package org.example;

public class Heap {

    int MAXSIZE = 0;

    int[] heap;

    int n = 0;

    public Heap(int max){
        this.MAXSIZE = max;
        this.heap = new int[max+1];

    }

    public Heap(int max, int[] array) {
        this.MAXSIZE = max;
        this.n = array.length;
        this.heap = new int[max + 1];
        System.arraycopy(array, 0, heap, 1, n);

        this.heapify();
    }
    public void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    public void bubbleUp(int index) {
        while (index != 1 && heap[index] > heap[index/2]) {
            swap(index, index/2);
            index = index/2;
        }
    }

    public void insert(int value) throws Exception {
        if (n != MAXSIZE) {
            n++;
            heap[n] = value;
            bubbleUp(n);
        } else {
            throw new Exception("Heap is full");
        }
    }

    public void bubbleDown(int index) {
        if (n > index*2) {
            if (heap[index*2] >= heap[index*2 + 1]) {
                if (heap[index] < heap[index*2]) {
                    swap(index, index * 2);
                    index = index * 2;
                    bubbleDown(index);
                }
            } else if (heap[index] < heap[index*2 + 1]) {
                swap(index, index*2 + 1);
                index = index*2 + 1;
                bubbleDown(index);
            }

        } else if (index <= n/2) {
            if (heap[index] < heap[index*2]) {
                swap(index, index * 2);
            }
        }
    }

    public void delete(int index) throws Exception {
        if (n < 1) {
            throw new Exception("EmptyHeapException");
        }
        if (index < 1 || index > n) {
            throw new IndexOutOfBoundsException();
        }
        swap(index, n);
        n--;
        bubbleUp(index);
        bubbleDown(index);
    }

    public void print() {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ",heap[i]);
        }
        System.out.println("");
    }

    public void heapify() {
        for (int j = n/2; j > 0; j--) {
            bubbleDown(j);
        }
    }
}
