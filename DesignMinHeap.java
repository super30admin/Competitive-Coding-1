
import java.util.ArrayList;
import java.util.List;

public class DesignMinHeap {
    private List<Integer> heap;

    public DesignMinHeap() {
        heap = new ArrayList();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);

    }

    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }

        int min = heap.get(0);
        int last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
       return min;
    }


    private void heapifyDown(int i) {
        int left = left(i);
        int right = right(i);

        int smallest = i;
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
        
    }
    
    public int peek() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }

        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        DesignMinHeap heap = new DesignMinHeap();
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(1);

        heap.printHeap(); // Should show [1, 4, 15, 10]

        System.out.println("Min: " + heap.extractMin()); // 1
        heap.printHeap(); // [4, 10, 15]
    }

    
}