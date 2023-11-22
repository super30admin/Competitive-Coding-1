//Time Complexity : insert(): O(logN), remove: O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : -

class GFG {

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public GFG(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) { return pos / 2; }

    private int leftChild(int pos) { return (2 * pos); }

    private int rightChild(int pos) { return (2 * pos) + 1; }

    private boolean isLeaf(int pos) {

        if (pos > (size / 2)) {
            return true;
        }

        return false;
    }

    private void swap(int fpos, int spos) {

        int tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if(!isLeaf(pos)){
            int swapPos= pos;
            // swap with the minimum of the two children
            // to check if right child exists. Otherwise default value will be '0'
            // and that will be swapped with parent node.
            if(rightChild(pos)<=size)
                swapPos = Heap[leftChild(pos)]<Heap[rightChild(pos)]?leftChild(pos):rightChild(pos);
            else
                swapPos= leftChild(pos);

            if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]){
                swap(pos,swapPos);
                minHeapify(swapPos);
            }

        }
    }

    public void insert(int element) {

        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    public int remove() {

        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");

        GFG minHeap = new GFG(15);

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

