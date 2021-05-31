/* TC   - mentioned in the meothods
 * SC  - O(1) no auxiliary space used in any of the operations
 * */


import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {
	
	PriorityQueue<Integer> pq;  
	
	public MinHeap() {
		 pq  = new PriorityQueue<Integer>();
	}
	public void insert(int elem) {
		// TC - O(logN) since re-heapification takes logN time
		pq.add(elem);
	}
	
	public void printHeap() {
		
		Iterator it = pq.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public int pop() {
		// TC - O(logN) since re-heapification takes logN time
		return pq.poll();
	}
	

	public void removeByValue(int val) {
		//TC - O(logN) since re-heapification takes logN time
		pq.remove(val);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap obj = new MinHeap();
		for (int i = 3; i <= 20 ; i++) {
			obj.insert(i);
		}
		obj.printHeap();
		// remove the minimum most, from from top of the list 
		int removed =  obj.pop();
		System.out.println("value popped \n " + removed );
		int val = 4;
		obj.removeByValue(val);
		System.out.println("Removed by value" );
		obj.printHeap();
		

	}

}
