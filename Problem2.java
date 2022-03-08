class MinHeap {
 
    // Member variables of this class
    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 0;
 
    // Constructor of this class
    public MinHeap(int maxSize)
    {
        this.heap=new int[maxSize];   
        this.maxSize=maxSize;
        this.size=0;
    }
 

    private int parent(int pos) { return (pos-1)/2;}

    private int leftChild(int pos) {  return 2*pos+1; }
 

    private int rightChild(int pos)
    {
        return 2*pos +2;
    }
 

    private boolean isLeaf(int pos)
    {
        return (pos>= size/2) && (pos<size);
        
    }
 

    private void swap(int fpos, int spos)
    {
        int temp= heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos]=temp;

    }
 
 
    private void minHeapify(int pos)
    {
       if(!isLeaf(pos)){
        if((heap[pos]>heap[leftChild(pos)] ||heap[pos]>heap[rightChild(pos)] )){
            if(heap[rightChild(pos)]>heap[leftChild(pos)]){
                swap(leftChild(pos),pos);
                minHeapify(leftChild(pos));
            }
           else{
                swap(rightChild(pos),pos);
                minHeapify(rightChild(pos));
            }
        }
       }  
    }
 

    public void insert(int element)
    {
       if(size>=maxSize)
        return;
        else{
            heap[size]=element;
            int curr =size;
           while(heap[curr]<heap[parent(curr)]){
            swap(curr,parent(curr));
            curr=parent(curr);
        }  
		size+=1;
	}  
    }
    public int extractMin()
    {
      int min = heap[FRONT];
      heap[FRONT]=heap[--size];
      
    	minHeapify(FRONT);
       return min;
    }
    
    public int getMin(){
        return heap[FRONT];
    }
    public void print()
    {
        for (int i = 0; i <size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i+1]
                + " RIGHT CHILD :" + heap[2 * i + 2]);
 
            // By here new line is required
            System.out.println();
        }
    }



    public static void main(String[] arg)
    {
 
        // Display message
        System.out.println("The Min Heap is ");
 
        // Creating object opf class in main() methodn
        MinHeap minHeap = new MinHeap(15);
 
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
                           + minHeap.getMin());
        System.out.println("Extracted Min is "
                           + minHeap.extractMin());
        System.out.println("Extracted Min is "
                           + minHeap.extractMin());
		System.out.println("Extracted Min is "
                           + minHeap.extractMin());
    }
}