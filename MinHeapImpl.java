// Time Complexity: O(logn) for insert(), removeMin(); O(1) for length(), min()
// Space complexity: O(1)

// Explanation: To insert, append new element to end and then bubble up(compare with parent and swap if lesser than parent)
// To remove min, swap first and last element, and pop last element. Then bubble down(compare with children and swap with lesser child)

class MinHeap {
    ArrayList<Integer> heap;
    MinHeap(int max_size){
        this.heap = new ArrayList<Integer>();
    }
    public int length(){
        return heap.size();
    }
    public int min(){
        return heap.get(0);
    }
    private void bubbleUp(int idx){
        int parentIdx = idx%2==0 ? (idx-1)/2 : idx/2;
        if(idx==0||(heap.get(parentIdx)<=heap.get(idx)))
            return;
        else
        {
            int temp = heap.get(idx);
            heap.set(idx, heap.get(parentIdx));
            heap.set(parentIdx, temp);
            bubbleUp(parentIdx);
        }
    }
    public void insert(int n){
            heap.add(n);
            bubbleUp(this.length()-1);
    }
    public void print(){
        for(int i:heap)
            System.out.print(i+"\t");
        System.out.println();
    }
    public void bubbleDown(int idx){
        int left = idx*2 + 1;
        int right = idx*2 + 2;
        int min = idx;
        if(right<this.length()&&heap.get(right)<heap.get(min))
            min = right;
        if(left<this.length()&&heap.get(left)<heap.get(min))
            min = left;
        if(min==idx)
            return;
        int temp = heap.get(idx);
        heap.set(idx, heap.get(min));
        heap.set(min, temp);
        bubbleDown(min);    
    }
    public int removeMin() {
        if(this.length()==0)
            return -1;
        else
        {
            heap.set(0,heap.get(this.length()-1));
            heap.remove(this.length()-1);
            if(this.length()<=1)
                return 1;
            bubbleDown(0);
        }
        return 1;
    }  
}
public class Main {
    public static void main(String[] args) {
        int max_size = 15;
        MinHeap heap = new MinHeap(max_size); 
        int[] insertOrder = {20,28,16,32,31,15};
        System.out.println("Inserting");
        for(int i:insertOrder){
            heap.insert(i);
            heap.print();
        }
        System.out.println("Removing Min");
        for(int i=0;i<insertOrder.length;i++){
        heap.removeMin();
        heap.print();
        }
    }
}