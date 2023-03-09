Min Heap

Heapify, insert and remove - TC - O(logn), SC - O(n)
get min - TC - O(1)
remove min - TC - O(logn) 


#include <iostream>
#include <vector>

using namespace std;

class MinHeap {
private:
    vector<int> heap;

    // helper functions
    void swap(int& a, int& b) {
        int temp = a;
        a = b;
        b = temp;
    }

    void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < heap.size() && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(heap[i], heap[smallest]);
            heapify(smallest);
        }
    }

public:
    // constructor
    MinHeap() {}

    // insert an element
    void insert(int val) {
        heap.push_back(val);
        int i = heap.size() - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && heap[i] < heap[parent]) {
            swap(heap[i], heap[parent]);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    // get the minimum element
    int getMin() {
        if (heap.size() == 0) {
            cout << "Heap is empty" << endl;
            return -1;
        }

        return heap[0];
    }

    // remove the minimum element
    void removeMin() {
        if (heap.size() == 0) {
            cout << "Heap is empty" << endl;
            return;
        }

        heap[0] = heap.back();
        heap.pop_back();
        heapify(0);
    }
};


https://www.geeksforgeeks.org/binary-heap/

