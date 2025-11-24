// Min Heap implementation in Java
class MinHeap {
    private int[] heap;      // Array to store heap elements
    private int size;        // Current number of elements
    private int capacity;    // Maximum capacity of heap

    // Constructor
    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Get index of parent, left child, and right child
    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i) + 1; }
    private int right(int i) { return (2 * i) + 2; }

    // Swap helper method
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Returns the minimum (root) element → O(1)
    public int getMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    // Inserts a new key → O(log n)
    public void insert(int key) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        // Insert key at end
        size++;
        int i = size - 1;
        heap[i] = key;

        // Fix the min-heap property if violated
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Heapify: restores min-heap property at index i → O(log n)
    private void heapify(int i) {
        int smallest = i;
        int leftChild = left(i);
        int rightChild = right(i);

        if (leftChild < size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        // If smallest is not the root, swap and continue heapifying
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Extract the minimum element (root) → O(log n)
    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        int root = heap[0];

        // Move last element to root and reduce size
        heap[0] = heap[size - 1];
        size--;

        // Call heapify to fix heap
        heapify(0);

        return root;
    }

    // Print heap for verification
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // DRIVER CODE
    public static void main(String[] args) {
        MinHeap h = new MinHeap(15);

        h.insert(5);
        h.insert(10);
        h.insert(15);
        h.insert(30);
        h.insert(20);
        h.insert(8);

        System.out.print("Heap elements: ");
        h.printHeap();   // Should be a valid min-heap

        System.out.println("Minimum element: " + h.getMin());

        System.out.println("Extracting minimum: " + h.extractMin());
        System.out.print("Heap after extract: ");
        h.printHeap();
    }
}

