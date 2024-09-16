
public class MinHeap {

    LinkNode head;
    static class LinkNode{
        int value;
        int priority;
        LinkNode next;
        LinkNode(int value, int priority){
            this.value = value;
            this.priority = priority;
            this.next = null;
        }
    }

    public void push(int value, int priority){
        LinkNode newNode = new LinkNode(value, priority);
        if(head==null){
            head = newNode;
            return;
        }
        LinkNode curr = head;
        if(curr.priority > priority){
            newNode.next = curr;
            head = newNode;
            return;
        }
        while(curr.next != null && curr.next.priority < priority){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public int pop(){
        if(head==null){
            return -1;
        }
        else{
            LinkNode temp = head;
            head = temp.next;
            return temp.priority;
        }
    }

}
