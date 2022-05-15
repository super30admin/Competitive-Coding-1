import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/min-heap-in-java/
 * 
 * A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to the values in the children of that node. 
 * Mapping the elements of a heap into an array is trivial: if a node is stored an index k, 
 * then its left child is stored at index 2k + 1 and its right child at index 2k + 2
 * 
 * Arr[(i -1) / 2] returns its parent node.
 * Arr[(2 * i) + 1] returns its left child node.
 * Arr[(2 * i) + 2] returns its right child node.
 * 
 * time: O (log n)
 * space: O(n) 
 * 
 * Approach:
 * iterative
 * 
 * insert:
 * 1. add element to the end of the array
 * 2. keep bubbling up if its parent is greater
 * 
 * remove:
 * 1. swap the 1st and last element
 * 2. delete the last element from the array
 * 2. keep bubbling down from the 1st element as it will not be in the right position
 * 
 */
class MinHeap{
    public List<Integer> arr;

    MinHeap(){
        arr = new ArrayList<>();
    }

    private void bubbleUp(){
        int i = arr.size()-1;
        int parent = (i-1)/2;

        while(arr.get(parent) > arr.get(i)){
            Collections.swap(arr, i, (i-1)/2);

            if(parent>0){
                i = parent;
                parent = (i-1)/2;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(){
        int i = 0;
        int n = arr.size();
        int leftChild = (2*i)+1;
        int rightChild = (2*i)+2;

        while(leftChild < n || rightChild < n){
            if (leftChild < n && arr.get(i) > arr.get(leftChild)) {
                Collections.swap(arr, i, leftChild);
                i = leftChild;                
            }
            if (rightChild < n && arr.get(i) > arr.get(rightChild)) {
                Collections.swap(arr, i, rightChild);
                i = rightChild;                
            }
            leftChild = (2*i)+1;
            rightChild = (2*i)+2;
        }     
    }

    /**
     * insert new element in the min heap
     * time: O(log n)
     */
    public void insert(int x){
        // append new element
        arr.add(x);
        // bubble up
        bubbleUp();
    }

    /**
     * remove the root - min element from the minheap
     * time: O(log n)
     */
    public void extractMin(){
        // swap 1st and last element
        Collections.swap(arr, 0, arr.size()-1);
        arr.remove(arr.size()-1);
        bubbleDown();
    }

    public int getMin(){
        return arr.get(0);
    }

    public int size(){
        return arr.size();
    }
}

public class Problem2{
    public static void main(String[] args) {
        int[] arr = {15, 28, 16, 32, 31, 20};

        MinHeap mh = new MinHeap();
        
        for (int i : arr) {
            mh.insert(i);
        }

        mh.extractMin();

        for (int i : mh.arr) {
            System.out.print(i + " ");
        }
    }
}
