class Solution{

    Node head;
    static class Node{
        int value;
        int priority;
        Node next;

        Node(int val, int priority){
            this.val = val;
            this.priority = priority;
            this.next = null;
        }
        static void push(int val, int priority){
            Node temp = new Node(val, priority);
            if(head == null){
                head = temp;
                return;
            }
            Node curr = head;
            if(curr.priority > priority){
                temp.next = head;
                head = temp;
                return;
            }
            while(curr.next != null && curr.priority < priority){
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
        static int pop(){
            Node temp = head;
            head = head.next;
            return temp.priority;
        }
}
