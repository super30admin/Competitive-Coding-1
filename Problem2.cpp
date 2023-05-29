/*

// Time Complexity : for insert O(log(n))
for remove_min O(logn)
for get min O(1)
// Space Complexity : its O(1) for every function
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
making sure that the tree is Heapified or the minimum is at the top.

// Your code here along with comments explaining your approach
For insert. We will add it to the end and then traverse through each parent node to 
check if its smaller than that.
For removal we will interchange the first and the last element. Pop the last element to give the min
then we will heapify the tree to make sure that the minimum is at the top again.

*/






#include<iostream>
#include<vector>

using namespace std;

class MinHeap{

    vector<int> arr;
    int capacity{},heap_size{};

    void swap(int *a,int *b){
        int temp{*a};
        *a = *b;
        *b = temp;
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left_child(int i){
        return 2*i+1;
    }

    int right_child(int i){
        return 2*i+2;
    }

    // bubble up from the given index;
    void __bubble_up(int idx){
        while(idx!=0 && arr.at(parent(idx))>arr.at(idx)){
            swap(&arr.at(parent(idx)),&arr.at(idx));
            idx = parent(idx);
        }
    }
    //bubble down from the parent index;
    void __bubble_down(int idx){
        int temp{idx};
        if(left_child(idx)<heap_size && arr[temp]>arr.at(left_child(idx))){
            temp = left_child(idx);
        }
        
        if(right_child(idx)<heap_size && arr[temp]>arr.at(right_child(idx))){
            temp = right_child(idx);
        }
        if (temp!=idx){
            swap(&arr.at(idx),&arr.at(temp));
            __bubble_down(temp);
        }

    }

    
    public:
        MinHeap(int capacity){
            arr.reserve(capacity);
            this->capacity = capacity;
        }

        int get_min(){
            if(heap_size == 0){
                cout<<"error empty error "<<endl;
                return -1;
            }
            return arr.at(0);
        }

        void insert(int val){
            if(heap_size == capacity){
                cout<<"heap overflow"<<endl;
                return ;
            }
            arr.push_back(val);
            ++heap_size;
            if(heap_size == 1){
                return ;
            }
            __bubble_up(heap_size-1);
        }

        int remove_min(){
            
            if(heap_size == 0){
                cout<<"underflow"<<endl;
                return -1;
            }
            swap(&arr.at(0),&arr.at(heap_size-1));
            int temp{arr.at(heap_size-1)};
            arr.pop_back();
            --heap_size;
            // if the index was at zero after popping the heap_size becomes zero therefore.
            if(heap_size == 0){
                return temp;
            }
            __bubble_down(0);
            return temp;
        }

        void print_vec(){
            for(auto i:arr){
                cout<<i<<"\t";
            }
            cout<<endl;
        }
};


int main(int argc, char const *argv[])
{
    /* code */
    MinHeap h(11);
    h.insert(15);
    h.insert(2);
    h.insert(3);
    h.insert(1);
    h.insert(45);
    h.insert(5);
    h.insert(4);
    h.print_vec();
    cout << "minimum element: " << h.remove_min() << endl;
    h.print_vec();
    cout << "second minimum element: " << h.get_min() << endl;
    return 0;
}

