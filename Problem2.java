// Time Complexity : O(log n) for insert and extractMin, O(n) for printHeap, O(1) for getMin, parent, leftChild, rightChild, swap 
// Space Complexity : O(n) for the heap array
// Did this code successfully run on GFG : Could not find testing, so ran locally
// Any problem you faced while coding this : No

// Approach : Created minheap using array, following the properties of a min heap - parent = i/2, leftChild = 2*i + 1, rightChild = 2*i + 2.
// Insert adds at end and keep pushing up to maintain the min heap property.
// ExtractMin replaces root with last element and then heapifies down to maintain the min heap property

class Minheap{
    int[] heap;
    int size;
    int capacity;
    public Minheap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }
    private int parent(int i) {return (i - 1) / 2;} // O(1)
    private int leftChild(int i) {return 2 * i + 1;} // O(1)
    private int rightChild(int i) {return 2 * i + 2;} // O(1)
    private void swap(int i, int j) { // O(1)
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private boolean isLeaf(int i) {return i >= size / 2 && i < size;} // O(1)
    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty, returning -1");
            return -1;
        }
        return heap[0];
    }
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty, returning -1");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);
        return min;
    }
    public void insert(int element) {
        // O(log n)
        if (size == capacity) {
            System.out.println("Heap is full, cannot insert " + element);
            return;
        }
        heap[size++] = element;
        int current = size - 1;
        while (current != 0 && heap[parent(current)] > heap[current]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void minHeapify(int i) {
        // O(log n)
        if (!isLeaf(i)) {
            int left = leftChild(i);
            int right = rightChild(i);
            int smallest = i;
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest != i) {
                swap(i, smallest);
                minHeapify(smallest);
            }
        }
    }
    public void printHeap() {
        // O(n)
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" PARENT : " + heap[i]);
            if (2 * i + 1 < size){
                System.out.print(" LEFT CHILD : " + heap[2 * i + 1]);
            }
            if (2 * i + 2 < size){
                System.out.print(" RIGHT CHILD : " + heap[2 * i + 2]);
            }
            System.out.println();
        }
    }

}

class Problem2{
    public static void main(String[] args) {
        Minheap minHeap = new Minheap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);
        System.out.println("Min Heap:");
        minHeap.printHeap();
        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.println("Current Min: " + minHeap.getMin());
        minHeap.printHeap();
    }
}