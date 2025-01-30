//Time Complexity: O(1) for peek of minimum element, O(logn) for adding an element, and O(log n) for removing the minimum element
//Space Complexity: O(n) where n is the number of elements that are stored in the array.

import java.util.Arrays;

class MinHeap{
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2*parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex-1)/2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >=0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity = capacity * 2;
        }
    }

    public int peek(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && parent(index) > index){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
        
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){//we are not checking right child because there is no right child if there is not a left child
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(smallerChildIndex) && leftChild(index) < rightChild(index)){
                smallerChildIndex = index;
            }

            if(items[index] < items[smallerChildIndex]){
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }

    }
}
