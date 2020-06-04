import java.io.*;
import java.util.*;

class MinHeap {
    int capacity = 10;
    int sizeOfHeap=0;
    
    int [] items = new int[capacity];
    
    private int getLeftChildIdx(int parentIdx) { return 2*parentIdx +1; }
    private int getRightChildIdx(int parentIdx) { return 2*parentIdx +2; } 
    private int getParentIdx(int childIdx) { return (childIdx -1)/2;}
    
    private boolean hasLeftChild(int idx) { return getLeftChildIdx(idx) < sizeOfHeap;}
    private boolean hasRightChild(int idx) { return getRightChildIdx(idx) < sizeOfHeap;}
    private boolean hasParent(int idx){ return getParentIdx(idx) >=0 ;}
    
    //contents
    private int leftChild(int idx){ return items[getLeftChildIdx(idx)];}
    private int rightChild(int idx){ return items[getRightChildIdx(idx)];}
    private int parent(int idx){ return items[getParentIdx(idx)];}
    
    private void swap(int idxOne,int idxTwo){
        int temp = items[idxOne];
        items[idxOne] = items[idxTwo];
        items[idxTwo] = temp;
    }
    
    private void reAllocateCapacity(){
        if(sizeOfHeap == capacity ){
            items = Arrays.copyOf(items,capacity*2); //double the size of array in which storing values 
            capacity = capacity *2;
        }
    }
    
    // get the minHeap value which is the first element
    public int peek(){
        if(sizeOfHeap==0) throw  new IllegalStateException();
        return items[0]; //always minimum value at 0th idex
    }
    
    //remove minHeap from heap
    public int poll(){
        if(sizeOfHeap==0) throw  new IllegalStateException();
        int itemVal = items[0];
        items[0] = items[sizeOfHeap -1]; //move last element to the first position
        sizeOfHeap--;  //minHeap removed
        heapifyDown();//then adjust heap
        
        return itemVal;
    }
    
    public void add (int itemVal){
        reAllocateCapacity();
        items[sizeOfHeap] = itemVal;//add in the last spot
        sizeOfHeap++;
        heapifyUp();
    }
    
    public void heapifyUp(){
        int index =sizeOfHeap -1;  //start at last element
        //as long as parent found and value of parent is greater than the current element
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIdx(index),index); //swap
            index = getParentIdx(index);//reset index
        }
    }
    
    public void heapifyDown(){
        int index = 0; //starting position
        while(hasLeftChild(index)){
            int smallerChildIdx = getLeftChildIdx(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIdx = getRightChildIdx(index);
            }
            if(items[smallerChildIdx] < items[index]){
                swap(smallerChildIdx,index);
            }
            else{
                break;
            }
            index = smallerChildIdx;
        }
    }
        
    
    
   /* 
    Time complexity for add and remove is O(n) ,peek is O(1)
    Space complexity O(1);
    */
    
	public static void main (String[] args) {
		System.out.println("GfG!");
		
		MinHeap minHeap = new MinHeap();
		minHeap.add(4);
		minHeap.add(2);
		minHeap.add(1);
		System.out.println("Poll "+minHeap.poll());
	System.out.println("Peek "+minHeap.peek());
		System.out.println("Latest Heap Elements");
		for(int i = 0 ;i<minHeap.items.length;i++)
		System.out.println(minHeap.items[i]);
		
	}
}



//Lohith
//My heap I added 4 2 1 
//After I do poll the last element is moved to the first postion but 
//both last and first positions are having the same element . What is wrong here
//please let me know
/*
GfG!
Poll 1
Peek 2
Latest Heap Elements
2
4
2
0
*/