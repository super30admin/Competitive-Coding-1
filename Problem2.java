//Implement Min-Heap
// Time Complexity : getMin - O(1), insert - O(n), extractMin - O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create array to store the values in heap
// It would be tree like structure but in array so, the nodes can be determined by using indexes
// If we are inseting, insert at the end and heapify up
// If we are deleting delete from the start and replace with last element then heapify down. 
public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;
    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        heap = new int[maxSize];
        size = -1;
    }
    public int getMin() {
        return heap[0];
    }
    public int extractMin() {
        if (size == -1) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        int min = heap[0];
        heap[0] = heap[size--];
        heapifyDown(0);
        return min;
    }
    public void insert(int x) {
        if (size == maxSize) {
            System.out.println("Overflow");
            return;
        }
        heap[++size] = x;
        heapifyUp();
    }
    public int parent(int pos) {
        return pos / 2;
    }
    public int leftChild(int pos) {
        return pos * 2;
    }
    public int rightChild(int pos) {
        return pos * 2 + 1;
    }
    public void heapifyUp() {
        int pos = size;
        int val = heap[pos];
        int parentpos = parent(pos);
        while (pos != 0 && (val < heap[parentpos])) {
            swap(pos, parentpos);
            pos = parentpos;
            parentpos = parent(pos);
        }
    }
    public void heapifyDown(int pos) {
        int leftpos = leftChild(pos);
        int rightpos = rightChild(pos);
        int minIndex = pos;
        if (leftpos <= size && heap[leftpos] < heap[minIndex]) {
            minIndex = leftpos;
        }
        if (rightpos <= size && heap[rightpos] < heap[minIndex]) {
            minIndex = rightpos;
        }
        if (pos != minIndex) {
            swap(minIndex, pos);
            heapifyDown(minIndex);
        }
    }
    public void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }
    public void print() {
        for (int i = 0; i <= size; i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args){
        MinHeap mh = new MinHeap(20);
        mh.insert(5);
        mh.insert(3);
        mh.insert(17);
        mh.insert(10);
        mh.insert(84);
        mh.insert(19);
        mh.insert(6);
        mh.insert(22);
        mh.insert(9);
        mh.print();
        System.out.println(mh.extractMin());
        mh.print();
        System.out.println(mh.extractMin());
        mh.print();
        System.out.println(mh.extractMin());
        mh.print();
        System.out.println(mh.extractMin());
        mh.print();
        System.out.println(mh.extractMin());
        mh.print();
        System.out.println(mh.extractMin());
        mh.print();
        mh.insert(5);
        mh.print();
        mh.insert(50);
        mh.print();
        System.out.println(mh.getMin());
    }
}
