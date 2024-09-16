// Time Complexity : getMin() ==> O(1), extractMin() ==> O(log n), insert() ==> O(log n)
// Space Complexity : O(N)

// Your code here along with comments explaining your approach
// The heap can be stored as array, because we each left child is filled before right child and
// the parent layer is filled before the child layer of nodes. We can calculate left and right child index
// for node i by 2*i +1 and 2*i+2. To find the parent from child i, we can use (i-1)/2. For inserting in heap,
// we can insert the element at the last index and shift it up if the parent node is greater than child else
// stop shifting. For removing an element, we can remove 0th element, replace it with last value in heap. After that,
// we can shift down the root value based on which child(left or right) is smaller than the root node.
// We do shift up and shift down to maintain the min heap invariant.

public class MinHeap {

    /*If the heap grows more than the MAX SIZE, we
    should create new heap of larger size*/
    private int MAX_SIZE = 100;
    private Integer[] heap = new Integer[MAX_SIZE];
    private int size = 0;

    public int getMin() {
        return heap[0] == null ? -1 : heap[0];
    }

    public int extractMin() {
        int temp = heap[0];
        int lastIndex = size - 1;
        heap[0] = heap[lastIndex];
        heap[lastIndex] = null;
        size--;
        shiftDown();
        return temp;
    }

    private void shiftDown() {
        int root = 0;
        int left = 2 * root + 1;

        while (left < size) {
            int indexWithMin = left;
            int right = left + 1;
            if (right < size) {
                indexWithMin = heap[left] < heap[right] ? left : right;
            }
            if (heap[indexWithMin] < heap[root]) {
                swap(root, indexWithMin);
                root = indexWithMin;
                left = 2 * indexWithMin + 1;
            } else {
                break;
            }
        }
    }

    public void insert(int value) {
        if (size == MAX_SIZE) return;
        heap[size] = value;
        shiftUp(size, value);
        size++;
    }

    private void shiftUp(int index, int value) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] > value) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int parent, int child) {
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(20);
        System.out.println("Min value:" + minHeap.getMin());
        minHeap.insert(13);
        System.out.println("Min value:" + minHeap.getMin());
        minHeap.insert(9);
        System.out.println("Min value:" + minHeap.getMin());
        minHeap.insert(25);
        minHeap.insert(5);
        System.out.println("Min value:" + minHeap.getMin());
        System.out.println("Removed top value: " + minHeap.extractMin());
        System.out.println("Min value:" + minHeap.getMin());
    }
}
