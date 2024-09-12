/*Implement Priority Queue using Linked Lists.

Operations on Priority Queue :

push(): This function is used to insert a new data into the queue.
pop(): This function removes the element with the highest priority form the queue.
peek() / top(): This function is used to get the highest priority element in the queue without removing it from the queue
*/

//Time Complexity: push - O(n), pop - O(1), peek - O(1)
//Space Complexity: O(n)

import java.io.*;

class Solution2
{
	Node head;
	
	public class Node
	{
		int data;
		int priority;
		Node next;
		//initialise the node component of the LinkedList
		Node(int d,int p)
		{
			this.data = d;
			this.priority = p;
			this.next = null;
		}
	}

	/*
	 * to push an element
	 * case 1: empty queue-> assign node to head
	 * case 2: current element's priority>head's priority ->assign current element = head, move the list to the right
	 * case 3: current element's priority<head's priority ->find where the element should lie based on priority, add it to that location
	*/
	public void push(int data, int p)
	{
		Node temp = new Node(data,p);
		if(head==null)
		{
			head = temp;
		}
		else if(head.priority<p)
		{
			temp.next = head;
			head = temp;
		}
		else
		{
			Node ptr = head;
			while(ptr.next!=null && ptr.priority>p)
			{
				ptr = ptr.next;
			}
			temp.next = ptr.next;
			ptr.next = temp;
			
		}
		
	}
	
	
	//remove the head(if list not empty), move the head to next node
	public void pop()
	{
		if(head==null)
			System.out.println("List is empty! Nothing to pop!");
		System.out.println("Element removed is:  Data - " + head.data+" Priority: "+head.priority);
		head = head.next;
	}
	
	public int peek()
	{
		return head.data; //head is the highest priority element -> print it's data
	}
	
	
	
	public static void main(String args[])
	{
		Solution2 obj = new Solution2();
		obj.push(1,4);
		System.out.println(obj.peek());
		obj.push(2,5);
		System.out.println(obj.peek());
		obj.push(3,3);
		System.out.println(obj.peek());
		obj.pop();
		System.out.println(obj.peek());
		obj.pop();
		System.out.println(obj.peek());
	}
}