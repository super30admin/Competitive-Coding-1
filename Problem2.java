//Time Complexity - O(1) for getMin and O(log n) for insert
//Space Complexity - O(n) Not using any extra space.

// Implemented a MinHeap with arrays
public class MinHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int mazSize) {
        this.maxSize = mazSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
    }

    private int getParent(int pos) {
        return (pos - 1)/2;
    }

    private int getLeftChild(int pos) {
        return 2 * pos + 1;
    }

    private int getRightChild(int pos) {
        return 2 * pos + 2;
    }

    private boolean isLeaf(int pos) {
        return pos >= size / 2 && pos < size;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapify(int i) {
        if(isLeaf(i)) return;

        int left = getLeftChild(i);
        int right = getRightChild(i);
        int smallest = i;

        if(left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if(right < size && heap[left] < heap[smallest]) {
            smallest = right;
        }

        if(smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void insert(int val) {
        if(size >= maxSize) {
            return;
        }
        heap[++size] = val;
        int current = size;
        size++;
        while( current > 0 && heap[current] < heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public int removeMin() {
        if(size == 0) {
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapify(0);
        return min;

    }

    public void printHeap() {
        for(int i =0; i <= (size -2) / 2; i++) {
            System.out.println("PARENT: " + heap[i]);
            if(getLeftChild(i) < size) {
                System.out.println(" LEFT: " + heap[getLeftChild(i)]);
            }
            if(getRightChild(i) < size) {
                System.out.println(" Right: " + heap[getRightChild(i)]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(15);

        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        System.out.println("Min Heap:");
        heap.printHeap();

        System.out.println("Removed Min: " + heap.removeMin());
    }
}

