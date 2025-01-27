/*
 Time Complexity :
 insert log(n)
 remove log(n)
 getMin O(1)
 Space Complexity : O(n) array used with n elements

 Design Min Heap
 */
class Problem2 {
    private int[] Heap;
    private int size;
    private int maxSize;
    private int front;

    public Problem2(int maxsize) {
        this.maxSize=maxsize;
        this.size=0;
        this.front=1;
        Heap=new int[this.maxSize+1];
        Heap[0]=Integer.MIN_VALUE;
    }

    private int parent(int pos) { return pos/2; }

    private int leftChild(int pos) { return 2*pos; }
    private int rightChild(int pos) { return 2*pos +1; }
    private boolean isLeaf(int pos) {
        if(pos > size/2){
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int temp=Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=temp;
    }

    private void minHeapify(int pos) {
        if(!isLeaf(pos)){
            int swapPos=pos;
            if(rightChild(pos)<=size)
                swapPos=Heap[leftChild(pos)]<Heap[rightChild(pos)]? leftChild(pos) : rightChild(pos);
            else
                swapPos=leftChild(pos);

            if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]){
                swap(pos,swapPos);
                minHeapify(swapPos);
            }
        }
    }

    public void insert(int element) {
        if(size>=maxSize){
            return;
        }

        Heap[++size]=element;
        int current=size;

        while(Heap[current]<Heap[parent(current)]){
            int parent = parent(current);
            swap(current,parent);
            current=parent;
        }
    }

    public void print() {
        for(int i=1;i<=size/2;i++){
            System.out.print(
                    " PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int remove() {
        int popped=Heap[front];
        Heap[front]=Heap[size--];
        minHeapify(front);
        return popped;
    }

    public static void main(String[] arg)
    {

        // Display message
        System.out.println("The Min Heap is ");

        // Creating object of class in main() method
        Problem2 minHeap = new Problem2(15);

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

