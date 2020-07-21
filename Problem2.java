
//Insertion Time Complexity : O(log N)
//Deletion Time Complexity : O(log N)
//GetMin Time Complexity : O(1)

/**
 *
 * @author sarthakgoel
 */
public class MinHeap {

    private int capacity = 10;
    private int size = 0;
    private int[] heap;

    public MinHeap() {
        this.heap = new int[capacity];
    }

    public int minElement() {
        if (isEmpty()) {
            return -1;
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int item) {
        heap[size++] = item;
        heapifyUp();
    }

    public int remove() {
        if (!isEmpty()) {
            int deletedItem = heap[0];
            heap[0] = heap[size - 1];
            heapifyDown();
            return deletedItem;
        }
        return -1;
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap[index] < parent(index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < heap[smallIndex]) {
                smallIndex = rightChildIndex(index);
            }

            if (heap[index] < heap[smallIndex]) {
                break;
            } else {
                swap(index, smallIndex);
            }
            index = smallIndex;
        }
    }

    private void swap(int index, int smallIndex) {
        int temp = heap[index];
        heap[index] = heap[smallIndex];
        heap[smallIndex] = temp;
    }

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return parentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int parent(int index) {
        return heap[parentIndex(index)];
    }

    public static void main(String[] args) {
        MinHeap min = new MinHeap();
        min.add(10);
        min.add(9);
        min.add(8);
        min.add(12);

        System.out.println(min.minElement());
        
        min.remove();
        System.out.println(min.minElement());
    }
}