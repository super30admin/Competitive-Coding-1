public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize heap with given capacity
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Get index of the parent node
    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    // Get index of the left child node
    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    // Get index of the right child node
    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    // Check if the node has a left child
    private boolean hasLeftChild(int i) {
        return getLeftChildIndex(i) < size;
    }

    // Check if the node has a right child
    private boolean hasRightChild(int i) {
        return getRightChildIndex(i) < size;
    }

    // Check if the node has a parent
    private boolean hasParent(int i) {
        return getParentIndex(i) >= 0;
    }

    // Get the value of the left child
    private int leftChild(int i) {
        return heap[getLeftChildIndex(i)];
    }

    // Get the value of the right child
    private int rightChild(int i) {
        return heap[getRightChildIndex(i)];
    }

    // Get the value of the parent
    private int parent(int i) {
        return heap[getParentIndex(i)];
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // Ensure there's enough space in the heap
    private void ensureCapacity() {
        if (size == capacity) {
            int[] newHeap = new int[capacity * 2];
            System.arraycopy(heap, 0, newHeap, 0, capacity);
            capacity *= 2;
            heap = newHeap;
        }
    }

    // Get the minimum element (root)
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return heap[0];
    }

    // Remove and return the minimum element
    public int extractMin() {
        if (size == 0) throw new IllegalStateException();
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    // Add a new element to the heap
    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    // Heapify up: maintain heap property after insertion
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // Heapify down: maintain heap property after extraction
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

    // Print the heap (for testing)
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        
        // Insert elements into the heap
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(50);
        minHeap.insert(100);
        minHeap.insert(25);
        
        // Print the heap
        System.out.println("MinHeap:");
        minHeap.printHeap();

        // Extract the minimum element
        System.out.println("Extracted Min: " + minHeap.extractMin());

        // Print the heap after extraction
        System.out.println("Heap after extraction:");
        minHeap.printHeap();
    }
}
