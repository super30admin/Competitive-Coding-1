// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinHeap {

    int size;
    int maxsize;
    int[] heap;

    minHeap(int maxsize) {
        this.size = 0;
        this.maxsize = maxsize;
        heap = new int[this.maxsize];
        heap[0] = Integer.MIN_VALUE;

    }

    private void swap(int fpos, int spos) {
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;

    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftchild(int pos) {
        return (2 * pos);
    }

    private int rightchild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > size / 2) {
            return true;
        }
        return false;
    }

    private void insert(int val) {  //insert in the array

        if (size >= maxsize) {
            return;
        }
        heap[++size] = val;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void bubbleDown(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos;
            if (rightchild(pos) <= size) {
                swapPos = heap[leftchild(pos)] < heap[rightchild(pos)] ? leftchild(pos) : rightchild(pos);
            } else {
                swapPos = leftchild(pos);
            }
            if (heap[pos] > heap[leftchild(pos)] || heap[pos] > heap[rightchild(pos)]) {
                swap(pos, swapPos);
                bubbleDown(swapPos);
            }
        }
    }

    private int remove() {
        int temp = heap[1];
        heap[1] = heap[size--];
        bubbleDown(1);
        return temp;
    }

    private void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    " Parent : " + heap[i]
                            + " Left Child : " + heap[2 * i]
                            + " Right Child :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeap Heap = new MinHeap(15);
        Heap.insert(5);
        Heap.insert(3);
        Heap.insert(17);
        Heap.insert(10);
        Heap.insert(84);
        Heap.insert(19);
        Heap.insert(6);
        Heap.insert(22);
        Heap.insert(9);

        Heap.print();
        int min = Heap.remove();
        System.out.println("The Min val is " + min);

    }

}