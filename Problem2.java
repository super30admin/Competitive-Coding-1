//Time Complexity: O(1) 
//Space Complexity: O(n) 
// Did this code successfully run on Leetcode : yes.
// Any problem you faced while coding this : no

public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    
    private static final int FRONT = 1;

    
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;  
    }

    // Return the index of the parent of the node at index pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Return the index of the left child of the node at index pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    
    private void minHeapify(int pos) {
        
        while (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallest = pos;
            if (left <= size && Heap[left] < Heap[smallest]) {
                smallest = left;
            }
            if (right <= size && Heap[right] < Heap[smallest]) {
                smallest = right;
            }
            if (smallest != pos) {
                swap(pos, smallest);
                pos = smallest;
            } else {
                break;
            }
        }
    }

    // Insert a new element into the heap
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

    // Print the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                               Heap[2 * i] + " RIGHT CHILD :" +
                               Heap[2 * i + 1]);
        }
    }

    
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size];
        Heap[size--] = 0;  
        minHeapify(FRONT);
        return popped;
    }

    
    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
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
        minHeap.print();
    }
}
