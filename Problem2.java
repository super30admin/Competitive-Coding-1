
package Arrays;

import java.nio.BufferOverflowException;

public class MinHeap {
    //Initialise an array and a capacity
    int capacity;
    int [] heap;
    int currentSize;

    public MinHeap(int heapSize){
        this.capacity = heapSize;
        heap = new int[this.capacity];
        currentSize =0;
    }
    // get the positions of the nodes using three functions for parent, left and right nodes

    private int parentPos(int i){
        return(i-1/2);
    }

    private  int leftChildPos(int i){
        return (i*2)+1;
    }
    private  int rightChildPos(int i){
        return (i*2)+2;
    }

    private boolean isLeaf(int i){
        if(this.rightChildPos(i)>=currentSize || this.leftChildPos(i)<=currentSize)
            return true;
        return false;
    }
    public int peek(){
        if(currentSize <=0)
            throw new IllegalArgumentException();

        return heap[0];
    }

    public int poll(){
        // Remove the top element and then heapify
        int item = heap[0];
        heap[0]=heap[currentSize-1];
        currentSize--;
        heapify(0);
        return item;
    }
    private void swap(int positionOne, int positionTwo){
        int temp = heap[positionOne];
        heap[positionOne]= heap[positionTwo];
        heap[positionTwo]=temp;
    }

    public void heapify(int i) {
        /**
         * Iterate from top(root) to the leaf
         * Check if the heap is greater than leftNode or rightNode and swap accordingly
         */
        if(!isLeaf(i)){
            if (heap[i] > heap[leftChildPos(i)] ||
                    heap[i] > heap[rightChildPos(i)]) {
                if (heap[leftChildPos(i)] < heap[rightChildPos(i)]) {
                    swap(i, leftChildPos(i));
                    heapify(leftChildPos(i));
                } else {
                    swap(i, rightChildPos(i));
                    heapify(rightChildPos(i));
                }
            }
        }
    }

    public void insert(int value){
        /**
         * insert the value to the bottom of the array(tree) and then bubble the value up
         * Check if the value is greater than it's parent and keep going
         */
        if (currentSize>= this.capacity)
            throw new BufferOverflowException();
        heap[currentSize] = value;
        int current = currentSize;
        while(heap[current] > heap[parentPos(current)]){
            swap(current,parentPos(current));
            current =parentPos(current);
        }

        currentSize++;

        //Check for the root and the value of the
    }




}
