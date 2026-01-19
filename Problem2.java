class MyMinHeap {
    private int[] heap;     
    private int size;       
    private int maxSize;    

    // Constructor to initialize the heap with a given capacity
    public MyMinHeap(int capacity) {
        this.maxSize = capacity;
        this.size = 0;
        heap = new int[capacity];  // Allocate space for the heap
    }

    // Returns the index of the parent of the node at index i
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns the index of the left child of the node at index i
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Returns the index of the right child of the node at index i
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Checks if the node at index i is a leaf node
    private boolean isLeaf(int i) {
        return i >= size / 2 && i < size;
    }

    // Swaps two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Maintains the min-heap property by pushing down the element at index i
    private void heapify(int i) {
        if (isLeaf(i)) return;  // No need to heapify leaf nodes

        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        // Find the smallest among current, left, and right
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If the smallest is not the current node, swap and continue heapifying
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void insert(int val) {
        if (size >= maxSize) return;  // Heap is full

        heap[size] = val;  // Place the new value at the end
        int current = size;
        size++;

        // Bubble up the new value to maintain heap property
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int removeMin() {
        if (size == 0) return -1;  // Heap is empty

        int min = heap[0];  
        heap[0] = heap[size - 1];  // Replace root with the last element
        size--;  // Reduce heap size
        heapify(0);  // Restore heap property from the root
        return min;
    }

    public void printHeap() {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            System.out.print("PARENT: " + heap[i]);
            if (leftChild(i) < size)
                System.out.print("  LEFT: " + heap[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print("  RIGHT: " + heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyMinHeap heap = new MyMinHeap(15);  

        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        // Display the heap structure
        System.out.println("Min Heap:");
        heap.printHeap();

        // Remove and print the minimum element
        System.out.println("Removed Min: " + heap.removeMin());
    }
}