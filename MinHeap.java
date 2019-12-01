// Time Complexity : O(Log(N)) for insert, remove and heapify
// Space Complexity : O(Constant).
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
public class MinHeap {

	private int[] heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;
	public MinHeap(int maxSize){
		super();
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[maxSize+1];
		heap[0] = Integer.MIN_VALUE;
	}
	
	private int getParent(int pos){
		return pos/2;
	}
	
	private int leftChild(int pos){
		return 2*pos;
	}
	
	private int rightChild(int pos){
		return 2*pos+1;
	}
	
	private void swap(int left, int right){
		heap[left] = heap[left]^heap[right];
		heap[right] = heap[left]^heap[right];
		heap[left] = heap[left]^heap[right];
	}
	
	public void insert(int element){
		if(size >= maxSize){
			return;
		}
		heap[++size] = element;
		int current = size;
		int parentPos = getParent(current);
		while(heap[current] < heap[parentPos]){
			swap(current,parentPos);
			current = parentPos;
			parentPos = getParent(current);
		}
	}
	
	public int remove(){
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		heapify(FRONT);
	return popped;
	}
	
	public void buildHeap(){
		for(int pos = size/2;pos>=1;pos--){
			heapify(pos);
		}
	}
	
	private boolean isLeaf(int pos){
	return pos >= size/2 && pos <= size;
	}
	
	public void heapify(int pos){
		if(!isLeaf(pos)){
			int leftPos = leftChild(pos);
			int rightPos = rightChild(pos);
			if(heap[pos]>heap[leftPos] || heap[pos]>heap[rightPos]){
				if(heap[leftPos] < heap[rightPos]){
					swap(pos,leftPos);
					heapify(leftPos);
				}else{
					swap(pos,rightPos);
					heapify(rightPos);
				}
			}
		}
	}
}
