
// Java implementation of Min Heap 
public class MinHeap { 
	private int[] Heap; 
	private int size; 
	private int maxsize; 

	private static final int FRONT = 1; 

	public MinHeap(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MIN_VALUE; 
	} 

	
	private int parent(int position) 
	{ 
		return position / 2; 
	} 

	
	private int leftChild(int position) 
	{ 
		return (2 * position); 
	} 

	//return the positionition of 
	// the right child for the node currently 
	// at positionition
	private int rightChild(int position) 
	{ 
		return (2 * position) + 1; 
	} 

	// returns true if the passed 
	// node is a leaf node 
	private boolean isLeaf(int position) 
	{ 
		if (position >= (size / 2) && position <= size) { 
			return true; 
		} 
		return false; 
	} 

	// swap two nodes of the heap 
	private void swap(int fposition, int sposition) 
	{ 
		int tmp; 
		tmp = Heap[fposition]; 
		Heap[fposition] = Heap[sposition]; 
		Heap[sposition] = tmp; 
	} 

	// heapify the node at position 
	private void minHeapify(int position) 
	{ 

		// If the node is a non-leaf node and greater 
		// than any of its child 
		if (!isLeaf(position)) { 
			if (Heap[position] > Heap[leftChild(position)] 
				|| Heap[position] > Heap[rightChild(position)]) { 

				// Swap with the left child and heapify 
				// the left child 
				if (Heap[leftChild(position)] < Heap[rightChild(position)]) { 
					swap(position, leftChild(position)); 
					minHeapify(leftChild(position)); 
				} 

				// Swap with the right child and heapify 
				// the right child 
				else { 
					swap(position, rightChild(position)); 
					minHeapify(rightChild(position)); 
				} 
			} 
		} 
	} 

	// insert a node into the heap 
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


	// min heap using 
	// the minHeapify 
	public void minHeap() 
	{ 
		for (int position = (size / 2); position >= 1; position--) { 
			minHeapify(position); 
		} 
	} 

	//EaxctMin and return the minimum 
	// element from the heap 
	public int EaxctMin() 
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
		MinHeap minHeap = new MinHeap(15); 
		minHeap.insert(1); 
		minHeap.insert(15); 
		minHeap.insert(2); 
		minHeap.insert(10);	 
		minHeap.insert(9); 
		minHeap.minHeap(); 
		minHeap.print(); 
		System.out.println("The Min val is " + minHeap.EaxctMin()); 
	} 
} 