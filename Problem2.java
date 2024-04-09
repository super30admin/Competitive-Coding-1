
    
// Design Min Heap

/* 
Heap is complete binary tree with heap property.
DS used is an array.
If k is a parent - left node is 2k and right node is 2k+1


Functions we want:  parent, leftchild, rightchild, isLeaf, size, heapify, insert, get, remove
*/ 

public class Problem2{
    int[] heap;
    int capacity;
    int size;

    Problem2(){
        this.size = 0;
        this.capacity = 10;
        this.heap = new int[capacity];
    }

    private int parent(int index){
        return index/2;
    }
    private int leftChild(int index){
        return (2*index);
    }
    private int righChild(int index){
        return (2*index+1);
    }

    private boolean isLeaf(int index){
        // All leaf nodes are the ones wih indexes > no.of.current.nodes/2;
        return index>(size/2) && index<=size;
    }

    private void swap(int p1, int p2){
        int temp = heap[p1];
        heap[p1]=heap[p2];
        heap[p2]=temp;
    }
    public int get (){
        return heap[1];
    }
    public void insert(int value){
        if(size>=capacity) return;
        // first add element at the end to maintain complete binary tree
        heap[++size]=value;
        int current = size;
        
        while(heap[parent(current)]>heap[current]){
            swap(parent(current), current);
            current = parent(current);
        }
        
    }
    public int remove(){
        int removed = heap[1];
        heap[1]=heap[size--];
        minHeapify(1);
        return removed;

    }
    public void minHeapify(int pos){
        if(!isLeaf(pos)){
            int left = leftChild(pos);
            int right = righChild(pos);
            int smallest = pos;
            if(left<size && heap[left]<heap[smallest]){
                smallest = left;
            }
            if(right<size && heap[right]<heap[smallest]){
                smallest = right;
            }
            
            if(smallest !=pos){
                swap(smallest,pos);
                minHeapify(smallest);
        
            }
        }
        
    }
}