/**
 * Approach:
 * - This function inserts a new value into a Min-Heap represented by an array.
 * - Step 1: Place the new element at the end of the heap (next available index).
 * - Step 2: "Heapify up" — compare the inserted element with its parent.
 * - If the parent is greater than the current element, swap them.
 * - Repeat this process until the Min-Heap property is restored (i.e., parent ≤ child).
 * - Uses a simple swap helper to switch two elements in the array.
 *
 * Time Complexity: O(log N), where N is the number of elements in the heap.
 * Space Complexity: O(1), as operations are done in-place.
 */

public class MinHeap {
    // Function to insert a new element into the Min-Heap
    public static void insertMinHeap(int[] heap, int size, int value) {
        // Add the new value at the next available position
        heap[size] = value;
        int index = size;

        // Heapify up: move the element up to maintain Min-Heap property
        while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
            swap(heap, index, (index - 1) / 2); // Swap with parent
            index = (index - 1) / 2; // Move to parent index
        }
    }
    // Helper function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
