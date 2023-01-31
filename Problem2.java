// TC mentioned at respective methods
class MinHeap {
	private int[] minHeap;
	private int size;
	private int max;

	private static final int index = 1;
	public MinHeap(int maxsize) {
		this.max = maxsize;
		this.size = 0;
		minHeap = new int[this.max + 1];
		minHeap[0] = Integer.MIN_VALUE;
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
		return (pos > (size / 2));
	}
	private void swap(int p, int c) {
		int temp = minHeap[p];
		minHeap[p] = minHeap[c];
		minHeap[c] = temp;
	}
	
    // TC: O(logN)	
	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			int sp = pos;
			if (rightChild(pos) <= size)
				sp = minHeap[leftChild(pos)] < minHeap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
			else
				sp = minHeap[leftChild(pos)];

			if (minHeap[pos] > minHeap[leftChild(pos)] || minHeap[pos] > minHeap[rightChild(pos)]) {
				swap(pos, sp);
				minHeapify(sp);
			}

		}
	}
	// TC: O(logN)
	public void insert(int element) {
		if (size >= max) {
			return;
		}
		minHeap[++size] = element;
		int current = size;
		while (minHeap[current] < minHeap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
//	TC: O(1)
	public int extractMin() {
		int popped = minHeap[index];
		minHeap[index] = minHeap[size--];
		minHeapify(index);
		return popped;
	}
	public int getMin() {
		if(size != 0)
			return minHeap[1];
		return minHeap[0];
	}
	public static void main(String[] arg) {
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
		System.out.println(minHeap.getMin());
		System.out.println("The Min val is " + minHeap.extractMin());
		System.out.println(minHeap.getMin());
	}
}
