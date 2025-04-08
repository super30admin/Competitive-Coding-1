// Time complexity:- O(log n) for insert, O(log n) for extractMin, O(n) for building the heap
// Space complexity:- O(n) for storing the heap array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * I used an array-based implementation of Min Heap where the root is the minimum element, and every parent node is smaller than its children.
 * For insertion, I added the element at the end of the heap and then performed "heapify-up" to maintain the heap property.
 * For extraction, I removed the root, replaced it with the last element, and "heapified-down" to restore the heap property.
 */
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Function to get the parent index
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Function to get the left child index
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Function to get the right child index
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Function to heapify the subtree rooted at index i
    private void heapify(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        // If left child is smaller than root
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        // If right child is smaller than smallest so far
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If smallest is not root, swap and continue heapifying
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Function to swap elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Function to insert a new element into the heap
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        // Insert the new element at the end
        heap[size] = key;
        size++;

        // Fix the min heap property if it is violated
        int i = size - 1;
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Function to extract the minimum element (root of the heap)
    public int extractMin() {
        if (size <= 0) {
            return Integer.MAX_VALUE; // Heap is empty
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the minimum value and remove it from the heap
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify the root to maintain the min heap property
        heapify(0);

        return root;
    }

    // Function to get the minimum element (root of the heap)
    public int getMin() {
        if (size <= 0) {
            return Integer.MAX_VALUE;
        }
        return heap[0];
    }

    // Function to print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the MinHeap implementation
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);

        System.out.println("Min Heap:");
        minHeap.printHeap();

        System.out.println("Extracted Min: " + minHeap.extractMin());

        System.out.println("Min Heap after extraction:");
        minHeap.printHeap();

        System.out.println("Current Min: " + minHeap.getMin());
    }
}

