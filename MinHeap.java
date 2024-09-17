// Time Complexity : minHeap leftchild rightchild parent isleaf swap take O(1)
// remove insert and minheapify take O(log n) since the need to bubble up the min element through the levels in the worst case

// Space Complexity :O(n)where n is the number of elements currently.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    // front should always point to 1 as 0th index is occupied by integer.minvalue
    private static final int FRONT = 1;

    // constructor which sets current size "0" and maxSize as "size" and creates
    // heap[] of maxsize with
    public minHeap(int size) {
        this.maxSize = size;
        this.size = 0;
        heap = new int[size + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    // returns the index of the parent
    private int parent(int pos) {
        return pos / 2;
    }

    // returns the index of the leftchild
    private int leftChild(int pos) {
        return 2 * pos;
    }

    // returns the index of the rightchild
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // swap the index
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // returns if the index is leaf or not
    private boolean isLeaf(int pos) {
        // since the heap increase by 2
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // inserts the element
    public void insert(int element) {
        // if maxsize is reached cant add
        if (size >= maxSize)
            return;

        // if not reached add the element at the last index and increase the current
        // size by 1
        Heap[++size] = element;
        int current = size;

        // also if the element currently added is smaller than its parent swap and
        // bubble that value until it is bigger than its parent
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // remove from 1st index and place the last element in the first postion and
    // minheapify it
    // also reduce the size
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
}
