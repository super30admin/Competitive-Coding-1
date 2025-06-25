// Time Complexity: O(1) to get min, O(log n) to extract min or to insert
// Space Complexity: O(n)

  
public class MinHeap {
    
    public int size;
    
    public MinHeap() {
        this.size = 0;
    }

    public int getLeftChild(int pos) {
        return 2*pos + 1;
    }
    
    public int getRightChild(int pos) {
        return 2*pos + 2;
    }
    
    public int getParent(int pos) {
        return (pos-1)/2;
    }
    
    public void bubbleUp(int[] heap, int index) {
        int parent = getParent(index);
        if (index > 0 && parent >=0 && heap[index] < heap[parent]) {
            swap(heap, index, parent);
            bubbleUp(heap, parent);
        }
    }
    
    public void bubbleDown(int[] heap, int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        if (leftChild < this.size && heap[leftChild] < heap[index]) {
            swap(heap, leftChild, index);
            bubbleDown(heap, index);
        }
        if (rightChild < this.size && heap[rightChild] < heap[index]) {
            swap(heap, rightChild, index);
            bubbleDown(heap, index);
        }
    }
    
    // Function to insert a new element into the min-heap
    public void insert(int[] heap, int value) {
        if (this.size >= heap.length) return;
        heap[this.size] = value;
        bubbleUp(heap, this.size);
        size ++;
    }
    
    public int removeMin(int[] heap) {
        int temp = heap[0];
        heap[0] = heap[this.size-1];
        this.size--;
        this.bubbleDown(heap, 0);
        return temp;
    }
    
    public int getMin(int[] heap) {
        return heap[0];
    }

    // Function to swap two elements in an array
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test the insertMinHeap function
    public static void main(String[] args)
    {
        int[] heap = new int[6];
        int[] values = { 10, 7, 11, 5, 4, 13 };
        int size = 0;
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < values.length; i++) {
            minHeap.insert(heap, values[i]);
            size++;
            System.out.print("Inserted " + values[i]
                             + " into the min-heap: ");
            for (int j = 0; j < size; j++) {
                System.out.print(heap[j] + " ");
            }
            System.out.println();
        }
    }
}
