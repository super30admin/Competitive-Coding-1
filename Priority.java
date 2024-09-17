//Time Complexity -push -O(n); pop-O(1)
//Space Complexity - push -O(1); POP- o(1)
/* Push->if the head is empty, make the new node as head
else check if the priority associated with the new node is greater the priorities of existing nodes
place the new node according to its priority. The node with highest priority is always the head
pop-> we have deleted the node at the head and made the head next node as new head */
public class Priority {

	static class  Node{
		int val;
		int priority;
		Node next;
		Node(int val,int priority){
			this.val=val;
			this.priority=priority;
			this.next =null;
		}
	}

		static Node head;
	 static void push(int val,int priority) {
			Node temp=new Node(val,priority);
			if(head==null) {
				head=temp;
				return;
		}
			Node curr=head;
			if(curr.priority>priority) {
				temp.next=head;
				head=temp;
				return;
			}

			while(curr.next!=null&&curr.next.priority<priority) {
			curr=curr.next;
				}
			temp.next=curr.next;
			curr.next=temp;
		}
	 static int pop() {
		 Node temp=head;
		 head=temp.next;
		 return temp.priority;
		  }

public static void main(String[] args) {
			Priority.push(8,7);
			Priority.push(8,2);
			Priority.push(8,4);
			Priority.push(8,8);
			Priority.push(8,9);
			System.out.println(Priority.pop());
		}


	}



