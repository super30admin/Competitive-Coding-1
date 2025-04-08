
public class MinHeap {
	private int[] Heap;
	private int size;
	private int maxsize;
	private static final int FRONT = 1;
	public minHeap(int maxsize)
	{

		this.maxsize = maxsize;
		this.size = 0;

		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) { return pos / 2; }
	private int leftChild(int pos) { return (2 * pos); }
	private int rightChild(int pos)
	{
		return (2 * pos) + 1;
	}
	private boolean isLeaf(int pos)
	{
		if (pos > (size / 2)) {
			return true;
		}
		return false;
	}
	private void swap(int fpos, int spos)
	{
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}
private void minHeapify(int pos)
{	 
	if(!isLeaf(pos)){
	int swapPos= pos;
	if(rightChild(pos)<=size)
		swapPos = Heap[leftChild(pos)]<Heap[rightChild(pos)]?leftChild(pos):rightChild(pos);
	else
		swapPos= leftChild(pos);
	if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]){
		swap(pos,swapPos);
		minHeapify(swapPos);
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
	public int remove()
	{

		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);

		return popped;
	}
}

/*
 Time Complexity:

insert: O(log n)

remove: O(log n)

minHeapify: O(log n)

Space Complexity:

O(n), where n is the number of elements in the heap.
 */
