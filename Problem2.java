//Problem Statement: Implement Minimum Heap

// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Question isn't available on leetcode, ran on IDE
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach



public class Problem2 {
	
	private int[] pq; 
	private int N = 0; 
	
	public Problem2(int maxN){
		pq = new int[maxN];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(int v){
	pq[++N] = v;
	swim(N); // Restore heap property.
	}
	
	public int delMin(){
	int max = pq[1]; // Retrieve min key from top.
	exch(1, N--); // Exchange with last item.
	pq[N+1] = -1; 
	sink(1); // Restore heap property.
	return max;
	}
	
	private void exch(int i, int j) {
		int temp = pq[i]; pq[i] = pq[j]; pq[j] = temp;
	}
	
	private void swim(int k) { //bubble up
		while (k > 1 && (pq[k/2]>pq[k])){
		exch(k/2, k);
		k = k/2;
		}
	}
	
	private void sink(int k) {  //bubble down
		while (2*k <= N){
		int j = 2*k;
		if (j < N && pq[j]>pq[j+1]) j++;
		if (pq[k]<pq[j]) break;
		exch(k, j);
		k = j;
		}
	}
	
	private void print() {
		for(int i=1; i<=N; i++) {
			System.out.print(pq[i]+ " ");
		}
	}
    
	public static void main(String[] args) {

		Problem2 mh = new Problem2(100);
		mh.insert(3);
		mh.insert(0);
		mh.insert(7);
		mh.insert(10);
		mh.insert(11);
		mh.insert(13);
		//mh.delMin();
		//mh.delMin();
		mh.insert(9);
		mh.insert(2);
		mh.insert(1);
		mh.insert(20);
		//System.out.println(mh.delMin());
		
		mh.print();
	}
    
}

