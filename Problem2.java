// Time complexity:O(log n)
// Space complexity: O(1)



class minheap{
    private int[] Heap;
    private int size;
    private int capasity;
    private static final int FRONT=1;

    public max(int capasity){
        this.capasity=capasity;
        this.size=0;

        Heap = new int[this.capasity +1];
        Heap[0]=Integer.MIN_VALUE;

    }

    private int parent(int pos){ return pos/2;}

    private int leftchild(int pos){return(pos*2);}
    private int rightchild(int pos){return(pos*2) +1;}

    private boolean isLeaf(int pos){
        if(pos>(size/2)){
            return true;
        }
        return false;
    }

    private void swap(int p1, int p2){
        int temp;
        temp=Heap[p1];
        Heap[p1]=Heap[p2];
        Heap[p2]=temp;
    }
    
    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            int swapPos= pos;
            if(rightchild(pos)<=size)
          swapPos = Heap[leftchild(pos)]<Heap[rightchild(pos)]?leftchild(pos):rightchild(pos);
       else
         swapPos= leftchild(pos);
        
       if(Heap[pos]>Heap[leftchild(pos)] || Heap[pos]> Heap[rightchild(pos)]){
         swap(pos,swapPos);
         minHeapify(swapPos);
       }
        
     }
    }
    public void insert(int element)
    {
 
        if (size >= capasity) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int remove()
    {
 
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return popped;
    }

    public static void main(String[] args) {
        
        minheap a = new minheap(15);
        a.insert(5);
        a.insert(3);
        a.insert(17);
        a.insert(10);
        a.insert(84);
        a.insert(19);
        a.insert(6);
        a.insert(22);
        a.insert(9);
    }
}