// Time Complexity : insert and extract are O(log n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : In min heap, the root node is smaller than or equal to the child nodes. In the insert function, we add the new element
// to the end of the array and then bubble up comparing with nodes and so on. In extractMin function, we remove the 0th element as it
// will be minimum always, assign the last value of array and heapify down the tree by comparing the values.

// Your code here along with comments explaining your approach



public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert new value
    public void insert(int val) {
        if (size == capacity) return;
        heap[size] = val;
        int current = size;
        size++;

        // Bubble up
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Extract the smallest element (root)
    public int extractMin() {
        if (size == 0) return -1;
        int min = heap[0]; //0th is minimum
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest); //continue the swapping logic
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Test
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.printHeap(); // may print like: 1 3 8 5 (heap order, not sorted)
        System.out.println("Extract Min: " + heap.extractMin()); // 1
        heap.printHeap(); // heap rearranged
    }
}
