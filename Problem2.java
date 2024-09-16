/*
A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

 */

/*
Time Complexity = O(N)
Space Complexity = O(1) //no extra space
 */

public class Problem2{

}

class PriorityQueue {

    private Node head;

    static class Node{
        int value;
        int priority;
        Node next;

        Node(int value, int priority){
            this.value = value;
            this.priority = priority;
            this.next = null;
        }
    }

    private void push(int val, int priority){
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

        while(curr.next!= null && curr.next.priority < priority){
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;

    }

    private int pop(){
        if(head == null) {
            return -1;
        }
        Node temp = head;
        head = head.next;
        return temp.priority;
    }

    private int peek(){
        if(head == null){
            return -1;
        }else{
            return head.priority;
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push(1, 3);
        pq.push(1, 4);
        pq.push(1, 1);
        pq.push(1, 2);
        System.out.println("peek = " + pq.peek());
        System.out.println(pq.pop());
        System.out.println("peek = " + pq.peek());
        System.out.println(pq.pop());
        System.out.println("peek = " + pq.peek());
        System.out.println(pq.pop());
        System.out.println("peek = " + pq.peek());
        System.out.println(pq.pop());
        System.out.println("peek = " + pq.peek());

    }
}

//priority queue as min heap
class MinHeap {

    private Node head;

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    private void insert(int val){
        Node temp = new Node(val);
        if(head == null){
            head = temp;
            return;
        }

        Node curr = head;

        if(curr.value > val){
            temp.next = head;
            head = temp;
            return;
        }

        while(curr.next!= null && curr.next.value < val){
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;

    }

    private int extractMin(){
        if(head == null) {
            return -1;
        }
        Node temp = head;
        head = head.next;
        return temp.value;
    }

    private int getMin(){
        if(head == null){
            return -1;
        }else{
            return head.value;
        }
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.insert(3);
        mh.insert(4);
        mh.insert(1);
        mh.insert(2);
        System.out.println("peek = " + mh.getMin());
        System.out.println(mh.extractMin());
        System.out.println("peek = " + mh.getMin());
        System.out.println(mh.extractMin());
        System.out.println("peek = " + mh.getMin());
        System.out.println(mh.extractMin());
        System.out.println("peek = " + mh.getMin());
        System.out.println(mh.extractMin());
        System.out.println("peek = " + mh.getMin());

    }
}
