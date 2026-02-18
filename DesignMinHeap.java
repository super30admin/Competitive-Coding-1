// Time Complexity : O(log n) for insert, remove
// Space Complexity : O(n) to store n elements
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
Use an array to store the incoming elements. To get parent, its i-1/2, to get left & right children, its
2*n+1 and 2*n+2,make sure to keep check of size value and doesnt cross maxSize.The logic of heapify is
that for any input, as long as its not a leaf, check if the left and right children are smaller than the
input, if so, swap them with the input and heapify recursively until smallest element stays at top. For
insert and rmeove methods as well, make sure to heapify and check smallest element is at the top.
 */
class MyMinHeap {
    private int Heap[];
    private int size;
    private int maxSize;

    public MyMinHeap(int capacity) {
       this.maxSize = capacity;
       this.size = 0;
       this.Heap = new int[capacity];
    }

    private int parent(int i) {
       return (i - 1) / 2;
    }

    private int leftChild(int i) {
       return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private boolean isLeaf(int i) {
        return i >= size / 2 && i < size;
    }

    private void swap(int i, int j) {
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }

    private void heapify(int i) {
        if(isLeaf(i))
            return;
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);

        int smallest = i;

        if(leftChild > 0 && Heap[leftChild] < Heap[smallest])
            smallest = leftChild;
        if(rightChild > 0 && Heap[rightChild] < Heap[smallest])
            smallest = rightChild;

        if(smallest != i) {
            swap(smallest, i);
            heapify(smallest);
        }
    }

    public void insert(int val) {
        if(size >= maxSize)
            return;
        Heap[size] = val;
        int curr = size;
        size++;

        while(curr > 0 && Heap[curr] < Heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public int removeMin() {
        if(size == 0)
            return -1;

        int min = Heap[0];
        Heap[0] = Heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    public void printHeap() {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            System.out.print("PARENT: " + Heap[i]);
            if (leftChild(i) < size)
                System.out.print("  LEFT: " + Heap[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print("  RIGHT: " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyMinHeap heap = new MyMinHeap(15);

        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        System.out.println("Min Heap:");
        heap.printHeap();

        System.out.println("Removed Min: " + heap.removeMin());
    }
}
