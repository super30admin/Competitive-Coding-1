#include <iostream>
#include <vector>

using namespace std;

class MinHeap
{
private:
    vector<int> heap;
    
    void bubbleUp(int idx) {
        int parentIdx = (idx - 1) / 2;  // Calculate parent index
        if (idx == 0 || heap[parentIdx] <= heap[idx])
            return;  // Stop if root or parent is smaller/equal to child
        // Swap parent and child
        swap(heap[idx], heap[parentIdx]);
        bubbleUp(parentIdx);  // Recurse for parent
    }

    void bubbleDown(int idx) {
        int left = idx * 2 + 1;  // Left child index
        int right = idx * 2 + 2; // Right child index
        int minIdx = idx;

        // Find the smallest of parent, left, and right child
        if (right < heap.size() && heap[right] < heap[minIdx])
            minIdx = right;
        if (left < heap.size() && heap[left] < heap[minIdx])
            minIdx = left;

        if (minIdx == idx)
            return;  // If no swap needed, stop
        // Swap parent and smallest child
        swap(heap[idx], heap[minIdx]);
        bubbleDown(minIdx);  // Recurse for child
    }

public:
    MinHeap(int max_size) {
        heap.reserve(max_size);  // Preallocate memory
    }
    
    int length() {
        return heap.size();  // Return current heap size
    }

    int min() {
        if (heap.empty()) {
            throw runtime_error("Heap is empty");
        }
        return heap[0];  // Return the root (minimum element)
    }

    void insert(int n) {
        heap.push_back(n);  // Add the new element at the end
        bubbleUp(heap.size() - 1);  // Restore heap property
    }

    int removeMin() {
        if (heap.empty())
            return -1;  // Return -1 if heap is empty

        int minElement = heap[0];  // Store the minimum element
        heap[0] = heap.back();  // Move the last element to the root
        heap.pop_back();  // Remove the last element

        if (!heap.empty())
            bubbleDown(0);  // Restore heap property

        return minElement;  // Return the removed element
    }

    void print() {
        for (int i : heap) {
            cout << i << "\t";
        }
        cout << endl;
    }

};

int main() {
    int max_size = 15;
    MinHeap heap(max_size);

    vector<int> insertOrder = {20, 28, 16, 32, 31, 15};

    cout << "Inserting:" << endl;
    for (int i : insertOrder) {
        heap.insert(i);
        heap.print();
    }

    cout << "Removing Min:" << endl;
    for (size_t i = 0; i < insertOrder.size(); i++) {
        heap.removeMin();
        heap.print();
    }

    return 0;
}