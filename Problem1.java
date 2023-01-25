//minHeap

// Time Complexity: O(1)// get min and O(logn) for insertion
// Space Complexity: O(1)

public class Heap {
    int[] heap;
    int size;
    int maxSize;
    
    static final int FRONT = 1;
    
    public Heap(int maxSize){
        size = 0;
        this.maxSize = maxSize;
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MIN_VALUE;
    }
    
    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2)) {
            return true;
        }
        return false;
    }
    
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }
    
    private void minHeapify(int pos)
   {     
     if(!isLeaf(pos)){
       int swapPos= pos;
       if(rightChild(pos)<=size)
          swapPos = heap[leftChild(pos)]<heap[rightChild(pos)]?leftChild(pos):rightChild(pos);
       else
         swapPos= heap[leftChild(pos)];
        
       if(heap[pos]>heap[leftChild(pos)] || heap[pos]> heap[rightChild(pos)]){
         swap(pos,swapPos);
         minHeapify(swapPos);
       }
     }      
   }
    
    public void insert(int element)
    {
 
        if (size >= maxSize) {
            return;
        }
 
        heap[++size] = element;
        int current = size;
 
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    
    public int remove()
    {
 
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
 
        return popped;
    }
}
