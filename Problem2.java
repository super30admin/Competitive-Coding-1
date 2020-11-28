// Time Complexity : O(logN) for insert and extractMin operations, O(1) for getMin operation
// Space Complexity : O(N), N is the maximum size of array 

public class MinHeap { 
    
    private int[] Heap;
    private int maxSize;
    private int size;
    private static int front = 1;

    public MinHeap(int maxSize) {

        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;

    }

    public int parent(int pos) {
        return pos/2 ;
    }

    public int leftChild(int pos) {
        return (2 * pos);
    }

    public int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    public boolean isLeaf(int pos) {
        if (pos >= (size/2) && pos <= size ) {
            return true;
        }
        return false;
    }

    public void swap(int first, int second){
        int tmp;
        tmp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = tmp;
    }

    private void minHeapify(int pos){

        if(!isLeaf(pos)) {
            if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if(Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else 
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos)); 
                }
            }
        }
    }

    public void insert(int x) {
        if (size > maxSize) {
            return;
        }
        size += 1;
        Heap[size] = x;
        int current = size;
        while(Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        } 
    }

    public void minHeap() {
        for (int pos = (size/2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public void print() {
        for (int pos = 1; pos <= size/2; pos++) {
            System.out.println("parent - " + Heap[pos]);
            System.out.println("left child - " + Heap[leftChild(pos)]);
            System.out.println("right child - " + Heap[rightChild(pos)]);
            System.out.println("\n");
        }
    }

    public int extractMin() {
        int popped = Heap[front];
        Heap[front] = Heap[size];
        size = size - 1;
        minHeapify(front);
        return popped;
    }

    public int getMin() {
        return Heap[front];
    }

    // Driver code 
    public static void main(String[] arg) 
    { 
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
        System.out.println("The Min val is " + minHeap.extractMin()); 
    } 
} 