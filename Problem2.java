// Time Complexity : insert and remove O(logn) , getMin - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : No

public class Program2 {
    private int[] heap;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;

    public Program2(int maxSize) {
        this.heap = new int[maxSize+1];
        this.size = 0;
        this.maxSize = maxSize;
        heap[0] = Integer.MIN_VALUE;
    }

    //find the position of parent and its children
    public int parent(int index) {
        return index/2;
    }
    private int leftChild(int index) {
        return (2*index);
    }
    private int rightChild(int index) {
        return (2*index)+1;
    }
    //find the node is leaf node
    private boolean isLeafNode(int index) {
        if(index >= (size/2) && index<= size) {
            return true;
        }else {
            return false;
        }
    }

    //swap two elements two maintain min heap
    private void swapElements(int firstIndex, int secondIndex) {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    private void minHeapify(int index) {
        if(!isLeafNode(index)) {
            if(heap[index] > heap[leftChild(index)] || heap[index] > heap[rightChild(index)]){
                //if the current element is greater than left or its right child then swap and current and left child
                if(heap[leftChild(index)] < heap[rightChild(index)]) {
                    swapElements(index,leftChild(index));
                    minHeapify(leftChild(index));
                } else {
                    //swap right child
                    swapElements(index,rightChild(index));
                    minHeapify(rightChild(index));
                }
            }
        }
    }

    //remove element
    public int removeElement() {
        int poppedElement = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return poppedElement;
    }

    public void insert(int element) {
        if(size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;
        while(heap[current] < heap[parent(current)]) {
            swapElements(current, parent(current));
            current = parent(current);
        }
    }

    public int getMin() {
        return heap[FRONT];
    }
    public void print()
    {
         System.out.println("size"+size);
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("Parent : " + heap[i]);
            if (leftChild(i) <= size)
                System.out.print(" Left : " + heap[leftChild(i)]);
            if (rightChild(i) <= size)
                System.out.print(" Right :" + heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        Program2 minHeap = new Program2(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        minHeap.removeElement();
        System.out.println("*******after removing element*****");
        minHeap.print();
        System.out.println("minimum element "+minHeap.getMin());
    }
}

