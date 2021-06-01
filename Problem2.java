
//Time Complexity
//Space Complexity

public class MinHeap {

    private final int FRONT = 1;
    private int[] Heap;
    private int size;
    private int maxSize;



    /** Constructor to initialize*/
    public MinHeap(int maxSize){

        this.maxSize = maxSize;
        this.size = 0;

        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }


    /** Function that will return the position of the parent for the node currently at pos*/

    private int parent(int pos) {
        return pos / 2;
    }


    /** Function that will return the position of the left child for the node currently at pos*/

    private int leftChild(int pos) {
        return (2 * pos);
    }

    /** Function that will return the position of the right child for the node currently at pos */

    private int rightChild(int pos) {

        return ( 2 * pos) + 1;

    }

    /** function to check if the passed node is a leaf node  */


    private boolean isLeaf(int pos) {

        if (pos >= (size/2) && pos <= size) {
            return true;
        }

        return false;

    }


    /** swap nodes of the heap */

    private void swap(int fpos, int spos){

        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;

    }

    /** Function to heapify the pos*/

    private void minHeapify(int pos) {

        if(!isLeaf(pos)) {
            /** to check if the node is non-leaf node and check with value greater then any other children*/
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

                /** Swap with left child else with right child*/

                if(Heap[leftChild(pos) < Heap[rightChild(pos)]]) {

                    swap(pos,leftChild(pos)]);
                    minHeapify(leftChild(pos));

                }

                else {
                    swap(pos,rightChild(pos)]);
                    minHeapify(rightChild(pos));

                }

            }

        }

    }

    /** Function to insert the element at the desired position */
    private void insert(int element){

        if (size >= maxSize) {

            return
        }

        Heap[++size] = element;
        int current = size;

        while(Heap[current] <= Heap[parent(current)]) {

            swap(current,parent(current));
            current = parent(current);
        }

    }

    /** function to find minHeap */

    public void minHeap() {

        for (int pos = (size / 2); pos >= 1; pos--){

            minHeapify(pos);
        }

    }

    /** function to remove element from minheap */

    public int remove() {

        int elementToBePopped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return elementToBePopped;

    }



    public static void main(String [] args){

        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(50);


    }



}
