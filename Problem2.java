class Problem2 {

    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public Problem2(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];//because we start from 1
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2; //any given position, parent is at location/2
    }

    private int leftChild(int pos) {
        return (2 * pos);   //left child at next level 
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1; // right child at next level + 1 
    }

    private boolean isLeaf(int pos) {

        if (pos > (size / 2)) {
            return true;   //all leaf nodes are after half the array is passed. because we store roots first
        }

        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos; //whenever new node is added, it is first added to leaf then checked is it more than root
            if (rightChild(pos) <= size) {
                swapPos = Heap[leftChild(pos)] < Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            } else {
                swapPos = leftChild(pos);
            }

            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                swap(pos, swapPos);
                minHeapify(swapPos); //recursive function until heapify
            }

        }
    }

    public void insert(int element) {

        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) { //if child less than parent means not min heap
            swap(current, parent(current));
            current = parent(current); //change current
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " parent : " + Heap[i]
                    + " leftC : " + Heap[2 * i]
                    + " rightC :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int remove() {

        int popped = Heap[FRONT]; //always pop front element as it is min heap
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT); //check for new min with recursive function

        return popped;
    }

    public static void main(String[] arg) {

        System.out.println("Min Heap:");

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

        System.out.println("The Min val is "
                + minHeap.remove());
    }
}
