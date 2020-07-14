//Time Complexity
getMin() - O(1)
extractMin() - O(log(n))
insert() - O(log(n))

//Space Complexity - O(n)

package axm180195;

public class MinHeap {
	int capacity; // capacity of minheap
	Integer[] li;
	int index; // index of last element + 1

	public MinHeap() {
		capacity = 10;
		li = new Integer[capacity];
		index = 0;
	}

	private int getMin() {
		return li[0]; // return the top element
	}

	private void extractMin() {
		li[0] = li[index - 1]; // replace last element with top
		if (index - 1 > 0) { // and move it to its correct position
			li[index - 1] = null;
			index--;
			perculateDown(0);
		}
	}

	private boolean insert(int x) {
		if (index >= capacity) // if more than capacity then increase capacity
			remake();
		li[index++] = x;
		int child = index - 1;
		int parent = child / 2;
		perculateUp(parent, child); // moving element up if its smaller
		return true;
	}

	// helper function to move element up if its smaller
	private void perculateUp(int parent, int child) {
		while (li[parent] > li[child] && parent >= 0) {
			int temp = li[parent];
			li[parent] = li[child];
			li[child] = temp;
			child = parent;
			parent = child / 2;
		}
	}

	// helper function to move element up if its larger
	private void perculateDown(int parent) {
		int left = (2 * parent) + 1;
		int right = left + 1;
		while (li[left] != null || li[right] != null) {
			int index;
			if (li[left] != null && li[right] != null)
				index = li[left] < li[right] ? left : right;
			else if (li[left] != null)
				index = left;
			else
				index = right;

			if (li[index] < li[parent]) {
				swap(parent, index);
				parent = index;
				left = (2 * parent) + 1;
				right = left + 1;
			} else
				break;
		}
	}

	// swaps two numbers in array
	private void swap(int i, int j) {
		int temp = li[i];
		li[i] = li[j];
		li[j] = temp;
	}

	// remake the MinHeap with twice capacity
	private void remake() {
		capacity = capacity * 2;
		Integer[] temp = li;
		li = new Integer[capacity];
		for (int i = 0; i < temp.length; i++)
			li[i] = temp[i];
	}

	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.insert(10);
		heap.insert(20);
		heap.insert(1);
		heap.insert(50);
		heap.insert(0);
		System.out.println(heap.getMin());
		heap.extractMin();
		System.out.println(heap.getMin());
		heap.extractMin();
		System.out.println(heap.getMin());
		heap.extractMin();
		System.out.println(heap.getMin());
		heap.extractMin();
		System.out.println(heap.getMin());
	}
}



