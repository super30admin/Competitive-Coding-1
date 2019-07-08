/*
 * 
Implement Priority Queue using Linked Lists.

Operations on Priority Queue :

push(): This function is used to insert a new data into the queue.
pop(): This function removes the element with the highest priority form the queue.
peek() / top(): This function is used to get the highest priority element in the queue without removing it from the queue
 
 */
public class Problem2 {
	
	 // create the node Class
	 static class Node {  
	    int data;  
	    int priority;  
	    Node next;  
	    
	} 
	
	
	private static Node newNode(int d, int p) {
		// TODO Auto-generated method stub
		
		Node n = new Node();
		n.data = d;
		n.priority = p;
		n.next = null;
		
		
		return n;
	}
	
	private static Object peek(Node pq) {
		// TODO Auto-generated method stub
		return pq.data;
	}

	private static Node pop(Node pq) {
		
		Node temp  = pq;
		pq = pq.next;
		return pq;
	}

	private static boolean isEmpty(Node pq) {
		// TODO Auto-generated method stub
		return (pq == null);
	}

	private static Node push(Node pq, int i, int j) {
		Node start = pq;  
	    
	    // Create new Node  
	    Node temp = newNode(i, j);  

	    
	    //if the head has the higher priority then insert before the head.
	    if ((pq).priority > j) {  
	    
	        // Insert New Node before head  
	        temp.next = pq;  
	        pq = temp;  
	    }  
	    else {  
	    
	       //find the perfect place to put the priority in the list.
	        while (start.next != null &&  
	               start.next.priority < j) {  
	            start = start.next;  
	        }  
	    
	        // Either at the ends of the list  
	        // or at required position  
	        temp.next = start.next;  
	        start.next = temp;  
	    }  
	    return pq; 
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a Priority Queue  
	    // 7.4.5.6  
	    Node pq = newNode(4, 1);  
	    pq =push(pq, 5, 2);  
	    pq =push(pq, 6, 3);  
	    pq =push(pq, 7, 0);  
	    
	    while (isEmpty(pq)==false) {  
	        System.out.printf("%d ", peek(pq));  
	        pq=pop(pq);  
	    }  
		
	}

	


	
}

