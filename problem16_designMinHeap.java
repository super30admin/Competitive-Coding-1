package CompetitiveCoding;

public class problem16_designMinHeap {
    private int[] heapArray;
    private int size = 0;
    private int capacity;
    private static final int FRONT = 1;

    private problem16_designMinHeap(int capacity) {
        this.capacity = capacity;
        this.size = size;
        this.heapArray = new int[capacity + 1];
    }

    private int parent(int position) {
        return position / 2;
    }
    private int leftChild(int position) {
        return (position * 2) + 1;
    }
    private int rightChild(int position) {
        return (position * 2) + 2;
    }
    private boolean isLeaf(int position) {
        if(position >= size / 2 && position < size) return true;
        return false;
    }

    private void swap(int childPos, int parentPos) {
        int temp = heapArray[childPos];
        heapArray[childPos] = heapArray[parentPos];
        heapArray[parentPos] = temp;
    }
    // inserting the values
    private void insert(int data) {
        if(size >= capacity) return;
        heapArray[++size] = data;
        int currPos = size;

        while(heapArray[currPos] < heapArray[parent(currPos)]) {
            swap(currPos, parent(currPos));
            currPos = parent(currPos);
        }
    }

    private void minHeapHeapify(int pos) {
        if(!isLeaf(pos)) { // check if it is the leaf node
            if(heapArray[pos] > heapArray[leftChild(pos)] || heapArray[pos] > heapArray[rightChild(pos)]) {
                if(heapArray[leftChild((pos))] < heapArray[rightChild((pos))]) {
                    swap(pos, leftChild(pos));
                    minHeapHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapHeapify(rightChild(pos));
                }
            }
        }
    }

    private void minHeap() {
        for(int i = size/2 ; i >= 0 ; i--) {
            minHeapHeapify(i);
        }
    }

    private int remove() {
        int poppedEl = heapArray[FRONT];
        heapArray[FRONT] = heapArray[size];
        size--;
        minHeapHeapify(FRONT);
        return poppedEl;
    }

    public static void main(String[] args) {
        problem16_designMinHeap heap = new problem16_designMinHeap(15);
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        heap.minHeap();
        int poppedElement = heap.remove();
        System.out.println("The popped element is:" + poppedElement);
    }
}
