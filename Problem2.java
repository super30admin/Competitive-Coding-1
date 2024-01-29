
// Time complexity: O(logn)
// Space complexity: O(1)
/*
 * Approach: If mid value = mid + 1; then left side is fine, move to right side.
 * If mid value != mid + 1; then element lies on the left. When the loop exits,
 * the low pointer points to the first element that is out of order (if there's
 * one).
 * So, return either low + 1 or nums[low] - 1
 */
import java.util.ArrayList;

public class Problem2 {
    private ArrayList<Integer> heap;

    public Problem2() {
        this.heap = new ArrayList<Integer>();
    }

    public int getMin() {
        if (heap.size() > 0) {
            System.out.println("Heap is empty!");
            return heap.get(0);
        }
        return -1;
    }

    public int extractMin() {
        return -1;
    }

    public int getParentIndex(int index) {
        return index / 2;
    }

    public void insert(int value) {
        heap.add(value);
        // heapify
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

    }
}