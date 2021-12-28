/**
 * A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:
    getMin(): It returns the root element of Min Heap. O(1)
    extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
    insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
 */

 public class Problem2{
     public static void main(String args[]) {
         MinHeap m = new MinHeap();
         int[] arr = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
         m.createMinHeap(arr);
         m.printHeap();
         System.out.println();
         m.insert(9);
         m.printHeap();
         System.out.println();
         System.out.println("Min value is: " + m.getMin());
         System.out.println("Extract min: " + m.extractMin());
         m.printHeap();
     }
}
class MinHeap{
    int index;
    int[] minHeap;
    int MAX_SIZE;

    public MinHeap(){
        MAX_SIZE = 1000;
        index = -1;
        minHeap = new int[MAX_SIZE];
    }

    public MinHeap(int size){
        MAX_SIZE = size;
        index = -1;
        minHeap = new int[MAX_SIZE];
    }

    public int getMin() {
         if(!isEmpty()){
             return minHeap[0];
         }else{
             System.out.println("Heap is empty");
         }
         return Integer.MIN_VALUE;
    }

    public int extractMin() {
         int minValue = getMin();
         
         if(!isEmpty()){
            //swap last element in the heap with the first element
            minHeap[0] = minHeap[index];
            index--;
            topDownHeapify();
         }else{
            System.out.println("Heap is empty");
         }
         return minValue;
    }
    public void insert(int value) {
        if(!isFull()){
            //insert at last position in the heap and hepify
            minHeap[++index] = value;
            bottomUpHeapify();
        }else{
            System.out.println("Heap is full");
        }
    }

    private void topDownHeapify() {
        int i = 0;
            while(i <= index){
                int curr = minHeap[i];
                int leftChildIdx = 2 * i + 1;
                int rightChildIdx = 2 * i + 2;
                
                if(curr > minHeap[leftChildIdx] || curr > minHeap[rightChildIdx]){
                    if(minHeap[leftChildIdx] < minHeap[rightChildIdx]){
                        swap(i, leftChildIdx);
                        i = leftChildIdx;
                    }else{
                        swap(i, rightChildIdx);
                        i = rightChildIdx;
                    }
                }else{
                    break;
                }
            }
    }

    private void bottomUpHeapify(){

        if(isEmpty()){
            return;
        }
        int i = index;
        while(i > 0){
            int parentIdx = (i - 1)/2;

            //check if parent is greater, if yes then swap
            if(minHeap[parentIdx] > minHeap[i]){
                swap(i, parentIdx);
            }
            i = parentIdx;
        }
    }

    private void swap(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    public void createMinHeap(int[] arr) {
        for(int i=0; i<arr.length; i++){
            minHeap[++index] = arr[i];
            bottomUpHeapify();
        }
    }

    public void printHeap() {
        for(int i=0; i<=index; i++){
            System.out.print(minHeap[i]+ " ");
        }
    }

    private boolean isEmpty() {
        return index < 0;
    }

    private boolean isFull() {
        return index >= MAX_SIZE;
    }
 }
