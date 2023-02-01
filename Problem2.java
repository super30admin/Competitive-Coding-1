class Heap{
    int size;
    int maxSize;
    int[] heap;

    private static final int FRONT = 1;
    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MIN_VALUE;
    }

    private void swap(int child, int parent) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    private int parent(int index) { return index / 2; }

    private int leftChild(int index){
        return (2*index);
    }

    private int rightChild(int index) {return (2*index)+1;}

    private void heapify(int index){

        if(!isLeaf(index)){
            int swapPos = index;
            if(rightChild(index)<=size)
                swapPos = heap[leftChild(index)]<heap[rightChild(index)]?leftChild(index):rightChild(index);
            else
                swapPos= heap[leftChild(index)];

            if(heap[index]>heap[leftChild(index)] || heap[index]> heap[rightChild(index)]){
                swap(index,swapPos);
                heapify(swapPos);
            }

        }
    }


    private boolean isLeaf(int index) {

        if (index>(size/2))
            return true;

        return false;
    }

    void insert(int element){
        if (size>=maxSize){
            return;
        }

        heap[++size] = element;
        int curElement = size;

        while (heap[curElement] < heap[parent(curElement)]) {
            swap(curElement, parent(curElement));
            curElement = parent(curElement);
        }
    }


    int extractMin(){
        int element = heap[FRONT];
        heap[FRONT] = heap[size--];
        heapify(FRONT);
        return element;
    }

    void printHeap()
    {
        for (int i = 1; i <= size / 2; i++) {

            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[(2 * i) + 1]);

            // By here new line is required
            System.out.println();
        }
    }


}
public class Problem2 {

    public static void  main(String[] args){

        Heap minHeap = new Heap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.printHeap();

        System.out.println("The Min val is "
                + minHeap.extractMin());
    }
}