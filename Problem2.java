//Time Complexity - 
// Insert & Remove: O(log n)
//Space Complexity - no extra space (size of array is part of declaration)

package Super30;

//Java program to implement Min Heap 
public class MinHeap { 
	private int size;
	private int[] heap;


 // Constructor to initialize an 
 // empty min heap with given maximum 
 // capacity. 
	public MinHeap(int size) {
		this.size = 0;
		this.heap = new int[size + 1];
		heap[0] = Integer.MIN_VALUE;
	}
 

 // Returns position of parent 
	private int parent(int pos) {
		return pos/2;
	}


 // Below two functions return left and 
 // right children. 
	private int leftC(int pos) {
		return  pos * 2;
	}
	
	private int rightC(int pos) {
		return pos * 2 + 1;
	}


 // Returns true of given node is leaf 
	private boolean isLeaf(int pos) {
		if(pos <= size && pos >= size / 2)
			return true;
		else
			return false;
	}
	


 // A recursive function to min heapify the given 
 // subtree. This function assumes that the left and 
 // right subtrees are already heapified, we only need 
 // to fix the root. 
	private void minHeapify(int pos) {
		//base case
		if(isLeaf(pos)) return;
		
		//logic
		if(heap[pos] < heap[leftC(pos)] || heap[pos] < heap[rightC(pos)]) {
			if(heap[leftC(pos)] < heap[rightC(pos)]) {
				swap(pos, leftC(pos));
				minHeapify(leftC(pos));
			}
			else {
				swap(pos, rightC(pos));
				minHeapify(rightC(pos));
			}
		}
	}


 // Inserts a new element to max heap 
	private void insert(int num) {
		heap[++size] = num;
		int curPos = size;
		
		while(heap[curPos] < heap[parent(curPos)]) {
			swap(curPos, parent(curPos));
			curPos = parent(curPos);
		}
	}
	
	private void swap(int pos1, int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}


 // Remove an element from max heap 
	private int removeMinElement() {
		if(this.size == 0) {
			return Integer.MIN_VALUE;
		}
		int minE = heap[1];
		heap[1] = heap[size--];
		minHeapify(1);
		
		return minE;
	}
	
	private void print() {
		for(int i = 1; i < size/2; i++) {
			System.out.println("Parent: " + heap[i] +
					" Left Child: " + heap[2*i] +
					" Right Child: " + heap[2*i + 1]);
		}
	}

 public static void main(String[] arg) 
 { 
     System.out.println("The Min Heap is "); 
     MinHeap minHeap = new MinHeap(15); 
     minHeap.insert(5); 
     minHeap.insert(10); 
     minHeap.insert(17); 
     minHeap.insert(55); 
     minHeap.insert(84); 
     minHeap.insert(19); 
     minHeap.insert(6); 
     minHeap.insert(22); 
     minHeap.insert(9); 

     minHeap.print(); 
     System.out.println("The min val is " + minHeap.removeMinElement()); 
 } 
}

