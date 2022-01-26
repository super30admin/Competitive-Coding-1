// Time Complexity : for push :O(n) for worst case scenario - need to traverse till end of LL to add a node
//                  for pop: O(1)
// Space Complexity : O(n)

import java.util.List;

public class Problem2 {

    static class ListNode {
        int val;
        int priority;
        ListNode next;
        ListNode(int x, int priority) {
            this.val = x;
            this.priority = priority;
            next = null;
        }
    }
    static ListNode head;

    static void push(int val, int priority){
        ListNode temp = new ListNode(val, priority);

        if(head == null){
            head = temp;
            return;
        }

        ListNode curr = head;

        if(curr.priority > priority){
            //add at beginning of LL
            temp.next = head;
            head = temp;
            return;
        }

        while(curr.next != null && curr.next.priority < priority){
            curr = curr.next;
        }
        temp.next = curr;
        curr.next = temp;
    }

    static int pop(){
        if(head == null) return -1;
        ListNode temp = head;
        head = head.next;
        return temp.priority;
    }

    public static void main(String[] args) {
        Problem2.push(1,3);
        Problem2.push(1,4);
        Problem2.push(1,1);
        Problem2.push(1,2);
        Problem2.pop();
        Problem2.pop();
    }
}