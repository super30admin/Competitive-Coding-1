public class MinHeap {

    private int heap[];
    private int size;
    private int maxSize;
    private static int front=1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size=0;
        heap=new int[maxSize+1];
    }

    public int parent(int pos){
        return pos/2;
    }
    public int leftChild(int pos){
        return 2*pos;
    }

    public int rightChild(int pos){
        return 2*pos+1;
    }

    public boolean isLeaf(int pos)
    {
        if(pos>size/2 && pos<=size){
            return true;
        }
        return false;
    }

    public void swap(int first, int second){
        int temp=heap[first];
        heap[first]=heap[second];
        heap[second]=temp;
    }
    public void minHeapify(int pos){

        if(!isLeaf(pos)){
            if(heap[pos]>heap[leftChild(pos)]){
                swap(pos,leftChild(pos));
                minHeapify(leftChild(pos));
            }else if(heap[pos]>heap[rightChild(pos)]){
                swap(pos,rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element){
        if(size>=heap.length){
            return;
        }

        heap[++size]=element;
        int current=size;
        while(heap[current]<heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }

    }
    public int remove(){
        int remove=heap[front];
        heap[front]=heap[size--];
        minHeapify(front);
        return remove;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            System.out.print(" Parent : " + heap[i] + " Left Child : " + heap[2 * i] + " Right Child :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

}

