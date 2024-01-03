
// Time Complexity : insert : O(logN), pop : O(logN), isEmpty : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes on geeksforgeeks
// Any problem you faced while coding this : no


import java.util.ArrayList;
import java.util.List;

class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int pop() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int smallest = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);

        return smallest;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int smallestChildIndex = index;

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallestChildIndex)) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallestChildIndex)) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex == index) {
                break;
            }

            swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);

        int smallest = heap.pop();
        System.out.println("The smallest element is: " + smallest);

        while (!heap.isEmpty()) {
            smallest = heap.pop();
            System.out.println("The smallest element is: " + smallest);
        }
    }
}
