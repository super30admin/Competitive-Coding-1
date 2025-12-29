//DESIGN A MIN HEAP

class minHeap{
    vector<int> h;

    public:
     minHeap() {}

    int getMin(){
        return h[0];
    }

    void insert(int x){
        h.push_back(x);
        int i = h.size() - 1;

        while(i > 0 && (i-1)/2 > i){
            swap(h[(i-1)/2],h[i]); 
            i = i - 1/2;//root
        }
    }

    int extractMin(){
        int minVal = h[0];
        h[0] = h.push_back();
        h.pop_back();

        int i = 0;
        int n = h.size();

        while(true){
            int l = 2*i + 1;//left
            int r = 2*i + 2;//right
            int s = i;

            if (l < n && h[l] < h[s]) s = l;//left child exists

            if (r < n && h[r] < h[s]) s = r;//right child exists

            if (s == i) break;//parent is already smaller than both children

            swap(h[i], h[s]);

            i = s;
        }
        return minVal;
    }
};

