#include<iostream>
#include<vector>
using namespace std;
#include <iostream>
using namespace std;
/*
->Array-based min-heap starting from index 0.
->insert() maintains heap by bubbling up.
->removeMin() replaces root with last and heapifies down.
*/
class MyMinHeap {
private:
    int* heap;
    int size;
    int maxSize;

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return 2 * i + 1;
    }

    int rightChild(int i) {
        return 2 * i + 2;
    }

    bool isLeaf(int i) {
        return i >= size / 2 && i < size;
    }

    void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    void heapify(int i) {
        if (isLeaf(i)) return;

        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

public:
    MyMinHeap(int capacity) {
        maxSize = capacity;
        size = 0;
        heap = new int[maxSize];
    }

    void insert(int val) {
        if (size >= maxSize) return;

        heap[size] = val;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    int removeMin() {
        if (size == 0) return -1;

        int minVal = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return minVal;
    }

    void printHeap() {
        for (int i = 0; i <= (size - 2) / 2; ++i) {
            cout << "PARENT: " << heap[i];
            if (leftChild(i) < size)
                cout << "  LEFT: " << heap[leftChild(i)];
            if (rightChild(i) < size)
                cout << "  RIGHT: " << heap[rightChild(i)];
            cout << endl;
        }
    }
};

int main() {
    MyMinHeap heap(15);
    int vals[] = {5, 3, 17, 10, 84, 19, 6, 22, 9};

    for (int val : vals)
        heap.insert(val);

    cout << "Min Heap:" << endl;
    heap.printHeap();
    cout << "Removed Min: " << heap.removeMin() << endl;

    return 0;
}

