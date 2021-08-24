// MIN HEAP
// TIME for INSERT: O(logn)
// EXTRACT-MIN: O(logn)
// GET MIN: O(1)
// MIN-HEAPIFY: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode


class MinHeap {
    Node root;
    int size;
    int[] minHeap;
    
    class Node {
        int value;
        Node left;
        Node right;
        
        Node(int val) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    MinHeap(int maxSize) {
        this.size = -1;
        this.minHeap = new int[maxSize];
        for (int i = 0; i < minHeap.length; i++) {
            minHeap[i] = Integer.MAX_VALUE;
        }
    }
    
    private boolean isLeaf(int pos) {
        return pos > this.size / 2 + 1 && pos <= this.size; 
    }
    
    public void insert(int val) {
        minHeap[++size] = val;
        // minHeapify(size);
        int current = size;
        while(minHeap[current] < minHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    
    public int extractMin() {
        int min = minHeap[0];
        minHeap[0] = minHeap[size--];
        minHeapify(0);
        return min;
    }
    
    private int parent(int child) {
        return (child - 1) / 2;
    }
    
    private int leftChild(int parent) {
        return 2 * parent + 1;
    }
    
    private int rightChild(int parent) {
        return 2 * parent + 2;
    }
    
    private void swap(int pos1, int pos2) {
        int temp = minHeap[pos1];
        minHeap[pos1] = minHeap[pos2];
        minHeap[pos2] = temp;
    }
    
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (minHeap[pos] > minHeap[leftChild(pos)] || minHeap[pos] > minHeap[rightChild(pos)]) {
                if (minHeap[leftChild(pos)] < minHeap[rightChild(pos)]) {
                    swap(leftChild(pos), pos);
                    minHeapify(leftChild(pos));
                } else {
                    swap(rightChild(pos), pos);
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    
    public void print() { 
        for (int i = 0; i <= size; i++) {
            System.out.print(minHeap[i]); 
        }
    } 
}

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(2);
        minHeap.insert(3);
        
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(0);
        minHeap.print();
        System.out.println(minHeap.extractMin());
    }
}