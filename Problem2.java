//Min Heap
//Time Complexity : O(logn) for insertion and removal; O(1) for getMin
//Space Complexity : O(1), Maximum size set to 15


class MinHeap{
    int [] Heap;
    int maximumsize;
    int size;
    
    private static final int FRONT = 1;
    
    MinHeap(int maximumsize) {
        this.maximumsize = maximumsize;
        this.size = 0;
        Heap = new int[this.maximumsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
    
    private int parent (int position) {
        return position/2;
    }
    
    private int leftChild (int position) {
        return (2*position);
    }

    private int rightChild (int position) {
        return (2*position + 1);
    }
    
    private boolean isLeaf (int position) {
        if(position >= size/2 && position < maximumsize) return true;
        return false;
    }
    
    private void swap (int pos1, int pos2) {
        int temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
    }
    
    
    private void heapify (int pos) {
        if(!isLeaf(pos)){
            if(Heap[pos] > Heap[rightChild(pos)] ||
            Heap[pos] > Heap[leftChild(pos)] ) {
                
                if(Heap[rightChild(pos)] < Heap[leftChild(pos)] ) {
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
                else {
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                }
            }
        }
        
    }
    
    
    public void insert (int value) {
        if(size >= maximumsize) return;
        Heap[++size] = value;
        int cur = size;
        
        while (Heap[cur] < Heap[parent(cur)]) {
            swap(cur,parent(cur));
            cur = parent(cur);
        }
    }
    
    public int remove () {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        heapify(FRONT);
        return popped;
    }
    
    public int minValue () {
        int popped = Heap[FRONT];
        return popped;
        
    }
    
    public void print () {
        for(int i = 1; i <= size/2; i++) {
            System.out.print("Parent : " +Heap[i]+" Left Child : "+Heap[2*i]+" Right Child : "+Heap[2*i + 1]);
            System.out.println();
        }
    }
    
    public static void main (String[] args) {
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(6); 
        minHeap.insert(4); 
        minHeap.print(); 
        System.out.println("The Minimum value is " + minHeap.minValue());
        minHeap.insert(9); 
        minHeap.insert(3); 
        minHeap.insert(12);
        minHeap.print(); 
        System.out.println("The Minimum value is " + minHeap.minValue());
        System.out.println("Removed value is " + minHeap.remove());
        minHeap.insert(8);
        minHeap.print(); 
        System.out.println("The Minimum value is " + minHeap.minValue());
        minHeap.insert(2);
        minHeap.insert(7); 
        minHeap.print(); 
        System.out.println("The Minimum value is " + minHeap.minValue());
        System.out.println("Removed value is " + minHeap.remove());
        
    }
}