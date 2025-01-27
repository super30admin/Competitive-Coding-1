import java.util.Arrays;

/**
 *   if a node is at ith index then  in an array starting at index 0
 *     left-child is at (2*i)+1
 *     right-child is at (2*i)+2
 *     Parent would be at |(i-1)/2|
 *   if a node is at ith index then  in an array starting at index 0
 *      left-child is at (2*i)
 *      right-child is at (2*i)+1
 *      Parent would be at |i/2|
 * Max-Heap Min-Heap
 */
public class MyMinHeap {
    private int[] heap;
    private int size;

    public MyMinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }
    public int getMin(){
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    //remove min
    public int extractMin(){
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        extractHeapify(0);
        return min;
    }

    private void extractHeapify(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            extractHeapify(smallestIndex);
        }
    }

    public void insert(int val){
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = val;
        insertHeapify(size);
        size++;
    }

    public int size() {
        return size;
    }

    private void insertHeapify(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public void swap(int i, int j){
        int temp = heap[i];
         heap[i] = heap[j];
         heap[j] = temp;
    }


    public static void main(String[] args){
        MyMinHeap minHeap=new MyMinHeap(3);
        System.out.println(minHeap.size());
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(1);
        System.out.println(minHeap.size());
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.getMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.size());
        System.out.println(minHeap.getMin());
        minHeap.insert(-6);
        System.out.println(minHeap.getMin());
    }

}
