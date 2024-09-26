
// Problem - https://www.geeksforgeeks.org/min-heap-in-java/

// Time Complexity : Mentioned below for each function
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : Nothing as such

class Problem2 {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public Problem2(int maxsize) {

        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int left(int pos) {
        return (2 * pos);
    }

    private int right(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2)) {
            return true;
        }
        return false;
    }

    private void swapFunction(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) { // O(Log n)
        if (!isLeaf(pos)) {
            int swapPosition = pos;
            if (right(pos) <= size)
                swapPosition = Heap[left(pos)] < Heap[right(pos)] ? left(pos) : right(pos);
            else
                swapPosition = Heap[left(pos)];

            if (Heap[pos] > Heap[left(pos)] || Heap[pos] > Heap[right(pos)]) {
                swapFunction(pos, swapPosition);
                minHeapify(swapPosition);
            }

        }
    }

    public void insert(int element) { // O(Log n)

        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swapFunction(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() { // O(Log n)
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
}