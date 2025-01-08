import java.util.NoSuchElementException;

// Various Operation havev various time complexity:
// Time Complexity:
// Insertion: O(log n), inserted element is placed at proper position which takes time
// Deletion: O(log n). deletion from top is O(1) but heapifying more time
// getTop: O(1), this is constant time.
// Heapify: O(log n)

// Space Complexity: Heap is represented in terms of array with some initial size.
// Operations on this array makes the SC O(n)
class Problem2 {
    private final int[] heap;
    private int size;
    private final int capacity;

    private static final int TOP = 1;

    public Problem2() {
        this(50);
    }

    public Problem2(int capacity) {
        this.heap = new int[capacity + 1];
        heap[0] = Integer.MIN_VALUE;
        this.size = 0;
        this.capacity = capacity;
    }

    // Parent is retrieved as element / 2
    private int getParentIndex(int x) {
        return x / 2;
    }

    // Left child is retrieved as element * 2
    private int getLeftChildIndex(int x) {
        return 2 * x;
    }

    // Left child is retrieved as element * 2 + 1
    private int getRightChildIndex(int x) {
        return 2 * x + 1;
    }

    private boolean isLeaf(int x) {
        return x > size / 2;
    }

    private void swapPositions(int pos1, int pos2) {
        int temporary = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temporary;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // returns the top element from an array is size > 0 and heapify is carried out
    public int getTop() {
        if (size < 1) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap[TOP];
    }

    // Heapify method is responsible for the maintaining the min-heap
    // characteristics. Starting from the top, it will check if
    // smaller child is available, will swap those continuing till it leaf
    private void heapify() {
        int index = TOP;
        while (true) {
            if (isLeaf(index)) {
                swapPositions(index, size);
                return;
            }
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int swapIndex;
            swapIndex = rightChildIndex > size || heap[leftChildIndex] < heap[rightChildIndex] ? leftChildIndex
                    : rightChildIndex;
            swapPositions(index, swapIndex);
            index = swapIndex;
        }
    }

    // New element is added at the end of an array if size is less than
    // capacity(base case).
    // Index is set to the current added element's index.
    // Current index and its parent elements are swapped if parent element is
    // greater than current index.
    public void insert(int item) {
        if (size == capacity) {
            throw new ArrayIndexOutOfBoundsException("Heap is full");
        }

        heap[++size] = item;
        int itemIndex = size;
        while (heap[itemIndex] < heap[getParentIndex(itemIndex)]) {
            swapPositions(itemIndex, getParentIndex(itemIndex));
            itemIndex = getParentIndex(itemIndex);
        }
    }

    // base case is checked if array is empty.
    // If it is not empty, then the
    public int removeTop() {
        if (size < 1) {
            throw new NoSuchElementException("Heap is empty");
        }
        heapify();
        return heap[size--];
    }

}

class Driver {
    public static void main(String[] args) {
        Problem2 minHeap = new Problem2(10);
        minHeap.insert(5);
        minHeap.insert(9);
        minHeap.insert(43);
        minHeap.insert(32);
        minHeap.insert(12);
        minHeap.insert(17);
        minHeap.insert(6);
        minHeap.insert(10);
        minHeap.print(); // 5 6 9 10 12 17 32 43
        System.out.println(minHeap.removeTop()); // 5
        System.out.println(minHeap.removeTop()); // 6
        System.out.println(minHeap.getTop()); // 9
        minHeap.print(); // 9 10 17 32 12 43
        minHeap.insert(5);
        minHeap.print(); // 5 10 9 32 12 43 17
    }
}