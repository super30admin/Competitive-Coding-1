//MinHeap Implementation
// MinHeap.cpp : This file contains the 'main' function. Program execution begins and ends there.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class MinHeap {
public:
    int capacity;
    int size;
    int* heap;

    MinHeap(int n) {
        capacity = n;
        size = 0;
        heap = new int[capacity];
    }

    //returns index of parent of given index
    // Time Complexity O(1) Space Copmplexity-O(1)
    int parent(int i) { return (i - 1) / 2; }

    //return index of left child of given index
    // Time Complexity O(1) Space Complexity-O(1)
    int left(int i) { return (2 * i + 1); }

    //return index of right child of given index
    // Time Complexity O(1) Space Complexity-O(1)
    int right(int i) { return (2 * i + 2); }

    //get minimum element
    // Time Complexity O(1) Space Complexity-O(1)
    int getMin() {
        if (size == 0) return INT_MAX;
        return heap[0];
    }

    //remove minimum element
    // Time Complexity O(logn) Space Complexity-O(1)
    int extractMin() {
        if (size == 0) return INT_MAX;
        if (size == 1) {
            size--;
            return heap[0];
        }
        int minElement = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return minElement;
    }

    //insert key into minheap 
    // Time Complexity O(logn) Space Complexity-O(1)
    void insertKey(int key) {
        if (capacity == size) {
            cerr << "heap capacity full" << endl;
            return;
        }
        size++;
        int i = size - 1;  //index of new inserted element
        heap[i] = key;

        while (i != 0 && heap[parent(i)] > heap[i])
        {
            swap(&heap[parent(i)], &heap[i]);
            i = parent(i);
        }
    }

    //decrease the value at given index to given value
    // Time Complexity O(logn) Space Complexity-O(1)
    void decreaseKey(int i, int newValue) {
        if (i < 0 || i >= size)
            cerr << "index out of bound" << endl;
        else {
            heap[i] = newValue;
            while (i != 0 && heap[parent(i)] > heap[i]) {
                swap(&heap[parent(i)], &heap[i]);
                i = parent(i);
            }
        }
    }
    //deletes key at given index
    // Time Complexity O(logn) Space Complexity-O(1)
    void deleteKey(int i) {
        decreaseKey(i, INT_MIN);
        extractMin();
    }

    //maintains the min heap property with root at given index
    void heapify(int i) {
        int smallest = i;
        if (left(i) < size && heap[left(i)] < heap[smallest]) smallest = left(i);
        if (right(i) < size && heap[right(i)] < heap[smallest]) smallest = right(i);
        if (smallest != i) {
            swap(&heap[i], &heap[smallest]);
            heapify(smallest);
        }
    }

    //swap two elements
    void swap(int* a, int* b) {
        int temp = *a;
        *a = *b;
        *b = temp;
    }

};


int main() {
    MinHeap h(8);
    h.insertKey(12);
    h.insertKey(21);
    h.deleteKey(1);
    h.insertKey(4);
    h.insertKey(8);
    h.insertKey(5);
    h.insertKey(6);
    //cout << h.getMin() << " "; 
    cout << h.extractMin() << " ";
    cout << h.getMin() << " ";
    h.decreaseKey(2, 1);
    cout << h.getMin();
    return 0;
}