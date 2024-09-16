class MinHeapImpl {
	private int[] Heap;
	private int size;
	private int maxsize;
	private static final int head = 1;

	public MinHeapImpl(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}
	private int parent(int i) { 
    return i / 2; 
    }

	private int leftChild(int i) { 
    return (2 * i); 
    }


	private int rightChild(int i)
	{
		return (2 * i) + 1;
	}

	private boolean isLeaf(int i)
	{

		if (i > (size / 2) && i <= size) {
			return true;
		}

		return false;
	}

	private void swap(int a, int b)
	{

		int tmp;
		tmp = Heap[a];
		Heap[a] = Heap[b];
		Heap[b] = tmp;
	}

	private void minHeapify(int i)
	{
		if (!isLeaf(i)) {
			if (Heap[i] > Heap[leftChild(i)]
				|| Heap[i] > Heap[rightChild(i)]) {


				if (Heap[leftChild(i)]
					< Heap[rightChild(i)]) {
					swap(i, leftChild(i));
					minHeapify(leftChild(i));
				}

				else {
					swap(i, rightChild(i));
					minHeapify(rightChild(i));
				}
			}
		}
	}

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

	public void print()
	{
		for (int i = 1; i <= size / 2; i++) {

			System.out.print(
				" PARENT : " + Heap[i]
				+ " LEFT CHILD : " + Heap[2 * i]
				+ " RIGHT CHILD :" + Heap[2 * i + 1]);

			System.out.println();
		}
	}

//O(log(n))
	public int extractMin()
	{

		int min = Heap[head];
		Heap[head] = Heap[size--];
		minHeapify(head);

		return min;
	}
//O(1)
	public int getMin()
  {
    return Heap[head];
	}
	public static void main(String[] arg)
	{
		System.out.println("The Min Heap is ");

		MinHeapImpl minHeap = new MinHeapImpl(15);
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
		System.out.println("The Min val is "
						+ minHeap.extractMin());
	}
}

