public class MyClass {
    static class Node{
        int value;
        int priority;
        Node next;
        Node(int value, int priority){
            value=value;
            this.priority=priority;
            this.next=null;
        }
    }
    static Node head;
    public static void push(int value, int priority){
        Node temp = new Node(value,priority);
        if(head==null){
            head=temp;
            return;
        }
        Node curr=head;
        if(curr.priority > priority){
            temp.next=head;
            head=temp;
            return;
            
        }
        while(curr.next!=null && curr.next.priority<priority){
            curr=curr.next;
        }
        temp.next=curr.next;
        curr.next=temp;
    }
    public static int pop(){
        Node temp=head;
        head=head.next;
        return temp.priority;
    }
    
    public static void main(String args[]) {
    MyClass obj=new MyClass() ;
    obj.push(1,3);
    obj.push(1,4);
    obj.push(1,7);
    obj.push(1,2);
    obj.push(1,6);
    obj.push(1,5);
    obj.push(1,1);
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    }
}
