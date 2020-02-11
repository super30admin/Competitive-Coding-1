// Time complexity: O(log N) where N is the size of the minHeap
// Space complexity: O(1) auxilliary space 
// Successful on leetcode playground


//=================================== Approach-1 ==================================

/*
Algorithm:
==========
1. Priority Queue by default has compare method to suit implementing min heap. 
2. If libraries can be used, minHeap can be implemented using priority queue
*/


public class MinHeapPriorityQueue {
    
    Queue<Integer> queue = new PriorityQueue<>();
    public int getMin() {
        return queue.peek();
    }
    
    public int extractMin() {
        return queue.size() > 0? queue.poll(): -1;
    }
    
    public void insert(int value) {
        queue.add(value);
    }
    
    public static void main(String[] args) {
        MinHeapPriorityQueue heap = new MinHeapPriorityQueue();
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        for (int item : ia) {
            heap.insert(item);
        }
        
        System.out.println("Min extracted is:"+ heap.extractMin() +" New min is:"+ heap.getMin());
        System.out.println("Min extracted is:"+ heap.extractMin() +" New min is:"+ heap.getMin());
        System.out.println("Min extracted is:"+ heap.extractMin() +" New min is:"+ heap.getMin());
    }
}

//=================================== Approach-2 ==================================

/*
Algorithm:
==========
1. As we have idea that if node is k, left child would be 2k-1 and right child would be 2k+1, use this fact to heapify the array
2. We always need to have min value at root, so swap root with whichever child is small whenever element is inserted or extracted
*/


public class MinHeap {
    static int[] heap;
    static int size, maxSize;
    final static int ROOT = 1;
    
    //Constructor
    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        heap = new int[maxSize+1];
        heap[0] = Integer.MIN_VALUE;
        this.size = 0;
    }
    
    //returns index of parent of node
    private static int parent(int curr) {
        return curr/2;
    }
    
    //returns index of left child of node 
    private static int leftChild(int curr) {
        return 2*curr;
    }
    
    //returns index of right child of node
    private static int rightChild(int curr) {
        return 2*curr + 1;
    }
    
    //if current node is stored in second half of the array, it is definitely a leaf node
    private static boolean isLeaf(int curr) {
        if(curr >= size/2 && curr <= size) 
            return true;
        
        return false;
    }
    
    // swap values at 2 positions
    private static void swap(int pos1, int pos2) {
        int temp = heap[pos2];
        heap[pos2] = heap[pos1];
        heap[pos1] = temp;
    }
    
    private static void printHeap() {
        for(int i = 1; i <= size/2; i++) {
            System.out.println("Parent:"+heap[i]+" Left child:"+heap[2*i]+" Right child:"+heap[2*i+1]);
            System.out.println(); 
        }
    }
    
    // wrapper for heapify method
    public static void minHeap() {
        for(int curr = size/2; curr >= 1; curr--) {
            minHeapify(curr);
        }
    }
    
    //Heapify the node at current position
    private static void minHeapify(int curr) {
        // If curr > leftChild or rightChild, swap with whichever is smaller than curr
        if( heap[curr] > heap[leftChild(curr)] || heap[curr] > heap[rightChild(curr)]) {
            if(heap[leftChild(curr)] < heap[rightChild(curr)]) {
                //Left child smaller than curr, so swap curr and left child
                swap(curr, leftChild(curr));
                minHeapify(leftChild(curr));
            }
            else {
                // Right child is smaller than curr, so swap curr and right child
                swap(curr, rightChild(curr));
                minHeapify(rightChild(curr));
            }
        }
    }
    
    
    //Insert node in minHeap
    public static void insert(int value) {
        if( size >= maxSize)
            return;
        
        // insert value at last index
        heap[++size] = value;
        int curr = size;
        
        //swap parent and curr until its right place is found
        while( heap[curr] < heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }
    
    
    public static int getMin() {
        return heap[0];
    }
     
    public static int extractMin() {
        int popped = heap[ROOT];
        heap[ROOT] = heap[size--];
        minHeapify(ROOT);
        return popped;
    }
    
   
    
    public static void main(String[] args) {
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
  
        minHeap.printHeap(); 
        System.out.println("The Min val is " + minHeap.extractMin());
    }
}