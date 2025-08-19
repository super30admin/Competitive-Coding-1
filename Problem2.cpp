//design minheap

#include <iostream>
#include <algorithm>
using namespace std;


class heap {
private:
   
    int parent(int i)     { return (i - 1) / 2; }
    int leftChild(int i)  { return 2 * i + 1; }
    int rightChild(int i) { return 2 * i + 2; }

    
    void heapifyDown(int i) {
        while (true) {
            int l = leftChild(i);
            int r = rightChild(i);
            int smallest = i;

            if (l < size && arr[l] < arr[smallest]) smallest = l;
            if (r < size && arr[r] < arr[smallest]) smallest = r;

            if (smallest == i) break;
            swap(arr[i], arr[smallest]);
            i = smallest;
        }
    }

   
    void heapifyUp(int i) {
        while (i > 0 && arr[parent(i)] > arr[i]) {
            swap(arr[i], arr[parent(i)]);
            i = parent(i);
        }
    }

public:
    int arr[100];  
    int size = 0;   

    
    bool insert(int val) {
        if (size == 100) return false;      
        arr[size] = val;                    
        heapifyUp(size);                   
        ++size;
        return true;
    }

  
    bool getMin(int &out) const {
        if (size == 0) return false;
        out = arr[0];                       
        return true;
    }


    bool extractMin(int &out) {
        if (size == 0) return false;

        out = arr[0];                       
        arr[0] = arr[size - 1];             
        --size;                             
        if (size > 0) heapifyDown(0);       
        return true;
    }

    void print() const {
        for (int i = 0; i < size; ++i) cout << arr[i] << ' ';
        cout << '\n';
    }
};