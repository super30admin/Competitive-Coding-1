// Time Complexity : 
// getMin(): O(1)
// extractMin() & insert(): O(log(n)) --> where n in size of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public int getMin() {
        return heap.get(0);
    }

    public void extractMin() {
        int size = heap.size() - 1;
        if (size < 0) return;

        heap.set(0, heap.get(size));
        heap.remove(size);

        int parent = 0;
        int leftChild = (2 * parent) + 1;
        int rightChild = (2 * parent) + 2;
        int child;

        if (leftChild < heap.size() && rightChild < heap.size()) {
            child = (heap.get(leftChild) < heap.get(rightChild)) ? leftChild : rightChild;
        } else {
            return;
        }


        while (heap.get(parent) > heap.get(child)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(child));
            heap.set(child, temp);

            parent = child;
            leftChild = (2 * parent) + 1;
            rightChild = (2 * parent) + 2;

            if (leftChild < heap.size() && rightChild < heap.size()) {
                child = (heap.get(leftChild) < heap.get(rightChild)) ? leftChild : rightChild;
            } else {
                break;
            }
        }

    }

    public void insert(int ele) {
        heap.add(ele);
        if (heap.size() > 1) {
            heapifyUp();
        }
    }

    public void heapifyUp() {
        int size = heap.size();
        int child = size - 1;
        int parent = (child % 2 == 0) ? (child - 2) / 2 : (child - 1) / 2;
        while (heap.get(parent) > heap.get(child)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(child));
            heap.set(child, temp);

            child = parent;
            if (child > 0) {
                parent = (child % 2 == 0) ? (child - 2) / 2 : (child - 2) / 2;
            }
        }
    }

    public void heapifyDown() {

    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(4);
        heap.insert(2);
        heap.insert(3);
        heap.insert(1);
        heap.insert(10);
        heap.insert(9);
        heap.insert(6);
        heap.insert(8);
        heap.insert(7);
        heap.insert(5);

        System.out.println(heap.heap.size());
        System.out.println(heap.getMin());
        for (int num : heap.heap) {
            System.out.print(num + ", ");
        }
        System.out.println();

        heap.extractMin();
        heap.extractMin();

        System.out.println(heap.heap.size());
        for (int num : heap.heap) {
            System.out.print(num + ", ");
        }
    }
}

