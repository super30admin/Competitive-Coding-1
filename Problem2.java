
// Time complexity: insert, extractMin: O(logn); getMin: O(1)
// Space complexity: O(1): No auxilliary space other than the heap itself
/*
 * Approach: Minheap's first element is always on 0th index. So, whenever we insert; we add it to the end
 * and then compare it with it's parent till it's bigger than the parent or reaches the root (it is the min element)
 * For extractMin(): We replace the min with the last element (and then remove the last element) and compare it with
 * it's children and keep swapping it with the min children if min children's value is less than the element
 */
import java.util.ArrayList;

public class Problem2 {
    private ArrayList<Integer> heap;

    public Problem2() {
        this.heap = new ArrayList<Integer>();
    }

    public int getMin() {
        if (heap.size() <= 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        System.out.println(heap.toString());
        return heap.get(0);
    }

    public int extractMin() {
        if (heap.size() == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        // return at the end of the fn
        int min = heap.get(0);
        // swap with last element; then remove
        swap(0, heap.size() - 1);
        // removing last element
        heap.remove(heap.size() - 1);

        // now the root might have an element that does not follow the heap property
        // heapify root: keep swapping with children which are smaller
        int index = 0, swapWith = 0;
        while (true) {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            // if left child exists
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(swapWith)) {
                swapWith = leftChildIndex;
            }

            // if right child exists
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(swapWith)) {
                swapWith = rightChildIndex;
            }

            // break loop if neither child is present or smaller than the inserted element
            if (swapWith == index)
                break;
            swap(swapWith, index);
            index = swapWith;
        }

        return min;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public void insert(int value) {
        heap.add(value);

        // heapify (getting the new element to it's right place)
        // comparing with parents and switching if it' value is less than it's ancestors
        int index = heap.size() - 1;
        while (index != 0) {
            int parentIndex = getParentIndex(index);
            if (heap.get(index) > heap.get(parentIndex))
                return;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    public void swap(int x, int y) {
        int temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        obj.insert(5);
        obj.insert(43);
        obj.insert(2);
        obj.insert(1);
        obj.insert(-4);
        obj.insert(0);

        System.out.println(obj.heap.toString());

        System.out.println(obj.getMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.extractMin());
    }
}