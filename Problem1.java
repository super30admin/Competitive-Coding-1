//the basic functionalities of a min heap are insert, remove, getMin, size
//Generally we use Complete Binary tree for MinHeap
//Root elemnt should be less than its children
//the min should be done in O(1)
//insert and remove O(log n)
//Insert: insert element at the end of the array and compare it with the parent element floor(ind-1/2)
//If parent is bigger then swap it (Buuble Up)
// Remove: find the target swap it with the last element in the array and remove the target
//and then bubble down the swapped value
import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public int getMin() {
        return heap.get(0);
    }

    public int getSize() {
        return heap.size();
    }

    public void insert(int val) {
        heap.add(val);
        bubbleUp(heap.size() - 1);
    }

    private void bubbleUp(int index) {
        if (index == 0)
            return;

        int parent = (index - 1) / 2;
        if (parent>=0 && (heap.get(parent) > heap.get(index))) {
            int temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);
            bubbleUp(parent);
        }
    }

    public int remove() {
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        bubbleDown(0);
        return temp;
    }

    private void bubbleDown(int index) {
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;
        int temp = index;

        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(temp)) {
            int b = heap.get(temp);
            heap.set(temp, heap.get(leftChild));
            heap.set(leftChild, b);
            temp = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(temp)) {
            int b = heap.get(temp);
            heap.set(temp, heap.get(rightChild));
            heap.set(rightChild, b);
            temp = rightChild;
        }

        if (temp == index)
            return;

        bubbleDown(temp);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        System.out.println(heap.getSize());

        int[] arr = new int[]{15, 28, 16, 32, 31, 20};
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
            System.out.println(heap.heap);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(heap.remove()); 
            System.out.println(heap.heap);
        }
    }
}


