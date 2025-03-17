// Time Complexity : getMin = O(1), extractMin() = O(log n), insert() = O(log n)
// Space Complexity : O(n) array space
// Did this code successfully run : Yes
// Any problem you faced while coding this : No
// Approach: keep static array to store elements. left child index 2*i + 1, right child index = 2*i + 2, parent node index = i-1/2, for get it is simple get root, for extract, remove root and heapify(), for insert at end of array and bubble up using while to find correct place for element.

public class MyMinHeap {
    private int[] heap;
    private int size;   //no of elements in heap
    private int capacity;    //variable to create initial storage array

    public MyMinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public int getMin() {
        if(this.size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    //function to insert new key in heap -> becomes O(log n) due to bubble up to finalize the correct place for the new key
    void insert(int key) {
        if(this.size >= this.capacity) {
            System.out.println("Heap is full, no more space");
            return;
        }
        this.heap[size] = key;  //store key
        int currentIndex = size;    //store current index
        size++; //increment index to put next element and size

        //bubble up
        while(currentIndex != 0 && heap[getParentIndex(currentIndex)] > heap[currentIndex]) {
            swap(getParentIndex(currentIndex), currentIndex);   //swap values at parent and current index
            currentIndex = getParentIndex(currentIndex);    //move up the current index
        }
    }

    //helper function to get index of parent of index i
    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    //helper function to get index of left child of index i
    private int getLeftChildIndex(int i) {
        return (2 * i + 1);
    }

    //helper function to get index of right child of index i
    private int getRightChildIndex(int i) {
        return (2 * i + 2);
    }

    //helper function to swap values at indices i and j

    private void swap(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }


    //function to delete and return min from minHeap -> O(log n) due to call of function heapify()
    public int extractMin() {
        if(this.size == 0) {
            System.out.println("Heap is empty, Nothing to delete");
            return  -1;
        }
        int root = heap[0]; //min value to return as output
        heap[0] = heap[size - 1];   //copy last value to root for easy deletion
        this.size--;
        //bubble down the root to its correct place using heapify()
        heapify(0);

        return root;
    }

    //helper function to restore min heap structure bu bubble down root to correc place
    public void heapify(int i) {
        int leftChild = getLeftChildIndex(i);
        int rightChild = getRightChildIndex(i);
        int smallIndex = i;

        //check if left is smaller
        if(leftChild < size && heap[leftChild] < heap[smallIndex]) {
            smallIndex = leftChild;
        }

        //check if right is smaller
        if(rightChild < size && heap[rightChild] < heap[smallIndex]) {
            smallIndex = rightChild;
        }
        //if smallIndex is not same as current index i then swap values and call heapify again on small index
        if(smallIndex != i) {
            swap(i, smallIndex);
            heapify(smallIndex);
        }
    }

    //function to print heap contents
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");

        // Creating object of class in main() method
        MyMinHeap minHeap = new MyMinHeap(15);

        // Inserting element to minHeap using insert() method
        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        // Print all elements of the heap
        minHeap.printHeap();

        // Removing minimum value from above heap and printing it
        System.out.println("Removing the Min val is " + minHeap.extractMin());
        //Displaying minmium value after extractMin()
        System.out.println("Current Min val is " + minHeap.getMin());
    }

}

