package goLeets;

public class minheap { 
	private int[] Heap; // declare a heap array
	private int size;  // declare a size variable 
	private int maxsize; // declare a maxsize

	private static final int FRONT = 1; 

	public minheap(int maxsize) 
	{ 
		this.maxsize = maxsize; // set the maxsize 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MIN_VALUE;  // constant min value
	} 

	// returns the position of the parent node
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	// Left child postion calculation formula  
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

	// Right child position calculation formula 
 

	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 


	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

	// using a temp variable swap two nodes
	private void swap(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = tmp; 
	} 

	// Function to heapify the node at pos 
	private void minHeapify(int pos) 
	{ 

		
		if (!isLeaf(pos)) { 
			if (Heap[pos] > Heap[leftChild(pos)] 
				|| Heap[pos] > Heap[rightChild(pos)]) { 

				// Swap with the left child and heapify 
				// the left child 
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				} 

				// Swap with the right child and heapify 
				// the right child 
				else { 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 

	// insertion operation
	public void insert(int element) 
	{ 
		if (size >= maxsize) { 
			return; 
		} 
		Heap[++size] = element; 
		int current = size; 

		while (Heap[current] < Heap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	// Heap is printed
	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] 
							+ " LEFT CHILD : " + Heap[2 * i] 
							+ " RIGHT CHILD :" + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	// Function to build the min heap using 
	// the minHeapify 
	public void minHeap() 
	{ 
		for (int pos = (size / 2); pos >= 1; pos--) { 
			minHeapify(pos); 
		} 
	} 

	// Function to remove and return the minimum 
	// element from the heap 
	public int remove() 
	{ 
		int popped = Heap[FRONT]; 
		Heap[FRONT] = Heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	} 

	// Driver code 
	public static void main(String[] arg) 
	{ 
		System.out.println("The Min Heap is "); 
		minheap minHeap = new minheap(15); 
		minHeap.insert(5); 
		minHeap.insert(3); 
		minHeap.insert(17); 
		minHeap.insert(10); 
		minHeap.insert(84); 
		minHeap.insert(19); 
		minHeap.insert(6); 
		minHeap.insert(22); 
		minHeap.insert(9); 
		minHeap.minHeap(); 

		minHeap.print(); 
		System.out.println("The Min val is " + minHeap.remove()); 
	} 
} 

