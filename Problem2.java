// Time Complexity : As below
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No
/*
getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
*/

import java.util.Arrays;

public class Problem2 {
    /*
   A min heap implementation
   Array Form: [ 5, 7, 6, 10, 15, 17, 12 ]
   Complete Binary Tree Form:
                   5
               /         \
           7               6
       /     \          /     \
     10      15        17      12
   Mappings:
     Parent -> (childIndex - 1) / 2
     Left Child -> 2 * parentIndex + 1
     Right Child -> 2 * parentIndex + 2
 */

        private static class minHeap{
            public int capacity = 5;
            public int size = 0;
            public int[] heap;

            public minHeap(){
                heap = new int[capacity];
            }

            public boolean isEmpty(){
                return size==0;
            }

            public int peek(){
                if(isEmpty()){
                    return Integer.MIN_VALUE;
                }

                return heap[0];
            }

            public int remove(){
                if(isEmpty()){
                    return Integer.MIN_VALUE;
                }

                int minVal = heap[0];
                heap[0] = heap[size -1];
                size--;

                heapifyDown();

                return minVal;
            }

            public void add(int item){
                ensureCapacity();

                heap[size] = item;
                size++;

                heapifyUp();
            }

            public void ensureCapacity() {
                if(size == capacity){
                    heap = Arrays.copyOf(heap, capacity*2);
                    capacity *= 2;
                }
            }

            public void heapifyDown(){
                int index = 0;
                while(hasLeftChild(index)){
                    int smallestIntIndex = getLeftChildIndex(index);
                    if(hasRightChild(index) && heap[getRightChildIndex(index)] < heap[getLeftChildIndex(index)]){
                        smallestIntIndex = getRightChildIndex(index);
                    }

                    if(heap[index] < heap[smallestIntIndex]){
                        break;
                    } else {
                        swap(index, smallestIntIndex);
                    }

                    index = smallestIntIndex;
                }
            }

            public void swap(int x, int y) {
                int temp = heap[x];
                heap[x] = heap[y];
                heap[y] = temp;
            }

            public boolean hasRightChild(int index) {
                int rightIndex = getRightChildIndex(index);
                if(rightIndex < size){
                    return true;
                }
                return false;
            }

            public int getRightChildIndex(int index) {
                return index * 2 + 2;
            }

            public int getLeftChildIndex(int index) {
                return index * 2 + 1;
            }

            public boolean hasLeftChild(int index) {
                int leftIndex = getLeftChildIndex(index);
                if(leftIndex < size){
                    return true;
                }
                return false;
            }

            public void heapifyUp(){
                int index = size - 1;
                while(hasParent(index) && heap[index] < heap[getParentIndex(index)]) {
                    swap(index, getParentIndex(index));
                    index = getParentIndex(index);
                }
            }

            public int getParentIndex(int index) {
                return (index - 1)/2;
            }

            public boolean hasParent(int index) {
                int parentIndex = getParentIndex(index);
                if(index!=0 && parentIndex >=0){
                    return true;
                }
                return false;
            }

        }
        public static void main(String args[]){
            minHeap mh = new minHeap();
            mh.add(5);
            mh.add(7);
            mh.add(6);
            mh.add(10);
            mh.add(15);
            mh.add(17);
            mh.add(4);
            mh.add(18);
            mh.add(12);
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());
            System.out.println(" peek "+ mh.peek());
            System.out.println("remove " +mh.remove());


        }
    }
