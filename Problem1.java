// Time Complexity :put->O(logn),delete->O(logn),where n is no of elements
// Space Complexity :constant as we are not using any extra space
// Did this code successfully run on Leetcode :Yes in leetcode playground
// Any problem you faced while coding this :No
public class MinHeap {
    private int size;// initializing properties
    private int maxSize;
    private int[] minHeap;

    public static void main(String[] args) {
        MinHeap m = new MinHeap(6);
        m.insert(2);
        m.insert(3);
        m.insert(1);
        m.insert(12);
        m.insert(13);
        m.insert(11);
        m.delete();
        System.out.println("Hello World!");
        for (int i = 0; i <= m.maxSize; i++) {
            System.out.println("minHeap" + m.minHeap[i]);

        }
        System.out.println("minHeap size" + m.size);
    }

    public MinHeap(int MaxSize) {// in constructor, we create a new array of length maxSize+1,set size to 0
        this.size = 0;
        this.maxSize = MaxSize;
        this.minHeap = new int[MaxSize + 1];
        this.minHeap[0] = Integer.MAX_VALUE;
    }

    public void swap(int first, int second) {
        int temp = this.minHeap[first];
        this.minHeap[first] = this.minHeap[second];
        this.minHeap[second] = temp;
    }

    public void insert(int value) {
        this.minHeap[size + 1] = value;// we'll insert at last index , then will compare with parent
        // if parent is larger, we'll swap , we'll do this till root
        size++;// will increase the size
        int i = size;
        while (i > 1) {
            int parent = i / 2;
            if (this.minHeap[parent] > this.minHeap[i]) {
                swap(parent, i);
                i = parent;
            } else {// if parent is smaller stop
                return;
            }
        }
    }

    public void delete() {// we'll overwrite last element to root, then will heapify
        this.minHeap[1] = this.minHeap[size];
        this.minHeap[size] = 0;
        System.out.println("inside delete" + size);
        int i = 1;
        size--;// decrement the size
        while (i < size / 2) {
            int leftChild = i * 2;
            int rightChild = i * 2 + 1;// first well check which child is smaller, then will check if smaller
            // child has value less than parent, if yes, we;ll swap to make parent have
            // smaller value
            int smaller = (this.minHeap[leftChild] < this.minHeap[rightChild]) ? leftChild : rightChild;
            if (this.minHeap[smaller] < this.minHeap[i]) {
                swap(i, smaller);
                i = smaller;
            } else {
                return;
            }

        }
    }
}