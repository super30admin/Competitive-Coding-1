
//Time Complexity: Insertion: O(log n), Deletion: O(log n), Access Min: O(1)
//space complexity: O(n)

class MyMinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MyMinHeap(int capacity) {
        this.maxSize=capacity;
        this.size=0;
        heap=new int[capacity];
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private int leftChild(int i) {
        return 2*i+1;
    }

    private int rightChild(int i) {
        return 2*i+2;
    }

    private boolean isLeaf(int i) {
        return i>=size/2 && i<size;
    }

    private void swap(int i, int j) {
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    
    private void heapify(int i) {
        if (isLeaf(i)) return;

        int left=leftChild(i);
        int right=rightChild(i);
        int smallest=i;

        // Find the smallest among root, left child and right child

        if (left<size && heap[left]<heap[smallest]) {    
            smallest=left;
        }
        if (right<size && heap[right]<heap[smallest]) {
            smallest=right;
        }

        // If parent is not the smallest, swap and continue heapifying

        if (smallest!=i) {    
            swap(i,smallest);
            heapify(smallest);  // Recursively heapify the affected sub-tree
        }
    }

    public void insert(int val) {
        if(size>=maxSize) 
            return;
        heap[size]=val;   //insert at the end
        int current=size;
        size++;
         // Move up until min-heap property is restored
        while(current>0 && heap[current]<heap[parent(current)]) {
            swap(current,parent(current));
            current=parent(current);
        }
    }

    public int removeMin() {
        if (size==0) 
            return -1;
        int min=heap[0]; // Root is smallest
        heap[0]=heap[size-1]; // Move last element to root
        size--;
        heapify(0); // Restore heap property
        return min;
    }

    public void printHeap() {
        for (int i=0;i<=(size-2)/2;i++) {
            System.out.print("PARENT: " + heap[i]);
            if (leftChild(i)<size)
                System.out.print("  LEFT: " + heap[leftChild(i)]);
            if (rightChild(i)<size)
                System.out.print("  RIGHT: " + heap[rightChild(i)]);
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

        System.out.println("Min Heap:");
        heap.printHeap();
    }
}
