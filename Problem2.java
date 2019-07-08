
public class priorityQueueWithLinkedList {

	Node head;  

	class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		if(head==null) {
			head = new Node(new_data);
			return;
		}
		new_node.next = null;
		
		Node last = head;
		while(last.next!=null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}
	public void pop() {
		if(head!=null && head.next!=null) {
			System.out.println(head.data+" is popped");
			head = head.next;
		}
		else if(head.next==null && head!=null) {
			System.out.println(head.data+" is popped");
			head = null;
		}
		
	}
	public void peek() {
		if(head!=null) {
			System.out.println(head.data+" is the priority element");
		}
		else {
			System.out.println("No element to peek");
		}
	}
	public void printList() {
		Node printNode = head;
		while(printNode!=null) {
			System.out.println(printNode.data);
			printNode = printNode.next;
		}
	}
	public static void main(String[] args) {
		priorityQueueWithLinkedList ll = new priorityQueueWithLinkedList();
		ll.push(6); 
		ll.push(7); 
		ll.push(8); 
		ll.pop();
		ll.peek();

		ll.printList(); 
		

	}

}
