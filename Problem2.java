// Operations on Min Heap:

// getMin(): It returns the root element of Min Heap. O(1)
// extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
// insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
// Example of Min Heap:

//              5                      11
//          /      \               /       \  
//        9        13           13         25 
//       /                      /  \        /  \
//     20                     32    45    95    40

// Time Complexity : getMin() - O(1); extractMin() - O(logn); insert(int node) - O(logn)
// Space Complexity : O(n)  - n is capacity of heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MinHeap{
    int[] minHeap;
    int size = 0;
    int cap = 0;

    public MinHeap(){
        this.size = 0;
        this.cap = 1;
        minHeap = new int[cap+1];
        minHeap[0] = Integer.MIN_VALUE;
    }

    public int getMin(){
        if(minHeap == null) return -1;
        return minHeap[0];
    }

    public int extractMin(){
        int pop = this.minHeap[0];
        swap(this.minHeap[size-1], this.minHeap[0]);
        size--;
        this.bubbleDown(size-1);
        return pop;
    }

    public void insert(int node){
        if(size == cap){
            this.copyHeap();
        }

        this.minHeap[size] = node;
        size++;
        this.bubbleUp(size-1);
    }

    void copyHeap(){
        this.cap *= 2;
        int[] newHeap = new int[cap];

        for(int i = 0; i < size; i++){
            newHeap[i] = minHeap[i];
        }
        this.minHeap = newHeap;
    }

    void swap(int src, int dest){
        int temp = this.minHeap[src];
        this.minHeap[dest] = this.minHeap[src];
        this.minHeap[src] = temp;
    }

    void bubbleUp(int idx){
        if(idx == 0) return;

        int par = (idx-1)/2;
        if(par >= 0 && this.minHeap[idx] < this.minHeap[par]){
            this.swap(this.minHeap[par], this.minHeap[idx]);
            bubbleUp(par);
        }
    }

    void bubbleDown(int idx){
        if(idx == this.size-1) return;

        int left = 2*idx+1;
        int right = 2*idx+2;

        int temp = idx;
        if(left < this.size && this.minHeap[left] < this.minHeap[idx]){
            temp = left;
        }

        if(right < this.size && this.minHeap[right] < this.minHeap[idx]){
            temp = right;
        }

        if(temp == idx) return;

        this.swap(this.minHeap[idx], this.minHeap[temp]);
        bubbleDown(temp);
    }
}