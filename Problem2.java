// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : --
// Any problem you faced while coding this : yes I got a problem of finding parent and children element because I started from the index 0 to add elements.
// I had also encounterd problem while I am comparing element of index 0 element if inserted element is negative so, I have made index 0 element smallest element

class MinHeap {
    private int maxSize;
    private int index;
    private int[] Heap;

    public MinHeap(int size) {

        // initialize maxSize of the Heap
        this.maxSize = size;

        // starting index is 0
        this.index = 0;
        Heap = new int[size];
        // here we are starting with index 1 to add our elements in Heap.
        // so, we make first element is smallest element if some how we came to this
        // position we are not going to swap with any other element.
        Heap[0] = Integer.MIN_VALUE;

    }

    private int parent(int i) {

        // parent of any element is index/2;
        return i / 2;
    }

    private int leftChild(int i) {

        // left child of any element is index*2;
        return 2 * i;
    }

    private int rightChild(int i) {
        // right child of any element is index*2;
        return 2 * i + 1;
    }

    public int extractMin() {

        // if index is less than or equal to 0 that means heap is empty so we return -1;
        if (index <= 0)
            return -1;

        // store smallest element that we want to extract
        int popped = Heap[1];

        // swap last element with first element
        Heap[1] = Heap[index];

        // decrease the size of the Heap as we remove element from the Heap
        index--;

        // for the minHeapify we are going to start with index 1;
        int current = 1;
        // we are going to traverse to the leaf node in heap
        while (current < index) {

            // store smaller element out of left child or right child.
            int smaller = Heap[leftChild(current)] < Heap[rightChild(current)] ? leftChild(current)
                    : rightChild(current);

            // if smaller element is less than the current element that means our conditon
            // not satisfies as per minHeap so we swap it and then again check our condition
            // satisfies or not until we reach to the leaf node
            if (Heap[current] > Heap[smaller]) {
                swap(current, smaller);
                current = smaller;
            } else {

                // else we break the loop as our minHeap condition satisfies
                break;
            }
        }

        // return smallest element.
        return popped;
    }

    public int getMin() {
        // if index is less than or equal to 0 that means heap is empty so we return -1;
        if (index <= 0)
            return -1;
        // else we return element at root.
        return Heap[1];
    }

    private void swap(int x, int y) {

        // swap function
        int temp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = temp;
    }

    public void print() {
        for (int i = 1; i <= index / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);
            // By here new line is required
            System.out.println();
        }
    }

    public void insert(int element) {
        // if size of the heap is greater than max size we return
        if (index >= maxSize) {
            return;
        }
        // increase the size of the Heap because we want to add new element in the array
        index++;

        // insert new element at the leaf node
        Heap[index] = element;

        // here we are going to check that newly added element is less than it's parent
        // element or not. if its less than its parent element we swap it until root
        // element.
        int current = index;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();

        System.out.println("Popped Min val is " + minHeap.extractMin());
        System.out.println("The Min val is " + minHeap.getMin());
    }
}
