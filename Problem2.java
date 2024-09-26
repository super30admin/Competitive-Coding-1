// Time Complexity : O(log(n)) for insert, O(log(n)) for remove, O(1) for getMin, O(1) for getsize, O(n) for print where n = size of minheap
// Space Complexity : O(1) other than space of size n required fo the minheap
// Did this code successfully run on Leetcode : Did not find on Leetcode
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem2 {
    
    // Instance variables for the class  
    private int[] heap;
    private int size;
    private int maxsize;

    // Constructor
    public Problem2(int maxsize) {
        // Initialise the values for the Instance variables
        this.maxsize = maxsize;
        this.size = 0;
        this.heap = new int[maxsize];
    }

    // The root of the minheap is the minimum element 
    public int getMin() {
        return this.heap[0];
    }

    // Insert a new number to minheap
    public void insert(int num) {
        // If the heap size is already maximum allowed size, do nothing
        if (this.size == this.maxsize){
            return;
        }
        // The current size is the index at which new element has to be inserted
        int index = this.size;
        // Increment the size
        this.size++;
        // Add the new element at the end
        this.heap[index] = num;
        // Index of parent is calculated by (child index-1)/2 
        int parentindex = (index-1) / 2;
        // Min heapify from last inserted leaf node to the root node of the tree
        while (index-1 >= 0 ) {
            if (this.heap[index] <this.heap[parentindex]) {
                int temp = this.heap[index];
                this.heap[index] = this.heap[parentindex];
                this.heap[parentindex] = temp;
            } else {
                break;
            }
            index = parentindex;
            parentindex = (index-1) / 2;
        }

    }

    // Remove the minimum element from minheap
    public void remove() { 
        // Put the value of the last leaf node in the minheap to the root      
        this.heap[0] = this.heap[this.size-1];
        // Reset the value of the last leaf node to 0
        this.heap[this.size-1] = 0;
        // Reduce size of minheap by 1
        this.size--;
        int index = 0;
        int leftchildindex = 2*index + 1;
        int rightchildindex = 2*index + 2;
        while (leftchildindex < this.size && rightchildindex < this.size) {
            // If the element at any of the children is less than the parent element
            if (this.heap[leftchildindex] < this.heap[index] || this.heap[rightchildindex] < this.heap[index]) {
                // If element at leftchild is less than rightchild
                if (this.heap[leftchildindex] < this.heap[rightchildindex]) {
                    // Swap parent and leftchild
                    int temp1 = this.heap[index];
                    this.heap[index] = this.heap[leftchildindex];
                    this.heap[leftchildindex] = temp1;
                    // Minheapify till leaf node at rightindex
                    index = rightchildindex;
                } else { // If element at leftchild is more than or equal to rightchild
                    // Swap parent and rightchild
                    int temp1 = this.heap[index];
                    this.heap[index] = this.heap[rightchildindex];
                    this.heap[rightchildindex] = temp1;
                    // Minheapify till leaf node at leftindex
                    index = leftchildindex;
                }
            } else { // If the element at both the children is more than or equal to the parent element, break the loop
                break;
            }
            leftchildindex = 2*index + 1;
            rightchildindex = 2*index + 2;
        }
    }

    // The value of the size variable is the present size of the minheap
    public int getsize() {
        return this.size;
    }

    // Print the minheap
    public void print() {
        int lastindex = this.size-1;
        for (int i = 0; i <= (lastindex-1)/2; i++) {
            System.out.println("Parent: " + this.heap[i] + ", Left Child: " + this.heap[2*i+1] + ", Right Child: " + this.heap[2*i+2]);
        }
    }

    public static void main(String[] args) {
        Problem2 minHeap = new Problem2(20);
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
        System.out.println("The minimum element is: " + minHeap.getMin());
        System.out.println("The size of the minheap is: " + minHeap.getsize());
        minHeap.remove();
        minHeap.insert(20);
        minHeap.print();
        System.out.println("The minimum element is: " + minHeap.getMin());
        System.out.println("The size of the minheap is: " + minHeap.getsize());
        minHeap.remove();
        minHeap.print();
        System.out.println("The minimum element is: " + minHeap.getMin());
        System.out.println("The size of the minheap is: " + minHeap.getsize());
    }
}


