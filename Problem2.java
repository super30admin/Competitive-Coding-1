//Priority Queue
// Time Complexity : O(N) for push operation and O(1) for pop
// Space Complexity : O(1)
// Did this code successfully run  : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Created a linked list data structure which is composed of value, priority and next pointer. The priority queue will maintain the 
 * priority order based on the priority passed. In this example, higher numeric value is considered as higher priority.
 */

import java.io.*;

class PriorityQueue {
    
    private class Node {
        int val;
        int priority;
        Node next;
        
        private Node(int val, int priority) {
            this.val = val;
            this.priority = priority;
        }
    }
    
    Node curr;
    public void push(int val, int priority) {
        // Node curr = head;
        if(curr == null) {
            curr = new Node(val, priority);
            return;
        }
        Node temp = new Node(val, priority);
        if(priority > curr.priority) { // considering higher number to be higher priority
            temp.next = curr;
            curr = temp;
        }
        else {
            while(curr.next != null && curr.next.priority > priority) {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
    }
    
    public int pop() {
        if(curr != null) {
            Node temp = curr;
            curr = curr.next;
            return temp.val;
        }
        return -1;
    }
    
	public static void main (String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.push(1,5);
		pq.push(4,1);
		pq.push(5,2);
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop()); // As per priority order, output should be 1, 5, 4
	}
}