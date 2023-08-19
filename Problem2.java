//Time Complexity:
// Insert : O(LogN)
// MinHeap: 
//Space Complexity: O(1)
class Problem2 {
    int[] heap;
    int size;
    int maxSize;

    int front = 1;

    public Problem2 (int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize +1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos/2;
    }

    private int leftChild(int pos) {
        return 2*pos;
    }
    
    private int rightChild(int pos) {
        return (2*pos)+1;
    }

    private boolean isLeaf(int pos) {
        if(pos > (size/2)) return true;
        return false;
    }
    
    private void swap(int pos1, int pos2) {
        int temp = heap[pos2];
        heap[pos2] = heap[pos1];
        heap[pos1] = temp;
    }

    private void minHeapify(int pos) {
        if(!isLeaf(pos)) {
            int idx = pos;
            if(rightChild(pos) <= size) {
                idx = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            } else {
                idx = leftChild(pos); 
            }
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                swap(pos, idx);
                minHeapify(idx);
            }

        }
    }

    public void insert (int ele) {
        if(size >= maxSize) return;
        heap[++size] = ele;
        int current  = size;

        while(heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for(int i = 1; i < size/2; i++) {
            System.out.println("Parent: " + heap[i] + " Left Child: "+heap[2*i]+ " Right Child: "+ heap[2*i+1]);
            System.out.println();
        }
    }

    public int remove() {
        int pop = heap[front];
        heap[front] = heap[size--];
        minHeapify(front);
        return pop;
    }

    public static void main(String[] arg) {
        System.out.println("The min heap is ");
        Problem2 minHeap = new Problem2(15);
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
        System.out.println("The min val is "+ minHeap.remove());
    }
}
