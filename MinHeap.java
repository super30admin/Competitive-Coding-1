public class MinHeap {
	public int [] heap ; 
	public int size ; 
	public int curSize ; 

	public MinHeap() {
		heap = new int[size] ; 
		curSize = 0 ; 
	}

	public void trickleUp(int i) {
		int child = heap[i] ; 
		int parent = (i - 1) / 2 ; 

		while(i > 0 && heap[parent] > child) {
			heap[i] = heap[parent] ; 
			i  = parent ; 
			parent = (i - 1) / 2 ; 
		}

		heap[i] = child ; 
	}


	public boolean insert(int val) {
		if(curSize == size)
			return false; 

		heap[curSize] = val ; 
		trickleUp(curSize++) ; 

		return true ; 
	}

	public void trickleDown (int index) {
		int top = heap[index] ; 
		int smallChild ; 
		while(index < curSize / 2) {
			int left = (index * 2) + 1 ; 
			int right = left + 1 ; 
			if(right < curSize && heap[right] < heap[left])
				smallChild = right ; 
				else
				smallChild = left ; 

				if(top <= heap[smallChild])
				break ; 
				heap[index] = heap[smallChild] ; 			
				index = smallChild ; 	
		}

		heap[index] = top ; 
	}

	public int extractMin() {
		int temp = heap[0] ; 
		heap[0] = heap[--curSize] ; 
		heap[curSize] = temp ; 
		trickleDown(0) ; 
		return temp ; 
	}

	public int getMin() {
		return heap[0] ; 
	}
}