// Time Complexity : getMin O(1), remove O(log n), insert O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* For insertion, we add element to end of array the check if newly added value is violating the min heap rule. If yes we swap them
   and "bubble-up" to parent till we reach the root. While removing we just pop element from front of array by swapping it with last 
   leaf element. Then we "bubble-down" from root to check if any child node is violating the min heap rule and swap parent with child
   of lesser value. We bubble down till we encounter a leaf.
*/

public class MinHeap {
    int[] heap;
    int size;
    int currSize;

    public MinHeap(int size) {
        this.size = size;
        this.currSize = 0;
        heap = new int[size + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    private boolean isLeaf(int pos) {
        if(pos > (currSize / 2))
            return true;
        return false;
    }

    private void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    private void insert(int element) {
        if(currSize >= size)
            return;
        heap[++currSize] = element;
        int current = currSize;
        while(heap[parent(current)] > heap[current]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void heapify(int pos) {
        if(!isLeaf(pos)) {
            int swapPos = pos;
            if(rightChild(pos) <= currSize) 
                swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            else
                swapPos = leftChild(pos);
            
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                swap(pos, swapPos);
                heapify(swapPos);
            }
        }
    }

    private int remove() {
        int popped = heap[1];
        heap[1] = heap[currSize--];
        heapify(1);

        return popped;
    }

    private void print() {
        for (int i = 1; i <= currSize; ++i) 
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main (String args[]) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
 
        // Print all elements of the heap
        minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                           + minHeap.remove());
        
        // Print all elements of the heap
        minHeap.print();
    }
}

//Output
//3 5 6 9 84 19 17 22 10 
//The Min val is 3
//5 9 6 10 84 19 17 22 