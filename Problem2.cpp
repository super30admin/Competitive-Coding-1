
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class MinHeap
{
    vector<int> heap;
    int parent(int i) { return (i - 1) / 2; }      // O(1)
    int leftChild(int i) { return (2 * i + 1); }   // O(1)
    int rightChild(int i) { return (2 * i + 2); }  // O(1)

    void heapify(int i) //O(log n)
    {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        // check if the left is leafnode
        if (l < heap.size() && heap[l] < heap[i])
        {
            smallest = l;
        }
        if (r < heap.size() && heap[r] < heap[smallest])
        {
            smallest = r;
        }
        if (smallest != i)
        {
            swap(heap[i], heap[smallest]);
            heapify(smallest);
        }
    }

public:
    int getMin() // O(1)
    {
        if (heap.size() == 0)
            return -1;
        return heap.front();
    }

    void insert(int k) //O(log n)
    {
        heap.push_back(k);
        int i = heap.size() - 1;
        while (i != 0 && heap[parent(i) > heap[i]]) 
        {
            swap(heap[i], heap[parent(i)]);
            i = parent(i);
        }
        heapify(0);
    }

    void deleteMin()  // O(log n) - worst case
    {
        if (heap.size() == 0)
        {
            cout << "Heap is empty" << endl;
            return;
        }
        heap[0] = heap.back();
        heap.pop_back();
        heapify(0);
    }

    int size()
    {
        return heap.size();
    }

    void printHeap()  
    {
        for (int i = 0; i < heap.size(); ++i)
        {
            cout << heap[i] << "\t";
        }
        cout << endl;
    }
};

int main()
{
    MinHeap H;
    H.insert(20);
    H.insert(8);
    H.insert(5);
    H.insert(10);
    H.insert(15);
    H.insert(12);

    // Print all elements of the heap
    H.printHeap();

    cout << "The Min:" << H.getMin() << endl;

    H.deleteMin();
    H.printHeap();

    return 0;
}
