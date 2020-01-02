// Time Complexity : Not sure
// Space Complexity : Not sure
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : Did not attempt myself.

public class MinHeap {
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
			System.out.print(Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

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