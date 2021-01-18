//Problem 16: Design Min Heap
//TC : O(log(n)), n is the number of elements in a given array
//SC : O(N)

import java.util.*;
class MinHeap{
    int[] arr; 
    int top; 
     MinHeap(int size){
        arr = new int[size];
        top = -1;
     }

    public static void main(String[] args){
        int arr[] = {7,8,6,9,5,4,12,1};
        //int arr[] = {15,5,3,17,10,84,19,6,22,9};
        MinHeap minHeap = new MinHeap(arr.length); 

        for(int i=0;i<arr.length;i++){
            minHeap.insert(arr[i]);
            System.out.println("Inserted elem "+arr[i]+" Current Min "+minHeap.getMin());
        }

        System.out.println("Min Heap "+Arrays.toString(minHeap.arr));

        System.out.println("After Iteration min" + minHeap.getMin());
        System.out.println("After 1st extraction " + minHeap.extractMin());

        System.out.println("After extraction min is " + minHeap.getMin());

        System.out.println("After 1st extraction Min Heap "+Arrays.toString(minHeap.arr));


    }

    private int getParentIdx(int currIdx){
       if(isEmpty()) return -1;

       if(currIdx==0) return -1;

       return (currIdx-1)/2;
    }

    private int getLeftChildIdx(int currIdx){

        return 2*currIdx+1;
    }

    private int getRightChildIdx(int currIdx){

        return 2*currIdx+2;
    }

    private void insert(int val){

          if(!isFull()){
            arr[top+1] = val;
            top++;
            heapifyUp(top);
            return;
          }
    }

    private int extractMin(){

        int minVal = -1;

        if(!isEmpty()){
            minVal = arr[0];
            arr[0] = arr[top];
            arr[top] = 0;
            top--;
            heapifyDown();
        }

        return minVal;
    }

    private int getMin(){

        if(!isEmpty()){
            return arr[0];
        }

        return -1;
    }

    private void heapifyUp(int index){
       int childIdx = index; 
       int parentIdx = getParentIdx(childIdx); 
       while(parentIdx>=0 && arr[parentIdx]>arr[childIdx]){//if you want yu can make a function called hasParent
             swap(parentIdx,childIdx);//swapping parent and child
             childIdx = parentIdx;
             parentIdx = getParentIdx(childIdx);
       }
    }

    private void heapifyDown(){
        int parentIdx = 0;

        while(hasLeftChild(parentIdx)){//its obvious as heap is a complete binary tree, first there will be a left and then right child. So no need to check both at the same time.

            int smallerIdx = getLeftChildIdx(parentIdx);//assume left will be smaller

            if(hasRightChild(parentIdx) && arr[getRightChildIdx(parentIdx)]<arr[smallerIdx]){
                 smallerIdx = getRightChildIdx(parentIdx);
            }

            if(arr[parentIdx]>arr[smallerIdx]){
                swap(parentIdx, smallerIdx);
                parentIdx = smallerIdx;
            }else{
                return;
            }
      }
} 

    private boolean isEmpty(){
      return top==-1;
    }

    private boolean isFull(){
       return top==arr.length-1;
    }

    private boolean hasLeftChild(int parentIdx){
         int leftChildIdx = getLeftChildIdx(parentIdx);

         return leftChildIdx<=top;
    }

    private boolean hasRightChild(int parentIdx){
        int rightChildIdx = getRightChildIdx(parentIdx);

        return rightChildIdx<=top;
   }

    private void swap(int parentIdx,int childIdx){
        int temp = arr[parentIdx];
        arr[parentIdx] = arr[childIdx];
        arr[childIdx] = temp;
    }

}