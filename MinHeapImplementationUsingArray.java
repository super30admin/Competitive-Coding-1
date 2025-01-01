// Time Complexity : Insertion-O(log n),extact min-O(log n),peek-O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only:
/*Perform heapify-up and heapify-down operation if it violates hin heap property so that we get the min element 
 * at the root or the first index of array
*/

import java.util.Arrays;

class MinHeapImplementationUsingArray{
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeapImplementationUsingArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private boolean isLeaf(int i) {
        return i >= size / 2 && i < size;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
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
            heapifyDown(smallest);
        }
    }

    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Heap is full, cannot insert element");
            return;
        }
        heap[size] = element;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMin() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return root;
    }

    public int peek() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }

    public static void main(String[] args) {
        MinHeapImplementationUsingArray minHeap = new MinHeapImplementationUsingArray(10);

        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);
        minHeap.printHeap();

        System.out.println("Extracted Min: " + minHeap.extractMin());

        minHeap.printHeap();

        System.out.println("Minimum element is: " + minHeap.peek());
        
        System.out.println("Extracted Min: " + minHeap.extractMin());

        minHeap.printHeap();

    }


}