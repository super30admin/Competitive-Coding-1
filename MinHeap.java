/* Time complexity: O(log n) for insert and removing the minimum; O(1) for fetching minimum
 * Space complexity: O(1)
 */

public class MinHeap {

	private int[] pq; 
	private int index = 0; 

	public MinHeap(int maxN){
		pq = new int[maxN];
	}

	public boolean isEmpty(){
		return index == 0;
	}

	public int size(){
		return index;
	}

	public void insert(int v){
	pq[++index] = v;
	swim(index); // Restore heap property.
	}

	public int delMin(){
	int max = pq[1]; // Retrieve min key from top.
	exch(1, index--); // Exchange with last item.
	pq[index+1] = -1; 
	sink(1); // Restore heap property.
	return max;
	}

	private void exch(int i, int j) {
		int temp = pq[i]; 
        pq[i] = pq[j]; 
        pq[j] = temp;
	}

	private void swim(int k) { //bubble up
		while (k > 1 && (pq[k/2]>pq[k])){
		exch(k/2, k);
		k = k/2;
		}
	}

	private void sink(int k) {  //bubble down
		while (2*k <= index){
		int j = 2*k;
		if (j < index && pq[j]>pq[j+1]) j++;
		if (pq[k]<pq[j]) break;
		exch(k, j);
		k = j;
		}
	}

	private void print() {
		for(int i=1; i<=index; i++) {
			System.out.print(pq[i]+ " ");
		}
	}

	public static void main(String[] args) {

		MinHeap mh = new MinHeap(50);
		mh.insert(3);
		mh.insert(0);
		mh.insert(7);
		mh.insert(10);
		mh.insert(11);
		mh.insert(13);
		mh.insert(9);
		mh.insert(2);
		mh.insert(1);
		mh.insert(20);
		mh.print();
        System.out.println("\n");
        mh.delMin();
        mh.print();
	}  
}
