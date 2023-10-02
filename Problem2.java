
class Minheap{
    private int size;
    private int capacity;
    private int[] heap;
    private int front;
    Minheap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
        front = 1;
        heap[0] = Integer.MIN_VALUE;
    }
    public int parent(int pos){
        return pos/2;
    }
    public int leftchild(int pos){
        return 2*pos;
    }
    public int rightchild(int pos){
        return 2*pos+1;
    }
    public boolean isleaf(int pos){
        if(pos > size/2 && pos <= size)
            return true;
        return false;
    }
    public void swap(int[] arr,int pos1,int pos2){
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }
    public void heapify(int pos){
        if(!isleaf(pos)){
            int swp = pos;
            if(rightchild(pos)<=size)
                swp = (heap[leftchild(pos)] < heap[rightchild(pos)]) ? leftchild(pos) : rightchild(pos);
            else
                swp = leftchild(pos);
            if(heap[pos] > heap[leftchild(pos)] || heap[pos] > heap[rightchild(pos)])
                swap(heap,pos,swp);
            heapify(swp);
        }
    }
    public void add(int ele){
        heap[++size] = ele;
        int pos = size;
        while(heap[pos] < heap[parent(pos)]){
            swap(heap,pos,parent(pos));
            pos = parent(pos);
        }
    }
    public int remove(){
        int res = heap[front];
        heap[front] = heap[size--];
        heapify(front);
        return res;

    }
    public void print(){
        for(int i = 1; i <= size/2; i++){
            System.out.println(heap[i]);
        }
    }
  
}