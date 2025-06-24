//Problem 2: Design Min Heap
// TC = O(log N) for insert & extractMin
// Approach: Insert places the element at end and "bubbles up" to maintain min-heap.
// ExtractMin swaps root with last element, removes it, then "bubbles down" to restore heap.
// Parent, left, and right indices are calculated using array index math.
class MinHeap{
    int capacity;
    int index;
    int[] heap;

    public MinHeap(){
        this.capacity = 1000;
        this.index = 0;
        this.heap = new int[capacity];
    }

    public int getParent(int i) { return (i - 1) / 2; }
    public int getLeft(int i) { return 2 * i + 1; }
    public int getRight(int i) { return 2 * i + 2; }

    public void insert(int element){
        if(index == capacity) return;
        
        heap[index] = element;
        int i = 0;
        index++;

        //Heapify-up
        while(i!=0 && getParent(i) > element){
            int temp = heap[i];
            heap[i] = heap[getParent(i)];
            heap[getParent(i)] = temp;
            i = getParent(i);
        }
    }

    public int extractMin(){
        if (index <= 0) return Integer.MIN_VALUE;
        if (index == 1) return heap[--index];

        int root = heap[0];
        heap[0] = heap[--index];
        heapifyDown(0);
        return root;

    }

    public void heapifyDown(int i){
        int left = getLeft(i);
        int right = getRight(i);
        int smallest = i;

        if (left < index && heap[left] < heap[smallest]) smallest = left;
        if (right < index && heap[right] < heap[smallest]) smallest = right;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(smallest);
        }
    }
}