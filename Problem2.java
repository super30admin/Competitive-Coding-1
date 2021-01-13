//Problem 16: Design Min Heap
//TC : O(log(n)), n is the number of elements in a given array
//SC : O(N)

/*Notes & Steps

  Difference between abstract data type and data structure:
   Stack, queues are abstract data types => because functions/operations are fixed pop, push, enqueue, dequeue, however for implementing these there can be any data structure such as array list, linked list, trees or what ever. Under the hood implementation can be of any type
  
   Priority Queue is a abstract data type and Heap data structure is used to implement priority queue but priority queue can be implemented without using heap as well
  
   Heap is a complete binary tree, which means there may be a possibility when right side doesnt have any elements but left side will definitely have. Complete binary tree is filled from level by level i.e top to bottom. Last node can have empty right child, but its not possible that right side has a child but left doesn't have.
  
   Heap doesnt have a property of min or max internally, it is not sorted. It only guarantees that root element will be minimum or maximum. Whenever u extract the top element from heap, it should be restructured/restored in the way u want either root will have max element or root will have min element.

   Searching an element in heap is equivalent to searching an element in array. Heap don't serve the purpose of searching. It just serve the purspose of min and max element at root
  
   Min Heap only property: Parent will be less than its child node for min heap
  
   Min & Max -O(1)

   Insert:
   1) Add element to end
   2) Heapify up function, check whether current node that u added is less than the parent node, then swap it, otherwise no need. Swap it until the above condition is satisfied or u reach the root node
   TC: O(log(N))
   
   In complete binary tree height is log(N) nodes, that's why heapify up will go from bottom to root, which is equivalent to height of complete binary tree
   
   Remove: 
   1) Put the last element in top and then heapify down
   2) Heapify Down, check whether current node at top is greater than its children nodes. If it is greater, swap it with the smaller child node until the current node is greater than the child node.
   Basically for this operation assume that left child will be smaller than the current node. If left child is not smaller, then check whether current note has right child or not. If it has right child, compare the current node with the right child and then swap the current node and the smaller node accordingly.
   TC : O(log(N))
   In complete binary tree height is log(N) nodes, that's why heapify down will go from root to bottom, which is equivalent to height of the complete binary tree
   
   Here I have implemented Heap using Array so following are some of the important functions
   Imp functions: 1) GetLeftChildIndex : 2k+1 , k is current index
                  2) GetRightChildIndex  : 2k+2
                  3) GetParentIndex : (k-1)/2
                  4) HasLeftChild   : can be checked with the help of top pointer
                  5) HasRightChild  : can be checked with the help of top pointer
                  6) Heapify Up
                  7) Heapify Down

*/
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

