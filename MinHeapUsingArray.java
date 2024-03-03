
/**
 * For a given index `i`
 * n = arr.length [size of the array]
 * leaf Node Idxes = i >= (n/2)
 * non leaf Node Indexes = i < (n/2)
 * leftNode pos = (2 * i) + 1
 * rightNode pos = (2 * i) + 2
 * parent node pos = (i-1) / 2
 */

class MinHeapUsingArray {

    static class MinHeap {
        private int arr[];
        private int size;
        private int capacity;

        MinHeap(int capacity) {
            this.arr = new int[capacity];
            this.size = 0;
            this.capacity = capacity;
        }

        private int parentIdx(int i) {
            return (i - 1) / 2;
        }

        private int leftChildIdx(int i) {
            return (i * 2) + 1;
        }

        private int rightChildIdx(int i) {
            return (i * 2) + 2;
        }

        private int getMinNode() {
            return this.arr[0];
        }

        //Time complexity: O(n)
        //Space complexity: O(1)
        private void insertElementMin(int element) {

            // if size is at full capacity can't insert new Elements
            if (this.size == this.capacity) {
                System.out.println("Heap is already full!\nCan't insert: " + element);
            }

            // increase the size
            this.size++;
            // insert at last pos
            this.arr[size - 1] = element;

            int currIdx = this.size - 1;

            // As long as current Idx is not root and current value is less than parent
            // value
            while (currIdx > 0 && this.arr[parentIdx(currIdx)] > this.arr[currIdx]) {
                // swap
                swap(this.arr, currIdx, parentIdx(currIdx));
                // Update the current Idx of the element
                currIdx = parentIdx(currIdx);
            }
        }

        //Time complexity: O(n)
        //Space complexity: O(1)
        private void deleteMinElement() {
            if (this.size == 0) {
                return;
            }

            int size = this.size;
            int lastElement = this.arr[size - 1];

            // update root value with the last element
            this.arr[0] = lastElement;

            this.size--;
            size--;
            // call heapify to maintain min-heap
            minHeapify(this.arr, 0, size);
        }
    }

    //Time complexity: O(logn)
    //Space complexity: O(logn)
    private static void minHeapify(int arr[], int nodeIdx, int arrSize) {
        if (arrSize <= 1) {
            return;
        }
        int smallest = nodeIdx;
        int l = 2 * nodeIdx + 1;
        int r = 2 * nodeIdx + 2;

        if (l < arrSize && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if (r < arrSize && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if (smallest != nodeIdx) {
            swap(arr, smallest, nodeIdx);
            minHeapify(arr, smallest, arrSize);
        }
    }

    //Time complexity: O(logn)
    //Space complexity: O(logn)
    private static void maxHeapify(int arr[], int nodeIdx, int arrSize) {
        if (arrSize <= 1) {
            return;
        }
        int largestNodeIdx = nodeIdx;
        int l = 2 * nodeIdx + 1;
        int r = 2 * nodeIdx + 2;

        if (l < arrSize && arr[l] > arr[largestNodeIdx]) {
            largestNodeIdx = l;
        }

        if (r < arrSize && arr[r] > arr[largestNodeIdx]) {
            largestNodeIdx = r;
        }

        if (largestNodeIdx != nodeIdx) {
            swap(arr, nodeIdx, largestNodeIdx);
            maxHeapify(arr, largestNodeIdx, arrSize);
        }
    }

    private static void buildMinHeap(int arr[], int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            minHeapify(arr, i, n);
        }
    }

    private static void buildMaxHeap(int arr[], int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    //Time complexity: O(n)
    //Space complexity: 
    private static void printHeap(int arr[], int N, String msg) {
        System.out.printf(
                "Array representation of %sHeap is: ", msg == null ? "" : msg);

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " -> ");

        System.out.println();
    }

    private static void swap(int arr[], int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }

        arr[i] = (arr[i] & arr[j]) + (arr[i] | arr[j]);
        arr[j] = arr[i] + (~arr[j]) + 1;
        arr[i] = arr[i] + (~arr[j]) + 1;
    }

    //Time complexity: O(nlogn)
    //Space complexity: O(logn)
    private static void heapSort(int arr[]) {
        int arrSize = arr.length;
        if (arrSize <= 1) {
            return;
        }

        buildMaxHeap(arr, arrSize);
        for(int i = arrSize - 1; i>= 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 5, 6, 8, 9, 7, 3 };
        int N = arr.length;
        //Sort the Array
        heapSort(arr);
        printHeap(arr, N, "sorted-");

        arr = new int [] { 1, 5, 6, 8, 9, 7, 3 };

        buildMaxHeap(arr, N);
        printHeap(arr, N, "Max");

        buildMinHeap(arr, N);
        printHeap(arr, N, "Min");

        MinHeap minHeap = new MinHeap(5);
        minHeap.insertElementMin(4);
        minHeap.insertElementMin(10);
        minHeap.insertElementMin(3);
        minHeap.insertElementMin(5);
        minHeap.insertElementMin(1);
        printHeap(minHeap.arr, minHeap.size, "Min");
        // System.out.println("Min node in Min Heap: " + minHeap.getMinNode());
        minHeap.deleteMinElement();
        printHeap(minHeap.arr, minHeap.size, "Min");
    }
}