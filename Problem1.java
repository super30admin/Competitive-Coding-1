//Problem 1
public class Main
{
    
	public static void main(String[] args) {
	    int[] nums = {1,2,3,4,5,6,8,9};
		
		int low = 0;
		int high = nums.length -1;
		
		while(high - low >= 2) {
		    int mid = low + (high - low) / 2;
		    
		    if(nums[mid] - mid != nums[low] - low) {
		        high = mid;
		    } else if(nums[high] - high != nums[mid] - mid) {
		        low = mid;
		    } 
		}
		System.out.println((nums[low] + nums[high]) / 2);
	}
}

//Problem 2

public class MinHeap {
    int[] Heap;
    int size;
    int maxsize;
 
    int FRONT = 1;
 
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
    private int parent(int position) {
        return position / 2;
    }
    private int leftChild(int position) {
        return (2 * position);
    }
    private int rightChild(int position) {
        return (2 * position) + 1;
    }
    private void swap(int a, int b) {
        int temp;
        temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }
    private boolean isLeaf(int position) {
        if (position >= (size / 2) && position <= size) {
            return true;
        }
        return false;
    }
    private void minHeapify(int position) {
        if (!isLeaf(position)) {
            if (Heap[position] > Heap[leftChild(position)]
                || Heap[position] > Heap[rightChild(position)]) {
                if (Heap[leftChild(position)] < Heap[rightChild(position)]) {
                    swap(position, leftChild(position));
                    minHeapify(leftChild(position));
                }
                else {
                    swap(position, rightChild(position));
                    minHeapify(rightChild(position));
                }
            }
        }
    }
    public void insert(int element) {
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
    
    public int extractMin() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

}
