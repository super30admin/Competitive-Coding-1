// Time complexity : Insert (O(log n)), Peek (O(1)), ExtractMin (O(log n))
// Space complexity : O(1)
public class MinHeap {
    private static Integer MAX_SIZE = 1000;
    private final Integer[] heap = new Integer[MAX_SIZE];
    private Integer size = 0;

    MinHeap() {}

    // Add the element to the end and bubble it up to the correct position
    public void insert(Integer element) {
        if (size.equals(MAX_SIZE)) return;

        heap[size] = element;
        heapifyUp(size-1);
        size++;
    }

    private void heapifyUp(int index) {
        while(index > 0){
            Integer parentIndex = getParentIndex(index);
            if (parentIndex == null) break;

            if(heap[parentIndex] > heap[index]){
                swap(parentIndex, index);
                index = parentIndex;
            }else{
                break;
            }
        }
    }

    // Remove the element to the first and copy the last element to the root.
    // Shift down the root value by comparing with its child.
    public Integer extractMin() {
        if (size == 0) return null;
        
        int minValue = heap[0];
        // Check if heap has elements
        if(size > 0) {
            heap[0] = heap[size - 1];
            heapifyDown(0);
        }
        size--;
        return minValue;
    }

    private void heapifyDown(int index) {
        int smallest = index;
        while (true) {
            Integer leftChildIndex = getLeftChild(index);
            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
                smallest = leftChildIndex;
            }

            Integer rightChildIndex = getRightChild(index);
            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
                smallest = rightChildIndex;
            }
            // If there is no child with lower value, stop
            if (smallest == index) {
                break;
            }

            // Otherwise, swap and update 'index' to continue the loop from the new position
            swap(index, smallest);
            index = smallest;
        }
    }

    public Integer getMin() {
        if (size == 0) return null;
        return heap[0];
    }

    private Integer getParentIndex(Integer childIndex) {
        // No parent for the root 
        if (childIndex == 0) return null;

        return (childIndex % 2 == 0) ? (childIndex - 1) / 2 : childIndex / 2;
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private Integer getLeftChild(Integer parentIndex) {
        return 2 * parentIndex + 1;
    }

    private Integer getRightChild(Integer parentIndex) {
        return 2 * parentIndex + 1;
    }
}