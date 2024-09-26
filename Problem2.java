// Time Complexity : O(log n) for insert. O(1) for getMin and O(log n) for extractMin
// Space Complexity : O(1) as no extra space is used other than to construct minheap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinHeap {
    private int[] arr;
    private int size;
    private int maxsize;

    private static final int top = 1;

    public MinHeap(int maxsize) // initalize minheap with size
    {
        this.maxsize = maxsize;
        this.size = 0;
        arr = new int[this.maxsize + 1]; // create array with given size+1 as it startes with 0 index
        arr[0] = Integer.MIN_VALUE; // initialize first index to min value
    }

    // Constructs minheap
    private void minHeap(int pos)
    {

        boolean leaf=(pos >= (size / 2) && pos <= size);
        int leftchild=2 * pos;
        int rightchild=(2 * pos)+1;
        if (!leaf) { // node is not a leaf
            if (arr[pos] > arr[leftchild] // current pos > left child or right child
                    || arr[pos] > arr[rightchild]) {

                if (arr[leftchild]< arr[rightchild]) { // check if left is less than right
                    swap(pos, leftchild);    // swap and again recursively apply heap on leftchild
                    minHeap(leftchild);
                }
                else { // else right is greater than left
                    swap(pos, rightchild); // so swap current with right and recursively apply heap on rightchild
                    minHeap(rightchild);
                }
            }
        }
    }

        // Function to swap two nodes of the heap
    private void swap(int i, int j)
    {
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public void insert(int element)
    {
        if (size >= maxsize) {  // if current size of heap exceeds maxsize.. not place to add new elements so return
            return;
        }
        arr[++size] = element; // increment size pointer pf arr and assign new element at end
        int current = size;

        while (arr[current] < arr[current/2]) { // chekc if current less than parent node(parent node is /2)
            swap(current, current/2); // swap their positions if true
            current = current/2; // reassign current node to parent
        }
    }

    public int extractMin()
    {
        int popped = arr[top]; // returns minimum element and pops. Calls minheapify to reconstruct minheap
        arr[top] = arr[size--];
        minHeap(top);
        return popped;
    }

    public int getMin(){

        return arr[top]; // returns root element
    }

}
