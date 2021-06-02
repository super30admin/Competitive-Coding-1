//Time Complexity: Insertion O(logn), getMin O(1), extractMin O(logn)
//Space Complexity: O(n)

import java.util.PriorityQueue;

public class MinHeap {

    static PriorityQueue<Integer> priorityQueue;

    public MinHeap() {
        priorityQueue = new PriorityQueue<>();
    }

    //the most priority/root element of the heap
    public static int getMin() {
        return priorityQueue.peek();
    }

    //Remove the most priority/root element of the heap and does heapification
    public static int extractMin() {
        return priorityQueue.poll();
    }
    
    public static void insert(int element) {
        priorityQueue.add(element);
    }

    public static void printMinHeap() {

        for (Integer integer : priorityQueue)
            System.out.println(integer);
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(12);
        minHeap.insert(17);
        minHeap.insert(5);
        minHeap.insert(15);

        System.out.println("Min Heap\n");
        minHeap.printMinHeap();
        System.out.println("Get Min\n");
        System.out.println(minHeap.getMin());
        System.out.println("extract Min\n");
        System.out.println(minHeap.extractMin());
        System.out.println("Min Heap\n");
        minHeap.printMinHeap();
    }
}

