/*
    Design Min Heap Implementation using Array
*/

class MinHeap {

    int[] Heap;
    int size;
    int maxSize;
    int front = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
 
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    public int parent(int index) {
        return index / 2;
    }

    public int leftChild(int index){
        return 2 * index;
    }

    public int rightChild(int index) {
        return (2 * index) + 1;
    }

    public boolean isLeaf(int index) {
        if(index > size/2 && index <= size) {
            return true;
        }
        return false;
    }

    public void print() {
        for(int i=1; i<=size/2; i++) {
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]);
 
            System.out.println();
        }
    }

    public void swap(int first, int second) {
        int temp = Heap[first];

        Heap[first] = Heap[second];
        Heap[second] = temp;
    }

    public void add(int value) {
        if(size >= maxSize) {
            return;
        }

        Heap[++size] = value;
        int current  = size;
        
        while(Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void minHeapify(int pos) {      
     if(!isLeaf(pos)){
       int swapPos= pos;

       if(rightChild(pos)<=size)
          swapPos = Heap[leftChild(pos)]<Heap[rightChild(pos)]?leftChild(pos):rightChild(pos);
       else
         swapPos= leftChild(pos);
        
       if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]){
         swap(pos,swapPos);
         minHeapify(swapPos);
       }
        
     }       
    }

    public int remove() {
        int popped = Heap[front];
        Heap[front] = Heap[size--];
        minHeapify(front);
 
        return popped;
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");

        MinHeap minHeap = new MinHeap(15);

        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);
 
        minHeap.print();
 
        System.out.println("The Min val is "
                           + minHeap.remove());
    }
}
