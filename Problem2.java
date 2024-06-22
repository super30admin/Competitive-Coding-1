// In this the min heap is implemented. A heapify function is used to compare the left and the right with the position to be swapped and swaps them accordingly to satisfy the property of the min heap. This heapify function is used in insert function, remove function, where the top element is removed and the last element is made the root node and heapify is used to traverse through the heap to find the next smallest element and makes it the root element. getmin() is implemented in O(1), where as remove and insert are implemented using O(logN). The space complexity is O(N). The code is tested using main function.


class Minheap{
    int[] heap;
    int size;
    int maxsize;
    public static final int FRONT =1;
     public static void main(String[] args){
        Minheap minHeap = new Minheap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19);
        System.out.println("min is "+minHeap.getmin());
        System.out.println("the element removed is"+minHeap.remove());

 }
 public Minheap(int maxsize){
     this.maxsize=maxsize;
     this.size=0;
     heap=new Int(this.maxsize+1);
     heap[0]=Integer.MIN_VALUE;
 } 
 private int parent(int pos){
     return pos/2;
 } 
 private int left(int pos){
     return (2*pos);
 }
 private int right(int pos){
     return (2*pos)+1;
 }
 public boolean isleaf(int pos){
     if(pos>=(size/2)&&(pos<=size)){
         return true;
     }
     else{
         return false;
     }
 }
 public void swap(int a,int b){
     int temp;
     temp = heap[a];
     heap[a]=heap[b];
     heap[b]=temp;
 }
 public void heapify(int pos){
     if(isleaf(pos)){
         if(heap(pos)>heap[left] || heap(pos)>heap[right]){
             if(heap[left(pos)]<heap[right(pos)]){
                 swap(pos,left(pos));
                 heapify(left(pos));
             }
             else{
                 swap(pos,right(pos));
                 heapify(right(pos));
             }
         }
     }
 }
 public void insert(int val){
     if(size>=maxsize){
         return;
     }
     heap[++size]=val;
     int curr=size;
     while(heap[curr]<heap[parent(curr)]){
         swap(curr,parent(curr));
         curr=parent(curr);
     }
 }
 public void minHeap() 
 { 
     for (int pos = (size / 2); pos >= 1; pos--) { 
         heapify(pos); 
     } 
 } 
 public int getmin(){
     return heap[FRONT];
 }
 public int remove(){
     int rem = heap[FRONT];
     heap[FRONT]=heap[size--];
     heapify(FRONT);
     return rem;
 }
}
