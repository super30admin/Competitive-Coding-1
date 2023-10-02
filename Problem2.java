

// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

import java.util.Arrays;

// Time Complexity : log(N) for insert & delete. Overall time complexity for min heap construction would be O(NlogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

public class Problem2
{
    public class MinHeap {
        int[] heap;
        int size = 0;

        public MinHeap(int initialCapacity) {
            heap = new int[initialCapacity];
        }

        public void add(int element) {
            if ((size * 100) / heap.length >= 75)
                arrayResize();

            heap[size] = element;
            reorder(size);
            size++;
        }

        public int pop() {
            if (size > 0) {
                int popped = heap[0];
                swap(0, size - 1);
                size--;
                heapify(0);
                return popped;
            } else
                return -1;
        }

        public void heapify(int index) {
            if (size == 0)
                return;
            int leftChildIdx = ((2 * index) + 1);
            int rightChildIdx = ((2 * index) + 2);
            int swapIdx;
            if (leftChildIdx < size && rightChildIdx < size) // Both child
                swapIdx = (heap[leftChildIdx] < heap[rightChildIdx]) ? leftChildIdx : rightChildIdx;
            else if (leftChildIdx < size) // Just left child
                swapIdx = leftChildIdx;
            else
                return; // Leave node

            if (heap[index] > heap[swapIdx]) {
                swap(index, swapIdx);
                heapify(swapIdx);
            }
        }

        public int peek() {
            return (size > 0) ? heap[0] : -1;
        }

        public void arrayResize() {
            int[] newArr = new int[heap.length * 2];
            System.arraycopy(heap, 0, newArr, 0, heap.length);
            heap = newArr;
        }

        public void reorder(int heapIdx) {
            if (heapIdx != 0 && heap[(heapIdx - 1) / 2] > heap[heapIdx]) {
                swap(heapIdx, (heapIdx - 1) / 2);
                reorder((heapIdx - 1) / 2);
            }
        }
        public void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }
    }
}