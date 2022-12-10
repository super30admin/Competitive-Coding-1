
// Time Complexity : 
//  Insert - O(logn)
// remove - O(logn)
// get Min - O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

class Problem2 {

    // array to store the numbers

    // create an array.
    private int[] heap;
    private int size;
    private int maxsize;

    // initialize values to the heap array.
    public Problem2(int maxsize) {
        this.maxsize = maxsize;
        this.heap = new int[this.maxsize + 1];
        this.size = 0;
    }

    // we add the element to the end and bubbleup the element to its actual
    // position, by comparing the value with the parent element
    public void insert(int num) {
        if (size >= maxsize)
            return;

        heap[size] = num;
        size++;
        bubbleUp(size - 1);
    }

    // swap the last element with 1st element and bubble down,-> find the exact
    // position of the element swapped
    // by comparing it to its children
    public int remove() {

        int element = heap[0];
        heap[0] = heap[size - 1];
        size--;
        bubbleDown(0);
        return element;
    }

    // Returning true if the passed node is a leaf node
    private boolean isLeaf(int pos) {

        if (pos > (size / 2)) {
            return true;
        }

        return false;
    }

    // check is the left or right child of the element is small, the smaller one is
    // swapped with the ith element
    private void bubbleDown(int i) {

        if (!isLeaf(i)) {
            int current = i;
            if (rightChildInd(i) <= size) {
                if (heap[leftChildInd(i)] < heap[rightChildInd(i)]) {
                    current = leftChildInd(i);
                } else {
                    current = rightChildInd(i);
                }
            } else {
                current = heap[leftChildInd(i)];
            }

            if (heap[i] > heap[leftChildInd(i)] || heap[i] > heap[rightChildInd(i)]) {
                swap(i, current);
                bubbleDown(current);
            }

        }
    }

    // index of the right child
    private int rightChildInd(int i) {
        return (i * 2) + 2;
    }

    // index of the left child
    private int leftChildInd(int i) {
        return (i * 2) + 1;
    }

    // move the element up.
    private void bubbleUp(int i) {

        while (heap[i] < heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);

        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public int getMin() {
        return heap[0];
    }

    public static void main(String[] arg) {

        // Display message
        System.out.println("The Min Heap is ");

        Problem2 minHeap = new Problem2(20);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.printHeap();
        System.out.println("The Remove min val is "
                + minHeap.remove());

        System.out.println("The  min val is "
                + minHeap.getMin());
    }

}
