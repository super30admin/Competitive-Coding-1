
public class PriorityQueue {
	
	Node head;
	
	public class Node{
		int value;
		int priority;
		Node next;
		
		public Node(int value, int priority) {
			this.value=value;
			this.priority=priority;
		}
	}
		
	
	
	public void push(int value,int priority) {
		Node temp= new Node(value,priority);
		if(this.head==null) {
			head=temp;
		}else {
			if(head.priority>priority) {
				temp.next=head;
				head=temp;
			}else {
				Node start = head;
				while(start.next!=null && start.next.priority<priority) {
					start = start.next;
				}
				temp.next = start.next;
				start.next=temp;
			}
		}
	}
	
	public Node pop() {
		Node temp = head;
		head = head.next;
		return temp;
	}
	
	public int peek() {
		return head.value;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PriorityQueue p = new PriorityQueue();
	     p.push(1,1);
	     p.push(2, 2);
	     p.push(4, 4);
	     p.push(3, 3);
	     
	    

	     System.out.println(p.peek());
	     p.pop();
	     System.out.println(p.peek());
	     p.pop();
	     System.out.println(p.peek());
	    p.pop();
	     System.out.println(p.peek());

	}

}