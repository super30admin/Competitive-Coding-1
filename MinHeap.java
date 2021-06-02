// Time Complexity : getMin() - O(1), extractMin() - O(log N), insert() - O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

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

	// returns the position of
	// the parent for the node currently
	// at pos
	private int parent(int pos)
	{
		return pos / 2;
	}

	// returns the position of the
	// left child for the node currently at pos
	private int leftChild(int pos)
	{
		return (2 * pos);
	}

	// returns the position of
	// the right child for the node currently
	// at pos
	private int rightChild(int pos)
	{
		return (2 * pos) + 1;
	}

	// returns true if the passed
	// node is a leaf node
	private boolean isLeaf(int pos)
	{
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	// swap two nodes of the heap
	private void swap(int fpos, int spos)
	{
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// heapify the node at pos
	private void minHeapify(int pos)
	{

		// If the node is a non-leaf node and greater
		// than any of its child
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

	// build the min heap using
	// the minHeapify
	public void minHeap()
	{
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	// remove and return the minimum
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
		minHeap.minHeap();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());
	}
}
