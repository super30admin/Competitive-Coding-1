/**
Time Complexity : O(log n),for insertion and deletion, where n is the number of nodes in the heap. 
O(1) for finding the min.
Space Complexity : O(1)

 */

//Approach : 
// 1. Solved it using arrays, because we can leverage the property of complete binary tree to get left(2*i) and right children(2*i)+1.
// 2. While inserting an element, we insert it at the end of the complete binary tree, where there is a spot and then heapify to satisfy the condition of min-heap
// 3. While removing an element from the root, we replace the removed node, with the last element and then heapify again.
// 4. In Heapify, we make sure that the root element(parent) is smaller than the children, if not, we swap them accordingly


//Implementation of Min Heap 
public class MinHeap { 
    private int[] Heap; 
    private int size; 
    private int maxSize; 
    private static final int ROOT = 1; 
    
  
    public MinHeap(int maxSize) 
    { 
        this.maxSize = maxSize; 
        this.size = 0; 
        Heap = new int[this.maxSize + 1]; //indexing starts from 1
        Heap[0] = Integer.MIN_VALUE; 
    } 
 
    private int parent(int currentPosition) 
    { 
        return currentPosition / 2; 
    } 

    private int leftChild(int currentPosition) 
    { 
        return (2 * currentPosition); 
    } 
  
    private int rightChild(int currentPosition) 
    { 
        return (2 * currentPosition) + 1; 
    } 

    private boolean isLeaf(int currentPosition) 
    { 
        if (currentPosition >= (size / 2) && currentPosition <= size) { 
            return true; 
        } 
        return false; 
    } 

    private void swap(int a, int b) 
    { 
        int temp; 
        temp = Heap[a]; 
        Heap[a] = Heap[b]; 
        Heap[b] = temp; 
    } 

    private void heapify(int currentPosition) 
    { 
  
        if (!isLeaf(currentPosition)) { 
            if (Heap[currentPosition] > Heap[leftChild(currentPosition)] || Heap[currentPosition] > Heap[rightChild(currentPosition)]) { 
  
                // Swap with the left child and heapify the left child 
                if (Heap[leftChild(currentPosition)] < Heap[rightChild(currentPosition)]) { 
                    swap(currentPosition, leftChild(currentPosition)); 
                    heapify(leftChild(currentPosition)); 
                } 
  
                // Swap with the right child and heapify the right child 
                else { 
                    swap(currentPosition, rightChild(currentPosition)); 
                    heapify(rightChild(currentPosition)); 
                } 
            } 
        } 
    } 
  
    // Inserts a node into the heap 
    public void insert(int element) 
    { 
        if (size >= maxSize) { 
            return; 
        } 
        Heap[++size] = element; 
        int current = size; 
  
        while (Heap[current] < Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    // Builds the min heap 
    public void minHeap() 
    { 
        for (int currentPosition = (size / 2); currentPosition >= 1; currentPosition--) { 
            heapify(currentPosition); 
        } 
    } 
  
  //removes the min element and returns it.
    public int getMin() 
    { 
        
        int popped = Heap[ROOT]; //minimum stays on the top of the tree(i.e, at the root node)
        Heap[ROOT] = Heap[size--]; // Now, place the last element in the place where root is removed.
        heapify(ROOT); // to ensure the heapify property is satisfied.
        return popped; 
    } 
  
    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(10); 
        minHeap.insert(10); 
        minHeap.insert(7); 
        minHeap.insert(6); 
        minHeap.insert(12); 
        minHeap.insert(17); 
        minHeap.insert(5); 
        minHeap.insert(15); 
        minHeap.minHeap(); 
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.getMin()); 
    } 
} 
