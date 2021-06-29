// Time Complexity : Insert -> O(log n), getMin -> O91), extractMin -> O(log n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//MinHeap
public class Problem2 {
	int[] heap;
	int capacity;
	int curSize;

	public Problem2(int capacity) {
		this.heap = new int[capacity + 1];
		this.capacity = capacity;
		this.curSize = 0;
		heap[0] = Integer.MIN_VALUE;
	}

	// Return root of heap
	private int getMin() {
		return heap[1];
	}

	// Satisfy the heap properties
	private void heapify(int pos) {
		if (pos >= capacity / 2 && pos <= capacity) {
			System.out.println("The element at position " + pos + " is a leaf node.");
			return;
		}

		int leftChildPos = 2 * pos;
		int rightChildPos = 2 * pos + 1;

		if (heap[pos] > heap[leftChildPos] || heap[pos] > heap[rightChildPos]) {
			if (heap[leftChildPos] < heap[rightChildPos]) {
				swap(pos, leftChildPos);
				heapify(leftChildPos);
			} else {
				swap(pos, rightChildPos);
				heapify(rightChildPos);
			}

		}
	}

	private void swap(int src, int dest) {
		heap[dest] = heap[src] + heap[dest];
		heap[src] = heap[dest] - heap[src];
		heap[dest] = heap[dest] - heap[src];
	}

	private int extractMin() {
		if (curSize == 0) {
			System.out.println("The heap is already empty.");
			return -1;
		}
		// Swap the first element with the last element. Remove the last element
		int min = this.getMin();
		heap[1] = heap[curSize--];
		// Percolate downwards, until all heap properties are satisfied.
		heapify(1);
		return min;
	}

	private void insert(int element) {
		if (curSize >= capacity) {
			System.out.println("Maximum number of elements have already been inserted.");
			return;
		}
		heap[++curSize] = element;
		// Percolate upwards, until all heap properties are satisfied.
		int curNodePos = curSize;
		while (heap[curNodePos] < heap[curNodePos / 2]) {
			swap(curNodePos, curNodePos / 2);
			curNodePos = curNodePos / 2;
		}
	}

	public void print() {
		for (int i = 1; i <= curSize; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("The Min Heap is ");
		Problem2 minHeap = new Problem2(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);

		minHeap.print();
		System.out.println("Removing the min val from the heap. The Min val is " + minHeap.extractMin());
		System.out.println("The Min Heap after removing the min val is ");
		minHeap.print();
	}
}
