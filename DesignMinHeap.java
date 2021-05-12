/*

Question: A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.

Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): 
extractMin(): 
insert(): 

*/

import java.util.*;
public class DesignMinHeap {
    //Default it's a min heap
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
    public static void main(String[] args) {
        insert(5);
        insert(10);
        insert(1);
        insert(15);
        insert(20);
        
        System.out.println("Extract Min : " + extractMin());
        System.out.println("Get Min : " + getMin());
    }
    
    // We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
    public static void insert(int num){
        pq.add(num);
    }
    
    // Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
    public static int extractMin(){
        return pq.poll();
    }
    
    //It returns the root element of Min Heap. O(1)
    public static int getMin(){
        return pq.peek();
    }
}