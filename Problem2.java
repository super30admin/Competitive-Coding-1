// Implementation of MinHeap using Array

class MinHeap {
    private int[] heap;
    private int size; 
    private int capacity;

    public MinHeap (int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[this.capacity + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    private int parent (int pos) {
        return pos / 2;
    }

    private int leftChild (int pos) {
        return pos * 2;
    }

    private int rightChild (int pos) {
        return (pos * 2) + 1;
    }

    private boolean isLeaf (int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private int size() {
        return size;
    }

    private void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(" " + heap[i]);
        }
        System.out.println();
    }

    private int peek() {
        return heap[1];
    }

    private void swap (int pos1, int pos2) {
        int temp;
        temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private void minHeapify (int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap (pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void add (int element) {
        if (size >= capacity) {
            return;
        }

        size = size + 1;
        heap[size] = element;

        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int poppedElement = heap[1];
        heap[1] = heap[size];
        size = size - 1;
        minHeapify(1);
        return poppedElement;
    }

    public static void main (String[] args) {
        MinHeap minHeap = new MinHeap(15);

        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(4);

        minHeap.print();
        

        System.out.println("Size: " + minHeap.size() + " Peek: " + minHeap.peek());

        minHeap.remove();
        minHeap.print();

        minHeap.remove();
        minHeap.print();
    }
}