// Time Complexity : O(logn) for insert and extractMin and O(1) for getMin
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : not found in leetcode
// Any problem you faced while coding this : no

import java.io.*;

class MinHeap {
    int[] heap;
    int len;
    
    public MinHeap() {
        heap = new int[100];
        heap[0] = Integer.MIN_VALUE;
        len = -1;
    }
    
    public void bubbleUp(int index) {
        if(index == 0) {
            return;
        }
        
        int parent = (index - 1) / 2;
        if(heap[index] < heap[parent]) {
            swap(index, parent);
            bubbleUp(parent);
        } else {
            return;
        }
    }
    
    public void bubbleDown(int index) {
        int leftChild = (2 * index + 1) / 2;  
        int rightChild = (2 * index + 2) / 2;    
        int temp = index;
        
        if(leftChild < len && heap[leftChild] < heap[temp]) {
            temp = leftChild;
        }
        if(rightChild < len && heap[rightChild] < heap[temp]) {
            temp = rightChild;
        }
        
        if(temp == index) {
            return;
        }
        bubbleDown(temp);

    }
    
    public int getMin() {
        return heap[0];
    }
    
    public void insert(int num) {
        
        if(len == -1) {
            len++;
            heap[len] = num;
            return;
        }
        len++;
        heap[len] = num;
        bubbleUp(len);
    }
    
    public void extractMin() {
        swap(0, len);
        len--;
        bubbleDown(0);
    }
    
    public void printMinHeap() {
        for(int i = 0; i <= len; i++) {
            System.out.print(heap[i] +", ");
        }
        System.out.println();
    }
    
    public void swap(int start, int end) {
        int temp = heap[start];
        heap[start] = heap[end];
        heap[end] = temp;
    }
    
	public static void main (String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(20);
		minHeap.insert(30);
		minHeap.printMinHeap();
		System.out.println("Minimum: " + minHeap.getMin());
		minHeap.extractMin();
		minHeap.insert(28);
		minHeap.printMinHeap();
		System.out.println("Minimum: " + minHeap.getMin());
		minHeap.extractMin();
		minHeap.insert(35);
		minHeap.insert(60);
		minHeap.printMinHeap();
		System.out.println("Minimum: " + minHeap.getMin());
		minHeap.extractMin();
		minHeap.printMinHeap();
		System.out.println("Minimum: " + minHeap.getMin());
		minHeap.printMinHeap();
	}
}