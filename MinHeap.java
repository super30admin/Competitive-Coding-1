/*
 *  Time Complexity: O(log n) for Insert, Remove element in heap. O(1) to fetch the min element in the heap. 
 *  Space Complexity: O(N) to store all the elements in the array.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  We first create an array with the requreid length. We compute the left child by calculating 2*i+1 and the right by calculation with 2*i+2 and we compute the parent element with (i-1)/2. 
 *  Now if we are inserting we simply insert the element at the last position in the array. Check if the new element is greater than its parent element if now swap the elements continue till the heap property satisfies.
 *  Now if we are removing we swap the first and the last element. The last element we replace with Integer.MAX_VALUE. Then we simply check the heap property for the first element with the child elements. 
 *  If the parent is greater than either the left or the right elements we swap with the least child elements. Repeat this till the heap property satisfies. 
 */

package CompetitiveProgramming;

public class MinHeapSolution {
    public static void main(String args[]){
        MinHeap heap = new MinHeap(6);
        heap.insert(13);
        heap.insert(6);
        System.out.println(heap.getMin());
        heap.insert(12);
        heap.insert(10);
        heap.insert(5);
        System.out.println(heap.getMin());
        heap.insert(3);
        System.out.println(heap.extractMin());
        System.out.println(heap.getMin());
    }
}

class MinHeap{
    int maxSize, currSize;
    int[] heap;

    public MinHeap(int maxSize){
        this.currSize=-1;
        this.maxSize=maxSize;
        this.heap = new int[this.maxSize];
    }

    private int leftIdx(int idx){
        return idx*2+1;
    }
    private int rightIdx(int idx){
        return idx*2+2;
    }
    private int parentIdx(int idx){
        return (idx-1)/2;
    }
    private void swap(int firstidx, int secondIdx){
        int temp=heap[firstidx];
        heap[firstidx] = heap[secondIdx];
        heap[secondIdx] = temp;
    }
    public void minHeapify(int pos){
        int currIdx = pos;
        int rightIndex = rightIdx(currIdx);
        int leftIndex = leftIdx(currIdx);
        while((leftIndex<maxSize && heap[currIdx]>heap[leftIndex]) || (rightIndex<maxSize && heap[currIdx]>heap[rightIndex])){
            if(rightIndex>=maxSize || heap[rightIndex]>heap[leftIndex]){
                swap(currIdx,leftIndex);
                currIdx=leftIndex;
            }else{
                swap(currIdx,rightIndex);
                currIdx=rightIndex;
            }
            rightIndex = rightIdx(currIdx);
            leftIndex = leftIdx(currIdx);
        }
    }
    public void insert(int value){
        if(currSize>=maxSize-1) return;
        heap[++currSize]=value;
        int currIndex=currSize;
        while(heap[currIndex]<heap[parentIdx(currIndex)]){
            swap(parentIdx(currIndex),currIndex);
            currIndex=parentIdx(currIndex);
        }
    }
    public int getMin(){
        if(maxSize==0 || currSize==-1) return Integer.MAX_VALUE;
        return heap[0];
    }
    public int extractMin(){
        if(maxSize==0 || currSize==-1) return Integer.MAX_VALUE;
        int minValue=heap[0];
        swap(0,currSize);
        heap[currSize]=Integer.MAX_VALUE;
        currSize--;
        minHeapify(0);
        return minValue;
    }
}





