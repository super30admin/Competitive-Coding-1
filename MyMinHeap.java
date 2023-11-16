// Time Complexity : add- O(log n) remove - O(log n) getMin- O(1)
// Space Complexity : O(1) auxiliary space complexity
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : -

/*
Design your own min heap using array DS
 */
public class MyMinHeap {
    int size;
    int capacity;
    int[] heap;

    // Initializing front as static with unity
    private static final int FRONT = 1;

    MyMinHeap(int maxSize) {
        this.capacity = maxSize;
        this.size = 0;
        this.heap = new int[maxSize+1];
        heap[0] = Integer.MIN_VALUE;

    }
    int parent(int pos){
        return pos/2;
    }

    int leftChild(int pos) {
        return 2*pos;
    }
    int rightChild(int pos) {
        return 2*pos + 1;
    }

    boolean isLeaf(int pos) {
        return pos > size/2 && pos <= size;
    }

    int peek(){
        return heap[1];
    }

    void print() {
        for(int i=1; i<=size/2; i++) {
            System.out.print("Parent: " + heap[i]);
            System.out.println("  Left: " + heap[leftChild(i)] + " Right:" + heap[rightChild(i)]);
        }
    }

    //If the current pos element violates min heap property, this function makes sure the elements are
    // positioned properly according to min heap concept.
    void heapify(int pos) {
        int swapPos = pos;
        if(!isLeaf(pos)) {
            //Swap with min of 2 children
            //chk if rt child exists, otherwise default to 0 and swap with pos
            if(rightChild(pos)<=size) {
                 swapPos = heap[rightChild(pos)]< heap[leftChild(pos)]? rightChild(pos): leftChild(pos);
            } else {
                swapPos = leftChild(pos);
            }

            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                swap(pos, swapPos);
                heapify(swapPos);
            }
        }
    }

    public void swap(int pos, int swapPos) {
            int temp;
            temp = heap[pos];
            heap[pos] = heap[swapPos];
            heap[swapPos] = temp;
    }

    //To add a new element and position it in the min heap using heapify
    public void add(int element) {
        if(size >= capacity)
            return;

        heap[++size] = element;
        int current = size;

        while(heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //To remove from FRONT and return the popped value which is min
    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        heapify(FRONT);

        return popped;
    }


    public static void main(String args[]) {
        MyMinHeap minHeap = new MyMinHeap(15);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);

        // Print all elements of the heap
        minHeap.print();

        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                + minHeap.remove());
    }

}