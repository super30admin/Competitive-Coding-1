package mock;

import java.util.*;

public class MinHeap {

    // Driver code
    public static void main(String args[])
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(400);

        // Printing the most priority element
        System.out.println("Min Element:" + pq.peek());

        // Printing all elements
        System.out.println("The queue elements:");
        Iterator itr = pq.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        pq.poll();
        System.out.println("After removing the min element");
        Iterator<Integer> itr2 = pq.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());

        // Removing 30 using remove()
        pq.remove(30);
        System.out.println("after removing 30");
        Iterator<Integer> itr3 = pq.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());

        // Check if an element is present using contains()
        System.out.println("Priority queue contains 20:" + pq.contains(20));

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pq.toArray();
        System.out.println("Value in array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i].toString());
    }
}