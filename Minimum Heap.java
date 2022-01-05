// Time Complexity : O(log2(n))
// Space Complexity : O(n) 

class minHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    // initialize the top most element of the heap
    private static final int FRONT = 1;


    // constructor method
    public minHeap(int maxsize)
    {
        //initialize maxsize and size variables
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }


    private int parent(int pos) {
        // return parent node's index
        return pos / 2;
    }

    private int leftChild(int pos) {
        // return left child node's index
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        // return right child node's index
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        // return true of the node is a leaf node
        if (pos > (size / 2) && pos <= size) {
            return true;
        }

        return false;
    }

    private void swap(int fpos, int spos)
    {
        // swap two nodes used during heapify
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greatee than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify the left child
                if (Heap[leftChild(pos)]
                        < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element)
    {
        if (size >= maxsize) {
            // return if the parent node capacity is reached
            return;
        }

        // insert new element
        Heap[++size] = element;
        int current = size;

        // heapify up until the node is greater or equal to its parent node
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {

            // Print the heap
            System.out.print("\nParent node : " + Heap[i] + " Left child node : " + Heap[2 * i] + " Right child node :" + Heap[2 * i + 1]);
        }
    }

    public int remove()
    {
        // remove and return the least (top-most) element from the heap
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    // Driver code
    public static void main(String[] arg)
    {
        minHeap heap = new minHeap(15);

        heap.insert(7);
        heap.insert(3);
        heap.insert(19);
        heap.insert(156);
        heap.insert(87);
        heap.insert(29);
        heap.insert(1);
        heap.insert(32);
        heap.insert(2);

        heap.print();

        System.out.println("\nThe minimum val is " + heap.remove());
    }
}