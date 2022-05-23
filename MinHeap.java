//time complexity:insertion O(logn), delete O(logn), getting min value is O(1)
//space complexity:O(n)
import java.util.Arrays;
public class MinHeap
{
	private int[] Heap;
	private int index;
	private int size;

	public MinHeap(int size) {
		this.size = size;
		this.index = 0;
		Heap = new int[size];
	}

	private int leftChild(int i) {
		return (i * 2) + 1;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int rightChild(int i) {
		return (i * 2) + 2;
	}

	private boolean isLeaf(int i) {
		if (rightChild(i) >= size || leftChild(i) >= size) {
			return true;
		}
		return false;
	}

	public void insert(int element) {
		if (index >= size) {
			return;
		}
		Heap[index] = element;
		int current = index;

		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		index++;
	}

	// removes and returns the minimum element from the heap
	public int remove() {
     // since its a min heap, so root = minimum
		int popped = Heap[0];
		Heap[0] = Heap[--index];
		minHeapify(0);
		return popped;
	}

	// heapify the node at i
	private void minHeapify(int i) {
	// If the node is a non-leaf node and any of its child is smaller
		if (!isLeaf(i)) {
			if (Heap[i] > Heap[leftChild(i)] ||
                  Heap[i] > Heap[rightChild(i)]) {
				if (Heap[leftChild(i)] < Heap[rightChild(i)]) {
					swap(i, leftChild(i));
					minHeapify(leftChild(i));
				} else {
					swap(i, rightChild(i));
					minHeapify(rightChild(i));
				}
			}
		}
	}

	// builds the min-heap using the minHeapify
	public void minHeap() {
		for (int i = (index - 1 / 2); i >= 1; i--) {
			minHeapify(i);
		}
	}

     // Function to print the contents of the heap
	public void printHeap() {
		for (int i = 0; i < (index / 2); i++) {
			System.out.print("Parent : " + Heap[i]);
			if (leftChild(i) < index)
				System.out.print(" Left : " + Heap[leftChild(i)]);
			if (rightChild(i) < index)
				System.out.print(" Right :" + Heap[rightChild(i)]);
			System.out.println();
		}
	}
	// swaps two nodes of the heap
	private void swap(int x, int y) {
		int tmp;
		tmp = Heap[x];
		Heap[x] = Heap[y];
		Heap[y] = tmp;
	}
	public static void main(String[] arg)
      {
	    MinHeap minHeap = new MinHeap(7);
	    minHeap.insert(3);
	    minHeap.insert(13);
	    minHeap.insert(7);
        minHeap.insert(16);
	    minHeap.insert(21);
	    minHeap.insert(12);
	    minHeap.insert(9);
	    minHeap.minHeap();

	   System.out.println("The Min Heap is : " + Arrays.toString(minHeap.Heap));
	   minHeap.printHeap();
	   System.out.println("\nThe Min Value is : " + minHeap.remove());
	   System.out.println("\nThe Min Heap is :"+ Arrays.toString(minHeap.Heap));
	   minHeap.printHeap();
	}
}

