import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {
	
	PriorityQueue<Integer> pq;  
	
	public MinHeap() {
		 pq  = new PriorityQueue<Integer>();
	}
	public void insert(int elem) {
		pq.add(elem);
	}
	
	public void printHeap() {
		
		Iterator it = pq.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public int pop() {
		
		return pq.poll();
	}
	

	public void removeByValue(int val) {
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
