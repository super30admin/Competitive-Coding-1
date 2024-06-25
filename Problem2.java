public class Problem2 {
    // Problem 2 is https://www.geeksforgeeks.org/min-heap-in-java/#
    private static int[] heap;
    private static int capacity;
    private static int size;

    public Problem2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity+1];
        heap[0] = Integer.MIN_VALUE;
    }

    private static int parent(int pos) {
        return pos/2;
    }

    private static int leftChild(int pos) {
        return 2*pos;
    }

    private static int rightChild(int pos) {
        return 2*pos + 1;
    }

    private int peak() {
        return heap[1];
    }

    private static boolean isLeaf(int pos) {
        return (size/2 < pos && pos <= size);
    }

    private void print() {
        for(int i = 1; i <= size/2; i++) {
            System.out.println("Parent is: " + heap[i]
            + " Left child is: " + heap[leftChild(i)] +
                    " Right child is: " + heap[rightChild(i)]);
        }
    }

    private static void swap(int prev, int current) { //helper function
        int temp = heap[prev];
        heap[prev] = heap[current];
        heap[current] = temp;
    }

    private void insert(int val) {
        if(size >= capacity) return;

        heap[++size] = val;
        int current = size;
        while(heap[parent(current)] > heap[current]) {
            swap(parent(current), current);
            current = parent(current);
        }
    }

    private void heapify(int current) {
        if(!isLeaf(current)) {
            int smallest;
            if(heap[leftChild(current)] < heap[current]) {
                smallest = leftChild(current);
            } else {
                smallest = current;
            }
            if(heap[rightChild(current)] < heap[smallest]) {
                smallest = rightChild(current);
            }
            if(smallest != current) {
                swap(smallest, current);
                heapify(smallest);
            }
        }
    }

    private int remove() {
        int popped = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return popped;
    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2(11);
        problem2.insert(0);
        problem2.insert(6);
        problem2.insert(5);
        problem2.insert(1);
        problem2.insert(9);
        System.out.println("Peak is: " + problem2.peak());
        System.out.println("First print");
        problem2.print();
        problem2.insert(3);
        problem2.insert(4);
        problem2.insert(10);
        System.out.println("Insert 3,4,10 and print");
        problem2.print();
        problem2.insert(8);
        problem2.insert(2);
        System.out.println("Insert 2,8 and print");
        problem2.print();
        System.out.println("Removing and print");
        System.out.println("Removed is: " + problem2.remove());
        System.out.println("Peak is: " + problem2.peak());
        problem2.print();
    }
}