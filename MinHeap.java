// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no


/**
 * 1. Create a complete binary tree.
 * 2. min heap should have root is less than left and right.
 * 3. on insert insert at the leaf level land swap with parent if needed.
 * 4.  
 */

public class MinHeap {
	private int[] data;
	private int curPos;
	private int capacity;
	private int minIndex = 1;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.curPos = 0;
		data = new int[capacity + 1];
		data[0] = Integer.MIN_VALUE;
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

	private boolean isLeaf(int pos) {
		if (pos >= (curPos / 2) && pos <= curPos) {
			return true;
		}
		return false;
	}

	private void swap(int pos1, int pos2) {
		int tmp;
		tmp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = tmp;
	}

	private void minHeapify(int pos) {

		if (!isLeaf(pos) && (data[pos] > data[leftChild(pos)] || data[pos] > data[rightChild(pos)])) {

			if (data[leftChild(pos)] < data[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}

			else {
				swap(pos, rightChild(pos));
				minHeapify(rightChild(pos));
			}
		}
	}

	public void insert(int element) {
		if (curPos >= capacity) {
			return;
		}
		data[++curPos] = element;
		int current = curPos;

		while (data[current] < data[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= curPos / 2; i++) {
			System.out.println(" root: " + data[i] + " left: " + leftChild(i) + " right: " + rightChild(i));
		}
	}

	public void minHeap() {
		for (int pos = (curPos / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = data[minIndex];
		data[minIndex] = data[curPos--];
		minHeapify(minIndex);
		return popped;
	}

	public static void main(String[] arg) {
		MinHeap minHeap = new MinHeap(20);
		minHeap.insert(8);
		minHeap.insert(5);
		minHeap.insert(11);
		minHeap.insert(2);
		minHeap.insert(2);
		minHeap.insert(19);
		minHeap.insert(26);
		minHeap.insert(6);
		minHeap.insert(3);
		minHeap.insert(1);
		minHeap.minHeap();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());
		minHeap.print();
	}
}
