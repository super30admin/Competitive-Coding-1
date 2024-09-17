
class PriorityQueue
{
	
	class QueueNode
	{
		int data,priority;
		QueueNode next;
		
		QueueNode(int data,int priority){this.data = data;this.priority=priority;}
	}
	QueueNode root = null;
	
	public boolean isEmpty(){return root==null;} 
	  
    public void push(int data,int priority) 
    { 
    	QueueNode node= root;
    	QueueNode temp= new QueueNode(data, priority);
    	if(this.isEmpty() || root.priority>temp.priority)
    	{
    		temp.next=root;
    		root=temp;
    	}
    	else 
    	{
    		while(node.next!=null && node.next.priority<priority)
    		{
    			node=node.next;
    		}
    		temp.next=node.next;
    		node.next=temp;
    		
    		
    	}
    	   
    } 
  
    public int pop() 
    { 	
    	if(this.isEmpty()) {System.out.println("Stack Underflow"); return 0;}
    	int value=root.data;
    	root=root.next;
    	return value;
    } 
  
    public int peek()
    {	if(this.isEmpty()){System.out.println("Stack is empty"); return -1;}
    	return root.data;} 
    
    public static void main(String args[])
    {
    	PriorityQueue queue= new PriorityQueue() ;
    	queue.push(1, 1);
    	queue.push(2, 0);
    	queue.push(3, 3);
    	while(!queue.isEmpty()) { System.out.println(queue.pop());}
    	
    }
}