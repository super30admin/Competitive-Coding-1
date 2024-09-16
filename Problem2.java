import java.util.Arrays;

// Time Complexity :O(logn) for percolate up and percolate down . O(1) for getMin
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Problem not available on leetcode
// Any problem you faced while coding this : No

// Min heap- Problem 15

class MinHeap {
    private int[] pq;
    private int size;

    MinHeap(int Capacity) {
        pq = new int[Capacity];
        Arrays.fill(pq, Integer.MAX_VALUE);
        size = 0;
    }

    public int getMin() {
        return isEmpty() ? -1 : pq[0];
    }

    private boolean isEmpty() {
            return size == 0;
    }

    public int extractMin() {
        if (isEmpty())
            return -1; 
        int min = pq[0];
        pq[0] = pq[--size];
        pq[size] = -1;
        percolateDown(0);
        return min;
    }

    public void insert(int x) {
        pq[size] = x;
        percolateUp(size++);
    }

    /**
     * compute index of parent of element at index i
     * 
     * @param i - index of element i
     * @return - index of parent element
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * compute index of left child of element at index i
     * 
     * @param i - index of element i
     * @return - index of left child element
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * compute index of right child of element at index i
     * 
     * @param i - index of element i
     * @return - index of right child element
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }
    /**
     * percolate up till the violation is avoided with parent
     * @param index - current position of element of type T
     */
    private void percolateUp(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = parent(index);
        if (pq[index]< pq[parentIndex]) { // if value at current index < parent, swap
            swap(index, parentIndex);
            percolateUp(parentIndex);
        }

    }

    /**
     * percolate up till the violation is avoided with children
     * @param index - current position of element of type T
     */
    private void percolateDown(int index) {

        int leftChildIndex = leftChild(index) > size - 1 ? -1 : leftChild(index);
        int rightChildIndex = rightChild(index) > size - 1 ? -1 : rightChild(index);

        if (leftChildIndex == -1 && rightChildIndex == -1) {
            return; // reach leaf
        }

        if (leftChildIndex != -1 && rightChildIndex != -1) {// has both children
            int minIndex = Math.min(index,Math.min(rightChildIndex, leftChildIndex));
            if (minIndex == index) {
                return;
            }
            // swap value at index with value at min index
            swap(index, minIndex);
            percolateDown(minIndex);
        } else if (leftChildIndex != -1 && rightChildIndex == -1) { // only have left child, not right child
            if (pq[leftChildIndex] < pq[index]) { // if leftchild value smaller than current node value
                swap(index, leftChildIndex);
                percolateDown(leftChildIndex);
            }
        } else {
            throw new Error("something is wrong");
        }

    }

    /**
     * Swap element at position indexA and indexB
     * @param indexA
     * @param indexB
     */
    private void swap(int indexA, int indexB) {
        int temp = pq[indexA];
        pq[indexA] = pq[indexB];
        pq[indexB] = temp;
    }

    public static void main(String[] args)
    {
        MinHeap m = new MinHeap(10);
        m.insert(5);
        m.insert(11);
        m.insert(2);
        System.out.println(m.getMin());
        System.out.println(m.extractMin());
        System.out.println(m.getMin());
    }

}