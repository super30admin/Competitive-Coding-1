// Time Complexity : push -> O(log n), pop -> O(log n), peek -> O(1), size -> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We implement a Min Heap using an ArrayList where the smallest element is always stored at the root.
// push inserts the element at the end and bubbles it upward to maintain heap order, while pop removes the root and heapifies downward.
// peek returns the minimum element at the root, and size returns the total number of elements currently present in the heap.

class minHeap {

    List<Integer> heap;

    // Constructor
    public minHeap() {

        // initialize heap
        heap = new ArrayList<>();
    }

    public void push(int x) {

        // insert element at end
        heap.add(x);

        int curr = heap.size() - 1;

        // bubble up
        while (curr > 0) {

            int parent = (curr - 1) / 2;

            // maintain min heap property
            if (heap.get(parent) > heap.get(curr)) {

                swap(parent, curr);

                curr = parent;
            } else {
                break;
            }
        }
    }

    public void pop() {

        // heap empty
        if (heap.size() == 0) {
            return;
        }

        int last = heap.get(heap.size() - 1);

        // move last element to root
        heap.set(0, last);

        // remove last element
        heap.remove(heap.size() - 1);

        // restore heap property
        heapify(0);
    }

    public int peek() {

        // return minimum element
        if (heap.size() == 0) {
            return -1;
        }

        return heap.get(0);
    }

    public int size() {

        // return heap size
        return heap.size();
    }

    // heapify downward
    private void heapify(int i) {

        int smallest = i;

        int left = 2 * i + 1;

        int right = 2 * i + 2;

        // compare left child
        if (left < heap.size() &&
            heap.get(left) < heap.get(smallest)) {

            smallest = left;
        }

        // compare right child
        if (right < heap.size() &&
            heap.get(right) < heap.get(smallest)) {

            smallest = right;
        }

        // swap if needed
        if (smallest != i) {

            swap(i, smallest);

            heapify(smallest);
        }
    }

    // helper swap function
    private void swap(int i, int j) {

        int temp = heap.get(i);

        heap.set(i, heap.get(j));

        heap.set(j, temp);
    }
}
