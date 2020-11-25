package com.mockinterview;


import java.util.Arrays;

abstract class Heap{

    // current array length
    protected int capacity;

    //current number of elements in Heap
    protected int size;

    //Array of Heap elements
    protected int[] items;


    public Heap(){
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity];
    }

    // takes parentIndex as parameter and returns the index of left child

    public int getLeftChildIndex(int parentIndex){
        return 2*parentIndex;
    }

    // takes parentIndex as parameter and returns the index of right child

    public int getRightChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }

    //takes childIndex as parameter and returns the index of parentIndex

    public int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    // takes index and returns true if heap contains enough
    // elements to fill the left child or false otherwise

    public boolean hasLeftChild(int index){
        return  getLeftChildIndex (index) < size;
    }

    // takes index and returns true if heap contains enough
    //elements to fill the right child or false otherwise

    public boolean hasRightChild(int index){
        return getRightChildIndex (index) < size;
    }

    // takes index of element and checks if the parentIndex
    // exists within array bounds

    public boolean hasParent(int index){
        return getParentIndex (index) >=0;
    }

    // takes the param as index and returns its left child value

    public int leftChild(int index){
        return items[getLeftChildIndex (index)];
    }

    // takes the param as index and returns its right child value

    public int rightChild(int index){
        return items[getRightChildIndex (index)];
    }

    // takes the param as index and returns the parent value

    public int parent(int index){
        return items[getParentIndex (index)];
    }

    // function to swap items elements

    public void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    // doubles the underlying array if the capacity reached
    public void ensureCapacity(){
        if(size == capacity){
            capacity = capacity << 1;
            items = Arrays.copyOf (items,capacity);
        }
    }
    // throws IllegalStateException if heap is empty
    // returns the value at top

    public int peek(){
        isEmpty("peek");

        return items[0];
    }

    public void isEmpty(String methodName){
        if(size == 0){
            throw new IllegalStateException (
                    "You cannot perform '" + methodName + " ' on an empty Heap"
            );
        }
    }

    // Extracts root element from Heap
    // throws IllegalStateException if heap is empty
    public int poll(){
        isEmpty ("poll");
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }



    //adds the items to the heap

    public void add(int item){
        ensureCapacity ();
        items[size] = item;
        size++;
        heapifyUp();
    }



    // swap the values down the heap

    public abstract void heapifyDown();

    // swap the values up the heap

    public abstract void heapifyUp();
}



 class MinHeap  extends  Heap{


     @Override
     public void heapifyDown() {
         int index = 0;
         while (hasLeftChild (index)){
             int smallerChildIndex = getLeftChildIndex (index);
             if(hasRightChild (index) && rightChild (index) < leftChild (index)){
                 smallerChildIndex = getRightChildIndex (index);
             }
             if(items[index] < items[smallerChildIndex]){
                 break;
             } else {
                 swap (index,smallerChildIndex);
             }
         }

     }

     @Override
     public void heapifyUp() {

         int index = size - 1;
         while(hasParent (index) && parent (index) > items[index]){
             swap (getParentIndex (index),index);
             index = getParentIndex (index);
         }

     }

     public static void main(String[] args) {

         MinHeap sol = new MinHeap();
         // adding the elements to heap

         sol.add (2);
         sol.add (22);
         sol.add (222);
         sol.add (1);
         sol.add (3);

         for (int i = 0; i < 5; i++) {
             System.out.println (sol.poll ());
         }

     }




 }
