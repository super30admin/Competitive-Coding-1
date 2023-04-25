// Implementing min Heap

// TC: insert O(log(n)), getmin O(1), extractmin O(log(n));
// SC: O(n)

#include <vector>
#include <iostream>
#include<climits>
using namespace std;

class minHeap{

    vector<int> hp;

    int parent(int i){
        if((i-1)/2<0) return -1;
        return (i-1)/2;
    }
    int leftchild(int i){
        return 2*i + 1;
    }
    int rightchild(int i){
        return 2*i +2;
    }
    void swap(int &a, int &b)
    {
        int temp = a;
        a = b;
        b = temp;
    }


    void percolateUp(int i){
        while(parent(i)>=0 && hp[parent(i)] > hp[i])
        {
            swap(hp[parent(i)], hp[i]);
            i = parent(i);
        }
    }
    void percolateDown(int i)
    {
        int minIdx = i;
        int l = leftchild(i);
        int r = rightchild(i);
        if(l<hp.size() && hp[l]< hp[minIdx]){
            minIdx = l;
        }
        if(r<hp.size() && hp[r] < hp[minIdx]){
            minIdx = r;
        }
        if(i!=minIdx){
            swap(hp[minIdx], hp[i]);
             percolateDown(minIdx);
        }
    }
    public:
    minHeap(){}
    minHeap(vector<int>v){
        hp = v;
        for(int i = parent(hp.size() - 1); i>=0;i--)
        {
            percolateDown(i);
        }
    }
    
    void insert(int value)
    {
        hp.push_back(value);
        int index = hp.size() -1;
        percolateUp(index);
    }
    int getMin(){
        return hp[0];
    }
    int extractMin(){
        int ans = hp[0];
        hp[0] = hp[hp.size() - 1];
        hp.pop_back();
        percolateDown(0);
        return ans;
    }
    void remove(int i)
    {
        hp[i] = INT_MIN;
        percolateUp(i);
        int p = extractMin();
        (void)p;
    }
    void printHeap(){
        for(int i=0;i<hp.size();i++)
        {
            cout << hp[i] << " ";
        }
        cout << endl;
    }
};

int main(){
    vector<int>items = {4, 3, 5, 7, 8, 3, 1};
    minHeap mH(items);
    mH.printHeap();
    mH.remove(3);
    mH.printHeap();
    cout << mH.extractMin()<< endl;
    cout << mH.getMin()<< endl;
    mH.printHeap();
    mH.insert(2);
    mH.printHeap();
}