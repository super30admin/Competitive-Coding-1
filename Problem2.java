
public class Problem2
{
	public static class Heap {
		int capacity;
		int size;
		int heap[];
		public Heap(int capacity){
			this.capacity = capacity;
			this.heap = new int[capacity];
		}
		
		public int getLeftChild(int parent){
			return 2 * parent;
		}
		
		public int getRightChild(int parent){
			return 2 * parent + 1;
		}
		
		public int getParent(int child){
			return child/2;
		}
		
		public void peek(){
			System.out.println("Peek - " +  heap[1]);
		}
		
		boolean isLeafNode(int i){
			return (i > size/2 && i <= size);
		}
		
		public void swap(int i, int j){
			int tmp = heap[i];
			heap[i] = heap[j];
			heap[j] = tmp;
		}
		
		public void insert(int element){
			if(size >= capacity-1){
				System.out.println("Heap is full");
				return;
			}
			heap[++size] = element;
			int curr = size;
			while(heap[curr] < heap[getParent(curr)]){
				swap(curr, getParent(curr));
				curr = getParent(curr);
			}
		}
		
		public void heapify(int i){
			if(!isLeafNode(i)){
				int swapPos = i;
				if(getRightChild(i) <= size){
					swapPos = heap[getLeftChild(i)] < heap[getRightChild(i)] ? getLeftChild(i) : getRightChild(i);
				}else{
					swapPos = getLeftChild(i);
				}
				if(heap[i] > heap[getRightChild(i)] || heap[getRightChild(i)] < heap[i]){
					swap(i, swapPos);
					heapify(swapPos);
				}
			}
		}
		
		public int remove(){
			int pop = heap[1];
			heap[1] = heap[size--];
			heapify(1);
			return pop;
		}
		
		public void print(){
			System.out.println("Printing Heap");
			for(int i: heap){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		Heap heap = new Heap(5);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.print();
		heap.peek();
		heap.remove();
		heap.print();
		heap.insert(5);
		heap.print();
	}
}
