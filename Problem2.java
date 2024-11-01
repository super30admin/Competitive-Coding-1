

class Problem2 {

    private int[] heap;
    private int size;
    private int maxSize;


    private static final int FRONT=1;

    public Problem2(int maxSize)
    {
        this.maxSize=maxSize;
        this.size=0;

        heap= new int[maxSize+1];
        heap[0]= Integer.MIN_VALUE;
    }
    private int parent(int pos)
    {
        return pos/2;
    }
    private int leftChild(int pos)
    {
        return (2*pos);
    }
    private int rightChild(int pos)
    {
        return (2*pos+1);
    }
    private boolean isLeaf(int pos){
        if(pos>(size/2))
        {
            return true;
        }
        return false;
    }
    private void swap(int fpos, int spos)
    {
        int temp=heap[fpos];;
        heap[fpos]=heap[spos];
        heap[spos]=temp;
    }
    private void minHeapify(int pos)
    {
        if(!isLeaf(pos))
        {
            int swapPos= pos;
            if (rightChild(pos) <=size)
            {
                swapPos= heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);

            }
            else {
                swapPos= leftChild(pos);
            }
            if (heap[pos] > heap[leftChild(pos) ] || heap[pos] > heap[rightChild(pos)])
            {
                swap(swapPos, pos);
                minHeapify(swapPos);
            }
        }
    }
    public void insert(int element)
    {
        if (size>= maxSize)
        {
            return;
        }
        heap[++size]=element;
        int current= size;
        while (heap[current]<heap[parent(current)])
        {
            swap(current, parent(current));
            current= parent(current);
        }
    }
    public void print(){
        for (int i=1;i<=size;i++)
        {
            System.out.print("Parent :" +heap[i]+" Left Child :  "+ heap[2*i]
                    + "Right child: "+ heap[2*i+1]);
            System.out.println();
        }
    }
    public int remove(){
        int popped= heap[FRONT];
        heap[FRONT]=heap[size--];
        minHeapify(FRONT);

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

//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 6, 7, 8};
//        int res = missingNumber(arr);
//        System.out.println(res);
//    }
}