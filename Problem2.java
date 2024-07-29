// TC O(nlogn) for adding , O(n) printing element ,O(nlogn) removing element
//SC O(n)
import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        // PriorityQueue 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements 
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(3);

        // Print elements 
        System.out.println("Min-Heap elements: " + minHeap);

        // Remove elements
        while (!minHeap.isEmpty()) {
            // Polling removes the root element (the smallest element)
            System.out.println("Removed element: " + minHeap.poll());
        }
    }
}
