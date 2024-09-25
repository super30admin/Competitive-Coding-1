/*
TC: Insert: O(N * logN). We need to insert N elements and heapify it takes LogN.
Remove(): O(N * logN). After removal of element, again we need to heapify - logN. 
peek(): O(1) - heap always returns first element

*/

import java.util.Arrays;

public class MinHeap{
    
    int capacity;
    int size;
    int[] heap;

    public MinHeap(){
        this.capacity = 10;
        this.size = 0;
        heap = new int[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        if(isEmpty()) { throw new IllegalStateException();}
        return heap[0];
    }

    public void insert(int key){

        ensureExtraCapacity();

        heap[size] = key;
        size++;

        heapifyUp();
    }

    public void ensureExtraCapacity(){
        if(size == capacity){
            heap = Arrays.copyOf(heap, 2 * capacity);
            capacity = capacity * 2;
        }
    }


    public void heapifyUp(){
        int index = size - 1;

        while(hasParent(index) && parent(index) > heap[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public boolean hasParent(int index){
        return getParentIndex(index) >= 0; 
    }

    public int getParentIndex(int index){
        return ( index - 1 )/2;
    }
    
    public int parent(int index){
        return heap[getParentIndex(index)];
    }

    public void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public int remove(){
        if(isEmpty()) { throw new IllegalStateException();}

        int minItem = heap[0];
        heap[0] = heap[size-1];
        size--;

        heapifyDown();
        return minItem;
    }

    public void heapifyDown(){
        int index = 0;
        while(hasLeft(index)){

            int smallIndex = getLeftChildIndex(index);

            if(hasRight(index) && heap[smallIndex] > heap[getRightChildIndex(index)]){
                smallIndex = getRightChildIndex(index);
            }
            swap(smallIndex, index);
            index = smallIndex;
        }
    }

    public boolean hasLeft(int index){
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRight(int index){
        return getRightChildIndex(index) < size;
    }

    public int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index){
        return 2 * index + 2;
    }
    
    public void printHeap(){
        for(int i = 0; i < size; i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}
class Solution{
    public static void main(String[] args){
        MinHeap heap = new MinHeap();
        int[] arr = new int[]{5,3,6,4,0,1};
        
        for(int num : arr){
            heap.insert(num);
        }
        heap.printHeap();
        heap.remove();
        heap.printHeap();
    }
}

