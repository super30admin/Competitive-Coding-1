
// Time Complexity : Please see below methods
// Space Complexity : O(N) (as we are using int[])
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Arrays;

class MinHeap {
    private int[] heap;
    private int index;
    private int size;

    public MinHeap(int size) {
        this.size = size;
        this.index = 0;
        heap = new int[size];
    }

    // Time Complexity : O(1) [as we return root]
    public int getMin() {
        return heap.length > 0 ? heap[0] : Integer.MAX_VALUE;
    }

    // Time Complexity : O(log N)
    public void insert(int element) {
        if (index >= size) {
            return;
        }
        heap[index] = element;
        int current = index;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    // Time Complexity : O(log N)
    // removes and returns the minimum element from the heap
    public int extractMin() {
        // since its a min heap, so root = minimum
        int popped = heap[0];
        heap[0] = heap[--index];
        minHeapify(0);
        return popped;
    }

    // builds the min-heap using the minHeapify
    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    // heapify the node at i
    private void minHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            if (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]) {
                if (heap[leftChild(i)] < heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    // swaps two nodes of the heap
    private void swap(int x, int y) {
        int tmp;
        tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
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

    public static void main(String[] arg) {
        MinHeap minHeap = new MinHeap(7);
        minHeap.insert(3);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(16);
        minHeap.insert(21);
        minHeap.insert(12);
        minHeap.insert(9);
        minHeap.minHeap();

        System.out.println("The Min Heap is : " + Arrays.toString(minHeap.heap));
        System.out.println("\nThe Min Value is : " + minHeap.extractMin());
        System.out.println("\nThe Min Heap is :" + Arrays.toString(minHeap.heap));
    }
}