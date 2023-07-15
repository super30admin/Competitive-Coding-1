// Time Complexity : insertion, removal, extract minimum and heapify - O(log n)
//                   Search: O(n)
// Space Complexity : O(n) (Array)

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        int currentIndex = size;
        size++;

        while (currentIndex > 0 && heap[currentIndex] < heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap[0];
    }

    private void heapify(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void remove(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Element not found in the heap");
        }

        heap[index] = heap[size - 1];
        size--;

        if (index > 0 && heap[index] < heap[parent(index)]) {
            while (index > 0 && heap[index] < heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        } else {
            heapify(index);
        }
    }

    public static void main(String[] args) {
        // Create a new min heap with a capacity
        MinHeap minHeap = new MinHeap(8);

        // Insert elements into the min heap
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(4);
        minHeap.insert(4);

        // Remove an element from the min heap
        minHeap.remove(3);

        // Iterate and print the minimum element from Heap
        while (!minHeap.isEmpty()) {
            int min = minHeap.extractMin();
            System.out.println("Extracted Min: " + min);
        }
    }
}
