// Time Complexity : insert(): O(log n); extractMin(): O(log n); getMin(): O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2
{
    private int[] Heap;
    private int index;
    private int size;

    public MinHeap(int size) {
        this.size = size;
        this.index = 0;
        Heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    public void insert(int element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    public int extractMin() {
        int popped = Heap[0];
        Heap[0] = Heap[--index];
        minHeapify(0);
        return popped;
    }

    private void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (Heap[i] > Heap[leftChild(i)] ||
                    Heap[i] > Heap[rightChild(i)]) {
                if (Heap[leftChild(i)] < Heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    ppublic int getMin() {
        if(index < 0) {return 0;}
        return Heap[0];
    }

    private void swap(int x, int y) {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }
    public static void main(String[] arg)
    {
        MinHeap minHeap = new MinHeap(7);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        System.out.println("\nThe Min Value is : " + minHeap.extractMin());
    }
} 