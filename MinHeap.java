//Time Complexity
getMin() - O(1)
extractMin() - O(log(n))
insert() - O(log(n))

//Space Complexity - O(n)

public class MinHeap {
	int capacity;
	Integer[] li;
	int index;

	public MinHeap() {
		capacity = 10;
		li = new Integer[capacity];
		index = 0;
	}

	private int getMin() {
		return li[0];
	}

	private void extractMin() {
		li[0] = li[index - 1];
		li[index - 1] = null;
		perculateDown(0);
	}

	private boolean insert(int x) {
		li[index++] = x;
		int child = index - 1;
		int parent = child / 2;
		perculateUp(parent, child);
		return true;
	}

	private void perculateUp(int parent, int child) {
		while (li[parent] > li[child] && parent >= 0) {
			int temp = li[parent];
			li[parent] = li[child];
			li[child] = temp;
			child = parent;
			parent = child / 2;
		}
	}

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

			swap(parent, index);

			if (li[parent + 1] < li[parent]) {
				swap(parent, parent + 1);
			}

			parent = index;
			left = (2 * parent) + 1;
			right = left + 1;
		}

		if (li[parent + 1] < li[parent]) {
			swap(parent, parent + 1);
		}
	}

	private void swap(int i, int j) {
		int temp = li[i];
		li[i] = li[j];
		li[j] = temp;
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
	}
}


