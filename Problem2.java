
/*
https://www.geeksforgeeks.org/min-heap-in-java/
Time: Offer/Insert is O(logN), Peek/Poll is O(1)
Space: O(N)
*/
import java.util.Iterator;
import java.util.PriorityQueue;

class Problem2 {

    public static void main(String[] args) {

        // Creating priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to pq
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);

        // Peek an element from the top of pq
        pq.peek();

        // Print all elements of a pq
        Iterator itr = pq.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Removing the top priority element
        pq.poll();

        // Remove a specific element
        pq.remove(30);

        // Check if an element is present using contains()
        System.out.println(pq.contains(20));

        // Store pq elements in an array
        Object[] arr = pq.toArray();

        // Print values of the array
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Array element is " + arr[i]);
        }
    }

}