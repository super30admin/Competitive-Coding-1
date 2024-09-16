public class minHeap {
    private int[] heap;
    private int size;
    private int maxSize;
    private static final int  FRONT = 1;
    public minHeap(int maxSize){
        this.maxSize = maxSize;
        heap = new int[this.maxSize +1];
        this.size = 0;
        heap[0]= Integer.MIN_VALUE;
    }

    private int Parent(int pos){
        return pos/2;
    }
    private boolean isLeaf(int pos){
        if(pos> size/2 && pos<=size) return true;
        return false;
    }
    private int leftNodeIndex(int parent){
        return parent*2;
    }
    private int rightNodeIndex(int parent){
        return parent*2+1;
    }
    private void swap(int fpos, int spos)
    {
 
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos)
    {
        if(!isLeaf(pos)){
            if(heap[pos]>heap[leftNodeIndex(pos)] || heap[pos]>heap[rightNodeIndex(pos)]){
                if(heap[leftNodeIndex(pos)]<heap[rightNodeIndex(pos)] ){
                    swap(leftNodeIndex(pos),heap[pos]);
                    minHeapify(leftNodeIndex(pos));
                }else{
                    swap(rightNodeIndex(pos),heap[pos]);
                    minHeapify(rightNodeIndex(pos));
                }
            }
        }
    }
    // time complexity : NLogN
    public void insert(int element){
        if(size>= maxSize){
            return;
        }
        heap[++size]= element;
        int current = size;
        while (heap[current] < heap[Parent(current)]) {
            swap(current, Parent(current));
            current = Parent(current);
        }
    }
    // time complexity : NlogN
    public int delete(){
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
 
        return popped;
    }
    // time complexity : 1
    public int min(){
        return heap[FRONT];
    }
    public boolean isEmpty(){
        return size ==0;

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
    public static void main(String[] arg)
    {
 
        // Display message
        System.out.println("The Min Heap is ");
 
        // Creating object opf class in main() methodn
        minHeap minHeap = new minHeap(15);
 
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
                           + minHeap.delete());
    }


}
