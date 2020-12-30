//Min Heap Implementation`

// Time Complexity : O(Log(N)), where n is nums.length
// Space Complexity : O(log(N)) as well?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Learning definitions of binary tree, complete binary tree, min heap, etc. 


public class MinHeap {
    
    private int maxSize;
    private int[] heap;
    private static final int front = 1;
    private int size;

    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0; 
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos){
        return heap[pos/2]; 
    }

    private int leftChild(int pos){
        return heap[pos*2]; 
    }

    private int rightChild(int pos){
        return heap[(pos*2)+1];
    }

    private boolean isLeaf(int pos){
        if(pos >= (size/2) && pos <= size){
            return true;
        }else{
            return false;
        }
    }

    private void swap(int fpos, int spos){
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }


    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            if( heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else{
                    swap(pos,rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element){
        if(size >= maxSize){
            return;
        }
        heap[++size] = element;
        int current = size;
        while(heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print(){
        for(int i = 1; i <= size/2; i++){
            System.out.println(" Parent : " + heap[i] + " left child : " + heap[2*i)] + " right child: " + heap[(2*i)+1]);
        }
    }

    public void minHeap(){
        //Function to call minHeapify()
        //All leaf nodes are located at floor(size/2) + 1; 
        //Position starts at 1, not 0. Thus, we can take out +1. 
        for(int pos = (size/2); pos >= 1; pos--){
            minHeapify(pos);
        }
    }

    public int remove(){
        int popped = heap[front];
        heap[front] = heap[size--];
        minHeapify(front);
        return popped;
    }

    // Driver code 
    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap(); 
    
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.remove()); 
    } 


}