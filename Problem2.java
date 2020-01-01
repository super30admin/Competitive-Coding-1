

// Time Complexity : O(1) for GetMin,,O(Log N) for Insert,ExtracMin
// Space Complexity : O(N) for all operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
A  min heap is complete binary tree in which root node is smaller than its children.
For any operation that violates this principle,we heapify the tree i.e arranging or swaping the nodes 
until the principle is upheld.Min Heap has got applications in find Nth Largest/Smallest Items
in Array of Infinite Stream
*/ 

class MinHeap {

	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int TOP = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	private void swap(int i, int j) {
		int tmp;
		tmp = Heap[i];
		Heap[i] = Heap[j];
		Heap[j] = tmp;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	public int getMin() {
		return Heap[TOP];
	}

	private boolean isLeaf(int pos) {
		return pos >= (size / 2) && pos <= size;
	}

	public void insert(int element) {
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

	public void heapify(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					heapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					heapify(rightChild(pos));
				}
			}
		}
	}

	public int extractMin() {
		int popped = Heap[TOP];
		Heap[TOP] = Heap[size--];
		heapify(TOP);
		return popped;

	}

	public void minHeap() {
		int mid = size / 2;
		for (int pos = 1; pos <= mid; pos++) {
			heapify(pos);
		}
	}

	public void print() {
		int mid = size / 2;
		for (int i = 1; i <= mid; i++) {
			System.out.print(
					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	
}

public class Problem2 { 
    public static void main(String[] arg) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(150);

		minHeap.insert(534);
		minHeap.insert(334);
		minHeap.insert(17434);
		minHeap.insert(1340);
		minHeap.insert(83434);
		minHeap.insert(1349);
		minHeap.insert(634);
		minHeap.insert(2234);
		minHeap.insert(934);

		minHeap.insert(934234);

		minHeap.insert(2334);
		minHeap.minHeap();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.extractMin());
	}
}