/**
 * Problem Statement: Min Heap in Java

A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

 */
// Time Complexity : 
//  getMin() : O(1)
//  insert() : O(logn)
//  extractMin(): O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach:
 * We are using an static size Array to implement the min-heap solution.
 * We always store the min element at the very start of the array to get a time complexity of O(1).
 * The children node in array is stored at (2*parent_idx + 1) and (2*parent_idx + 2) respectively.
 * The parent index for any child is calculated by (child_idx - 1) / 2.
 * For insert operation, we insert at the end of the Heap and adjust the Heap upwards.
 * For Delete Operation, we copy the last element at the top of the heap and adjust the heap downwards.
**/

class MinHeap {
    private int front;
    private int end;
    private int size;
    private int[] minHeap;

    public MinHeap(int size) {
        this.size = size;
        minHeap = new int[size];
        front = -1;
        end = -1;
    }

    private int getMin() {
        // return the root of the heap or the first element in the array
        if (front == -1) {
            return -1;
        }
        return minHeap[front];
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private void percolateDown(int index) {
        // if index does not have children (i.e. it is a leaf node), we return.

        int left_child_idx = 2 * index + 1;
        int right_child_idx = 2 * index + 2;

        if(left_child_idx > end && right_child_idx > end) {
            return;
        } else {
            // children exist
            int min = minHeap[left_child_idx];
            int min_index = left_child_idx;

            if (right_child_idx <= end && minHeap[right_child_idx] < min) {
                min = minHeap[right_child_idx];
                min_index = right_child_idx;
            }

            if(minHeap[min_index] < minHeap[index]) {
                swap(minHeap, min_index, index);

                percolateDown(min_index);
            }
        }
    }

    private int extractMin() {
        if(front == -1) {
            // there is no element in heap
            return -1;
        } 

        if(front == end) {
            // when there is only one element and needs to be popped,
            // set front and end to -1;
            int popped = minHeap[front];
            front = -1;
            end = -1;

            return popped;
        }

        // otherwise there is a element that can be removed.
        // copy the element from the end to the front

        int popped = minHeap[front];
        minHeap[front] = minHeap[end];
        end--;

        percolateDown(front);

        return popped;
    }

    private void percolateUp(int index) {
        // this accepts the index of the number to be adjusted or percolated up in the Heap

        if (index == 0) {
            return;
        }

        // calculate the parent of the index
        int parent_idx = (index - 1) / 2;

        if(minHeap[parent_idx] > minHeap[index]) {
            // swap the elements
            swap(minHeap, parent_idx, index);

            percolateUp(parent_idx);
        }
    }

    private void insert(int key) {
        if (front ==  -1) {
            // there is no element in the heap
            minHeap[++front] = key;
            end++;
        } else {
            // there are elements existing in the heap
            // add the element to the end of the array first
            minHeap[++end] = key;

            percolateUp(end);
        }
    }

    private void printDetails() {
        for(int i=0;i<=end;i++) {
            System.out.print(minHeap[i] + " ");
        }
        System.out.println("Front index: "+ front);
        System.out.println("End index: "+ end);

        System.out.println("");
    }
}