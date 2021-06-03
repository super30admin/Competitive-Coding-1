package competitiveCoding1;

import java.util.Arrays;
//Not completed yet
class Problem2 {

    private int[] heap;
    private int size;
    private int maxSize;

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    private static final int FRONT = 1;

    public Problem2(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        heap = new int[maxSize];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    public void insert(int value) {
        if (size >= maxSize) {
            return;
        }
        heap[size] = value;
        int current = maxSize;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void swap(int x, int y) {
        int temp;
        temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
}

