
#include <iostream>
#include<climits>
using namespace std;

void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

class MinHeap{
	
	int capicity;
	int size = 0;
	int *minHeap;
	
	public :
	MinHeap(int sizes){
		capicity = sizes;
		minHeap = new int[sizes];
	}
	
	int getMin(){
		return minHeap[0];
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	int leftChild(int i) {
		return 2*i+1;
	}
	
	int rghtChild(int i) {
		return 2*i+2;
	}
	
	void insert(int value) {
		
		if(size == capicity) return ;
		size++;
		int i = size-1;
	
		minHeap[i] = value;
			//cout<<minHeap[i];
		while(i != 0 && (minHeap[parent(i)] > minHeap[i])) {
			swap(&minHeap[parent(i)],&minHeap[i]);
			i = parent(i);
		}
		
	}
	
	void minHeapify(int i){
		
		int smallest = i;
		
		int l  = leftChild(i);
		int h = rghtChild(i);
		if(l < size && minHeap[l] < minHeap[i]) 
		 smallest = l;
		 if( h < size && minHeap[h] < minHeap[smallest]) 
		 smallest = h;
		 
		 if(smallest != i) {
		 	swap(&minHeap[i],&minHeap[smallest]);
		 	minHeapify(smallest);
		 	
		 }
	}
	
	int extractMin() {
		
		if(size <= 0) {
			return INT_MIN;
		}
		
		if(size== 1) {
			size--;
			return minHeap[size];
		}
		
		int root =  minHeap[0];
		minHeap[0] = minHeap[size-1];
		minHeapify(0);
		return root;
		
	}
	
};



int main() {
	// your code goes here
	MinHeap h(15);
    h.insert(3);
    h.insert(2);
    h.insert(15);
    h.insert(5);
    h.insert(4);
    h.insert(45);
    cout << h.extractMin() << " ";
    cout << h.getMin();

	return 0;
}