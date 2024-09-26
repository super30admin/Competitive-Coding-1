
/*
A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

*/

import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> heap;

    public MinHeap() {

        this.heap = new ArrayList<Integer>();
    }

    public void insert(int data) {
        heap.add(data);
        int i = heap.size() - 1;
        int parent = parent(i);
        while (parent != i && heap.get(i) < heap.get(parent)) {
            swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    public int extractMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        } else if (heap.size() == 1) {
            int min = heap.remove(0);
            return min;
        }
        // swap the last elemnt as new root
        int min = heap.get(0);
        int lastdata = heap.remove(heap.size() - 1);
        heap.set(0, lastdata);
        heapify(0);
        return min;
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    private int rightChild(int i) {

        return 2 * i + 2;
    }

    private int leftChild(int i) {

        return 2 * i + 1;
    }

    private void heapify(int i) {

        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = -1;
        if (left <= heap.size() - 1 && heap.get(left) < heap.get(i)) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right <= heap.size() - 1 && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != i) {

            swap(i, smallest);
            heapify(smallest);
        }
    }

    public int getMin() {

        return heap.get(0);
    }

    public boolean isEmpty() {

        return heap.size() == 0;
    }

    private void swap(int i, int parent) {

        int temp = heap.get(parent);
        heap.set(parent, heap.get(i));
        heap.set(i, temp);
    }

    void printHeap(){
    	for (int i = 0; i < heap.size() / 2; i++) { 
        	System.out.print(" PARENT : " + heap.get(i) 
                             + " LEFT CHILD : " + heap.get(2 * i) 
                             + " RIGHT CHILD :" + heap.get(2 * i + 1)); 
         	System.out.println(); 
       	} 
    }
}