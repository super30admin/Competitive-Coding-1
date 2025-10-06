// Time Complexity :
// Space Complexity : 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : i dont fully understand this, i have never implement heaps before so most of the code is taken from some where

class minHeap {
    int[] heap;
    int size;
    int index;

    public minHeap(int size) {
        this.size = size;
        this.index = 0;
        this.heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    private void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;

    }

    private void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]) {
                swap(i, leftChild(i));
                minHeapify(leftChild(i));
            } else {
                swap(i, rightChild(i));
                minHeapify(rightChild(i));
            }
        }
    }

    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void insert(int num) {
        if (index >= size) {
            return;
        }
        heap[index] = num;
        int current = index;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + heap[i]);
            if (leftChild(i) < index)
                System.out.print(" Left : " + heap[leftChild(i)]);
            if (rightChild(i) < index)
                System.out.print(" Right :" + heap[rightChild(i)]);
            System.out.println();
        }
    }

    public int remove() {
        int popped = heap[0];
        heap[0] = heap[--index];
        minHeapify(0);
        return popped;
    }
}
