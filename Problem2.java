import java.util.Arrays;
import java.util.NoSuchElementException;

// Time Complexity: O(1) - getMin(), O(logn) - extractMin(), O(logn) - insert()
// Space Complexity: O(1) - No extra dataset used
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

class MinHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;

        heap = new int[maxSize];
    }

    public int getMin() {
        if(heap.length == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    public int extractMin() {
        if(heap.length == 0) {
            throw new NoSuchElementException();
        }

        int minElement = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown();
        return minElement;
    }

    public void insert(int item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
                
            }

            index = smallerChildIndex;

        }
    }

    // Helper methods to find correct item based on left and right child indexes
    private int getLeftChildIndex(int parentIndex) { return (2*parentIndex)+1; }
    private int getRightChildIndex(int parentIndex) { return (2*parentIndex)+2; }
    private int getParentIndex(int childIndex) { return (childIndex-1)/2; }

    private int leftChild(int index) { return heap[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return heap[getRightChildIndex(index)]; }
    private int parent(int index) { return heap[getParentIndex(index)]; }

    private boolean hasLeftChild(int index) { return leftChild(index) < size; }
    private boolean hasRightChild(int index) { return rightChild(index) < size; }
    private boolean hasParent(int index) { return parent(index) >= 0; }

    // Swap elements at 2 indices to bubble up or down the minimum/new element
    private void swap(int indexOne, int indexTwo){
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private void ensureCapacity(){
        if(size == maxSize) {
            heap = Arrays.copyOf(heap, maxSize*2);
            maxSize = maxSize*2;
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(10);
        heap.insert(4);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        System.out.println(heap.getMin());
        heap.extractMin();
        System.out.println(heap.getMin());
    }
}
