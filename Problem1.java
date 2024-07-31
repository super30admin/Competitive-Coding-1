public class Problem1{
    private int size,maxSize;
    private int[] Heap;
    private static final int a=1;
    public Problem1(int maxSize){
        this.size=0;
        this.maxSize=maxSize;
        Heap=new int[this.maxSize+1];
        Heap[0]=Integer.MIN_VALUE;
    }
    private int parent(int idx){
        return idx/2;
    }
    private int leftChild(int idx){
        return (2*idx);
    }
    private int rightChild(int idx){
        return (2*idx)+1;
    }
    private boolean isLeafNode(int idx){
        if(idx>(size/2))
            return true;
        return false;
    }
    private void swap(int a, int b){
        int temp=Heap[a];
        Heap[a]=Heap[b];
        Heap[b]=temp;
    }
    private void minHeapify(int idx){
    if(!isLeafNode(idx)){
        int temppos=idx;
        if(rightChild(idx)<=size)
        temppos=leftChild(idx)<rightChild(idx)?leftChild(idx):rightChild(idx);
        temppos=leftChild(idx);
        if(Heap[idx]>Heap[leftChild(idx)]||Heap[idx]>Heap[rightChild(idx)]){
            swap(idx,temppos);
            minHeapify(idx);
        }
    }
    }
    private void insert(int element){
        if(size>=maxSize)
        return;
        Heap[++size]=element;
        int curr=size;
        while(Heap[curr]>parent(curr)){
            swap(curr,parent(curr));
            curr=parent(curr);
        }
    }
    public int remove(){//O(log N)
        int pops=Heap[a];
        Heap[a]=Heap[size--];
        minHeapify(a);
        return pops;
    }
    public static void main(String[] args){
        Problem1 minHeap=new Problem1(12);

        minHeap.insert(3);
        minHeap.insert(23);
        minHeap.insert(12);
        minHeap.insert(121);
        minHeap.insert(82);
        minHeap.insert(19);
        minHeap.insert(63);
        minHeap.insert(13);
        minHeap.insert(15);

        minHeap.display();
    }
    private void display(){
            for(int i=0;i<=size/2;i++){
                System.out.println(Heap[i]+"     "+Heap[2*i]+"    "+Heap[(2*i)+1]);
            }
    }
}
