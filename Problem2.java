/**
problem: implement min heap in java - https://www.geeksforgeeks.org/min-heap-in-java/
*/

public class Minheap {

	private int[] heap;
	private int size;
	private int maxsize;
	private static final int FRONT = 1;

	public Minheap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		heap = new int[this.maxsize + 1];
		heap[0] = Integer.MIN_VALUE;
	}

	private int getParent(int pos) { return pos / 2; }

	private int getLeftChild(int pos) { return (2 * pos); }

	private int getRightChild(int pos) { return (2 * pos) + 1; }

	private boolean isLeaf(int pos)
	{
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos)
	{
		int tmp;
		tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}

	private void minheapify(int pos)
	{
		if (!isLeaf(pos)) {
			if (heap[pos] > heap[getLeftChild(pos)] || heap[pos] > heap[getRightChild(pos)]) {
				if (heap[getLeftChild(pos)] < heap[getRightChild(pos)]) {
					swap(pos, getLeftChild(pos));
					minheapify(getLeftChild(pos));
				} else {
					swap(pos, getRightChild(pos));
					minheapify(getRightChild(pos));
				}
			}
		}
	}

	public void insert(int element)
	{
		if (size >= heap.length) {
			System.out.println("Overflow. Cannot insert!");
			return;
		}

		heap[++size] = element;
		int current = size;

		// Will stop when indices current and getParent(current) become equal
		while (heap[current] < heap[getParent(current)]) {
			swap(current, getParent(current));
			current = getParent(current);
		}
	}

	public void print()
	{
		for (int i = 1; i <= size / 2; i++) {
			System.out.println(
				" PARENT : " + heap[i] +
				" LEFT CHILD : " + heap[2 * i] +
				" RIGHT CHILD :" + heap[2 * i + 1]
			);
		}
	}

	public int extractMin()
	{

		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minheapify(FRONT);

		return popped;
	}

	public int getMin() {
		if (size == 1) {
			System.out.println("Underflow. Cannot retrieve minimum");
			return Integer.MAX_VALUE;
		}
		return heap[FRONT];
	}

	public static void main(String[] arg)
	{
		Minheap minheap = new Minheap(15);
		minheap.insert(5);
		minheap.insert(3);
		minheap.insert(17);
		minheap.insert(10);
		minheap.insert(84);
		minheap.insert(19);
		minheap.insert(6);
		minheap.insert(22);
		minheap.insert(9);
		minheap.print();

		System.out.println("The minimum value is " + minheap.extractMin());
		System.out.println("The minimum value is " + minheap.getMin());
	}
}
