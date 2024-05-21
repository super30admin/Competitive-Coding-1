//Problem Name: Interview Problem: Design Min Heap
//TC - getMin() - O(1), insert() - O(log n), remove() - O(log n)
public class Problem2 {

    int[] minHeap;
    int size;
    int maxSize;

    public Problem2(int maxSize) {
        size = -1;
        this.maxSize = maxSize;
        this.minHeap = new int[maxSize + 1];
    }

    //function to get the parent for this pos(child)
    public int getParent(int pos) {

        return (pos-1)/2;
    }

    //function to left get child for this pos(parent)
    public int getLeftChild(int pos) {

        return 2*pos + 1;
    }

    //function to left get child for this pos(parent)
    public int getRightChild(int pos) {

        return 2*pos + 2;
    }

    //function to check if the node is a leaf node
    public boolean isLeafNode(int pos) {
        return pos >= size / 2;
    }

    //function to swap elements
    public void swap(int pos1, int pos2) {

        int temp = minHeap[pos1];
        minHeap[pos1] = minHeap[pos2];
        minHeap[pos2] = temp;
    }

    //heapify function to maintain the heap property if an element is deleted
    public void heapify(int pos) {
        if(!isLeafNode(pos)) {
            //Check if this pos is greater than its left or right child, swap this position with min(leftChild, rightChild)
            int leftPos = getLeftChild(pos);
            int rightPos = getRightChild(pos);
            if(minHeap[pos] > minHeap[leftPos] || minHeap[pos] > minHeap[rightPos]) {
                int swapPos = (minHeap[leftPos] <= minHeap[rightPos])? leftPos : rightPos;
                swap(pos, swapPos);
            }
        }
    }

    //function to insert an element into the heap
    public void insert(int item) {
        if(size >= maxSize)
            return;

        minHeap[++size] = item;

        //if item value is less than its parent, then swap the parent with item and check other elements upwards
        int current = size;
        while(item < minHeap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    //function to get min element
    public int getMin() {
        if(size == 0)
            return Integer.MIN_VALUE;
        return minHeap[0];
    }

    //function to delete element from minHeap and return the min element
    public int remove() {
        int popped = minHeap[0];
        minHeap[0] = minHeap[size--];
        heapify(0);
        return popped;
    }

    public void print()
    {
        for (int i = 0; i < size / 2; i++) {

            System.out.print(
                    " PARENT : " + minHeap[i]
                            + " LEFT CHILD : " + minHeap[2 * i + 1]
                            + " RIGHT CHILD :" + minHeap[2 * i + 2]);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Problem2 minHeap = new Problem2(10);

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

        //Get Min element
        System.out.println("Min element =" + minHeap.getMin());

        //Remove 3
        System.out.println("Removed element =" + minHeap.remove());

        //Get Min element
        System.out.println("Min element =" + minHeap.getMin());

        //Insert 1
        minHeap.insert(1);

        //Get Min element
        System.out.println("Min element =" + minHeap.getMin());
    }
}
