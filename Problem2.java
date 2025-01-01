// Approach (insert, extractMin, heapify):
// insert/add to min-heap - To insert a new element into the min-heap, add it to the end of the heap array and bubble it up by
// comparing it with its parent. Continue this process until the heap property is restored at all ancestor nodes.

// extractMin - Remove and store the first element of heap array. If heap has remaining elements, remove the last element and add it to the
// front of heap array and heapify (bubble down from root) the array. Return the initially stored element as minimum.

// heapify - Starting at the root, compare the current node with its left and right children to check for any violations of the heap property.
// If a violation is found, ensure the current node holds the smallest value by swapping it with the smaller child. Update the current index
// to the index of the swapped child and repeat this process. Continue until the current node holds the smallest value among itself, its left
// child, and its right child. This is a linear time operation.

// Time Complexity : getMin - O(1), extractMin - O(n)  since it calls heapify inside, insert - O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Reference: https://www.geeksforgeeks.org/heap-implementation-in-java/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class MinHeap {

    private List<Integer> minHeap;
    MinHeap() {
        minHeap = new ArrayList<>();
    }

    // Three important methods to implement - add/insert, getMin, extractMin
    void add(int num) {
        minHeap.add(num);
        int idx = minHeap.size() - 1;
        // Bubble UP to restore heap property
        while (idx > 0 && minHeap.get(idx) < minHeap.get(getParent(idx))) {
            swapValuesAt(idx, getParent(idx));
            idx = getParent(idx);
        }
    }

    int getMin() {
        if (minHeap.isEmpty()) {
            throw new RuntimeException("Heap is empty..");
        }
        return minHeap.get(0);
    }

    // Calls heapify inside
    int extractMin() {
        if (minHeap.isEmpty()) {
            throw new RuntimeException("Heap is empty..");
        }
        int min = minHeap.remove(0);
        // If there was only one element before popping min, heap becomes empty after removing and returning it
        if (!minHeap.isEmpty()) {
            int last = minHeap.remove(minHeap.size() - 1);
            minHeap.add(0, last);
            heapify(); // Bubble DOWN to restore heap property
        }
        return min;
    }

    // Helper methods below - heapfiy, getParent, getLeftChild, getRightChild, swapValuesAt, printHeap

    // Heapify an existing array TC: O(n) because half of the nodes are leaves
    // Bubble DOWN to restore heap property
    void heapify() {
        int idx = 0;
        while (true) {
            int left = getLeftChild(idx);
            int right = getRightChild(idx);

            int smallestValAt = idx;
            if (left < minHeap.size() && minHeap.get(left) < minHeap.get(smallestValAt)) {
                smallestValAt = left;
            }
            if (right < minHeap.size() && minHeap.get(right) < minHeap.get(smallestValAt)) {
                smallestValAt = right;
            }

            if (smallestValAt == idx) {
                break;
            }
            swapValuesAt(idx, smallestValAt);
            idx = smallestValAt;
        }
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    int getLeftChild(int i) {
        return 2 * i + 1;
    }

    int getRightChild(int i) {
        return 2 * i + 2;
    }

    void swapValuesAt(int i, int j) {
        int t = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, t);
    }

    void printHeap() {
        while (!minHeap.isEmpty()) {
            System.out.println(extractMin());
        }
    }

    // Heap sort uses insert/add and extractMin
    void heapSort(int[] arr) {
        for (int i : arr) {
            add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = extractMin();
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
//        heap.add(10);
//        heap.add(5);
//        heap.add(30);
//        heap.add(12);
//        System.out.println("Minimum element is (-1 if heap is empty): " + heap.getMin());
//        heap.extractMin();
//        System.out.println("Minimum element after popping once is (-1 if heap is empty): " + heap.getMin());
//        System.out.println("Remaining heap elements are..");
//        heap.printHeap();
        int[] arr = { 5, 9, 2, 4, 1, 3, 8, 6, 10, 7 };
        heap.heapSort(arr);
    }
}
