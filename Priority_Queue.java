// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
public class Priority_Queue_p16 {
    static class Node{
        // keeping the class static so that there no need of making object
        // sa irrespective of the object there would be only one priority queue that would be dealing with all priorities
        Node next;
        int value;
        int priority;
        public Node(int value , int priority){
            this.value = value;
            this.priority = priority;
            this.next = null;
        }
    }
    static Node head;

    static void push(int val, int priority){
        Node temp = new Node(val,priority);
        if(head == null){
            head = temp;
            return;
        }
        Node cur = head;
        if(cur.priority > priority){
            temp.next = head;
            head = temp;
            return; 
        }
        while(cur.next != null && cur.next.priority < priority){
            cur = cur.next;
        }
        temp.next = cur.next;
        cur.next = temp;
    }

    static int pop(){
        Node temp = head;
        head = head.next;
        return temp.priority;

    }
    public static void main(String[] args) {
        Priority_Queue.push(1,3);
        Priority_Queue.push(1,2);
        Priority_Queue.push(1,1);
        Priority_Queue.push(1,4);
        System.out.println(Priority_Queue.pop());
        System.out.println(Priority_Queue.pop());
        System.out.println(Priority_Queue.pop());
        System.out.println(Priority_Queue.pop());
    }
    
}
