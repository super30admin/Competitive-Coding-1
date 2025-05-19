//Time Complexity for different operations
// --getMin():  O(1).
//--extractMin(): O(Log n)
//--insert():  O(Log n)

//Space Complexity : O(1)

class Problem2{
  private int[] Heap;
	private int size;
	private int maxsize;
	private static final int FRONT = 1;

	public Problem2(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	private int parent(int position) {
		return position / 2;
	}

	private int leftChild(int position) {
		return (2 * position);
	}

	private int rightChild(int position) {
		return (2 * position) + 1;
	}

	private boolean isLeaf(int position) {
		if (position > (size / 2)) {
			return true;
		}
		return false;
	}

	private void swap(int firstPosition, int swaoPosition) {
		int tmp;
		tmp = Heap[firstPosition];

		Heap[firstPosition] = Heap[swaoPosition];
		Heap[swaoPosition] = tmp;
	}

	private void minHeapify(int position) {
		if (!isLeaf(position)) {
			int swapPos = position;

			if (rightChild(position) <= size) {
				swapPos = Heap[leftChild(position)] < Heap[rightChild(position)] ? leftChild(position)
						: rightChild(position);
			} else {
				swapPos = leftChild(position);
			}

			if (Heap[position] > Heap[leftChild(position)] || Heap[position] > Heap[rightChild(position)]) {
				swap(position, swapPos);
				minHeapify(swapPos);
			}
		}
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

	public int remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);

		return popped;
	}
}
