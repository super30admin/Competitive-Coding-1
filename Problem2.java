// TC: print() - O(1)
// TC: remove() - O(logn)
// TC: Insert() - O(logn)

// SC: O(1)

// Java Program to Implement Heaps
// by Illustrating Min Heap

// Main class (MinHeap)
class GFG {

	// Member variables of this class
	private int[] Heap;
	private int size;
	private int maxsize;

	// Initializing front as static with unity
	private static final int FRONT = 1;

	// Constructor of this class
	public GFG(int maxsize)
	{

		// This keyword refers to current object itself
		this.maxsize = maxsize;
		this.size = 0;

		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	// Method 1
	// Returning the position of
	// the parent for the node currently
	// at pos
	private int parent(int pos) { return pos / 2; }

	// Method 2
	// Returning the position of the
	// left child for the node currently at pos
	private int leftChild(int pos) { return (2 * pos); }

	// Method 3
	// Returning the position of
	// the right child for the node currently
	// at pos
	private int rightChild(int pos)
	{
		return (2 * pos) + 1;
	}

	// Method 4
	// Returning true if the passed
	// node is a leaf node
	private boolean isLeaf(int pos)
	{

		if (pos > (size / 2)) {
			return true;
		}

		return false;
	}

	// Method 5
	// To swap two nodes of the heap
	private void swap(int fpos, int spos)
	{

		int tmp;
		tmp = Heap[fpos];

		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Method 6
	// To heapify the node at pos
private void minHeapify(int pos)
{
	if(!isLeaf(pos)){

	//swap with the minimum of the two children
	int swapPos = Heap[leftChild(pos)]<Heap[rightChild(pos)]?leftChild(pos):rightChild(pos);

	if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]){
		swap(pos,swapPos);
		minHeapify(swapPos);
	}

	}
}

	// Method 7
	// To insert a node into the heap
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

	// Method 8
	// To print the contents of the heap
	public void print()
	{
		for (int i = 1; i <= size / 2; i++) {

			// Printing the parent and both childrens
			System.out.print(
				" PARENT : " + Heap[i]
				+ " LEFT CHILD : " + Heap[2 * i]
				+ " RIGHT CHILD :" + Heap[2 * i + 1]);

			// By here new line is required
			System.out.println();
		}
	}

	// Method 9
	// To remove and return the minimum
	// element from the heap
	public int remove()
	{

		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);

		return popped;
	}
