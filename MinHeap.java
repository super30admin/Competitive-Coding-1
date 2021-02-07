public class MinHeap{

    /*

    Time complexity: Insert - O(log n)
                    Extract Min - O(log n)
                    getMin - O(1)
    */

    private int[] Heap;
    private int index, maxsize;
    private static final int FRONT = 1;

    // initialize Minheap
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.index = 0;
        // initialize the Heap array with maxsize + 1
        Heap = new int[this.maxsize + 1];
        // initialze the first element of the heap with minimum int value
        Heap[0] = Integer.MIN_VALUE;
    }


    // parent node
    private int parent(int position) {
        return ((position) / 2);
    }

    // left child
    private int leftChild(int position) {
        return (2 * position);
    }

    // right child
    private int rightChild(int position){
        return ((2 * position) + 1);
    }

    // check for leaf nodes
    private boolean isLeaf(int position) {
        if (position >= index/2 || position <= index) {
            return true;
        }
        return false;
    }

    // swap the two nodes in the heap
    private void swap(int i, int j) {
        int temp;
        temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }

    // insert a new node in the heap
    public void insert(int elem) {

        // check if the index has exceeded the max limit for the heap or not
        if (index >= maxsize) {
            return;
        }

        // place the elem at current index position(i.e. at the end) in the heap
        Heap[++index] = elem;

        int curr = index;

        // check if value at curr is lesser than parent of curr
        while(Heap[curr] < Heap[parent(curr)]) {
            // if true then swap the two nodes satisfy heap conditions
            swap(curr, parent(curr));
            // now update curr with index of parent of curr to check for heap conditions
            curr = parent(curr);
        }
        
    }

    // remove the root element of the heap
    public int remove() {
        int pop_elem = Heap[FRONT];
        // after removing the root element place it as the last element in the heap
        // so that the heap is not able to access it
        // decrement the index after placing it at the last position
        Heap[FRONT] = Heap[index--];
        // then perform heapify on the heap to balance it
        minHeapify(FRONT);
        // return the popped elem
        return pop_elem;
    }

    // balances the heap
    private void minHeapify(int i) {

        // check if the node is leaf node or not
        if(!isLeaf(i)) {
            // check if the value is greater than the left or right child
            if (Heap[i] > Heap[leftChild(i)] || Heap[i] > Heap[rightChild(i)]) {
                // check if the left child is lesser than the right child
                if(Heap[leftChild(i)] < Heap[rightChild(i)]) {
                    //swap that elem with elem at i position
                    swap(i, leftChild(i));
                    // balance the heap until leaf node is reached
                    minHeapify(leftChild(i));
                }
                // do the same for the right child
                else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    // check if the heap is balance or not
    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    // print the heap
    public void print() {
        for (int i = 1; i <= (index / 2); i++) {
            System.out.println("Parent: " + Heap[i]);
            System.out.println("LeftChild: " + Heap[2*i]);
            System.out.println("RightChild: " + Heap[2*i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args){
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
        minHeap.minHeap(); 
  
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.remove()); 
    }

}