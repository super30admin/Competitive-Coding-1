#include<iostream>
using namespace std;
class MinHeap{
    public: 
        int *arr;
        int capacity;
        int heap_size;

        MinHeap(int cap){
            heap_size=0;
            capacity=cap;
            arr = new int[cap];
        }
        int parent(int idx){
            return (idx-1)/2;
        }
        int left(int idx){
            return 2*idx+1;
        }
        int right(int idx){
            return 2*idx+2;
        }
        void insert(int key){
            if(heap_size>=capacity){
                cout<<"Heap Overflow";
                return;
            }
            heap_size++;
            int i = heap_size-1;
            arr[i]=key;
            while(i!=0&&arr[parent(i)]>arr[i]){
                int temp = arr[i];
                arr[i]=arr[parent(i)];
                arr[parent(i)]=temp;
                i = parent(i);
            }
        }
        void minHeapify(int idx){
            int l = left(idx);
            int r = right(idx);
            int min = idx;
            if(l<heap_size&&arr[l]<arr[idx]){
                min=l;
            }
            if(r<heap_size&&arr[r]<arr[min]){
                min=r;
            }
            if(min!=idx){
                int temp = arr[idx];
                arr[idx]=arr[min];
                arr[min]=temp;
                minHeapify(min);
            }    
        }
        void extractMin(){
            if(heap_size==0){
                cout<<"Heap is empty!";
                return;           
            }
            if(heap_size==1){
                heap_size--;
            }
            int min = arr[0];
            arr[0]=arr[heap_size-1];
            heap_size--;
            minHeapify(0);
        }
        int getMin(){
            if(heap_size==0){
                cout<<"Heap is empty!";
                return -1;
            }
            return arr[0];
        }
};
int main(){
    MinHeap obj(5);
    obj.insert(5);
    obj.insert(2);
    obj.insert(1);
    obj.insert(9);
    obj.insert(6);
    cout<<obj.getMin()<<endl;
    obj.extractMin();
    cout<<obj.getMin()<<endl;
    obj.extractMin();
    obj.insert(3);
    cout<<obj.getMin();
}
