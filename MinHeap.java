public class MinHeap {
    private int[] Heap;
    private int length;
    private int capacity;

    private static final int  head= 1;

    public MinHeap(int maxsize)
    {
        this.capacity = maxsize;
        this.length = 0;
        Heap = new int[this.capacity + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos)
    {
        return pos / 2;
    }
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (length / 2) && pos <= length) {
            return true;
        }
        return false;
    }
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(int element)
    {
        if (length >= capacity) {
            return;
        }
        Heap[++length] = element;
        int current = length;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void minHeap()
    {
        for (int pos = (length/2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }
    public int remove()
    {
        int popped = Heap[head];
        Heap[head] = Heap[length--];
        minHeapify(head);
        return popped;
    }
    public static void main(String[] arg)
    {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
        System.out.println("The Min val is " + minHeap.remove());
    }
}

//time complexity for finding the top element in the heap is O(1), for inserting and removing it's O(logN).
//Space complexity is O(N) because we're making use of an array.
