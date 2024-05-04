/*
time complexity:
getMin(): O(1)
extractMin(): O(log(n)) to heapify where n is the number of elements
insert()L O(log(n)) to heapify where n is the number of elements
space complexity: O(n) 
did this run on leetcode? N/A
 */
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    private int maxHeapSize;
    private List<Integer> heap;

    public Problem2(int heapSize) {
        this.maxHeapSize = heapSize;
        this.heap = new ArrayList<>();
    }
    private int getMin() {
        if(heap.size() > 0) {
            return heap.get(0);
        }
        return Integer.MAX_VALUE;
    }

    private int extractMin() {
        if(heap.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int lastIdx = heap.size()-1;
        int rootValue = heap.get(0);
        swap(0, lastIdx);
        heap.remove(lastIdx);
        heapify(0);
        return rootValue;
    }

    private void insert(int value) {
        if(heap.size() == maxHeapSize) {
            System.out.println("Max heap size reached, cannot insert any more");
            return;
        }
        heap.add(value);
        heapify(getParentIndex(heap.size()-1));
    }

    private void heapify(int parentIdx){
        while(isInBounds(parentIdx) && !isLeaf(parentIdx)){
            int leftChildValue = getLeftChild(parentIdx);
            int rightChildValue = getRightChild(parentIdx);
            int parentValue = heap.get(parentIdx);
            if(parentValue <= leftChildValue && parentValue <= rightChildValue){
                break;
            }
            if(leftChildValue <= rightChildValue){
                //swap with the left child
                swap(parentIdx, getLeftChildIdx(parentIdx));
            }else{
                //swap with the right child
                swap(parentIdx, getRightChildIdx(parentIdx));
            }
            parentIdx = getParentIndex(parentIdx);
        }
    }


    private void swap(int firstIdx, int secondIdx){
        int temp = heap.get(firstIdx);
        heap.set(firstIdx, heap.get(secondIdx));
        heap.set(secondIdx, temp);
    }

    private boolean isLeaf(int idx){
        return idx >= heap.size()/2;
    }

    private int getLeftChildIdx(int parentIdx){
        return  2 * parentIdx + 1;
    }

    private int getRightChildIdx(int parentIdx){
        return  2 * parentIdx + 2;
    }

    private int getLeftChild(int parentIdx){
        int leftChildIdx = 2 * parentIdx + 1;
        if(!isInBounds(leftChildIdx)){
            return Integer.MAX_VALUE;
        }
        return heap.get(leftChildIdx);
    }
    private int getRightChild(int parentIdx){
        int rightChildIdx = 2 * parentIdx + 2;
        if(!isInBounds(rightChildIdx)){
            return Integer.MAX_VALUE;
        }
        return heap.get(rightChildIdx);
    }

    private int getParentIndex(int childIdx){
        int parentIdx = (childIdx-1)/2;
        if(!isInBounds(parentIdx)){
            return -1;
        }
        return parentIdx;
    }

    private boolean isInBounds(int idx){
        return idx >=0 && idx < heap.size();
    }

    private void print(){
        for(int i=0; i<heap.size()/2; i++){
            System.out.println("PARENT: " + heap.get(i) + " LEFT CHILD: " + getLeftChild(i) + " RIGHT CHILD: " +  getRightChild(i));
        }
    }


    public static void main(String[] args) {
        // Display message
        System.out.println("The Min Heap is ");

        // Creating object of class in main() method
        Problem2 minHeap = new Problem2(15);

        // Inserting element to minHeap
        // using insert() method

        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        // Print all elements of the heap
        minHeap.print();

        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                + minHeap.getMin());

        System.out.println("Removing the Min val:"
                + minHeap.extractMin());
        minHeap.print();
        System.out.println("The Min val is "
                + minHeap.getMin());
        minHeap.insert(2);
        // Print all elements of the heap
        minHeap.print();

        System.out.println("The Min val is "
                + minHeap.getMin());
        minHeap.insert(-10);

        System.out.println("The Min val is "
                + minHeap.getMin());
    }
}
