//Min Heap Implementation using Array
//TC: O(log n) SC: O(n)
class Problem2 {
    /*
     * Min Heap Properties: heap[C];
     * Size of heap = n;
     * Total Capacity of heap = C;
     * Parent(i) = i/2;
     * LeftChild(i) = 2i;
     * RightChild(i) = 2i+1;
     * isLeafNode(i) = n/2 < i <= n;
     * print: for loop
     * peek: first element
     * add(element)
     * remove(element)
     * heapify()
     * */

    private int[] heap;
    private int size;
    private int capacity;
    private static final int FRONT = 1;

    public Problem2(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        heap = new int[this.capacity + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        Problem2 minHeap = new Problem2(15);
        minHeap.insert(52);
        minHeap.insert(34);
        minHeap.insert(19);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(193);
        minHeap.insert(623);
        minHeap.insert(57);
        minHeap.insert(97);
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2);
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos;
            if (rightChild(pos) <= size)
                swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            else
                swapPos = leftChild(pos);
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                swap(pos, swapPos);
                minHeapify(swapPos);
            }

        }
    }

    public void insert(int element) {
        if (size >= capacity) {
            return;
        }
        heap[++size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

}