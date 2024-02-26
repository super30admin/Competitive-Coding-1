public class MinHeap {

    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    // Helper methods
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void add(int num) {
        int n = items.length;
        items[n] = num;
        int parent = getParentIndex(n);

        while(items[n] < items[parent]) {
            int tmp = items[parent];
            items[parent] = items[n];
            items[n] = tmp;
        }

        size++;
    }

    private void remove(int num) {

    }

    private int getMinimum() {
        return items[0];
    }

    private int size() {
        return size;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.add(5);
        minHeap.add(7);
        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(13);

        System.out.println("Min element: " + minHeap.getMinimum());
        System.out.println("Heap size: " + minHeap.size());

        minHeap.remove(10);
//        System.out.println("Removed min element: " + minElement); // Should print 2
//
//        System.out.println("Min element after removal: " + minHeap.getMinimum()); // Should print 4
//        System.out.println("Heap size after removal: " + minHeap.size()); // Should print 3
    }
}
