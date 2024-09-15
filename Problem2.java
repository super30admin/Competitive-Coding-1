import java.util.Arrays;
//Approach: 1. Here while inserting, we call heapfiyUp(), to maintain the min element in the top position.
//2. While removing an element, we call heapifyDown() - so if a min element is removed its replaced with the last inserted element in the heap. and then we again check the conditions
// if parent is not lesser than the child we do bubbling down, swapping parent and child till it satisfies the property. 
//3. We use array here, if the capacity is full, we just double the size of the array.
class MinHeap
{
	private int capacity;
	private int size;
	private int[] heap;
	
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.heap = new int[this.capacity];
	}
	
	private void insert(int element)
	{
		doublingHeapSize();
		heap[size] = element;
		size++;
		heapifyUp();
	}
	private int remove()
	{
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		int min = heap[0];
		heap[0] = heap[size-1];
		size--;
		heapifyDown();
		return min;
	}
	
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	private int peek()
	{
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return heap[0];
	}
	private void heapifyUp()
	{
		int index = size -1;
		while (hasParent(index) && parent(index) > heap[index]) 
		{
			swap(getParent(index), index);
			index = getParent(index);
		}
	}
	private void heapifyDown()
	{
		int index = 0;
		while(hasLeftChild(index))
		{
			int smallerChild = getLeftChild(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index))
			{
				smallerChild = getRightChild(index);
			}
			if(heap[index] < heap[smallerChild])
			{
				break;
			}else
			{
				swap(index, smallerChild);
			}
			index = smallerChild;
		}
	}
	private void doublingHeapSize() 
	{
		if(size == capacity)
		{
			heap = Arrays.copyOf(heap, capacity*2);
			capacity = capacity *2; 
		}
	}
	public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + heap[i] 
                             + " LEFT CHILD : " + heap[2 * i] 
                             + " RIGHT CHILD :" + heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
	private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = heap[fpos]; 
        heap[fpos] = heap[spos]; 
        heap[spos] = tmp; 
    }
	private int getLeftChild(int parent) 
	{
	   return 2*parent + 1;
	}
	private int getRightChild(int parent) 
	{
	   return 2*parent + 2;
	}
	private int getParent(int child) 
	{
	   return (child - 1) / 2;
	}
	private boolean hasLeftChild(int index) 
	{
	   return getLeftChild(index) < size;
	}
	private boolean hasRightChild(int index) 
	{
		return getRightChild(index) < size;
	}
	private boolean hasParent(int index) 
	{
	   return getParent(index) >= 0;
	}
	private int leftChild(int index) 
	{
	   return heap[getLeftChild(index)];
	}
	private int rightChild(int index) 
	{
	   return heap[getRightChild(index)];
	}
	private int parent(int index) 
	{
	   return heap[getParent(index)];
	}
	public static void main(String[] args)
	{
		System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        
  
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.remove()); 
        minHeap.print();
	}
}
//Time Complexity : O(log n) for insertion and removal since the height of binary tree is log n, we might have to bubble up or down to that depth. For getMin() its O(1).
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : NA
//Any problem you faced while coding this :
