package Heap;

public class BinaryMinHeap {
    int heapArray[];
    int size;

    //Time Complexity: O(1)
    //Space Complexity: O(N)
    // Constructor initializes the heap with a given capacity.
     // We use a 1-based indexing for easier parent-child relationship calculations.

    public BinaryMinHeap(int capacity){
        this.size = 0;
        this.heapArray = new int[capacity+1];
        System.out.println(" Binary Heap of size " + capacity + " has been created");
    }
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    // Checks if the heap contains any elements by verifying the current size.
    public boolean isEmpty(){
        return size == 0;
    }
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Returns the root element (minimum) without removing it.
    //In a min-heap, the minimum value is always at index 1.
    public Integer peek(){
        if(isEmpty()){
            System.out.println("The Heap is Empty.");
            return null;
        }
        return heapArray[1];
    }
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Returns the current number of elements in the heap.
    public int sizeOfHeap(){
        return size;
    }

    //Time Complexity: O(N)
    //Space Complexity: O(1)
    //Iterates through the array from index 1 to size to print elements
    // in the order they appear in the heap's array representation.
    public void levelOrderTraversal(){
        for(int i=1; i<=size; i++){
            System.out.print(heapArray[i] + " ");
        }
        System.out.println("");
    }
    //Time Complexity: O(logN)
    //Space Complexity: O(logN)
    //Inserts a new value at the end of the heap (next available leaf)
    //and then bubbles it up to restore the min-heap property.
    public void insert(int value){
        heapArray[++size] = value;
        heapifyBottomUp(size);
    }
    //Time Complexity: O(logN)
    //Space Complexity: O(logN)
    //Maintains min-heap property by comparing the current node with its parent.
    //If the current node is smaller, they are swapped, and the process continues upward.
    public void heapifyBottomUp(int index){
        int parent = index/2;
        // base condition
        if(index <= 1){
            return;
        }
        //swap condition for min heap
        if(heapArray[index] < heapArray[parent]){
            int temp = heapArray[index];
            heapArray[index] = heapArray[parent];
            heapArray[parent] = temp;
        }
        heapifyBottomUp(parent);
    }

    //Time Complexity: O(logN)
    //Space Complexity: O(logN)
    //Maintains min-heap property by comparing the current node with its children.
    //If a child is smaller than the parent, it swaps with the smaller child and continues downward.
    public void heapifyToptoBottom(int index){

        int leftChild = 2*index;
        int rightChild = 2*index + 1;

        if(leftChild <= size && heapArray[leftChild] < heapArray[index]){
            int temp = heapArray[leftChild];
            heapArray[leftChild] = heapArray[index];
            heapArray[index] = temp;
            heapifyToptoBottom(leftChild);
        }else if(rightChild <= size && heapArray[rightChild] < heapArray[index]){
            int temp = heapArray[rightChild];
            heapArray[rightChild] = heapArray[index];
            heapArray[index] = temp;
            heapifyToptoBottom(rightChild);
        }
    }

    //Time Complexity: O(logN)
    //Space Complexity: O(logN)
    //Removes and returns the minimum element (root).
    //The last element in the heap replaces the root, the size is decremented,
    //and heapifyToptoBottom is called to restore the heap property.
    public int extractMin(){
        if(isEmpty()){
            return -1;
        }
        int extractedValue = heapArray[1];
        heapArray[1] = heapArray[size--];
        heapifyToptoBottom(1);
        return extractedValue;
    }

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void deleteHeap(){
        heapArray = null;
        System.out.println();
    }
}
