
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Return index of parent
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Return index of left child
    private int left(int i) {
        return 2 * i + 1;
    }

    // Return index of right child
    private int right(int i) {
        return 2 * i + 2;
    }

    // Swap two elements
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert a new value into heap
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Return the minimum value (root of heap)
    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    // Remove and return the minimum value
    public int poll() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    // Maintain heap after insertion
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    // Maintain heap after removal
    private void heapifyDown(int index) {
        int smallest = index;
        int left = left(index);
        int right = right(index);

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Return current heap size
    public int size() {
        return heap.size();
    }

    // Print the heap
    public void printHeap() {
        System.out.println(heap);
    }
}

