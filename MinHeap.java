public class MinHeap {
    private  int[] Heap;
    private int size;
    private  int capacity;


    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        Heap = new int[this.capacity+1];
    }


    private int parent(int pos) {
        return (pos-1)/ 2;
    }

    private int leftChild(int pos) {
        return (2 * pos)+1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swapNodes(int fidx, int sidx) {
        int temp;
        temp = Heap[fidx];
        Heap[fidx] = Heap[sidx];
        Heap[sidx] = temp;
    }

    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]|| Heap[pos] > Heap[rightChild(pos)]) {

                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swapNodes(pos, leftChild(pos));
                    heapify(leftChild(pos));
                } else {
                    swapNodes(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= capacity) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swapNodes(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() 
    { 
        int popped = Heap[0]; 
        Heap[0] = Heap[size--]; 
        heapify(0); 
        return popped; 
    } 
    public void printHeap() {
        for (int i = 0; i < size / 2; i++) {
            System.out.println("PARENT : " + Heap[i]);

            System.out.println("--LEFT CHILD : " + Heap[2 * i+1]);

            System.out.println("--RIGHT CHILD : " + Heap[2 * i + 2]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(15);
        minHeap.insert(90);
        minHeap.insert(19);
        minHeap.insert(8);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.printHeap();

        System.out.println("The Min val is " + minHeap.remove()); 
        System.out.println("The Min val is " + minHeap.remove()); 
        //minHeap.insert(2)
        System.out.println("Heap after min removal is ");
        minHeap.printHeap();

    }
}
