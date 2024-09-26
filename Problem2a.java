

public class PriorityQueue {
    ListNode head;
    int pri = Integer.MAX_VALUE;

    public class ListNode{
        int data;
        int priority;
        ListNode next;
        public ListNode(int key,int priority){
            this.data = key;
            this.priority = priority;
            this.next = null;
        }

    }
    public void push(int data,int priority){
        if(isEmpty()) {
            head = new ListNode(data, priority);
            pri = priority;
        }
        else{
            ListNode temp = head,prev = null;
            while(temp!=null&&priority>temp.priority){
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                prev.next = new ListNode(data,priority);
            }
            else{
               // pri = priority;
                ListNode newtemp = new ListNode(data,priority);
                newtemp.next = temp;
                if(prev == null){
                    head = newtemp;
                    pri = priority;
                }
                else
                    prev.next = newtemp;

            }

        }

    }

    public int pop(){
        if(isEmpty())
            return -1;
        int data = head.data;
        head = head.next;
        return data;

    }

    public int peek(){
        if(isEmpty())
            return -1;

        return head.data;
    }
    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.push(4,1);
        pq.push(5,2);
        pq.push(6,4);
        pq.push(7,0);
        pq.push(8,3);
        while (!pq.isEmpty()){
            System.out.println(pq.pop());
        }
    }
}



