// Time Complexity : getMin() -> O(1), extractMin() -> O(logn), insert() -> O(logn)
// Space Complexity : O(n) - space for heap array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Min heap design
//S30 FAANMG Problem #16 {Medium }


public class Heap {

    private int[] heap;
    private int capacity;
    private int size = 0;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2*parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2*parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1)/2;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapifyUp() {

        //poison
        int index = size-1;

        //parent exists and parent is greater than child
        while(getParentIndex(index)>=0 && (heap[getParentIndex(index)] > heap[index])) {
            //swap with parent
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        //poison
        int index = 0;

        //left child exists
        while(getLeftChildIndex(index) < size) {
            int minChildIndex = getLeftChildIndex(index);
            //calculate smallest child if right child also exists
            if(getRightChildIndex(index) < size && heap[getRightChildIndex(index)] < heap[getLeftChildIndex(index)]) {
                minChildIndex = getRightChildIndex(index);
            }

            //swap parent with min child
            if(heap[index] > heap[minChildIndex]) {
                swap(index, minChildIndex);
            } else {
                break;
            }

            index = minChildIndex;
        }
    }

    public void ensureCapacity() {
        if(size == capacity) {
            heap = Arrays.copyOf(heap, 2*capacity);
            capacity = 2*capacity;
        }
    }

    public int getMin() throws Exception{
        if(size > 0)
            return heap[0];
        else
            throw new Exception();
    }

    public int extractMin() throws Exception{
        if(size == 0)
            throw new Exception();

        int minElement = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown();
        return minElement;
    }

    public void insert(int element) {
        ensureCapacity();
        heap[size] = element;
        size++;
        heapifyUp();
    }


    public static void main(String[] args) {
        //System.out.println("Hello World!");
    }
}
