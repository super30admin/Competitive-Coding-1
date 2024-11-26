import java.util.Arrays;

/*
Heap - complete Binary tree, no skewed trees
Implement Min Heap
Operations: 
1. GetMin() in O(1)
2. ExtractMin() in O(log n)
3. Insert() in O(log n)
*/

class Heap {
    int size = 0;
    int capacity = 10;
    int[] heap;

    public Heap() {
        heap = new int[capacity];
    }

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, 2*capacity);
            capacity = 2*capacity;
        }
    }

    private int getParentIndex(int i) {
        return (i-2)/2;
    }

    private int getLeftChildIndex(int i) {
        return 2*i + 1;
    }

    private int getRightChildIndex(int i) {
        return 2*i + 2;
    }

    private int getParent(int i) {
        return heap[getParentIndex(i)];
    }

    private int getLeftChild(int i) {
        return heap[getLeftChildIndex(i)];
    }

    private int getRightChild(int i) {
        return heap[getRightChildIndex(i)];
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int i) {
        return getLeftChildIndex(i) < size;
    }

    private boolean hasRightChild(int i) {
        return getRightChildIndex(i) < size;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // O(log n) time
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap[index] < getParent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    // O(log n) time
    private void heapifyDown() {
        int index = 0;
        int minIndex = 0;

        while(hasLeftChild(index)) {
            minIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                minIndex = getRightChildIndex(index);
            }
            if (heap[index] < heap[minIndex]) {
                break;
            } else {
                swap(index, minIndex);
            }
            index = minIndex;
        }
    }

    public int getMin() {
        if (size == 0) {
            return -1;
        }
        return heap[0];
    }

    public void insert(int i) {
        ensureCapacity();
        size += 1;
        heap[size - 1] = i;
        heapifyUp();
    }

    public int extractMin() {
        if (size == 0) {
            return -1;
        }
        int val = heap[0];
        heap[0] = heap[size-1];
        size -= 1;
        heapifyDown();
        return val;
    }
}

public class Problem2 {
    public static void main(String args[]) {
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(7);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(4);
        heap.insert(6);

        System.out.println("Min value: " + heap.getMin());
        System.out.println("Removed min value of: " + heap.extractMin());
        System.out.println("Min value: " + heap.getMin());
        
        heap.insert(-5);
        System.out.println("Min value: " + heap.getMin());
    }
}