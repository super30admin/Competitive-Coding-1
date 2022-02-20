import java.util.Arrays;

/**
 * Properties
 * 1. ACBT - balanced tree it should be be
 * 2. Left and then right child should be full
 * 
 * - Insetion in Heap tree
 * if 1 by 1 then O(nlog n) else Heapify - O(m)
 * 
 */

class MinHeap {

    // arr [7,8,9,10,11]
    // 0 1 2 3 4

    private int capacity = 5;
    // to know the current elements in the heap
    private int size = 0;
    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private int getRightChildIndex(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    private int getParentIndex(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int idx) {
        return items[getLeftChildIndex(idx)];
    }

    private int rightChild(int idx) {
        return items[getRightChildIndex(idx)];
    }

    private int parent(int idx) {
        return items[getParentIndex(idx)];
    }

    private void swap(int i, int j) {
        // THIS WAS ASKED IN ONE INTERVIEW
        items[i] = (items[i] + items[j]) - (items[j] = items[i]);
    }

    /**
     * Like Arraylist checking capacity and on fly increasing size
     */
    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    /**
     * to get the min element, the top element
     * 
     * @return min element
     */
    public int peek() {
        if (size == 0)
            throw new IllegalStateException();
        return items[0];
    }

    /**
     * Remove the min element from the array which is at the top
     * 
     * @return the item removed, the min element at top
     */
    public int poll() {
        if (size == 0)
            throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;

    }

    /**
     * Add items at the leaf node and then heapify up to get the correct position
     * 
     * @param item
     */
    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    /**
     * Take the last element and then swap it with parent if its less.
     * Continues till it has parent and greater than iteself
     */
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * Take the top elem and check the lowest of childs and swap.
     */
    private void heapifyDown() {
        int idx = 0;
        int smallChildIdx = getLeftChildIndex(idx);
        // if no left child then certainly no right child
        while (hasLeftChild(idx)) {
            if (hasRightChild(idx) && rightChild(idx) < leftChild(idx)) {
                smallChildIdx = getRightChildIndex(idx);
            }

            if (items[idx] <= items[smallChildIdx]) {
                // then the heap is proper
                break;
            } else {
                System.out.println(" Swapping : "+items[idx] +" & "+items[smallChildIdx] );
                swap(idx, smallChildIdx);
            }
            idx = smallChildIdx;
        }
    }

    /**
     * Printing the tree, based on the tree height and value at each level
     * At level 1 check if iterator reaches end of nodes; then increase the tree
     * height and nodes capactiy at that level
     */
    public void printTree() {
        int treeHeight = 0;
        double nodes = Math.pow(2, treeHeight);
        for (int i = 0; i < items.length; i++) {
            if (i == nodes - 1) {
                // print new line
                System.out.println();
                treeHeight++;
                nodes = Math.pow(2, treeHeight);
            }
            System.out.print(" " + items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(" Program Test " + MinHeap.class.getSimpleName());
        MinHeap obj = new MinHeap();
        // Adding elements
        obj.add(10);
        obj.add(22);
        obj.add(30);
        obj.add(5);
        obj.add(1);
        obj.printTree();
        System.out.println(" Poll : " +obj.poll()); // Removing the min element which is 1
        System.out.println();
        obj.printTree();

    }
}