// Time Complexity = O(log N)
// Space Complexity = O(1)
// where N is the number of elements in the heap.
#include <iostream>
#include <cstdlib>
#include <vector>
#include <iterator>
using namespace std;

class Heap
{
    private:
        vector <int> heap;
        
        int left(int parent){
            int l = 2 * parent + 1;
            if(l < heap.size())
                return l;
            else
                return -1;
        }
        
        int right(int parent){
            int r = 2 * parent + 2;
            if(r < heap.size())
                return r;
            else
                return -1;
            
        }
        
        int parent(int child){
            int p = (child - 1)/2;
            if(child == 0)
                return -1;
            else
                return p;
        }
        
        void heapifyup(int in){
            if (in >= 0 && parent(in) >= 0 && heap[parent(in)] > heap[in]){
                int temp = heap[in];
                heap[in] = heap[parent(in)];
                heap[parent(in)] = temp;
                heapifyup(parent(in));
            }
        }
        
        void heapifydown(int in){
            int child = left(in);
            int child1 = right(in);
            if (child >= 0 && child1 >= 0 && heap[child] > heap[child1]){
                child = child1;
            }
            if (child > 0){
                int temp = heap[in];
                heap[in] = heap[child];
                heap[child] = temp;
                heapifydown(child);
            }
        }
        
    public:
        Heap()
        {}
        void Insert(int element){
                heap.push_back(element);
                heapifyup(heap.size() -1);
        }
        
        void DeleteMin(){
            if (heap.size() == 0){
                cout<<"Heap is Empty"<<endl;
                return;
            }
            heap[0] = heap.at(heap.size() - 1);
            heap.pop_back();
            heapifydown(0);
            cout<<"Element Deleted"<<endl;
        }
        int ExtractMin(){
            if (heap.size() == 0)
                return -1;
            else
                return heap.front();
        }
        
        void DisplayHeap(){
            vector <int>::iterator pos = heap.begin();
            cout<<"Heap -->  ";
            while (pos != heap.end())
            {
                cout<<*pos<<" ";
                pos++;
            }
            cout<<endl;
        }
        
        int Size(){
            return heap.size();
        }
};

 

int main()
{
    Heap h;
    h.Insert(4);
    h.Insert(2);
    h.Insert(1);
    h.Insert(3);
    if (h.ExtractMin() == -1)
        cout<<"Heap is Empty"<<endl;
    else
        cout<<"Minimum Element:  "<<h.ExtractMin()<<endl;
    h.DeleteMin();
    h.DisplayHeap();
    if (h.ExtractMin() == -1)
        cout<<"Heap is Empty"<<endl;
    else
        cout<<"Minimum Element:  "<<h.ExtractMin()<<endl;
    return 0;
}
