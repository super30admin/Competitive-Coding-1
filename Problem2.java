
// "static void main" must be defined in a public class.
import java.util.*;

public class MinHeap {
    private int size;
    private List<Integer> minHeap;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        this.minHeap = new ArrayList<>(maxSize);
    }

    public int getMin() {
        return minHeap.get(0);
    }

    public boolean isEmpty() {
        if (this.minHeap.size() == 0)
            return true;
        return false;
    }

    public void insert(int elem) {
        if (isEmpty()) {
            this.minHeap.add(elem);
            size++;
            return;
        }
        if (size == maxSize + 1) {
            System.out.println("Heap is full!");
            return;
        }
        this.minHeap.add(elem);
        size++;
        bubleUp(size - 1);
    }

    public void remove() {
        int temp = minHeap.get(size);
        minHeap.add(size, this.minHeap.get(0));
        minHeap.add(0, temp);
        minHeap.remove(size);
        bubleDown(size - 1);
    }

    public void bubleUp(int index) {
        if (size == 0)
            return;
        int parent = (index - 1) / 2;
        if (parent >= 0 && (this.minHeap.get(index) < this.minHeap.get(parent))) {
            int temp = this.minHeap.get(index);
            minHeap.add(index, this.minHeap.get(parent));
            minHeap.add(parent, temp);
        }

    }

    public void bubleDown(int size) {

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Integer> list = new ArrayList<>();
    }
}