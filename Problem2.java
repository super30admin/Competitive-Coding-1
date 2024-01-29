// Min heap

class Problem2 {
    private int size;
    private int capacity;
    private int storage[];

    public Problem2(){
        size=0;
        capacity=1000;
        // We will insert the first element at ind 1
        storage=new int[capacity+1];
    }

    public int getParent(int pos){
        return pos/2;
    }

    public int getLeftChild(int pos){
        int leftChildInd=2*pos;
        // Check if out of bounds
        if(leftChildInd>this.size)  return -1;
        return leftChildInd;
    }

    public int getRightChild(int pos){
        int rightChildInd=2*pos;
        // Check if out of bounds
        if(rightChildInd>this.size)  return -1;
        return rightChildInd;
    }

    public boolean isLeafNode(int pos){
        return pos>this.size/2 && pos<=this.size;
    }

    public int getSize(){
        return this.size;
    }

    public void print(){
        for(int i=0;i<this.size;i++){
            System.out.print(this.storage[i+1]+"->");
        }
        System.out.println();
    }

    public int peek(){
        return storage[1];
    }

    // Helper method to swap positions in heap, used by add and remove
    private void swap(int a, int b){
        int temp=this.storage[a];
        this.storage[a]=this.storage[b];
        this.storage[b]=temp;
    }

    public void add(int val){
        if(this.size>=this.capacity){
            System.out.println("Element not added");
            return;
        }

        this.size=this.size+1;
        int currInd=this.size;
        this.storage[currInd]=val;

        int parentInd=this.getParent(currInd);
        while(storage[parentInd]>storage[currInd] && parentInd!=currInd){
            // swap values at parent index
            this.swap(parentInd, currInd);
            currInd=parentInd;
            parentInd=this.getParent(currInd);
        }
    }

    // Helper function to get the child index of a node with lower value, used by heapify operation
    private int getMinChildIndex(int pos){
        int left=this.getLeftChild(pos);
        int right=this.getRightChild(pos);

        if(left==-1 && right==-1)   return -1;
        if(left==-1)    return right;
        if(right==-1)   return left;

        if(this.storage[left]<this.storage[right])  return left;
        return right;
    }

    private void heapify(){
        // Heapify operation starts at the first ind
        if(this.size==0)    return;

        int currInd=1;
        int minChildInd=this.getMinChildIndex(currInd);

        while(currInd<=size && (minChildInd!=-1) && this.storage[currInd]>this.storage[minChildInd]){
            this.swap(currInd, minChildInd);
            currInd=minChildInd;
            minChildInd=this.getMinChildIndex(currInd);
        }
    }

    public int remove(){
        if(this.size==0){
            System.out.println("Heap Empty");
            return -1;
        }

        int min=this.storage[1];
        int lastInd=this.size;
        this.storage[1]=this.storage[lastInd];
        this.size=this.size-1;
        this.heapify();

        return min;
    }

    public static void main(String[] arg)
    {
 
        // Display message
        System.out.println("The Min Heap is ");
 
        // Creating object of class in main() method
        Problem2 minHeap = new Problem2();
 
        // Inserting element to minHeap
        // using add() method
 
        // Custom input entries
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);
 
        // Print all elements of the heap
        minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                           + minHeap.remove());
    }
}
