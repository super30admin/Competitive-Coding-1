
//Design Min_Heap - Parent is less than both of its children
//First element in the Min-heap array will be the smellest element

// Time Complexity : 
/* For Insert and ExtractMin : O(Log N base 2)
For getMin and getLength : O(1)

*/
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : Having problem minHeapify() when deleting min from heap but now it's fixed.


// Your code here along with comments explaining your approach


class MinHeap{
    int[] heap;
    int len;
    public MinHeap(){
        heap = new int[100]; //Heap of 100 elements
        len = -1; //Curr length of heap;
    }
    public int getMin(){ // O(1)
        return heap[0];
    }
    public int getSize(){ //O(1)
        return len + 1;
    }
    public void insert(int n){ //O(Log N base 2)
        if(len == -1){
            len++;
            heap[len] = n;
            return;
        }
        len++;
        heap[len] = n;
        heapify(len); // After inserting an element in heap
    }
    public int extractMin(){ //O(Log N base 2)
        int first = heap[0];
        
        swap(0,len);
        minHeapify(0, len-1); // After extracing min element from heap 
        len--;
        return first;
    }
    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void heapify(int i){
        if(i == 0)  return;
        
        int parent =(int) Math.floor((i-1)/2);
        
        if(parent >= 0 && heap[i] < heap[parent]){
            swap(i, parent);
            heapify(parent); // Checking parent of element at curr Parent index
        }
    }
    public void printMinHeap(){
        for(int p = 0; p <= len; p++){
            System.out.print(heap[p] + "  ");
        }
        System.out.println();
    }
    public void minHeapify(int i, int l){
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        int temp = i;
        
        if( left <= l && heap[left] < heap[temp] ){
            temp = left;
        }
        if( right <= l && heap[right] < heap[temp] ){ //If above conditin true, Temp will be updated and  that valuw will be checked
            temp = right;
        }
        
        if(temp == i){
            return;
        }
        swap(i, temp);
        minHeapify(temp, l);
    }
}

public class Main {
    public static void main(String[] args) {
        MinHeap m = new MinHeap();
        m.insert(15); m.insert(28); m.insert(16);
        m.insert(32); m.insert(31); m.insert(20);
        
        System.out.print("Current Heap : ");
        m.printMinHeap();
        
        System.out.println("Now Inserting 5 in MinHeap");
        m.insert(5); 
        m.printMinHeap();


        System.out.println("Now Inserting 10 in MinHeap");
        m.insert(10);
        
        System.out.print("Current Heap : ");
        m.printMinHeap();
        
        System.out.println("Extracting min from Heap " );
        System.out.println("Extracted from MinHeap : " + m.extractMin());
        
        m.printMinHeap();
        
    }
}
