import java.util.*;;

public class PriorityQueueUsingLinkedList {
		
	static class Node{
	     int val, priority;
	     Node next;
	    }
	
	public static Node ln(int v, int p){
        Node temp = new Node();
        temp.val = v;
        temp.priority = p;
        temp.next = null;
        
        return temp;
    }
	
	public static Node push(Node head, int v, int p) {
		Node first = head;
		
		Node temp = ln(v, p);
		
		if(head.priority > p) {
			temp.next = head;
			head = temp;
		}
		else {
			while (first.next != null && first.next.priority < p) {
				first = first.next;
			}
			
			temp.next = first.next;
			first.next = temp;
		}
		return head;
	}
	
	public static int peek(Node head) {
		return head.val;
	}
	
	
	
	
	public static Node pop(Node head) {
		Node node = head;
		head = head.next;
		
		return (head);
	}
	
	public static boolean isEmpty(Node head) {
		if(head == null) return true;
		return false;
	}
	
	
	public static void main(String args[]) {
		
		Node node = ln(3,3);
		node = push(node, 6, 1);
		node = push(node, 8, 4);
		node = push(node, 4, 2);
		node = push(node, 1, 0);
		
		peek(node);
		pop(node);
	}
	
}
