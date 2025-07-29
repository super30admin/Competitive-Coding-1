// I used ArrayList to implement Min Heap.
// It supports insertion (add), deletion (remove), and peek in O(log n) time.
// The heap maintains the min-heap property using heapify-up and heapify-down methods.

// Time Complexity: add - O(log n), remove - O(log n), peek - O(1)
// Space Complexity: O(n) for storing 'n' elements in the ArrayList

import java.util.*;

public class MinHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Return index of parent node
    private int parent(int ind) {
        return (ind - 1) / 2;
    }

    // Return index of left child
    private int leftchild(int ind) {
        return (2 * ind) + 1;
    }

    // Return index of right child
    private int rightchild(int ind) {
        return (2 * ind) + 2;
    }

    // Return the number of elements in the heap
    public int size() {
        return heap.size();
    }

    // Return the minimum element (root), or -1 if heap is empty
    public int peek() {
        if (heap.size() == 0) return -1;
        return heap.get(0);
    }

    // Print all elements of the heap
    public void print() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Maintain heap property after insertion by bubbling up
    public void heapifyUp(int ind) {
        while (ind > 0 && heap.get(ind) < heap.get(parent(ind))) {
            swap(ind, parent(ind));
            ind = parent(ind);
        }
    }

    // Swap values at two indices
    private void swap(int ind, int parent) {
        int temp = heap.get(ind);
        heap.set(ind, heap.get(parent));
        heap.set(parent, temp);
    }

    // Add a new element to the heap and fix heap property
    public void add(int val) {
        heap.add(val);                    // Add at the end
        heapifyUp(heap.size() - 1);       // Bubble up to restore heap
    }

    // Maintain heap property after deletion by bubbling down
    public void heapifyDown(int ind) {
        int size = heap.size();
        while (true) {
            int left = leftchild(ind);
            int right = rightchild(ind);
            int min = ind;

            // Find smallest among parent and children
            if (left < size && heap.get(left) < heap.get(min)) {
                min = left;
            }
            if (right < size && heap.get(right) < heap.get(min)) {
                min = right;
            }

            // If no change, heap property is maintained
            if (min == ind) break;

            // Swap and continue
            swap(ind, min);
            ind = min;
        }
    }

    // Remove and return the root (minimum element)
    public int remove() {
        if (heap.size() == 0) return -1;

        int min = heap.get(0);                    // Root element
        int last = heap.remove(heap.size() - 1);  // Remove last element

        if (!heap.isEmpty()) {
            heap.set(0, last);                    // Move last to root
            heapifyDown(0);                       // Fix the heap
        }

        return min;
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
