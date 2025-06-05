// Time Complexity :
//   insert(): O(log n) per insertion
//   removeMin(): O(log n) due to heapify
//   printHeap(): O(n)
// Space Complexity : O(n) where n is the max size of the heap
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This code implements a Min Heap using an array. Each element is inserted at the end
// and then "bubbled up" to maintain the heap property. The removeMin() method removes the
// root (minimum value), replaces it with the last element, and then "heapifies" down.
// Helper methods are provided for parent, children, swapping, and heap printing.
class Main {

    private int[] Heap;
    private int size;
    private int maxsize;

    // Initializing front as static with unity
    private static final int FRONT = 0;

    //Constructor
    public Main(int maxsize) {

        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[maxsize];
        //Heap[0] = Integer.MIN_VALUE;
    }

    // Returns parent
    private int parent(int pos) { return (pos - 1) / 2; }

    // Returns left child
    private int leftChild(int pos) { return (2 * pos) + 1; }

    // Returns right child
    private int rightChild(int pos) { return (2 * pos) + 2; }

    // Returns if its a leaf node
    private boolean isLeaf(int pos) { return pos >= size / 2 && pos < size; }

    // Swaps two nodes of the heap
    private void swap(int i, int j) {
        int tmp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = tmp;
    }

    //heapify
    private void heapify(int i) {
        if (isLeaf(i)) return;

        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && Heap[left] < Heap[smallest]) {
            smallest = left;
        }
        if (right < size && Heap[right] < Heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // inserts a node into the heap
    public void insert(int element) {

        if (size >= maxsize) return;

        Heap[size] = element;
        int current = size;
        size++;

        while (current > 0 && Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Removes and returns the minimum element from the heap
    public int removeMin() {
        if (size == 0) return -1;

        int min = Heap[FRONT];
        Heap[FRONT] = Heap[size-1];
        size--;
        heapify(FRONT);

        return min;
    }

    // Prints the contents of the heap
    public void printHeap() {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            System.out.print("PARENT: " + Heap[i]);
            if (leftChild(i) < size)
                System.out.print("  LEFT: " + Heap[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print("  RIGHT: " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        Main minHeap = new Main(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        // Print all elements of the heap
        System.out.println("The Min Heap: ");
        minHeap.printHeap();

        // Removing minimum value from above heap and printing it
        System.out.println("The Min val is "
                + minHeap.removeMin());
    }
}
