/**
 * A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:
getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
 * 
 */

class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;

    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public int getMin(){
        return this.heap[0];
    }

    public int extractMin(){
        int popped = this.heap[FRONT];
        this.heap[FRONT] = this.heap[this.size--];
        minHeapify(FRONT);
        return popped;
    }

    private void minHeapify(int front2) {
        int left = 2 * front2;
        int right = 2 * front2 + 1;
        int smallest = front2;
        if(left <= this.size && this.heap[left] < this.heap[smallest]){
            smallest = left;
        }
        if(right <= this.size && this.heap[right] < this.heap[smallest]){
            smallest = right;
        }
        if(smallest != front2){
            swap(front2, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int front2, int smallest) {
        int temp = this.heap[front2];
        this.heap[front2] = this.heap[smallest];
        this.heap[smallest] = temp;
    }

    public void insert(int element){
        if(this.size >= this.maxSize){
            return;
        }
        this.heap[++this.size] = element;
        int current = this.size;
        while(this.heap[current] < this.heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private int parent(int current) {
        return 0;
    }
}
