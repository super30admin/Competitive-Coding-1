/*
problem statement - Design MinHeap
Time Complexity -
insert - O(log n) inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If a new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
remove - O(log n) if removing the root element violates the property of heap we have to perform heapify starting from the root to retore heap properties
Space Complexity - O(n)
 */

public class MinHeap {
    private int [] minHeap;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        minHeap = new int[this.maxSize+1];
        minHeap[0] = Integer.MIN_VALUE;
    }

    // Method to return the position the parent node
    private int findParent(int index) {
        return index/2;
    }
    //method to return the position the left node
    private int findLeft(int index) {
        return (index*2);
    }
    //method to return the position of right node

    private int findRight(int index) {
        return (index*2)+1;
    }
    //method to find the leaf node
    private boolean isLeafNode(int index) {
        if(index > (size/2)){
            return true;
        }
        return false;
    }
    private void minHeapify(int index){
       while (!isLeafNode(index)){
           int left = findLeft(index);
           int right = findRight(index);
           int smallest = left;
           if(right <= size && minHeap[right] < minHeap[left]){
               smallest = right;
           }
           if(minHeap[index] <= minHeap[smallest]){
               break;
           }
           swap(index,smallest);
           index = smallest;
       }
    }

    private void swap(int index1, int index2) {
        int temp = minHeap[index1];
        minHeap[index1] = minHeap[index2];
        minHeap[index2] = temp;
    }
    public void insert(int value) {
        if(size >= maxSize){
            return;
        }
        minHeap[++size] = value;
        int current = size;
        //swap the current value if the current value is less than its parent
        while(minHeap[current] < minHeap[findParent(current)]){
            swap(current, findParent(current));
            current = findParent(current);
        }
    }
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + minHeap[i]);

            int left = findLeft(i);
            int right = findRight(i);

            if (left <= size) {
                System.out.print(" LEFT CHILD : " + minHeap[left]);
            }

            if (right <= size) {
                System.out.print(" RIGHT CHILD : " + minHeap[right]);
            }

            System.out.println();
        }
    }
    public int remove(){
        int value = minHeap[FRONT];
        minHeap[FRONT] = minHeap[size--];
        minHeapify(FRONT);
        return value;
    }

}
