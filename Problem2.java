import java.util.*;
class Solution {
    private List<Integer> heap;
    private int size;
    private int capacity;
    
    // Initializes the heap with a predefined capacity and fills it to prevent index issues.
    public void initializeHeap() {
        capacity=10000;
        size=0;
        heap = new ArrayList<>(capacity);
        heap.add(0); // index 0 is a dummy value
    }
    // Time Complexity : O(n) | Space Complexity : O(1)
    public void print() {
        // Prints all elements in the heap from 1 to size
        for(int i=1;i<=size;i++)
        {
            System.out.print(heap.get(i)+" ");
        }
    }
    // Time Complexity : O(1)  | Space Complexity : O(1)
    // Returns the parent index of a given node
    public int parent(int pos){
        return pos/2;
    }
    // Time Complexity : O(1)  | Space Complexity : O(1)
    // Returns the left child index of a given node
    public int leftChild(int pos){
        return 2*pos;
    }
    // Time Complexity : O(1)  | Space Complexity : O(1)
     // Returns the right child index of a given node
    public int rightChild(int pos){
        return 2*pos+1;
    }
    // Time Complexity : O(1)  | Space Complexity : O(1)
    // Returns the current size of the heap
    public int size(){
        return size;
    }
    // Time Complexity : O(1)  | Space Complexity : O(1)
    // Checks if a node is a leaf node
    public boolean isLeafNode(int pos){
        return size/2<pos && pos<=size;
    }
    // Time Complexity : O(1)  | Space Complexity : O(1)
    // Returns the smallest element in the heap (min-heap root)
    public int peek() {
        return heap.get(1);
    }
    // Time Complexity : O(logn)  | Space Complexity : O(1)
    // Inserts a new key into the heap and maintains min-heap property
    public void insert(int key) {
        if(size==capacity){
            System.out.println("Capacity Reached");
            return;
        }
        size++;
        int current=size;
        heap.add(key);
         // Heapify up: swap with parent while current is smaller than parent
        int parentID = parent(current);
        while(current > 1 && heap.get(current)<heap.get(parentID)){
            int temp = heap.get(current);
            heap.set(current, heap.get(parentID));
            heap.set(parentID, temp);
            current = parentID;
            parentID = parent(current);
        }
    }
    // Time Complexity : O(logn)  | Space Complexity : O(1)
    // Removes and returns the smallest element from the heap
    public int remove() {
        int removedElement = heap.get(1);
        heap.set(1,heap.get(size));
        size--;
        heapify(1);
        return removedElement;
    }
    // Time Complexity : O(logn)  | Space Complexity : O(1)
    // Heapify down from a given position to restore min-heap property
    public void heapify(int pos) {
        if(!isLeafNode(pos)){
            // Check if left child or right child exists that lesser element is there
            if(heap.get(pos)>heap.get(leftChild(pos))||heap.get(pos)>heap.get(rightChild(pos))){
                // Check if left child or right child is greater
                if(heap.get(rightChild(pos))>heap.get(leftChild(pos))){
                    int temp = heap.get(pos);
                    heap.set(pos,heap.get(leftChild(pos)));
                    heap.set(leftChild(pos),temp);
                    pos = leftChild(pos);
                }
               else{
                    int temp = heap.get(pos);
                    heap.set(pos,heap.get(rightChild(pos)));
                    heap.set(rightChild(pos),temp);
                    pos = rightChild(pos);
                }
                heapify(pos);
            }
        }
    }
    // Time Complexity : O(1) | Space Complexity : O(1)
    public boolean isEmpty() {
        return size==0;
    }

    
}
class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.initializeHeap();
        s.insert(8);
        s.insert(7);
        s.insert(6);
        s.insert(1);
        s.insert(9);
        s.insert(4);
        s.print();
        System.out.println();
        s.remove();
        s.print();
      // System.out.println(s.peek());
    }
}


