import java.util.*;

class MinHeap {
    static class Node
    {
        int val; 
        Node next;
        int priority;

        public Node (int val, int priority)
        {
            this.val = val;
            this.priority= priority;
            this.next = null;
        }
    }
    Node head;
    public void push (int val, int priority)
    {
        Node temp = new Node(val , priority);
        if(head==null)
        {
            head=temp;
            return;
        }
       
        Node curr = head;
        if(curr.priority < priority)
        {
            temp.next=curr;
            head=temp;
            return;
        }

        while(curr.next != null && curr.next.priority < priority)
        {
            curr=curr.next;
        }
        temp.next=curr.next;
        curr.next=temp;
        
       
    }

    public int pop()
    {
        Node temp = head;
        head=temp.next;
        return temp.priority;
     
    }
}
