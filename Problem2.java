// Time Complexity : getMin() O(1)
//      extractMin O(log n)
//      insert O(log n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinHeap{
    private int heap[];
    private int size;
    private int maxSize;
    
    public MinHeap(int maxSize){
        this.size=0;
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
    }
    
    public int getMin(){
        return heap[0];
    }
    
    public int extractMin(){
        if(maxSize <=0){
            return Integer.MAX_VALUE;
        }
        if(size==1){
            size++;
            return heap[0];
        }
        
        int root = heap[0];
        heap[0] = heap[size-1];
        size--;
        minHeapify(0);
        return root;
    }
    
    public void insert(int val){
        if(size > maxSize){
            return;
        }
        heap[size] = val;
        size++;
        int current = size-1;
        while(current != 0 && heap[current] < heap[getParent(current)]){
            swap(current, getParent(current)); 
            current = getParent(current);
        }
    }
    
    private int getParent(int pos){ 
        return (pos - 1 )/ 2; 
    } 
    
    private int left(int i) { 
        return (2*i + 1); 
    } 
    
    private int right(int i) { 
        return (2*i + 2); 
    } 
    
    private void swap(int x, int y) { 
        int temp = heap[x]; 
        heap[x] = heap[y]; 
        heap[y] = temp; 
    } 
    
    private void minHeapify(int i) { 
        int l = left(i); 
        int r = right(i); 
        int smallest = i; 
        if (l < size && heap[l] < heap[i]) 
            smallest = l; 
        if (r < size && heap[r] < heap[smallest]) 
            smallest = r; 
        if (smallest != i) { 
            swap(heap[i], heap[smallest]); 
            minHeapify(smallest); 
        } 
    } 
}

