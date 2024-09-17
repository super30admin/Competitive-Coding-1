/**
 * Time Complexity : 
 * getMin(): O(1)
 * extractMin() : O(logn) where n = number of elements
 * insert() : O(logn) where n = number of elements in tree
 *  */
public class Problem2 { 
	private int[] myHeap; 
	private int size; 
	private int maxsize; 

	public Problem2(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		myHeap = new int[this.maxsize + 1]; 
		myHeap[0] = Integer.MIN_VALUE; 
	} 

//return position of parent
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

///return position of left child
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

//return position of right child
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 


	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
    } 
    
//swap two nodes of the myHeap 
	private void swap(int node1, int node2) 
	{ 
		int temp; 
		temp = myHeap[node1]; 
		myHeap[node1] = myHeap[node2]; 
		myHeap[node2] = temp; 
	} 

	private void minHeapify(int pos) 
	{ 

//if node is non-leaf node
		if (!isLeaf(pos)) { 
			if (myHeap[pos] > myHeap[leftChild(pos)] || myHeap[pos] > myHeap[rightChild(pos)]) { 
				if (myHeap[leftChild(pos)] < myHeap[rightChild(pos)]) { 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				} 
				else { 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 
 
	public void insert(int element) 
	{ 
		if (size >= maxsize) { 
			return; 
		} 
		myHeap[++size] = element; 
		int current = size; 

		while (myHeap[current] < myHeap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 


	public void minHeap() 
	{ 
		for (int pos = (size / 2); pos >= 1; pos--) { 
			minHeapify(pos); 
		} 
    } 
    
    public int getMin(){
        return myHeap[1];
        }


	public int extractMin() 
	{ 
		int removed = getMin();
		myHeap[1] = myHeap[size--]; 
		minHeapify(1); 
		return removed; 
	} 
	public static void main(String[] arg) 
	{ 

		Problem2 minHeap = new Problem2(4); 
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(1);
        
        System.out.println("The Min val is " + minHeap.extractMin()); 

	} 
} 

