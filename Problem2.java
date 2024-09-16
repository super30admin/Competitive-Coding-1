import java.util.PriorityQueue;

class Problem2 {
	PriorityQueue<Integer> minHeap;
	
	public Problem2() {
		minHeap = new PriorityQueue<>();
	}
	
	// O(1)
	public int getMin() {
		return minHeap.peek();
	}
	
	// O(log N)
	public void extractMin() {
		minHeap.poll();
	}
	
	// O(log N)
	public void insert(int val) {
		minHeap.add(val);
	}
}
