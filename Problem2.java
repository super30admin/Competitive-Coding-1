// Question:
// A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to 
// the values in the children of that node. Mapping the elements of a heap into an array is trivial: 
// if a node is stored an index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

// Time Complexities:
//// upHeapify() : O(log n)
//// downheapify() : O(log n)
//// printMinHeap() : O(n)
// insert() : O(log n)
// extractMin() : O(log n)
// getMin() : O(1)

// Space Complexity : O(n)

// where n is the number of elements in the heap.


import java.util.*;

class Problem2 {

    static List<Integer> minHeap = new ArrayList<Integer>();
    static int size;

    private static void swap(int idx1, int idx2) {
        int t = minHeap.get(idx1);
        minHeap.set(idx1, minHeap.get(idx2));
        minHeap.set(idx2, t);
    }

    private static void upHeapify(int idx) {
        if (idx == 0)
            return;

        int parentIdx = (idx - 1) / 2;

        if (minHeap.get(idx) < minHeap.get(parentIdx)) {
            swap(idx, parentIdx);
            upHeapify(parentIdx);
        }
    }

    private static void downHeapify(int idx) {
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;

        int minIdx = idx;

        if (leftIdx < size && minHeap.get(leftIdx) < minHeap.get(minIdx)) {
            minIdx = leftIdx;
        }
        
        if (rightIdx < size && minHeap.get(rightIdx) < minHeap.get(minIdx)) {
            minIdx = rightIdx;
        }

        if (idx != minIdx) {
            swap(idx, minIdx);
            downHeapify(minIdx);
        }

    }

    private static void insert(int val) {
        minHeap.add(val);
        size++;
        int idx = size - 1;
        upHeapify(idx);
    }

    private static int extractMin() {
        if (size == 0) {
            System.out.println("Heap is Empty.!!");
            return Integer.MIN_VALUE;
        }
        int min = minHeap.get(0);
        swap(0, size - 1);
        minHeap.remove(--size);
        downHeapify(0);
        return min;
    }

    private static int getMin() {
        if (size == 0) {
            System.out.println("Heap is Empty.!!");
            return Integer.MIN_VALUE;
        }
        return minHeap.get(0);
    }

    private static void printMinHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(minHeap.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        insert(5);
        insert(3);
        insert(17);
        insert(10);
        insert(84);
        insert(19);
        insert(6);
        insert(22);
        insert(9);

        printMinHeap();

        System.out.println("Extracted Min: " + extractMin());

        printMinHeap();

        System.out.println("Min Element: " + getMin());

        printMinHeap();

        insert(-1);

        printMinHeap();

        insert(0);

        printMinHeap();
    }
}