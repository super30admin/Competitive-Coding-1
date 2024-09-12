public class MinHeap {
    int[]Heap;
    int maxSize;
    int currSize;

    private static  int Front = 1;//to keep track of root node

    MinHeap(int maxSize){
        this.maxSize = maxSize;
        this.Heap = new int[maxSize+1];
        this.Heap[0] = Integer.MIN_VALUE;
        this.currSize = 0;
    }

    //insert function
    /*
    whenever we want to insert an element into the heap, we insert it at the bottom rightmost
    node in order to maintain the complete binary tree property and do bubble up
   the min element
   insert operation : O(log n), where n is the number of nodes
     */

    private void insert(int data){
        //this means Heap is full and no space available
        if (currSize >= maxSize){
            return;
        }

        Heap[++currSize] = data;
        int currPtr = currSize;
        while (Heap[currPtr] < Heap[getParent(currPtr)]){
            swap(currPtr,getParent(currPtr));
            currPtr = getParent(currPtr);
        }
    }

    private void swap(int currPtr, int parent) {
        int temp;
        temp = Heap[currPtr];
        Heap[currPtr] = Heap[parent];
        Heap[parent] = temp;
    }

    private int getParent(int currPtr) {
        return currPtr / 2; //returning the position of parent node of the current node
    }
    /*
    remove the min element at root node by swapping it wiht bottom rightmost node
    then perform heapify.
	time complexity : O(log n), where n is the number of nodes

     */
    private int remove(){
        int popped = Heap[Front];
        Heap[Front] = Heap[currSize];currSize--;

        heapify(Front);
        return popped;
    }

    private void heapify(int front) {
        if (!isLeaf(front)){
            if (Heap[front] > Heap[getLeftChild(front)] ||
                    Heap[front] > Heap[getRightChild(front)]){
                //heapify with the minimum node
                if (Heap[getLeftChild(front)] < Heap[getRightChild(front)] ){
                    swap(front,getLeftChild(front));
                    heapify(getLeftChild(front));
                }else {
                    swap(front,getRightChild(front));
                    heapify(getRightChild(front));
                }
            }
        }
    }

    private int getRightChild(int position) {
        return (2 * position) + 1;
    }

    private int getLeftChild(int position) {
        return (2 * position);
    }

    private boolean isLeaf(int position) {
        if(position >= currSize/2 && position <= currSize){
            return true;
        }
        return false;
    }

   /*
    time complexity: O(1)
     */
    private int getMin(){
        return Heap[Front];
    }

    private void print(){
        for (int i = 1;i <= currSize/2;i++){
            System.out.println(" parent:" +Heap[i] +
                            " left : " + Heap[2*i] +
                            "right : " + Heap[2*i + 1]);

        }
    }


    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(20);
        minHeap.insert(22);
        minHeap.insert(21);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(12);

        minHeap.print();
        System.out.println("the minimum element is: " + minHeap.getMin());

        System.out.println();
        System.out.println("element removed :" + minHeap.remove());
        System.out.println("the minimum element is: " + minHeap.getMin());
        minHeap.print();
    }




}
