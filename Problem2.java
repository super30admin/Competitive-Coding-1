class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Returns the index of the parent of the node at index i
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns the index of the left child of the node at index i
    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    // Returns the index of the right child of the node at index i
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    // Swaps two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Inserts a new value into the heap
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        // Insert the new value at the end of the heap
        heap[size] = value;
        size++;

        // Fix the heap property by "bubbling up"
        int current = size - 1;
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Removes and returns the minimum value from the heap
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];

        // Move the last element to the root and reduce the size
        heap[0] = heap[size - 1];
        size--;

        // Fix the heap property by "heapifying down"
        heapify(0);

        return min;
    }

    // Heapify the subtree rooted at index i
    private void heapify(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        // Find the smallest among root, left child, and right child
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If the smallest is not the root, swap and continue heapifying
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Prints the heap elements
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Returns the minimum value without removing it
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }