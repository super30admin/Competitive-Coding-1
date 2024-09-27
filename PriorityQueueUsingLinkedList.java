class Node {
    int val;
    int priority;
    Node next;

    Node(int val, int priority) {
        this.val = val;
        this.priority = priority;
    }
}

/*Assume that 1 has highest priority than other numbers*/
public class PriorityQueueUsingLinkedList {
    Node head;
    Node cur, prev;

    PriorityQueueUsingLinkedList() {
        head = null;
        cur = null;
        prev = null;
    }

    public void add(int val, int priority) {
        Node node = new Node(val, priority);

        if(head == null) {
            head = node;
            return;
        }

        Node cur = head;
        if(cur.priority > priority) {
            node.next = cur;
            head = node;
            return;
        }
        while(cur.next!= null && cur.next.priority < priority) {
            cur = cur.next;
        }


        node.next = cur.next;
        cur.next = node;
    }

    public int poll() {
        Node temp = head;
        head = head.next;
        return temp.priority;
    }


    public static void main(String[] args) {
        PriorityQueueUsingLinkedList pq = new PriorityQueueUsingLinkedList();
        pq.add(1, 3);
        pq.add(1, 4);
        pq.add(1, 2);
        pq.add(1, 6);
        pq.add(1, 7);
        pq.add(1, 5);
        pq.add(1, 1);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
