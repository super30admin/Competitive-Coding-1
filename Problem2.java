//Time = O(log n)
//Space = O(1)

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a PriorityQueue to represent a Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements into the Min-Heap
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(30);
        minHeap.add(40);

        // Extract and print the minimum element
        System.out.println("The minimum element is: " + minHeap.poll());

        // Print the elements in the Min-Heap
        System.out.println("Elements in the Min-Heap:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}

