public class Problem2 {
    // Time Complexity : O(n) - push, O(1) - pop, O(1) - peek
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

        class Node {
            int data;
            int priority;
            Node next;

            Node(int data,  int priority) {
                this.data = data;
                this.priority = priority;
            }
        }
        private Node head;
        public Problem1() {
            head = null;
        }
        public void push(int x, int priority) {
            Node temp = new Node(x,priority);
            if(head == null) {
                head = temp;
            } else if (head.priority < priority) { //if new node priority is less than head, append at the start
                temp.next = head;
                head = temp;
            } else {
                Node curr = head;
                Node prev = null;
                while(curr != null && (curr.priority > priority || curr.priority == priority)) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = temp;
                temp.next = curr;
            }
        }

        public Node pop() {
            Node del = head;
            head = head.next;
            return del;
        }

        public int peek() {
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public static void main(String args[])
        {
            Problem1 obj = new Problem1();
            obj.push(4,1);
            obj.push(2,1);
            obj.push(5,2);
            obj.push(6,3);
            obj.push(9,3);
            obj.push(7,0);

            while (!obj.isEmpty()) {
                System.out.printf("%d ", obj.peek());
                obj.pop();
            }
//output - 6 9 5 4 2 7
        }
    }

