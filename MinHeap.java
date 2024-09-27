public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap(int maxsize){
        this.maxSize = maxsize;
        int size = 0;
        Heap = new int[this.maxSize+1];
        Heap[0] = Integer.MIN_VALUE;
    }
    private int getParent(int pos){
        return pos/2;
    }
    private int getLeftChild(int pos){
        return 2*pos;
    }
    private int getRightChild(int pos){
        return 2*pos+1;
    }
    private boolean isLeaf(int pos){
        return pos > this.size/2 && pos <= this.size;
    }
    private void swap(int iPos,int jPos){
        int temp = Heap[iPos];
        Heap[iPos] = Heap[jPos];
        Heap[jPos] = temp;
    }
    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            if(Heap[pos] > Heap[getLeftChild(pos)] || Heap[pos] > Heap[getRightChild(pos)]){
                if(Heap[getLeftChild(pos)] < Heap[getRightChild(pos)]){
                    swap(pos,getLeftChild(pos));
                    minHeapify(getLeftChild(pos));
                }else{
                    swap(pos,getRightChild(pos));
                    minHeapify(getRightChild(pos));
                }
            }
        }
    }

    public void insert(int element){
        if(this.size >= this.maxSize){
            return;
        }
        Heap[++this.size] = element;
        int currentIndex = this.size;
        while(Heap[currentIndex] < Heap[getParent(currentIndex)]){
            swap(currentIndex,getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int remove(){
        if(this.size == 0){
            System.out.println("Heap is already empty !");
            return -1;
        }
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[this.size--];
        minHeapify(FRONT);
        return popped;
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(9);
        minHeap.insert(12);
        minHeap.insert(7);
        minHeap.insert(13);
        minHeap.print();
        System.out.println(minHeap.remove());
    }
}
