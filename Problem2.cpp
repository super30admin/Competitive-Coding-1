#include <iostream>
#include <vector>

using namespace std;

class MinHeap {
private:
    vector<int> heap;

    int parent(int i) { return (i - 1) / 2; }
    int leftChild(int i) { return 2 * i + 1; }
    int rightChild(int i) { return 2 * i + 2; }

    void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
    }

    void heapifyDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < heap.size() && heap[l] < heap[minIndex])
            minIndex = l;
        if (r < heap.size() && heap[r] < heap[minIndex])
            minIndex = r;

        if (i != minIndex) {
            swap(heap[i], heap[minIndex]);
            heapifyDown(minIndex);
        }
    }

public:
    MinHeap() {}

    void insert(int val) {
        heap.push_back(val);
        int index = heap.size() - 1;
        heapifyUp(index);
    }

    void deleteMin() {
        if (heap.empty()) {
            cout << "Heap is empty!" << endl;
            return;
        }

        heap[0] = heap.back();
        heap.pop_back();

        heapifyDown(0);
    }

    int getMin() {
        if (heap.empty()) {
            cout << "Heap is empty!" << endl;
            return -1;
        }
        return heap[0];
    }
};

int main() {
    MinHeap minHeap;

    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(8);
    minHeap.insert(1);
    minHeap.insert(10);

    cout << "Minimum element: " << minHeap.getMin() << endl;

    minHeap.deleteMin();

    cout << "Minimum element after deletion: " << minHeap.getMin() << endl;

    return 0;
}

