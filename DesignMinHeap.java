// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed some time to understand heapify method
// Problem Statement: Implement Min Heap


class DesignMinHeap{
    int maxsize;
    int size;
    int[] heap;
    
    public DesignMinHeap(int maxsize) {
	this.maxsize=maxsize;
	size=-1;
	heap=new int[maxsize];
    }
    
    private int parent(int pos) {
	if(pos==0) {
	    return 0;
	}
	return (pos-1)/2;
    }
    
    private int leftChild(int pos) {
	return 2*pos +1;
    }
    
    private int rightChild(int pos){
	return 2*pos +2;
    }
    private boolean isLeaf(int pos) {
	if(pos>=(size/2)) {
	    return true;
	}
	return false;
    }
    
    private void swap(int fpos, int spos) {
	int tmp=heap[fpos];
	heap[fpos]=heap[spos];
	heap[spos]=tmp;
    }
    
    private void heapify(int pos){	 
    	int current=heap[pos];

    	if(rightChild(pos)<=size && current>heap[rightChild(pos)] && heap[leftChild(pos)]>heap[rightChild(pos)]) {
    	    swap(pos,rightChild(pos));
    	    heapify(rightChild(pos));
    	}else if(leftChild(pos)<size && current>heap[leftChild(pos)]){
    	    swap(pos,leftChild(pos));
    	    heapify(leftChild(pos));
    	}
    }
    
    public void insert(int element){
	size++;
	if(size>=maxsize) {
	    System.out.println("max size achieved");
	    return;
	}
	int current=size;
	heap[current]=element;
	while(heap[current]<heap[parent(current)]) {
	    swap(current,parent(current));
	    current=parent(current);
	}
    }
    
    public int remove() {
	int popped=heap[0];
	//System.out.println("removed "+popped);
	heap[0]=heap[size];
	size--;
	heapify(0);
	return popped;
    }
    
    public void print() {
	for(int i=0;i<=(size-1)/2;i++) {
	    System.out.print("parent: "+heap[i]);
	    if(leftChild(i)<=size) {
		System.out.print(" left child "+heap[leftChild(i)]);
	    }
	    if(rightChild(i)<=size) {
		System.out.print(" right child "+heap[rightChild(i)]);
	    }
	    System.out.println();
	}
    }
    
 // Main driver method
 	public static void main(String[] arg)
 	{

 		// Display message
 		System.out.println("The Min Heap is ");

 		// Creating object of class in main() method
 		DesignMinHeap minHeap = new DesignMinHeap(15);

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
 		System.out.println("The Min val is "+ minHeap.remove());
 		minHeap.print();
 		System.out.println("The Min val is "+ minHeap.remove());
 		minHeap.print();
 		System.out.println("The Min val is "+ minHeap.remove());
 		minHeap.print();
 		System.out.println("The Min val is "+ minHeap.remove());
 		minHeap.print();
 		System.out.println("The Min val is "+ minHeap.remove());
 		minHeap.print();
 		
 	}
    
}
