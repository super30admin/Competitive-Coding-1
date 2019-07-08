


public class PriorityQList {
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

        if(head == null)
            head= new ListNode(data,priority);
        else{
            ListNode temp = new ListNode(data,priority);
            temp.next = head;
            head = temp;

        }
        if(priority<pri)
            pri = priority;

    }

    public int pop(){
        if(head == null)
            return -1;
        ListNode temp = head,prev = null;
        while(temp!=null && temp.priority!=pri){
            prev = temp;
            temp = temp.next;
        }
        if(prev == null)
            head = head.next;
        else
            prev.next = temp.next;
        ListNode newtemp = head;
        if(newtemp!=null){
            pri = newtemp.priority;
            newtemp = newtemp.next;
            while(newtemp!=null){
                if(newtemp.priority<pri)
                    pri = newtemp.priority;
                newtemp = newtemp.next;
            }
        }
        return temp.data;
    }

    public int peek(){
        if(head == null)
            return -1;
        ListNode temp = head;
        while(temp!=null){
            if(temp.priority == pri)
                return temp.data;
            temp = temp.next;
        }
        return head.data;
    }
    public boolean isEmpty(){
        if (head == null)
            return false;
        return true;
    }

    public static void main(String[] args) {
        PriorityQList pq = new PriorityQList();
        pq.push(4,1);
        pq.push(5,2);
        pq.push(6,3);
        pq.push(7,0);
        while (pq.isEmpty()){
            System.out.println(pq.pop());
        }
    }
}



