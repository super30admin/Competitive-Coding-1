import java.util.NoSuchElementException;

class MinHeap {
    private final int[] heap;
    private int size;
    private final int capacity;

    private static final int TOP = 1;

    public MinHeap() {
        this(100);
    }

    public MinHeap(int capacity) {
        this.heap = new int[capacity + 1];
        heap[0] = Integer.MIN_VALUE;
        this.size = 0;
        this.capacity = capacity;
    }

    private int getParentIndex(int x) {
        return x / 2;
    }

    private int getLeftChildIndex(int x) {
        return 2 * x;
    }

    private int getRightChildIndex(int x) {
        return 2 * x + 1;
    }

    private boolean isLeaf(int x) {
        return x > size / 2;
    }

    private void swapPositions(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    /**
     * Swaps top of heap (min element) with last element in the heap,
     * but while maintaining heap property
     */
    private void heapify() {
        int index = TOP;
        while (true) {
            if (isLeaf(index)) {
                // if index has reached a leaf,
                // make sure it is swapped with the last leaf
                swapPositions(index, size);
                // and return
                return;
            }
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int swapIndex;
            if (rightChildIndex > size || heap[leftChildIndex] < heap[rightChildIndex]) {
                // if only left child is present or left child is smaller
                swapIndex = leftChildIndex;
            } else {
                // if right child is present and smaller
                swapIndex = rightChildIndex;
            }
            // swap with the smaller of its children
            swapPositions(index, swapIndex);
            // continue the process
            index = swapIndex;
        }
    }

    /**
     * @return the top (minimum) element of the heap
     */
    public int getTop() {
        if (size < 1) {
            throw new NoSuchElementException("Heap is empty!");
        }
        return heap[TOP];
    }

    /**
     * inserts an element in its correct position into the minheap
     * @param item item to be inserted in the heap
     */
    public void insert(int item) {
        if (size == capacity) {
            throw new ArrayIndexOutOfBoundsException("Heap is at capacity!");
        }

        heap[++size] = item;
        int itemIndex = size;
        while (heap[itemIndex] < heap[getParentIndex(itemIndex)]) {
            swapPositions(itemIndex, getParentIndex(itemIndex));
            itemIndex = getParentIndex(itemIndex);
        }
    }

    /**
     * Extracts and returns the top (minimum) element in the heap,
     * while maintaining heap property
     * @return the minimum element in the heap
     */
    public int removeTop() {
        if (size < 1) {
            throw new NoSuchElementException("Heap is empty!");
        }
        heapify();
        return heap[size--];
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
class Driver {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(9);
        minHeap.insert(12);
        minHeap.insert(22);
        minHeap.insert(7);
        minHeap.insert(18);
        minHeap.insert(16);
        minHeap.insert(19);
        minHeap.insert(4);
        minHeap.print(); // 4 7 16 9 18 22 19 12
        System.out.println(minHeap.removeTop()); // 4
        System.out.println(minHeap.removeTop()); // 7
        System.out.println(minHeap.getTop()); // 9
        minHeap.print(); // 9 12 16 19 18 22
        minHeap.insert(5);
        minHeap.print(); // 5 12 9 19 18 22 16
    }
}
