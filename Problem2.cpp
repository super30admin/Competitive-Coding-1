/*The MinHeap class is implemented using a vector (heap) to represent the binary heap structure, 
where each element satisfies the min-heap property (the value of each node is less than or equal 
to the values of its children).

Time Complexity: O(log n) for insert and extractMin operations. O(1) for getMin. 
Space Complexity: O(n).*/
#include <iostream>
#include <vector>

using namespace std;

class MinHeap {
private:
    vector<int> heap;

    void heapify(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(heap[index], heap[smallest]);
            heapify(smallest);
        }
    }

public:
    MinHeap() {}

    void insert(int value) {
        heap.push_back(value);

        int index = heap.size() - 1;
        while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
            swap(heap[index], heap[(index - 1) / 2]);
            index = (index - 1) / 2;
        }
    }

    int extractMin() {
        if (heap.empty()) {
            cerr << "Heap is empty." << endl;
            return -1;
        }

        int root = heap[0];
        heap[0] = heap.back();
        heap.pop_back();

        heapify(0);

        return root;
    }

    int getMin() {
        if (heap.empty()) {
            cerr << "Heap is empty." << endl;
            return -1; 
        }

        return heap[0];
    }

    bool isEmpty() {
        return heap.empty();
    }
};