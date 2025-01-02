public class MinHeap {

    int[] nums;
    int capacity;
    int size;
    MinHeap(int capacity) {
        this.capacity = capacity;
        nums = new int[capacity];
        this.size = 0;
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    int getLeft(int i) {
        return 2 * i + 1;
    }

    int getRight(int i) {
        return 2 * i + 2;
    }

    private void insert(int val) {
        this.size++;
        int index = size - 1;
        nums[index] = val;

        int parent = getParent(index);
        while (val < nums[parent]) {
            swap(nums, index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    private void swap(int[] nums, int index, int parent) {
        int temp = nums[index];
        nums[index] = nums[parent];
        nums[parent] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(20);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(0);
        minHeap.insert(12);
        minHeap.insert(7);
        minHeap.getLeft(20);
    }
}