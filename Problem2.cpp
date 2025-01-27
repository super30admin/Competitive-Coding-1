//Time Complexity : 
// array implementation
// Insert(): O(log n)
// ExtractMin(): O(log n)
// GetMin(): O(1)

// priority_queue implementation
// Insert(): O(log n)
// ExtractMin(): O(log n)
// GetMin(): O(1)

// Space Complexity for both : O(n)
// Did this code successfully run on Leetcode : Geeksforgeeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


//using arrays
#include <iostream>
#include <climits>
using namespace std;

class MinHeap {
private:
    int *heap;
    int capacity;
    int size;

    // Helper functions to get indices of parent and children
    int parent(int i) { return (i - 1) / 2; }
    int leftChild(int i) { return 2 * i + 1; }
    int rightChild(int i) { return 2 * i + 2; }

    // Heapify-up to maintain heap property
    void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
    }

    // Heapify-down to maintain heap property
    void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(heap[i], heap[smallest]);
            heapifyDown(smallest);
        }
    }

public:
    MinHeap(int cap) {
        size = 0;
        capacity = cap;
        heap = new int[capacity];
    }

    // Insert an element into the heap
    void insert(int value) {
        if (size == capacity) {
            cout << "Heap is full!" << endl;
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // Remove and return the minimum element (root)
    int extractMin() {
        if (size <= 0)
            return INT_MAX;
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return root;
    }

    // Get the minimum element without removing it
    int getMin() {
        if (size <= 0)
            return INT_MAX;
        return heap[0];
    }

    // Print the heap elements (for debugging)
    void printHeap() {
        for (int i = 0; i < size; i++)
            cout << heap[i] << " ";
        cout << endl;
    }
};

int main() {
    MinHeap minHeap(10);

    minHeap.insert(10);
    minHeap.insert(5);
    minHeap.insert(20);
    minHeap.insert(3);

    cout << "MinHeap elements: ";
    minHeap.printHeap();

    cout << "Minimum element: " << minHeap.getMin() << endl;

    cout << "Extracted minimum: " << minHeap.extractMin() << endl;

    cout << "Heap after extraction: ";
    minHeap.printHeap();

    return 0;
}


//using priority queue
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

// Custom comparator to make the priority_queue a Min Heap
class Compare {
public:
    bool operator()(int a, int b) {
        return a > b;  // Reverse comparison for Min Heap
    }
};

int main() {
    // Create a priority_queue with the custom comparator
    priority_queue<int, vector<int>, Compare> minHeap;
    //priority_queue<int, vector<int>, greater<int>> minHeap; //min heap declaration 

    // Insert elements into the heap
    minHeap.push(10);
    minHeap.push(5);
    minHeap.push(20);
    minHeap.push(3);

    cout << "MinHeap elements: ";
    while (!minHeap.empty()) {
        cout << minHeap.top() << " ";
        minHeap.pop();
    }
    cout << endl;

    return 0;
}

