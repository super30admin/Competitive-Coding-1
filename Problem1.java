//Problem : Design Min Heap
//Time Complexity : O(log n) for insert and delete operations
//Space Complexity : O(n) for the heap
//Did this code successfully run on Leetcode : Yes 
//Any problem you faced while coding this : No
class MinHeap{
    int capacity;
    int size;
    int index;
    int heap[];
    MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.index = 1;
        heap = new int[capacity];
    }
    public void insert(int val){
        if(size == capacity){
            System.out.println("Heap is full");
            return;
        }
        heap[size+1] = val;
        size++;
        heapify(size);
    }
    public int remove(){
        int top = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;
        int i = 1;
        while(i<=size){
            int left = getLeftChild(i);
            int right = getRightChild(i);
            if(left<=size && heap[i]>heap[left]){
                int temp = heap[i];
                heap[i] = heap[left];
                heap[left] = temp;
                i = left;
            }
            else if(right<=size && heap[i]>heap[right]){
                int temp = heap[i];
                heap[i] = heap[right];
                heap[right] = temp;
                i = right;
            }
            else{
                break;
            }
        }
        return top;
    }
    public int peek(){
        if(size==0){
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[1];
    }
    public int getParent(int index){
        return index/2;
    }
    public int getLeftChild(int index){
        return 2*index;
    }   
    public int getRightChild(int index){
        return 2*index + 1;
    }
    public void heapify(int index){
        while(index>0){
            int parent = getParent(index);
            if(parent>0 && heap[parent]>heap[index]){
                int temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            }
            else{
                break;
            }
        }
    }
    public void print(){
        for(int i=1;i<=size;i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
class Problem1{
    public static void main(String args[]){
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        int rem = minHeap.remove();
        System.out.println("Removed element: " + rem);
        minHeap.print();
        System.out.println("Min element: " + minHeap.peek()); // Output: 3
    }
}
