//Push into queue based on priority. Maintain the top priority element as head node

class PriorityQueue {

    class Node {
        int data;
        Node next;
        int priority;

        Node(int data, int priority){
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    Node head;

    PriorityQueue(){
        head = null;
    }

    public void insert(int data,int priority){
        Node newNode = new Node(data, priority);

        if(head == null){
            head = newNode;
            return;
        }

        Node curr = head;
        Node prev = null;
        while(curr != null){
           
            //found the right position
            if(curr.priority < newNode.priority){
                
                //making the newnode as head
                if(curr == head){
                    newNode.next = head;
                    head = newNode;
                    return;
                }
                
                prev.next = newNode;
                newNode.next = curr;
                return;
            }
            else{
                prev = curr;
                curr = curr.next;
            }                                                                                        
            
        }
        //reached end of queue. Append
        prev.next = newNode;
        return;
    }

    public Node peek(){
        return head;
    }

    public void pop(){
        if(head == null){
            System.out.println("Queue is empty");
        }
        else{
            head = head.next;
        }

        
    }

    public void printList(){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data + " " + curr.priority);
            curr = curr.next;
        }

    }

    public static void main(String[] args){
        System.out.println("Inside Priority Queue Implementation...");
        PriorityQueue obj = new PriorityQueue();
        obj.insert(1,1);
        obj.insert(2,2);
        obj.insert(3,3);
        obj.insert(0,0);
        obj.insert(4,4);
        obj.insert(-1,-1);
        obj.printList();

        System.out.println("Peek: " + obj.peek().data);
        obj.pop();
        obj.printList();
        obj.insert(4,4);
        obj.insert(-1,-1);
        obj.printList();
        obj.pop();obj.pop();obj.pop();obj.pop();
        obj.pop();obj.pop();obj.pop();obj.pop();obj.pop();
    }

}
