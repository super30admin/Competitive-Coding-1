/**
 *
 * Heap is implemented using an array
 * left child pos will at 2*i;
 * right child pos will be at 2*i+1;
 * first element will be -inf;
 * parent will be at pos/2;
 *
 * Insertion:
 * Time Complexity -->O(log(n))
 * Space Complexity -->O(1)
 * Add a new node at the end of the leftmost leaf and compare it with parent and swap if the parent is grater.
 *
 * extract Min
 * Time Complexity -->O(log(n))
 * Space Complexity -->O(1)
 *
 * Remove the top element(first element in the row) move the last element to the top and heapify it
 *
 */
public class Problem2 {
    public static void main(String[] args) {
        System.out.println("The Min Heap is ");

        // Creating object of class in main() method
        myMinHeap minHeap = new myMinHeap(15);

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
                + minHeap.extractMin());
    }
}


class myMinHeap{
    private int[] heap;
    private int maxSize;
    private int size;
    private static final int FRONT = 1;
    public myMinHeap(int maxSize){
        this.maxSize = maxSize;
        heap = new int[maxSize+1];
        heap[0] =  Integer.MIN_VALUE;
        size = 0;
    }
    private int parentPos(int pos) {
        return pos / 2;
    }

    private int leftChildPos(int pos) {
        return 2 * pos;
    }

    private int rightChildPos(int pos) {
        return 2 * pos + 1;
    }

    private void swapPos(int pos1, int pos2){
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }
    public void insert(int value){
        if(size>=maxSize)
            return;
        heap[++size] = value;
        int current = size;
        while(heap[parentPos(current)]>heap[current]){
            swapPos(parentPos(current),current);
            current = parentPos(current);
        }
    }
    public boolean isLeafNode(int pos){
        return pos >size/2;
    }
    public void minHeapify(int pos){
        if(!isLeafNode(pos)){
            int swapPos = pos;
            if(rightChildPos(pos)<=size){
                swapPos = heap[leftChildPos(pos)]<heap[rightChildPos(pos)]?leftChildPos(pos):rightChildPos(pos);
            }else{
                swapPos = leftChildPos(pos);
            }
            if(heap[swapPos]<heap[pos]){
                swapPos(swapPos,pos);
                minHeapify(swapPos);
            }
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);

            System.out.println();
        }
    }
    public int extractMin(){
        int cmin = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return cmin;
    }

}
