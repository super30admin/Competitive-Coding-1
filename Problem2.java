
class Problem2 {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // find parent of the node at index i
    private int parent(int i) {
        return (i - 1) / 2;
    }
    // find left
    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    // to insert a new value in the heap O(log n)
    public int insert(int val) {
        if (size == capacity) {
            return -1; // heap full
        }

        heap[size] = val;
        int curr = size;
        size++;

        // heapify up
        while (curr > 0 && heap[parent(curr)] > heap[curr]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
        return 1;
    }

    // get the minimum value in the heap O(1)
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return heap[0];
    }

    // get min value
    public int extractMin() {
        if (size == 0) {
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);
        return min;
    }

    // heapify down
    private void heapifyDown(int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }
}
