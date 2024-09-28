// Time Complexity : O(logN)
// Space Complexity : O(n)

//Implement MinHeap

import java.util.Iterator;
import java.util.PriorityQueue;

class MinHeap {

    // PriorityQueue<Integer> pQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        MinHeap minHeap = new MinHeap();
        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(400);

        minHeap.getMin(pQueue);
        System.out.println("The queue elements:");

        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        minHeap.extractMin(pQueue);

        System.out.println("After removing an element "
                + "with poll function:");
        Iterator<Integer> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());

        minHeap.insert(pQueue, 60);

        System.out.println("after inserting 60 with"
                + " insert function:");
        Iterator<Integer> itr3 = pQueue.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());

        minHeap.extractMin(pQueue);

        System.out.println("After removing an element "
                + "with poll function:");
        Iterator<Integer> itr4 = pQueue.iterator();
        while (itr4.hasNext())
            System.out.println(itr4.next());

    }

    int getMin(PriorityQueue<Integer> pQueue) {
        System.out.println("Head value using peek function:" + pQueue.peek());
        return pQueue.peek();
    }

    // Removing the top priority element (or head) and
    // printing the modified pQueue using poll()
    void extractMin(PriorityQueue<Integer> pQueue) {
        if (!pQueue.isEmpty()) {
            int poll = pQueue.poll();

            System.out.println("Polling an element "
                    + "with poll function: " + poll);
        }
    }

    void insert(PriorityQueue<Integer> pQueue, int val) {
        pQueue.add(val);
    }

}