/*
 Time Complexity:
 add: O(log N)
 remove: O(log N)
 peek: O(1)
 heapify: O(log N)
 parent, leftChild, rightChild, isLeaf: O(1)
 */
 /*
 Space Complexity:
 * - O(N) for storing the heap elements
 */
import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 0;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize];
    }


    private int parent(int pos) {
        return (pos - 1) / 2;
    }


    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }


    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }


    public int size() {
        return size;
    }

=
    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos < size;
    }


    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + heap[i] + " Left Child: " + heap[leftChild(i)] + " Right Child: " + heap[rightChild(i)]);
            System.out.println();
        }
    }


    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[FRONT];
    }


    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallest = pos;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != pos) {
                swap(pos, smallest);
                heapify(smallest);
            }
        }
    }


    public void add(int element) {
        if (size >= maxSize) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element;
        int current = size;
        size++;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    public int remove() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        int popped = heap[FRONT];
        heap[FRONT] = heap[--size];
        heapify(FRONT);

        return popped;
    }


    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }


    public static void main(String[] args) {
        System.out.println("The Min Heap is: ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);

        minHeap.print();
        System.out.println("The Min value is: " + minHeap.peek());
        System.out.println("Removed Min value: " + minHeap.remove());
        minHeap.print();
    }
}
