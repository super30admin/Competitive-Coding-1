//Implement a Min Heap 
//Time Complexity: O(logn)
//Space Complexity: O(n)
//Code run successfully.

public class Problem2{
	
	private int[] heap;
	private int size;
	private int index;
	
	public Problem2(int size) {
		this.size = size;
		heap = new int[size];
		index = 0;
	}
	
	public int getParent(int i) {
		return (i-1)/2;
	}
	
	public int leftChild(int i) {
		return (2*i) + 1;
	}
	
	public int rightChild(int i) {
		return (2*i) + 2;
	}
	
	public void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public boolean isLeaf(int i) {
		
		if(leftChild(i) < size && rightChild(i) < size)
			return false;
		
		return true;
	}
	public void insert(int val) {
		
		if(index >= size)
			return;
		
		heap[index] = val;
		int current = index;
		
		while(heap[current] < heap[getParent(current)]) {
			swap(current,getParent(current));
			current = getParent(current);
		}
		index++;	
	}
	
	public void remove(){
		heap[0] = heap[--index];
		heap[index] = 0;
		heapify(0);
	}
	
	public void heapify(int i) {
		
		if(!isLeaf(i)){
			
			int l = heap[leftChild(i)];
			int r = heap[rightChild(i)];
			int v = heap[i];
			
			if(v > r || v > l) {
				if(l < r) {
					swap(i,leftChild(i));
					heapify(leftChild(i));
				}
				else if(r < l) {
					swap(i,rightChild(i));
					heapify(rightChild(r));
				}
			}	
		}	
	}
	
	public int getMin()
	{
		return heap[0];
	}
	
	public void printHeap() {
		for(int i =0; i < size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Problem2 ob = new Problem2(6);
		ob.insert(15);
		ob.insert(28);
		ob.insert(31);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		
		ob.printHeap();
		
		ob.remove();
		ob.remove();
		
		ob.printHeap();
		
	}
	
}
