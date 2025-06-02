//Problem: Design Min Heap

public class MinHeap {
    private int[] heapArr;
    private int capacity;
    private int curr_size;

    // Constructor
    public MinHeap(int n) {
        capacity = n;
        heapArr = new int[capacity];
        curr_size = 0;
    }

    // Swap helper function
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Get parent index
    private int parentNode(int pos) {
        return (pos - 1) / 2;
    }

    // Get left child index
    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    // Get right child index
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    // Insert a new key
    public boolean insertKey(int key) { //Time Complexity: O(log n), Space Complexity: O(n)
        if (curr_size == capacity) {
            return false; // Heap is full
        }

        int i = curr_size;
        heapArr[i] = key;
        curr_size++;

        // Bubble up
        while (i != 0 && heapArr[i] < heapArr[parentNode(i)]) {
            swap(heapArr, i, parentNode(i));
            i = parentNode(i);
        }

        return true;
    }

    // Decrease key value
    public void decreaseKey(int pos, int new_val) { //Time Complexity: O(log n), Space Complexity: O(n)
        heapArr[pos] = new_val;

        while (pos != 0 && heapArr[pos] < heapArr[parentNode(pos)]) {
            swap(heapArr, pos, parentNode(pos));
            pos = parentNode(pos);
        }
    }

    // Get the minimum element
    public int getMin() { //Time Complexity: O(log n), Space Complexity: O(n)
        if (curr_size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heapArr[0];
    }

    // Remove and return the minimum element
    public int extractMin() { //Time Complexity: O(log n), Space Complexity: O(n)
        if (curr_size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        if (curr_size == 1) {
            curr_size--;
            return heapArr[0];
        }

        int root = heapArr[0];
        heapArr[0] = heapArr[curr_size - 1];
        curr_size--;
        minHeapify(0);

        return root;
    }

    // Maintain min-heap property
    private void minHeapify(int i) { //Time Complexity: O(log n), Space Complexity: O(n)
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < curr_size && heapArr[left] < heapArr[smallest]) {
            smallest = left;
        }

        if (right < curr_size && heapArr[right] < heapArr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(heapArr, i, smallest);
            minHeapify(smallest);
        }
    }
}