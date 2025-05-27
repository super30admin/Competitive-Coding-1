import java.util.*;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }
    private int parent(int ind) {
        return (ind - 1) / 2;
    }
    private int leftChild(int ind) {
        return (2* ind) + 1;
    }
    private  int rightChild(int ind) {
        return (2* ind) + 2;
    }
    public  int size() {
        return heap.size();
    }
    public int peek() {
        if(heap.size() == 0) return -1;
        return heap.get(0);
    }
    public void print() {
        for(int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public void heapifyUp(int ind) {
        while(ind > 0 && heap.get(ind) < heap.get(parent(ind))) {
            swap(ind, parent(ind));
            ind = parent(ind);
        }
    }

    private void swap(int ind, int parent) {
        int temp = heap.get(ind);
        heap.set(ind, heap.get(parent));
        heap.set(parent, temp);
    }

    public void add(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public void heapifyDown(int ind) {
        int size = heap.size();
        while(true) {
            int left = leftChild(ind);
            int right = rightChild(ind);
            int min = ind;

            if (left < size && heap.get(left) < heap.get(min)) {
                min= left;
            }

            if (right < size && heap.get(right) < heap.get(min)) {
                min = right;
            }

            if (min == ind) {
                break;
            }

            swap(ind, min);
            ind = min;
        }
    }
    public int remove() {
        if(heap.size() == 0) return -1;
        int min = heap.get(0);
        int temp = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()) {
            heap.set(0, temp);
            heapifyDown(0);
        }
        return min;
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.add(5);
        h.add(4);
        h.add(6);
        h.add(10);
        h.add(15);
        h.add(2);
        System.out.println("peek" + h.peek());
        h.print();

    }
}
