
// Time Complexity : insert : log(n) which is height of tree, remove log(n) height of tree again, size o(1) size of an array, getMinimum element o(1) first element of array
//
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


void insert(vector<int> &heap, int val) {
    //o(log(n))
    heap.push_back(val);
    int n = heap.size()-1;
    while(n >= 0) {
        int parent = heap[floor(n-1)/2];
        int child = heap[n];
        if(parent > child) {
            swap(heap[floor(n-1)/2], heap[n]);
            n = floor(n-1)/2;
        } else {
            break;
        }
    }
}

//first element will be removed
//1. swap first and last element
//2. heapify on first element check its child if smaller or not
int remove(vector<int> &heap) {
    int r = heap[0];
    int n = heap.size()-1;
    swap(heap[0], heap[n]);
    n = heap.size()-1;
    heap.pop_back();
    int parentIdx = 0;
    int tempIdx = 0;
    while(parentIdx < heap.size()) {
        int child1Idx = parentIdx * 2 + 1;
        int child2Idx = child1Idx + 1;
        bool flag1 = true;
        bool flag2 = true;
        tempIdx = parentIdx;
        if(child1Idx < heap.size()) {
            if(heap[tempIdx] > heap[child1Idx]) {
                tempIdx = child1Idx;
                flag1 = false;
            }
        }
        if(child2Idx < heap.size()) {
            if(heap[tempIdx] > heap[child2Idx]) {
                tempIdx = child2Idx;
                flag2 = false;
            }
        }
        swap(heap[tempIdx], heap[parentIdx]);
        if(flag1 && flag2) break;
    }
    return r;
}

int getSize(vector<int> &heap) {
    return heap.size();
}

int minElement(vector<int> &heap) {
    return heap[0];
}

int main() {
    vector<int> heap = {15,28,16,32,31,20};
    insert(heap, -1);
    for(auto &x : heap) {
        cout << x << " , ";
    }
    cout << "\n";
    int removed = remove(heap);
    for(auto &x : heap) {
        cout << x << " , ";
    }
    cout << "\n";
    cout << "removed = " << removed << endl;
    
    int size = getSize(heap);
    cout << "size = " << size << endl;
    
    int minn = minElement(heap);
    cout << "minimum element = " << minn << endl;
    
    
}






