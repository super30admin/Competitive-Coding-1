/*
Time Complexity : 
insert(): O(log n)
getMin(): O(1)
extractMin(): O(log n)
decreaseKey(): O(log n).
delete(): O(log n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/


#include <iostream>
using namespace std;


class MinHeap{
    int *heap_array;
    int capacity;
    int heap_size; 

public:
    MinHeap(int capacity){
        this->heap_size = 0;
        this->capacity = capacity;
        this->heap_array = new int[capacity];
    }

    // recursive method to heapify a subtree with the root at given index i
    void MinHeapify(int i){
        int l = left(i);
        int r = right(i);

        int smallest = i;
        if (l < heap_size && heap_array[l] < heap_array[i])
            smallest = l;
        if (r < heap_size && heap_array[r] < heap_array[smallest])
            smallest = r;

        if (smallest != i){
            swap(heap_array[i], heap_array[smallest]);
            MinHeapify(smallest);
        }
    }


    int parent(int i){ return (i-1)/2; }

    int left(int i){ return (2*i + 1); }

    int right(int i){ return (2*i + 2); }

    // method to remove minimum element (or root) from min heap
    int extractMin(){
        if (heap_size <= 0)
            return INT_MAX;
        if (heap_size == 1){
            heap_size--;
            return heap_array[0];
        }

        int root = heap_array[0];
        heap_array[0] = heap_array[heap_size-1];
        heap_size--;
        MinHeapify(0);

        return root;
    }


    void decreaseKey(int i, int new_val){
        heap_array[i] = new_val;
        while (i != 0 && heap_array[parent(i)] > heap_array[i]){
            swap(heap_array[i], heap_array[parent(i)]);
            i = parent(i);
        }
    }

    int getMin(){ return heap_array[0]; }


    void deleteKey(int i){
        decreaseKey(i, INT_MIN);
        extractMin();
    }


    void insertKey(int k){
        if (heap_size == capacity){
            cout << "\nOverflow: Could not insertKey\n";
            return;
        }
        int i = heap_size;
        heap_array[heap_size++] = k;

        while (i != 0 && heap_array[parent(i)] > heap_array[i]){
            swap(heap_array[i], heap_array[parent(i)]);
            i = parent(i);
        }
    }
};


int main(){
    MinHeap h(11);
    h.insertKey(15);
    h.insertKey(2);
    h.insertKey(3);
    h.insertKey(1);
    h.insertKey(45);
    h.insertKey(5);
    h.insertKey(4);
    cout << "minimum element: " << h.extractMin() << endl;
    cout << "second minimum element: " << h.getMin() << endl;
    return 0;
}