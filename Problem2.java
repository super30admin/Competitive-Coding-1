// Problem: Priority Queue using Linked List
// Example: [3,4,2,6,7,5,1]

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Here we assume the priority with lesser value has more priority

public class Solution {

    static class Node {
        int priority;
        Node next;

        Node (int priority) {
            this.priority = priority;
            this.next = null;
        }
    }

    static Node head;

    // We organize the Linkedlist to have the most prior element at the head, hence it would be sorted in ascending order
    // of priority. Hence we place the new element based on its priority.
    static void push (int priority) {
        Node temp = new Node(priority);

        // If its the first element
        if (head == null) {
            head=temp;
            return;
        }

        Node cur = head;

        if (cur.priority > priority) {
            temp.next = head;
            head = temp;
            return;
        }

        while (cur.next != null && cur.next.priority < priority) {
            cur = cur.next;
        }
        temp.next = cur.next;
        cur.next=temp;
    }

    // We return the head priority since it is the most priority
    static int pop () {
        Node temp = head;
        head = head.next;
        return temp.priority;
    }

    public static void main(String args[]) {
        System.out.println("Implementation of Priority Queue");
        int[] argsInt = new int[]{3,4,2,6,7,5,1};
        for (int i=0; i<argsInt.length; i++) {
            Solution.push(argsInt[i]);
        }

        for (int i=0; i<argsInt.length; i++) {
            System.out.println(Solution.pop());
        }
    }
}