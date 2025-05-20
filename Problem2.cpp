/*
Time Complexity:
- insert/add: O(log n)
- remove/extractMin: O(log n)
- peek: O(1)
- size: O(1)
- heapify (build heap from array): O(n)
- print: O(n)

Space Complexity:
- O(n)

Problems Faced:
- Managing child index bounds to avoid accessing invalid memory.
- Ensuring correct swap logic during heapifyUp and heapifyDown.
*/

#include <vector>
#include <iostream>
#include <climits>
using namespace std;

class MinHeap {
private:
    vector<int> heap;

    int parent(int i) { return (i - 1) / 2; }
    int leftChild(int i) { return 2 * i + 1; }
    int rightChild(int i) { return 2 * i + 2; }

    void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heap.size() && heap[left] < heap[smallest])
            smallest = left;
        if (right < heap.size() && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(heap[i], heap[smallest]);
            heapifyDown(smallest);
        }
    }

    void heapifyUp(int i) {
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
    }

public:
    MinHeap() {}

    void add(int val) {
        heap.push_back(val);
        heapifyUp(heap.size() - 1);
    }

    int remove() {
        if (heap.empty()) return INT_MIN;
        int root = heap[0];
        heap[0] = heap.back();
        heap.pop_back();
        heapifyDown(0);
        return root;
    }

    int peek() const {
        return heap.empty() ? INT_MIN : heap[0];
    }

    int size() const {
        return heap.size();
    }

    void print() const {
        for (int val : heap) {
            cout << val << " ";
        }
        cout << endl;
    }

    void heapify(vector<int>& arr) {
        heap = arr;
        for (int i = heap.size() / 2 - 1; i >= 0; --i) {
            heapifyDown(i);
        }
    }

    const vector<int>& getHeap() const {
        return heap;
    }
};

