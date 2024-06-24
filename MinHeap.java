// Time Complexity : 
//Inseretion - O(LogN) // Remove - Log(N) //peek - O(1)
// Space Complexity :O(n) - 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class MinHeap {
    private int heapCapacity; // Maximum capacity of the heap
    private int size; // Current number of elements in the heap
    private int[] heap; // Array to store the heap elements
    private final int START = 1; // Starting index of the heap elements

    // Constructor to initialize the heap with a given capacity
    MinHeap(int heapCapacity) {
        this.heapCapacity = heapCapacity;
        heap = new int[heapCapacity + 1];
        heap[0] = Integer.MIN_VALUE; // Sentinel value for ease of comparison
    }

    // Returns the index of the parent node
    private int parent(int pos) {
        return pos / 2;
    }

    // Returns the index of the left child node
    private int leftChild(int pos) {
        return pos * 2;
    }

    // Returns the index of the right child node
    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    // Checks if a node is a leaf node
    private boolean isLeafNode(int pos) {
        return pos > size / 2 && pos <= size;
    }

    // Returns the minimum element in the heap (root element)
    private int peek() {
        return size == 0 ? Integer.MIN_VALUE : heap[START];
    }

    // Prints the heap elements in a tree-like structure
    private void printHeap() {
        for (int i = START; i <= size / 2; i++) {
            System.out.println("Parent: " + heap[i]);
            if (leftChild(i) <= size) {
                System.out.println("Left Child: " + heap[leftChild(i)]);
            }
            if (rightChild(i) <= size) {
                System.out.println("Right Child: " + heap[rightChild(i)]);
            }
        }
    }

    // Swaps two elements in the heap
    private void swap(int firstPos, int secondPos) {
        int temp = heap[firstPos];
        heap[firstPos] = heap[secondPos];
        heap[secondPos] = temp;
    }

    // Maintains the heap property by adjusting the element at pos downwards
    private void heapify(int pos) {
        if (!isLeafNode(pos)) {
            int swapPos = pos;
            if (rightChild(pos) <= size) {
                swapPos = heap[rightChild(pos)] < heap[leftChild(pos)] ? rightChild(pos) : leftChild(pos);
            } else {
                swapPos = leftChild(pos);
            }
            if (heap[pos] > heap[swapPos]) {
                swap(pos, swapPos);
                heapify(swapPos);
            }
        }
    }

    // Removes and returns the minimum element from the heap
    private int remove() {
        if (size == 0) {
            return Integer.MIN_VALUE; // or throw an exception
        }
        int removedElement = heap[START];
        heap[START] = heap[size];
        size--;
        heapify(START);
        return removedElement;
    }

    // Inserts a new value into the heap
    private void insert(int value) {
        if (size >= heapCapacity) {
            System.out.println("Heap is full, cannot insert " + value);
            return;
        }
        size++;
        heap[size] = value;
        int currentIndex = size;
        while (heap[currentIndex] < heap[parent(currentIndex)]) {
            swap(parent(currentIndex), currentIndex);
            currentIndex = parent(currentIndex);
        }
    }

    // Main method to test the MinHeap class
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        // Initial empty heap
        System.out.println("Initial empty heap:");
        minHeap.printHeap();

        // Test inserting elements
        System.out.println("Inserting elements: 10, 5, 3, 2, 4");
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(4);

        // Test printing the heap
        System.out.println("Heap after insertion:");
        minHeap.printHeap();

        // Test peeking the minimum element
        System.out.println("Peek minimum element:");
        System.out.println(minHeap.peek()); // Should print 2

        // Test removing the minimum element
        System.out.println("Removing minimum element:");
        System.out.println(minHeap.remove()); // Should print 2

        // Test printing the heap after removal
        System.out.println("Heap after removing the minimum element:");
        minHeap.printHeap();
    }
}
