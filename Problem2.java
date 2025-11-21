// Time Complexity :insert - O(n), heapify-O(n), removemin-O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//for remove min..i removed the first val, and then replaced the last with first and then heapify
//for insert..i inserted first then do at last and then check with parent and iterate
// for heapify..select an index and check with right and left child, then swap

class MyMinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MyMinHeap(int capacity) {
        this.size = 0;
        this.maxSize = capacity;
        this.heap = new int[capacity];
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public int leftChild(int i){
        return 2*i+1;
    }

    public int rightChild(int i){
        return 2*i+2;
    }

    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public boolean isLeaf(int i){
        return i >= size/2 && i < size;
    }

    public void insert(int val){
        if (size >= maxSize){
            return;
        }
        heap[size] = val;
        int curr = size;
        size += 1;
        while (curr > 0){
            if (heap[curr] < heap[parent(curr)]){
                swap(curr,parent(curr));
                curr = parent(curr);
            }
        }
    }

    public void heapify(int i){
        if (size >= maxSize){
            return;
        }
        if (isLeaf(i)){
            return;
        }
        int smallest = i;
        if (rightChild(i) < size && heap[smallest]> heap[rightChild(i)]){
            smallest = rightChild(i);
        }
        if (leftChild(i) < size && heap[smallest]> heap[leftChild(i)]){
            smallest = leftChild(i);
        }
        if (smallest != i){
            swap(smallest,i);
            heapify(smallest);
        }

    }

    public int removeMin(){
        if (size ==0){
            return -1;
        }
        int min_val = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return min_val;
    }



    
}
