public class MinHeap {
    private int[] heap;   // Array to store the heap elements
    private int size;     // Number of elements in the heap
    private int capacity; // Maximum capacity of the heap

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Get the index of the parent of a node at index i
    private int parent(int i) { return (i - 1) / 2; }

    // Get the index of the left child of a node at index i
    private int leftChild(int i) { return 2 * i + 1; }

    // Get the index of the right child of a node at index i
    private int rightChild(int i) { return 2 * i + 2; }

    // Return the minimum element (root of the heap)
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Insert a new element into the heap
    public void insert(int key) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        // Insert the new key at the end
        size++;
        int i = size - 1;
        heap[i] = key;

        // Fix the min heap property if it's violated
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Remove and return the minimum element from the heap
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the minimum value and remove it from the root
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify the root to maintain the min heap property
        minHeapify(0);

        return root;
    }

    // Heapify a subtree with the root at index i
    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        // Find the smallest element among root, left child, and right child
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // Swap and continue heapifying if the root is not the smallest
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print the heap for visualization
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing the MinHeap class
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(16);
        minHeap.insert(12);

        System.out.print("MinHeap: ");
        minHeap.printHeap(); // Output should show elements in heap order

        System.out.println("Minimum element: " + minHeap.getMin());
        System.out.println("Extracting minimum element: " + minHeap.extractMin());

        System.out.print("MinHeap after extracting min: ");
        minHeap.printHeap(); // Output should show updated heap order
    }
}
// time complexity - O(log n) -
//insert() - O(log n)  bubbling up
// extractMin() O(log n) heapifying down
//getMin() O(1)
// Space Complexity O(1)
