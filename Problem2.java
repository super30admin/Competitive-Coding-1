// Time Complexity: O(log(n))
// Space Complexity: O(1)
// Design Min Heap

import java.util.Arrays;

class Problem2 {
    private int[] heap;  // Array to store heap elements
    private int size;    // Current number of elements in the heap
    private int capacity; // Maximum capacity of the heap

    public Problem2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Helper methods to get parent and children indices
    private int getParentIndex(int index) { return (index - 1) / 2; }
    private int getLeftChildIndex(int index) { return 2 * index + 1; }
    private int getRightChildIndex(int index) { return 2 * index + 2; }

    // Helper methods to check if parent or children exist
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }

    // Helper methods to get values of parent or children
    private int parent(int index) { return heap[getParentIndex(index)]; }
    private int leftChild(int index) { return heap[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return heap[getRightChildIndex(index)]; }

    // Swap values at two indices
    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    // Ensure the heap has enough capacity, double the size if needed
    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    // Insert a new element into the heap
    public void insert(int item) {
        ensureExtraCapacity();
        heap[size] = item; // Place the item at the end
        size++;
        heapifyUp(); // Restore the heap property
    }

    // Extract the minimum element (root) from the heap
    public int extractMin() {
        if (size == 0) throw new IllegalStateException();
        int item = heap[0]; // Root element
        heap[0] = heap[size - 1]; // Move the last element to the root
        size--;
        heapifyDown(); // Restore the heap property
        return item;
    }

    // Return the minimum element (root) without removing it
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return heap[0];
    }

    // Restore the heap property by moving the element at the end up
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // Restore the heap property by moving the root element down
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    // Main method to test the MinHeap implementation
    public static void main(String[] args) {
        Problem2 minHeap = new Problem2(10);
        minHeap.insert(10);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(17);
        minHeap.insert(8);

        System.out.println("Min: " + minHeap.extractMin()); // 8
        System.out.println("Min: " + minHeap.extractMin()); // 10
        System.out.println("Min: " + minHeap.extractMin()); // 15
    }
}
