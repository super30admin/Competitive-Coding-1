//Time Complexity
//GetMin O(1)
//insert O(logn)
//extractMin O(logn)

public class MinHeap {
    int arr[];
    int capacity;
    int currSize;

    MinHeap(int capacity) {
        arr = new int[capacity];
        currSize = 0;
    }

    public void insert(int num) {

        currSize++;
        int i = currSize - 1;
        arr[i] = num;

        while (i != 0 && arr[parent(i)] > arr[i]) {

            // swap parent and child
            int t = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = t;

            // Go upwards
            i = parent(i);
        }

    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public int getMin() {

        return arr[0];

    }

    public int extractMin() {

        if (currSize == 1) {
            currSize--;
            return arr[0];
        }

        int min = arr[0];
        arr[0] = arr[currSize - 1];
        currSize--;
        MinHeapify(0);

        return min;

    }

    public void MinHeapify(int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int root = i;

        if (left < currSize && arr[left] < arr[i])
            root = left;

        if (right < currSize && arr[right] < arr[root])
            root = right;

        if (root != i) {
            // swap parent and min child
            int t = arr[root];
            arr[root] = arr[i];
            arr[i] = t;

            MinHeapify(root);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MinHeap heap = new MinHeap(5);

        heap.insert(60);
        heap.insert(10);
        heap.insert(90);
        heap.insert(25);
        heap.insert(20);
        System.out.println(heap.getMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.getMin());

    }

}
