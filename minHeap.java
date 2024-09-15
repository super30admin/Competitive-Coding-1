//Time Complexity : inserting and bubbling up O(log n), removing and extracting minimum O(1)
// Space Complexity : O(n) for storing n elements 
// Any problem you faced while coding this : 


import java.util.Arrays;

public class minHeap {

	int capacity;
	int[] heap;
	int size;

	public minHeap(int capacity) {
		this.capacity=capacity;
		this.heap=new int[capacity+1];
		this.size=0;
		this.heap[0] = Integer.MIN_VALUE;
	}

	public int getmin() // this method will extract the minimum number at root
	{
		if(heap == null || heap.length == 0) {
			System.out.println("Heap is empty!");
			return -1;
		}
		else{
			return heap[0]; // means return the first element of heap array as its minimum and array is of minHeap
		}
	}

	private int getparentindex(int childindex) {return (childindex-1)/2;}
	private int getleftchildindex(int parentindex) {return (parentindex*2)+1;}
	private int getrightchildindex(int parentindex) {return (parentindex*2)+2;}

	public void insert(int value) {
		if(capacity == size && size>0) {
		resize(); }
		//will insert new element at last position in an array i.e. available place in left loaded binary minheap tree
		//called resize() if no capacity is remaining

		heap[size]= value;  // insert the value at last position
		size++;
		bubbleup();
		//System.out.println(value+ "The size after insert is now"+ size);
	}

	public void resize() {
			heap = Arrays.copyOf(heap, capacity*2);
			capacity=capacity*2;
	}

	private void bubbleup() {
		int index=size-1; // means whenever bubble up is called we would have known its index because we know the latest index on which item has been inserted
		//System.out.println("the index of inserted element before bubble up is:"+ index+ "  parents index before bu() is"+ getparentindex(index));
		while(getparentindex(index) >=0) {
			if(heap[getparentindex(index)] > heap[index]) {
				swap(getparentindex(index), index);
				index=getparentindex(index); // assign parent's index to this value. i.e. now this value is at parent's position
				//System.out.println("  the index of inserted element after bubble up is:  "+ index);
			}else break;
		}
	}

	public void swap(int parentindex, int index) {
		int temp= heap[parentindex];
		heap[parentindex]=heap[index];
		heap[index]=temp;
	}

	public void print() {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++) {
			System.out.print(heap[i]+"->");
		}
		System.out.println();
	}

	public int remove() { //will the remove the element from first position in an array i.e. root in left loaded binary minheap tree
		if(heap.length == 0) return -1;

		int minElement =  heap[0];
		heap[0]= heap[size-1];
		size--; // because the size of array is decreased
		bubbledown();
		return minElement;

	}

	private void bubbledown() {
		int index=0; // because the swapped element is at root position
		while(getleftchildindex(index) < size) {
			int smallerindex=index;
			if(heap[getleftchildindex(index)] < heap[smallerindex]) { smallerindex=getleftchildindex(index);}
			if(heap[getrightchildindex(index)] < heap[smallerindex]) { smallerindex=getrightchildindex(index);}
			if(smallerindex != index) {
				swap(smallerindex, index);
				index=smallerindex;
			}
			else break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minHeap min= new minHeap(10);

		System.out.println("The inserted elements are:");
		min.insert(5);
		min.print();
		min.insert(3);
		min.print();
		min.insert(17);
		min.print();
		min.insert(10);
		min.print();
		min.insert(6);min.print();
		min.insert(19);

        // Print all elements of the heap
         min.print();       

     // Removing minimum value from above heap and printing it
         System.out.println("The Min val is " + min.getmin());
        System.out.println("Remove the minimum element " + min.remove());
        min.print();
	}

}