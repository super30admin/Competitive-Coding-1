
#include <iostream>
using namespace std;

class MH {
private:
    int* h;
    int sz;
    int cap;

    int p(int i) { 
        return (i - 1) / 2; 
    }
    int l(int i) { 
        return 2 * i + 1; 
    }
    int r(int i) { 
        return 2 * i + 2; 
    }

    bool isLeaf(int i) { 
        return i >= sz / 2 && i < sz; 
    }

    void swp(int i, int j) {
        int t = h[i];
        h[i] = h[j];
        h[j] = t;
    }

    void heapify(int i) {
        if (isLeaf(i)) 
            return;
        int li = l(i), ri = r(i), s = i;
        if (li < sz && h[li] < h[s]) s = li;
        if (ri < sz && h[ri] < h[s]) s = ri;
        if (s != i) {
            swp(i, s);
            heapify(s);
        }
    }

public:
    MH(int c) {
        cap = c;
        sz = 0;
        h = new int[cap];
    }
    void ins(int v) {
        if (sz >= cap) 
            return;
        h[sz] = v;
        int i = sz++;
        while (i > 0 && h[i] < h[p(i)]) {
            swp(i, p(i));
            i = p(i);
        }
    }
    int remMin() {
        if (sz == 0) 
        return -1;
        int m = h[0];
        h[0] = h[--sz];
        heapify(0);
        return m;
    }
    void print() {
        for (int i = 0; i <= (sz - 2) / 2; ++i) {
            cout << "P: " << h[i];
            if (l(i) < sz) cout << " L: " << h[l(i)];
            if (r(i) < sz) cout << " R: " << h[r(i)];
            cout << endl;
        }
    }
};

int main() {
    MH heap(15);
    int arr[] = {5, 3, 17, 10, 84, 19, 6, 22, 9};
    for (int x : arr) heap.ins(x);
    cout << "Min Heap:\n";
    heap.print();
    cout << "Removed Min: " << heap.remMin() << endl;

    return 0;
}
