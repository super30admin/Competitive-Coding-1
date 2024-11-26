/* Design Min Heap */

// Time Complexity : 0(logN) (binary search)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//approach-Heap is a data structure and Priority queue is Abstract DT.
//Heap is a complete binary tree with root as minimum and it always maintain min at top
//Purpose of heap is finding element (top priority) in O(1)
//3 Operations: getMin(), insert(), remove()
//for remove, always call heapify() to maintain heap function

public class MinHeap {
    //data members
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    //initialise constructor
    public MinHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        //initialise heap
        Heap = new int[this.maxsize];
        Heap[0] = Integer.MIN_VALUE;
    }

    //parent- (i/2)
    private int parent(int pos){
        return pos/2;
    }

    //leftChild-(2*i)
    private int leftChild(int pos){
        return (2*pos);
    }

    //rightChild-(2*i+1)
    private int rightChild(int pos){
        return (2*pos)+1;
    }

    //isLeaf
    private boolean isLeaf(int pos){
        if(pos >= (size/2) && pos <= size){
            return true;
        }
        return false;
    }

    //swap function
    private void swap(int fpos, int spos){
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    //minHeapify: function to heapify node at pos-maintaining minheap property-keeping min value at top node
    private void minHeapify(int pos){
        //check if node is non-leaf node
        if(!isLeaf(pos)){
            //check if value at pos is greater than its leftchild
            if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]){
                //now check if value of leftchild is lesser or greater than right child
                if(Heap[leftChild(pos)] < Heap[rightChild(pos)]){
                    //swap value at pos with value of leftchild
                    swap(pos, leftChild(pos));
                    //again call minheapify func to maintain heapify (min heap) property
                    minHeapify(leftChild(pos));
                }
                //swapping right child value with pos
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    //1. function to insert node
    public void insert(int element){
        //check if size doesn't exceed maxsize
        if(size >= maxsize){
            return;
        }
        //assign element int heap array
        Heap[++size] = element;
        int current = size;
        //swap elements based on minheap property
        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //2. function to remove and return minimum element from heap
    public int remove(){
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
    
    //3. print
    public void print(){
        for(int i = 0; i < size/2; i++){
            System.out.print(" PARENT : " + Heap[i] 
                             + " LEFT CHILD : " + Heap[2 * i] 
                             + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        }
    }

    //function to build minHeap
    public void minHeap(){
        for(int pos = (size/2); pos >= 1; pos--){
            minHeapify(pos);
        }
    }
    
    public static void main(String[] arg){
        System.out.println("Min Heap");
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

        System.out.println("Min value is "+minHeap.remove());

    }
}

