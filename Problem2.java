class Problem2 {

    private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;

    Problem2 (int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    int parent (int index) {
        return index / 2;
    }

    int left (int index) {
        return 2 * index;
    }

    int right (int index) {
        return 2 * index + 1;
    }

    void insert (int val) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = val;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    void minHeapify(int pos)
    {
 
        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[left(pos)]
                || Heap[pos] > Heap[right(pos)]) {
 
                // Swap with the left child and heapify
                // the left child
                if (Heap[left(pos)] < Heap[right(pos)]) {
                    swap(pos, left(pos));
                    minHeapify(left(pos));
                }
 
                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, right(pos));
                    minHeapify(right(pos));
                }
            }
        }
    }

    void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                             + " LEFT CHILD : " + Heap[2 * i]
                             + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");
        Problem2 minHeap = new Problem2(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}
