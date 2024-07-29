
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private int leftChild(int i) {
        return 2*i+1;
    }

    private int rightChild(int i) {
        return 2*i+2;
    }

    private void swap(int i, int j) {
        if (i != j) { // Ensuring i and j are not the same to avoid zeroing out the value
            heap[i] = heap[i] ^ heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] = heap[i] ^ heap[j];
        }
    }

    public void add(int key) {
        if (size == capacity) {
            throw new RuntimeException("Heap is full");
        }
        size++;
        int index = size - 1;
        heap[index] = key;

        while (index != 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int extractMin() {
        if (size <= 0) {
            throw new RuntimeException("Heap is empty");
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);

        return root;
    }

    private void minHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    public int getMin() {
        if (size <= 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);
        minHeap.add(7);
        minHeap.add(8);
        minHeap.add(4);
        minHeap.add(10);
        minHeap.add(16);
        minHeap.add(12);

        minHeap.printHeap();

        System.out.println("Extracted min: " + minHeap.extractMin());
        minHeap.printHeap();

        System.out.println("Current min: " + minHeap.getMin());
    }
}
