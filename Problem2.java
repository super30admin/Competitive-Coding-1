
/*
Min Heap in Java

A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

    getMin(): It returns the root element of Min Heap. O(1)
    extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
    insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

*/


//Problem
// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Running on eclipse
// Any problem you faced while coding this : YES UNFAMILIAR OF CONCEPT


public class MinHeap {
    public static int[] heap;
    public static int size;
    public int maxSize;
    public static int Front = 1;
    public MinHeap(int maxSize)
    {
      this.size = 0;
      this.maxSize = maxSize;
      heap = new int[maxSize];
      heap[0] = Integer.MIN_VALUE;
    }
     public static void swap(int val1, int val2)
     {
       int temp = val1;
       val1 = val2;
       val2= temp;
     }
    public static void insert(int val)
    {
      
      size++; // incrementing size
      heap[size]= val; // inserting at end of array
      int current = size; 
      while(heap[current] < heap[current/2]) // till value at the index is less than the parent found at index/2
      {
       swap(heap[current],heap[current/2] );
        current = current/2; // change current to parent index to check the condition again
      }
    }
    public boolean isLeaf(int index)
    {
        if (index >= (size / 2) && index <= size) { 
              return true; 
          } 
          return false; 
    }
    public void minHeapify(int index)
    {
      if(!isLeaf(index))
      { // value at index greater than its left child  or right child
        if(heap[index] > heap[2*index] || heap[index] > heap[(2*index)+1])
        {
          if(heap[index] > heap[2*index]) // value at index greater than its left child
          {
           swap(heap[index], heap[2*index] ) ; // swap the two values
            minHeapify(heap[2*index]); // call minheapify at left child now
          } 
          else
          {
           swap(heap[index], heap[(2*index)+1] ) ; // swap the two values
            minHeapify(heap[(2*index)+1]); // call minheapify at right child 
          } 
      }
     } 
    }
    public int remove()
    {
      //Remove at front
      int val = heap[Front];
      heap[Front] = heap[size]; // put last element of array at the front
      size--; // decrement size as element removed
      minHeapify(Front); // now need to satisfy the property of min heap
      return val;
    }
     public void print() 
      { 
          for (int i = 1; i <= size / 2; i++) { 
              System.out.print(" P : " + heap[i] + " L : " + heap[2 * i] + " R :" + heap[2 * i + 1]); 
              System.out.println(); 
          } 
      } 
    
    public static void main(String[] args) {
      MinHeap minHeap = new MinHeap(10);
       minHeap.insert(8);
       minHeap.insert(0);
       minHeap.insert(7);
       minHeap.insert(4);
       minHeap.insert(10);
       minHeap.insert(27);
       minHeap.insert(1);
       minHeap.insert(2);
       minHeap.insert(19);
       minHeap.insert(23); 
       minHeap.print(); 
      
    }
  }
  