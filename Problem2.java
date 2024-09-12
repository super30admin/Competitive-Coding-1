
import java.util.Arrays;

public class MinHeap {

	private int capacity = 10;
	private int size;
	private int heap[];

	public MinHeap() {
		heap = new int[capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return heap[0];
	}

	/*
	 * This is a min heap. remove() will remove and return the smallest item.
	 */

	public int remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}

		/*
		 * -> Grab the min item. It is at index 0. -> Move the last item in the heap to
		 * the "top" of the heap at index 0. -> Reduce size.
		 */

		int minItem = heap[0];
		heap[0] = heap[size - 1];
		size--;

		/*
		 * Restore the heap since it is very likely messed up now by bubbling down the
		 * element we just put in index 0
		 */
		heapifyDown();
		return minItem;
	}

	/*
	 * Add an item to the min heap
	 */

	public void add(int itemToAdd) {
		ensureExtraCapacity();
		// Increment size
		heap[size] = itemToAdd;
		size++;
		
		/*
		 * Restore the heap since it is very likely messed up now by bubbling up the
		 * element we just put in the last empty position of the conceptual complete
		 * binary tree
		 */
		heapifyUp();
	}

	/**************************
	 * 
	 * Heap restoration helpers
	 * 
	 **************************/

	private void heapifyDown() {
		/*
		 * We will bubble down the item just swapped to the "top" of the heap after a
		 * removal operation
		 */
		int index = 0;
		/*
		 * Since a binary heap is a complete binary tree, if we have no left child then
		 * we have no right child. So we continue to bubble down as long as there is a
		 * left child. Basically...as long as there IS A child. We wouldn't check for a
		 * right child to see if we terminate since a non-existent right child doesn't
		 * say anything about whether there is a left child or not. BUT, a non-existent
		 * left child IMMEDIATELY tells us that a right child does not exist.
		 */

		while (hasLeftChild(index)) {
			// By default assume that left child is smaller. If a right child exists see if
			// it can overtake the left child by being smaller
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			if (heap[index] < heap[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}

			// Continue our bubbling down from where we just swapped the item to
			index = smallerChildIndex;
		}
	}

	// Bubble up the item we inserted at the "end" of the heap
	private void heapifyUp() {

		// We will bubble up the item just inserted into to the "bottom" of the heap
		// after an insert operation
		int index = size - 1;

		// While the item has a parent and the parent is larger than the item we stand
		// at we swap them...our item beat the parent by being smaller
		while (hasParent(index) && parent(index) > heap[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void swap(int indexOne, int indexTwo) {
		int temp = heap[indexOne];
		heap[indexOne] = heap[indexTwo];
		heap[indexTwo] = temp;
	}

	// If heap is full then double capacity
	private void ensureExtraCapacity() {
		if (size == capacity) {
			heap = Arrays.copyOf(heap, capacity * 2);
			capacity *= 2;
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return heap[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return heap[getParentIndex(index)];
	}
}
