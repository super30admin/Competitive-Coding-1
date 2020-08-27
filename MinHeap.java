
//TC: O(logN) insertion, deletion since the height of the tree is logN
// SC: O(N) where N represents the number of elements in the array and the complexity since we are using array of N size.

class MinHeap {
	
	private int maxsize;
	private int[] Heap;
	private int size;
	
	private static final int FRONT = 1;
	MinHeap(int maxsize){
		this.maxsize = maxsize;
		this.size=0;
		Heap = new int[maxsize+1];
		Heap[0] = Integer.MIN_VALUE;
	}
	public  int parent(int pos) {
		return pos/2;
	}
	
	public int leftChild(int pos) {
		return 2*pos;
	}
	
	public int rightChild(int pos) {
		return 2*pos+1;
	}
	
	public void swap(int parent, int  child) {
		
		int temp = Heap[parent];
		Heap[parent] = Heap[child];
		Heap[child] = temp;
	}
	
	public boolean isleaf(int pos) {
		
		if(pos>=(size/2) && pos<size) {
			return true;
		}
		return false;
		
	}

	public void minHeapify(int pos) {
		
		if(!isleaf(pos)) {
			
			if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos] >Heap[rightChild(pos)]) {
				if(Heap[leftChild(pos)]<Heap[rightChild(pos)]){
					swap(leftChild(pos), pos);
					minHeapify(leftChild(pos));
				}
				else {
					swap(rightChild(pos), pos);
					minHeapify(rightChild(pos));
				}
			}
		}
		
	}
	
	public void insert(int element) {
		
		if(size>=maxsize)
			return;
		Heap[++size] = element;
		int curr = size;
		
		while(Heap[curr]<Heap[parent(curr)]) {
			swap(curr, parent(curr));
			curr = parent(curr);
		}
	}
	void print() {
		
		for(int i=1;i<=size/2;i++) {
			System.out.print("Parent: "+Heap[i]+" Left Child: "+Heap[2*i]+" Right Child "+Heap[2*i+1]);
			System.out.println();
		}
	}
	public void minheap() {
		
		for(int pos=size/2;pos>=1;pos--) {
			minHeapify(pos);
		}
	}
	
	public int remove() {
		
		int removed = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return removed;
		
	}
	
	public static void main(String[] args) {
		
		 System.out.println("The Min Heap is "); 
	        MinHeap minHeap = new MinHeap(15); 
	        minHeap.insert(5); 
	        minHeap.insert(3); 
	        minHeap.insert(17); 
	        minHeap.insert(10); 
	        minHeap.insert(84); 
	        minHeap.insert(19); 
	        minHeap.insert(6); 
	        minHeap.insert(22); 
	        minHeap.insert(9); 
	        minHeap.minheap(); 
	  
	        minHeap.print(); 
	        System.out.println("The Min val is " + minHeap.remove());
	}
}