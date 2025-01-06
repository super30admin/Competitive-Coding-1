
// Problem 2: Design Min Heap
public class Problem2 {

    int heap[];
    int size;
    public Problem2 (int maxSize){
        heap = new int[maxSize];
        size = 0;
    }

    //time complexity: O(logn)
    public void add (int i){
        if (size == heap.length){
            throw new IllegalStateException("Heap is full");
        }

        heap[++size] = i;
        heapify();

    }
    //time complexity: O(logn)
    public void remove (){
        heap[1] = heap[size --];
        heapify();
    }
    //time complexity: O(1)
    public int getMin(){
        if (size == 0){
            throw new IllegalStateException("Heap is empty");
        }
        return heap[1];
    }

    //time complexity: O(1)
    public int getParent (int i){
        return heap[i/2];
    }
    //time complexity: O(1)
    public int getLeftChild (int i){
        return heap[2*i];
    }

    public int getRightChild(int i){
        return heap[2*i+1];

    }
    public void swap (int leftPos, int rightPos){
        int temp = heap[leftPos];
        heap[leftPos] =  heap[rightPos];
        heap[rightPos] = temp;
    }
    public void heapify (){
       int pos = size;
       while (pos >1){
        if (heap[pos] < getParent(pos) ){
            swap(pos, pos/2);
        }
       pos--;
       } 
    }
    public static void main(String[] args) {
        Problem2 minHeap = new Problem2(10);
        minHeap.add(15);
        // minHeap.add(10);
        // minHeap.add(20);
        System.out.println(minHeap.getMin());
    }
}
