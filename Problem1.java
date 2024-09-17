// Time Complexity : Insertion TC : O(log n), Removal TC : O(log n), getMinimumElement/Peek element TC : O(1)
// Space Complexity : O(n) // array size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MinHeap {
    public int[] heap;
    int len;
    int maxSize;
    
    MinHeap(int size){
        heap = new int[size+1];
        heap[0] = Integer.MIN_VALUE;
        len = 0;
        maxSize = size;
    }
    
    public void swap(int l,int r){
        int temp = heap[l];
        heap[l] = heap[r];
        heap[r] = temp;
    }
    
    public void insert(int x){
        if(len >= maxSize) return;
        heap[++len] = x;
        int index = len;
        while(heap[index] < heap[index/2]){
            swap(index,index/2);
            index = index/2;
        }
    }
    
    public void print(){
        for (int i =1; i <= len / 2; i++){ 
            System.out.println(" Parent : "+heap[i]+ " Left Node : "+heap[2 * i]+" Right Node :"+heap[2*i+1]);
        } 
    }
    
    public int remove(){
        int res = heap[1];
        heap[1] = heap[len--];
        // heap[len-1] = 0;
        heapify(1);
        return res;
    }
    
    public void heapTree(){
        for(int i= len/2; i>0;i--){
            heapify(i);
        }
    }
    
    public void heapify(int ind){
        if(!(ind >= (len/2)) && (ind <= len)){
            if(heap[ind] > heap[ind*2] || heap[ind] > heap[(ind*2)+1]){
                if(heap[ind*2] < heap[(ind*2)+1]){
                    swap(ind,ind*2);
                    heapify(ind*2);
                }
                else{
                    swap(ind,(ind*2)+1);
                    heapify((ind*2)+1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(2);
        heap.insert(4);
        heap.insert(3);
        heap.insert(1);
        heap.print();
        heap.insert(5);
        heap.insert(6);
        heap.heapTree();
        System.out.println("Print tree with newly inserted elements after sorting");
        heap.print();
        System.out.println("Top most element: "+ heap.remove());
    }
    
}
