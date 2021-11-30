//Time complexity:
//space complexity:

public class Problem2 {
    class Node {
        int value;
        int priority;
        Node next;

        public  Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
            this.next=null;
        }
    }

    Node head;
    void push(int val, int p) {
        Node temp = new Node(val, p);
        if (head == null) {
            head = temp;
            return;
        }
        Node curr = head;
        if (curr.priority > p) {
            temp.next = head;
            head = temp;
        } else {
            while (curr.next != null && curr.next.priority < p) {
                curr = curr.next;
            } 
            temp.next = curr.next;
            curr.next = temp;
            return;
        }
    }
    public int pop(){
        Node temp=head;
        head=head.next;
        return temp.priority;
    }
    public static void main(String args[]) {
        Problem2 obj = new Problem2();
        obj.push(1, 2);
        obj.push(1, 4);
        obj.push(1, 3);
        obj.push(1, 1);
        obj.push(1, 6);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}