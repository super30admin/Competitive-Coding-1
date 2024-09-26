 //Time Complexity of getMin() = O(1) and insert () = O(logn) and extractMin() = O(logn)
// Space Complexity :O(n)

public class problem2 {
	public static class MinHeap {
	    int[] heap;
	    int arr_size;
	    int heap_size;

	    public MinHeap(int arr_size) {
	        this.arr_size = arr_size;
	        this.heap_size = 0;
	        heap = new int[this.arr_size];
	        heap[0] = Integer.MIN_VALUE;

	    }

	    public int parent(int index) {
	        return index / 2;
	    }

	    public int leftChild(int index) {
	        return 2 * index;
	    }

	    public int rightChild(int index) {
	        return (2 * index) + 1;
	    }

	    public void minHeapify(int heap[], int i) {
	        int left = leftChild(i);
	        int right = rightChild(i);
	        int smallest = 0;

	        if (left <= heap_size && heap[left] < heap[i]) {
	            smallest = left;
	        } else {
	            smallest = i;
	        }
	        if (right <= heap_size && heap[right] < heap[smallest]) {
	            smallest = right;
	        }
	        if (smallest != i) {
	            int temp = heap[i];
	            heap[i] = heap[smallest];
	            heap[smallest] = temp;

	            minHeapify(heap, smallest);

	        }

	    }

	    // 1
	    // Insert into heap
	    public void insert(int element) {

	        heap[++heap_size] = element;

	    }

	    public void buildMinHeap() {
	        // heap_size = arr_size;
	        for (int i = heap_size / 2; i >= 1; i--) {
	            minHeapify(heap, i);
	        }
	    }

	    // 2
	    // Retrieves min heap value;
	    public int getMin() {
	        return heap[1];

	    }

	    // 3
	    // Removes element from min
	    public int extractMin() {
	        int min = heap[1];
	        heap[1] = heap[heap_size--];
	        // heap_size --;
	        minHeapify(heap, 1);

	        return min;
	    }

	    public void print() {

	        for (int i = 1; i <= heap_size / 2; i++) {
	            System.out.print(
	                    " Parent : " + heap[i] + " left child : " + heap[2 * i] + " right child :" + heap[2 * i + 1]);
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {

	        System.out.println("The Min Heap is ");
	        MinHeap minHeap = new MinHeap(12);
	        minHeap.insert(40);
	        minHeap.insert(60);
	        minHeap.insert(10);
	        minHeap.insert(20);
	        minHeap.insert(50);
	        minHeap.insert(30);
	        minHeap.insert(70);
	        minHeap.buildMinHeap();

	        minHeap.print();
	        System.out.println("The Min val is " + minHeap.getMin());
	        System.out.println("-------------------------------------------");
	        System.out.println("The removed element is = " + minHeap.extractMin());
	        System.out.println("Heap after removing element is ");
	        minHeap.print();
	        System.out.println("-------------------------------------------");
	        System.out.println("The removed element is = " + minHeap.extractMin());
	        System.out.println("Heap after removing element is ");
	        minHeap.print();
	        System.out.println("-------------------------------------------");
	        System.out.println("The removed element is = " + minHeap.extractMin());
	        System.out.println("Heap after removing element is ");
	        minHeap.print();
	        System.out.println("-------------------------------------------");
	        System.out.println("The Min val is " + minHeap.getMin());
	        System.out.println("The removed element is = " + minHeap.extractMin());
	        System.out.println("Heap after removing element is ");
	        minHeap.print();

	    }
	}
}
	
