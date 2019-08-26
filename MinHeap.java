/**
 * A Min-Heap is a complete binary tree in which the value in each internal node
 * is less than or equal to the values in the children of that node. 
 * Mapping the elements of a heap into an array is trivial: if a node is stored a index k,
 * then its left child is stored at index 2k + 1 and its right child at index 2k + 2.
 * 
 * Space Complexity: O(n) where n is the capacity of the heap created.
 * Time Complexity:
 *      getMin(): O(1)
 *      extractMin(): O(log n)
 *      insert(x): O(log n)
 */
public class MinHeap {

    int arr[];
    int size;

    /**
     * Constructor: Initializes array of 'capacity' for internal representation of
     * MinHeap.
     * 
     * @param capacity array capacity
     */
    public MinHeap(int capacity) {
        size = 0;
        arr = new int[capacity];
    }

    /**
     * It returns the root element of Min Heap. 
     * Time Complexity of this operation is O(1).
     * 
     * @return root element of the Min Heap if it exists, null otherwise.
     */
    private Integer getMin() {
        if (isEmpty()) {
            return null;
        }
        return arr[0];
    }

    /**
     * Removes the minimum element from MinHeap. 
     * Time Complexity of this Operation is O(Log n).
     * 
     * @return minimum elment from the Min Heap, null otherwise.
     */
    private Integer extractMin() {
        if (isEmpty()) {
            return null;
        }
        int element = arr[0];
        move(0, arr[--size]);
        percolateDown(0);
        return element;
    }

    /**
     * Inserting a new key takes O(Log n) time. 
     * The key is added at end of array, and percolated up to satisfy the heap property.
     * 
     * @param key element to be inserted
     * @return true on insertion, false if already full.
     */
    private boolean insert(int key) {
        if (isFull()) {
            return false;
        }
        move(size, key);
        percolateUp(size++);
        return true;
    }

    /**
     * arr[i] may violate heap order with parent percolateUp(i) brings heap into
     * order on path from i to root.
     * 
     * @param i index where order needs to be verified upwards.
     */
    private void percolateUp(int i) {
        int element = arr[i];
        while (i > 0 && element < arr[parent(i)]) {
            move(i, arr[parent(i)]);
            i = parent(i);
        }
        move(i, element);
    }

    /**
     * arr[i] may violate heap order with child percolateDown(i) brings heap into
     * order on path from i to leaf
     * 
     * @param i index where order needs to be verified downwards.
     */
    private void percolateDown(int i) {
        int element = arr[i];
        int c = leftChild(i);
        while (c < size) {
            // choose smaller of the left and right child
            if (c + 1 < size && arr[c] > arr[c + 1]) {
                c = c + 1;
            }
            if (element <= arr[c]) { // position found
                break;
            }
            move(i, arr[c]);
            i = c;
            c = leftChild(i);
        }
        move(i, element);
    }

    /**
     * 
     * @return true if arr is filled to capacity, false otherwise
     */
    private boolean isFull() {
        return size == arr.length;
    }

    /**
     * 
     * @return true is arr is empty, false otherwise
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * helper utility used for percolation i.e. fixing heap order
     * 
     * @param i       destination index
     * @param element to be moved
     */
    void move(int i, int element) {
        arr[i] = element;
    }

    /**
     * helper utility
     * 
     * @param i index whose parent index needs to be found
     * @return parent index corresponding to child index i
     */
    int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * helper utility
     * 
     * @param i index whose left child index needs to be found
     * @return left child index corresponding to parent index i
     */
    int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Does as it says, prints heap elements in level order from root.
     */
    private void printHeap() {
        System.out.print("Capacity: " + arr.length + " Size: " + size + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(8);
        minHeap.printHeap();
        System.out.println(minHeap.getMin()); // should be null
        System.out.println(minHeap.extractMin()); // should be null
        minHeap.insert(15);
        minHeap.insert(25);
        minHeap.insert(5);
        minHeap.insert(35);
        minHeap.insert(10);
        minHeap.printHeap();
        System.out.println(minHeap.getMin()); // should be 5
        System.out.println(minHeap.extractMin()); // should be 5
        minHeap.printHeap();
        minHeap.insert(100);
        minHeap.insert(-5);
        minHeap.insert(-10);
        minHeap.insert(12);
        boolean result = minHeap.insert(10);
        System.out.println(result); // should be false
        minHeap.printHeap();
    }
}
