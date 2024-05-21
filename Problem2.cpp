// Min Heap Implementation using Array

#include <iostream>
#include <vector>

class MinHeap {
    std::vector<int> heap;
    int parent(int index) { return (index - 1) / 2; }
    int leftChild(int index) { return 2 * index + 1; }
    int rightChild(int index) { return 2 * index + 2; }

    void heapifyUp(int index) { // Function to loop through the array till each element is at its correct position
        while (index != 0 && heap[parent(index)] > heap[index]) { // If the current node is not parent and the current node's parent is bigger than it
            std::swap(heap[index], heap[parent(index)]);
            index = parent(index);
        }
    }

    void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap[left] < heap[smallest]) {  // If the left child exists and is smaller than the current node, update smallest to the left child index.
            smallest = left;
        }

        if (right < heap.size() && heap[right] < heap[smallest]) {// Same with the right child
            smallest = right;
        }

        if (smallest != index) { // If the current node is not the smallest element
            std::swap(heap[index], heap[smallest]); // Swap current with the smallest
            heapifyDown(smallest); // Recursive call to heapify down from the current smallest node
        }
    }

public:
    void insert(int value) {
        heap.push_back(value);
        heapifyUp(heap.size() - 1);
    }

    int extractMin() { // Removes the root element
        if (heap.size() == 0) return -1;

        int root = heap[0];
        heap[0] = heap.back();
        heap.pop_back();

        heapifyDown(0);

        return root;
    }

    int getMin() {
        if (heap.size() == 0) return -1;
        return heap[0];
    }

    bool isEmpty() {
        return heap.size() == 0;
    }

};

// Example Usage
int main() {
    MinHeap heap;

    heap.insert(10);
    heap.insert(20);
    heap.insert(15);
    heap.insert(5);
    heap.insert(30);
    heap.insert(50);
    heap.insert(20);
    heap.insert(3);

    std::cout << "Min Element: " << heap.getMin() << std::endl; // Output: 3
    std::cout << "Extract Min: " << heap.extractMin() << std::endl; // Output: 3
    std::cout << "Min Element: " << heap.getMin() << std::endl; // Output: 5

    return 0;
}

