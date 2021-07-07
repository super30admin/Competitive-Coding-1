import java.util.* ; 
  
//Linked List |  peek() O(1)    push()  O(n)     pop() O(1)

class Solution 
{ 
    
    
// Node  
 static class Node {  
    int data;  
    
    // Lower values indicate higher priority  
    int priority;  
    
     Node next;  
    
} 
  
static Node node = new Node(); 
    
// Function to Create A New Node  
static Node newNode(int d, int p)  
{  
    Node temp = new Node();  
    temp.data = d;  
    temp.priority = p;  
    temp.next = null;  
    
    return temp;  
}  
    
// Return the value at head  
static int peek(Node head)  
{  
    return (head).data;  
}  
    
// Removes the element with the  
// highest priority form the list  
static Node pop(Node head)  
{  
    Node temp = head;  
    (head)  = (head).next;  
    return head; 
}    
    
// Function to push according to priority  
static Node push(Node head, int d, int p)  
{  
    Node start = (head);  
    
    // Create new Node  
    Node temp = newNode(d, p);  
    
    // Special Case: The head of list has lesser  
    // priority than new node. So insert new  
    // node before head node and change head node.  
    if ((head).priority > p) {  
    
        // Insert New Node before head  
        temp.next = head;  
        (head) = temp;  
    }  
    else {  
    
        // Traverse the list and find a  
        // position to insert new node  
        while (start.next != null &&  
               start.next.priority < p) {  
            start = start.next;  
        }  
    
        // Either at the ends of the list  
        // or at required position  
        temp.next = start.next;  
        start.next = temp;  
    }  
    return head; 
}  
    
// Function to check is list is empty  
static int isEmpty(Node head)  
{  
    return ((head) == null)?1:0;  
}  
    

public static void main(String args[]) 
{  
    // Create a Priority Queue  
    // 3 2 1 4   
    Node pq = newNode(2, 1);  
    pq =push(pq, 1, 2);  
    pq =push(pq, 4, 3);  
    pq =push(pq, 3, 0);  
    
    while (isEmpty(pq)==0) {  
        System.out.printf("%d ", peek(pq));  
        pq=pop(pq);  
    }  
    
}  
} 
