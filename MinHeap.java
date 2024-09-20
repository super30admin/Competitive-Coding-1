public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int i) { return (i - 1) / 2; }
    private int getLeftChildIndex(int i) { return (2 * i) + 1; }
    private int getRightChildIndex(int i) { return (2 * i) + 2; }

    private boolean hasParent(int i) { return getParentIndex(i) >= 0; }
    private boolean hasLeftChild(int i) { return getLeftChildIndex(i) < size; }
    private boolean hasRightChild(int i) { return getRightChildIndex(i) < size; }

    private int parent(int i) { return heap[getParentIndex(i)]; }
    private int leftChild(int i) { return heap[getLeftChildIndex(i)]; }
    private int rightChild(int i) { return heap[getRightChildIndex(i)]; }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    public int peek() {
        return heap[0];  // Simply return the top element without any exception handling
    }

    public int poll() {
        int item = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

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

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(10);
        minHeap.add(15);
        minHeap.add(20);
        minHeap.add(17);
        minHeap.add(8);

        System.out.println("Min value: " + minHeap.poll());  // Output: 8
        System.out.println("Min value: " + minHeap.poll());  // Output: 10
    }
}

