// Time Complexity : 
        //insert : O(log N) as we need to heapifyUp 
        //extractMin : O(log N) as we need to heapifyDown
        //getMin : O(1)
// Space Complexity : O(1) as we are not using any auxillary space.
// Did this code successfully run on Leetcode : wrote my own testcases
// Any problem you faced while coding this : not really.

import java.util.*;

public class MinHeap {
    //Will store elements in a list
    //parent and child nodes accessible by 2*k +1 and 2*k +2 formulas
    List<Integer> heapList;

    public MinHeap() {
        heapList = new ArrayList<>();
    }

    public void insert(int k) {
        //add the number and then call heapify up as the element will be added at the end of the heap
        heapList.add(k);
        heapifyUp();

        return;
    }

    private void heapifyUp() {
        if(heapList.size() == 1) {
            return;
        }

        int i = heapList.size() - 1;
        int parentIndex = getParentIndex(i);
        while(parentIndex > -1 && heapList.get(parentIndex) > heapList.get(i)) {
            int temp = heapList.get(i);
            heapList.set(i, heapList.get(parentIndex));
            heapList.set(parentIndex, temp);

            i = parentIndex;
            parentIndex = getParentIndex(i);
        }
    }

    private int getParentIndex(int i) {
        //parent index depends whether child is right child or left child
        //modulus 2 tells us that
        if(i % 2 == 0) {
            return (i - 2)/2;
        } else {
            return (i - 1)/2;
        }
    }

    public int extractMin() {
        if(getMin() == -1) {
            return -1;
        } 
        if(heapList.size() == 1) {
            return heapList.remove(0);
        }

        //replace root of the mean heap with last element
        //return what was at root
        int min = heapList.get(0);
        heapList.set(0, heapList.remove(heapList.size() - 1));

        //and then heapify down
        heapifyDown();

        return min;
    }

    private void heapifyDown() {
        if(heapList.size() == 1) {
            return;
        }

        int i = 0;
        int minChildIndex = getMinChild(0);

        while(minChildIndex != -1 && minChildIndex != i) {
            int minChildVal = heapList.get(minChildIndex);
            heapList.set(minChildIndex, heapList.get(i));
            heapList.set(i, minChildVal);

            i = minChildIndex;

            minChildIndex = getMinChild(i);
        }

        return;
    }

    private int getMinChild(int index) {
        int l = 2*index + 1;
        int r = 2*index + 2;

        if(l < heapList.size() && heapList.get(l) < heapList.get(index)) {
            index = l;
        }

        if(r < heapList.size() && heapList.get(r) < heapList.get(index)) {
            index = r;
        }

        return index;
    }

    public int getMin() {
        if(isEmpty()) {
            return -1;
        } else {
            return heapList.get(0);
        }
    }

    private boolean isEmpty() {
        return heapList.size() == 0;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.printHeap();

        heap.insert(4);
        heap.printHeap();

        heap.insert(15);
        heap.printHeap();

        int min = heap.extractMin();
        System.out.println(min);
        heap.printHeap();

        min = heap.getMin();
        System.out.println(min);

        heap.insert(20);
        heap.printHeap();

        heap.insert(0);
        heap.printHeap();

        heap.insert(30);
        heap.printHeap();

        min = heap.extractMin();
        System.out.println(min);
        heap.printHeap();

        min = heap.extractMin();
        System.out.println(min);
        heap.printHeap();

        heap.insert(2);
        heap.printHeap();

        heap.insert(4);
        heap.printHeap();
    }

    private void printHeap() {
        System.out.println(heapList);
    }
}