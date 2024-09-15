// Time Complexity : O(n)
// Space Complexity :O(n) 
class Solution{
     class Node{
        int value;
        int priority;
        Node next;

        Node(int val, int priority){
            this.value=val;
            this.priority=priority;
            this.next=null;
        }
    }

        Node head;

         void push(int val, int priority){
            Node temp= new Node(val, priority);
            if(head==null){
                head=temp;
                return;
            }
            Node curr=head;
            if(curr.priority>priority){
                temp.next=curr;
                head=temp;
            }
            while(curr.next!=null && curr.next.priority<priority){
                curr=curr.next;
            }
            temp.next=curr.next;
            curr.next=temp;
        }

        int pop(){
            Node temp=head;
            head=head.next;
            return temp.priority;
        }
}

