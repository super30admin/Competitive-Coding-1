
// operations supported - insert()/push() - O(N)
//                        - remove() - O(N)
// getMin() - O(1)
// getMax() - O(1)
//isempty() - O(1)


class Node
{
  int value;
  Node next;

  public Node(int val)
  {
    this.value = val;
    this.next = null;
  }
}

class PriorityQueue
{
  Node head;
	Node tail;

	public void add(int key)
	{
	 if(this.head == null)
	 {
	   this.head = new Node(key);
	   this.tail = this.head;
	   return;
	 }

	 Node curr = new Node(-1);
	 curr.next = this.head;

	 while(curr.next != null && curr.next.value <= key)
	 {
	   curr = curr.next;
	 }

	 Node temp = curr.next;
	 curr.next = new Node(key);
	 curr.next.next = temp;
	 curr = curr.next;

	 if(curr.next == null)
	 {
	   this.tail = curr;
	 }
	 if(temp == this.head)
	 {
		 this.head = curr;
	 }
	}

	public int remove()
	{
	 if(this.isEmpty()) return -1;

	 if(this.head == this.tail){
	   int ret = this.head.value;
	   this.head = null;
	   this.tail = null;
	   return ret;
	 }

	 Node curr = this.head;

	 while(curr.next != this.tail){
	   curr = curr.next;
	 }

	 int ans = this.tail.value;
	 curr.next = null;
	 this.tail = curr;

	 return ans;
	}

	public boolean isEmpty()
	{
	 return this.head == null;
	}

	public int getMax()
	{
	 if(!this.isEmpty()) return this.tail.value;

	 return -1;

	}

	public int getMin()
	{
	 if(!this.isEmpty()) return this.head.value;

	 return -1;
	}

	public void printQueue(){

		if(this.isEmpty()) return;

		Node curr = this.head;


		while(curr != null) {
			System.out.print(curr.value + "->");
			curr = curr.next;
		}

	}

}
