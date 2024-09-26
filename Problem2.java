// https://www.geeksforgeeks.org/min-heap-in-java/

// Time Complexity : O(logn) as building heap takes logn time 
// Space Complexity : O(m) where m is maxsize of heap
// Did this code successfully run on Leetcode : N/a
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach: I have used array to store elements. The property that parents start from
// index 1 and go till size/2. I have purposely put mininum integer at index 0 as even and odd size gives different indexes of parent
// if we start from index 0. 
class Minheap{
    int[] Heap;
    int size;
    int maxsize;
    private static final int START = 1; 

    public Minheap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int position) {
        return position / 2;
    }

    private int leftchild(int position) {
        return (2*position);
    }

    private int rightchild(int position) {
        return (2*position) + 1;
    }

    private boolean isleaf(int position) {
        if (position > size/2 && position <= size)
            return true;

        return false;
    }

        // Time and space - O(1)
    private void swap(int first, int second){
        int temp;
        temp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = temp;
    }

    // Time - O(logn) Space - O(1)
    private void minheapify(int position) {
        if (!isleaf(position)){
            if (Heap[position] > Heap[leftchild(position)] || Heap[position] > Heap[rightchild(position)]){
                if (Heap[leftchild(position)] < Heap[rightchild(position)]) {
                    swap(position, leftchild(position));
                    minheapify(leftchild(position));
                }
                else{
                    swap(position, rightchild(position));
                    minheapify(rightchild(position));
                }
            }
        }
    }

    // Time - O(logn) Space - O(m) where m is maxsize
    public void insert(int ele) {
        if (size >= maxsize)
            return;

        size = size + 1;
        Heap[size] = ele;

        int cur = size;
        while (Heap[cur] < Heap[parent(cur)]){
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    // Time - O(logn) Space - O(1)
    public void minheap() {
        for(int i=(size/2); i>=1; i--)
            minheapify(i);
    }

    // Time - O(logn) Space - O(1)
    public int remove() {
        int removed = Heap[START];
        Heap[START] = Heap[size];
        size = size - 1;
        minheapify(START);
        return removed;
    }

    

}
