class MinHeap {
    private:
    int size;
    int capacity;
    vector<int> minHeap;
    int parent(int i) { return (i-1)/2; }
    int left(int i) { return 2*i + 1; }
    int right(int i) { return 2*i + 2; }
    public:
    MinHeap(int capacity);
    void insert(int k);
    int extractMin();
    int getSize();
    int getElement(int idx);
};

MinHeap::MinHeap(int capacity) {
        size = 0;
        this->capacity = capacity;
        minHeap.resize(capacity);
        };

        void MinHeap::insert(int k) {
        if(size == capacity) return;
        size++;
        int i = size-1;
        minHeap[i] = k;

        while(i != 0 and minHeap[parent(i)] > minHeap[i]) {
        swap(minHeap[parent(i)], minHeap[i]);
        i = parent(i);
        }
        }

        int MinHeap::extractMin() {
        if(size == 0) return -1;
        if(size == 1) {
        size--;
        return minHeap[0];
        } else {
        int root = minHeap[0];
        minHeap[0] = minHeap[size-1];
        size--;
        heapify(0);

        return root;
        }
        }

        int MinHeap::getSize() {return size;}

        int MinHeap::getElement(int idx) {
        if(idx > size or idx < 0) return -1;
        return minHeap[idx];
        }
