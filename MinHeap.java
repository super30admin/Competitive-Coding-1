import java.util.Arrays;

/** Time : O(log n) where n is length of array
 *  Space O(1) */
public class MinHeap {
	private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;
 
    public MinHeap(int maxsize){
    	this.maxsize = maxsize;
        this.size = 0; 
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
 
    private int parent(int pos) { 
    	return pos / 2; 
    }
    private int leftChild(int pos) { 
    	return (2 * pos); 
    }
    private int rightChild(int pos){
        return (2 * pos) + 1;
    } 
    private boolean isLeaf(int pos){ 
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    private void swap(int index1, int index2){ 
        int tmp = Heap[index1]; 
        Heap[index1] = Heap[index2];
        Heap[index2] = tmp;
    }
 
    private void minHeapify(int pos){ 
        // If the node is a non-leaf node and greater than any of its child
        if (!isLeaf(pos) && (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)])) { 
            // Swap with the left child and heapify the left child
                if (Heap[leftChild(pos)]
                    < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
 
                // Swap with the right child and heapify the right child
            else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }
 
    public void insert(int element){ 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    
    public int remove() { 
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT); 
        return popped;
    }
 
    public void print(){
        for (int i = 1; i <= size / 2; i++) { 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println();
        }
    }
    
	//Main Method
	public static void main(String[] args) {
		MinHeap minHeap= new MinHeap(15);
		minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
		
		/*MinHeap minHeap= new MinHeap(7);
		minHeap.insert(3);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(16);
        minHeap.insert(21);
        minHeap.insert(12);
        minHeap.insert(9);*/
		
		System.out.println("Min Heap before removal :"+ Arrays.toString(minHeap.Heap));
		minHeap.print();
		System.out.println("Min value to be removed is :"+ minHeap.remove());
		System.out.println("Min Heap after removal :"+ Arrays.toString(minHeap.Heap));
		minHeap.print();		
	}	
}
