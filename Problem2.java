// Design a Min heap
// heap basically is a tree which is insertion is left to right
// and like the topmost element is the minimum element.
// Insertion is bottom-up
// Deletion is top-down
// Time complexity = O(log(n))
// Space complexity = O(n)

class MinHeap{
    private int[] heap;
    private int size;
    private int maxSize;


    public MinHeap() {
        heap = new int[1000];
        heap[0] = Integer.MIN_VALUE;
        size =0;
        maxSize = 1000;
    }

    private int parent(int pos) {
        return pos/2;
    }

    private int leftChild(int pos) {
        return 2*pos;
    }
    
    private int rightChild(int pos) {
        return (2*pos)+1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size/2);
    }

    private void swap(int fpos, int lpos) {
        int temp = heap[fpos];
        heap[fpos] = heap[lpos];
        heap[lpos] = temp;
    }

    private void minHeapify(int pos) {
        if(!isLeaf(pos)) {
            int swapPos = pos;

        if(rightChild(pos)<= size) {
            swapPos = heap[leftChild(pos)]< heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
        } else {
            swapPos = leftChild(pos);
        }

        if(heap[pos]> heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
            swap(pos, swapPos);
            minHeapify(swapPos);
        }
    }
    }

    private void insert(int element) {
        if(size>= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;
        while(heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private int remove() {
        int popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }

    private void print()
    {
        for (int i = 1; i <= size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i]
                + " RIGHT CHILD :" + heap[2 * i + 1]);
 
            // By here new line is required
            System.out.println();
        }
    }

     // Method 10
    // Main driver method
    public static void main(String[] arg)
    {
 
        // Display message
        System.out.println("The Min Heap is ");
 
        // Creating object of class in main() method
        MinHeap minHeap = new MinHeap();
 
        // Inserting element to minHeap
        // using insert() method
 
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
        minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                           + minHeap.remove());
    }


}
