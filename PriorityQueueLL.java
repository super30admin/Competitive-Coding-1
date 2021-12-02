// Time Complexity : Push O(n) Pop O(1)
// Space Complexity : O(n)

public class PriorityQueueLL {
    private Node head;

    class Node {
        int data;
        int priority;
        Node next;

        public Node(int data, int priority)
        {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }


    public void push(int val, int priority)
    {
        Node temp = new Node(val, priority);

        if(head == null)
        {
             head = temp;
        }
        else if(head.priority > priority)
        {
            temp.next = head;
            head = temp;
        }
        else
        {
            Node curr = head;
            while(curr.next != null && curr.next.priority < priority)
            {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    public int pop()
    {
        int val = head.priority;
        head = head.next;
        return val;
    }

    public static void main(String[] args) {
        PriorityQueueLL obj = new PriorityQueueLL();
        obj.push(3,3);
        obj.push(4,4);
        obj.push(2,2);
        obj.push(6,6);
        obj.push(5,5);
        obj.push(1,1);

        System.out.println("Popped " + obj.pop());
    }
    
}