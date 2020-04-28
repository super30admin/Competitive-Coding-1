/* Time Complexity : Insert: O(nlogn)-> for n elements, ExtractMin -> O(nlogn) for n elements
getMin() -> O(1) since we are returning the root value
// Space Complexity : O(n) for the integer array we are using to represent the heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/*Algorithm:  Insert the values one by one and increment the size index. After insertion, compare the inserted value with its parent as the value
will move up till it finds its correct place. For ExtractMin, the root will be popped, its value gets replace with the last array value or the
last leaf to maintain the complete binary tree property. The value gets adjusted by Heapify that searches for the next smallest value 
that is selected by comparing the parent value with its children as we move down the tree to leaf. If we reach leaf, we replace the root value with
the found value. 
*/
class MinHeap{
        private int maxsize;
        private int[] Heap;
        private int currentSize;
        MinHeap(int size){
            this.maxsize = size;
            this.currentSize = 0;
            Heap = new int[this.maxsize];           // Creating the Heap Array
        }
        int i = -1;
        public void insert(int data){
            i++;
            currentSize = i;
            Heap[i] = data;
            int parent = (i-1)/2;               // Searching for the parent of the child since index started is 0.
            while(parent !=-1 && Heap[parent] > Heap[i]){
                int t = Heap[parent];
                Heap[parent] = Heap[i];                 // Swap the parent if the parent value is larger than the child
                Heap[i] = t;
                i = parent;
                parent = (parent-1)/2;
            }
            i = currentSize;                        // update the i to the current size of the heap
        }
        public int extractMin(){
            int popped = Heap[0];
            Heap[0] = Heap[currentSize--];              // Swap the first element/root with the last element of the heap
            heapify(0);                             // Adjust the heap by heapify (compare the value from root to leaf)
            return popped;
        }
        private boolean isLeaf(int pos) 
        { 
            if (pos >= (currentSize / 2) && pos <= currentSize) {       // If leaf node is reached we are done comparing
                return true; 
            } 
            return false; 
        } 
        public int getMin(){
            return Heap[0];                 // Root will carry the least element always
        }
        
        public void heapify(int pos){
            int left = 2*pos+1;
            int right = 2*pos+2;
            if(isLeaf(pos)){
                return;
            }
            if((Heap[pos] > Heap[left]) || (Heap[pos] > Heap[right])){
                if(Heap[left] > Heap[right]){
                int t = Heap[pos];
                Heap[pos] = Heap[right];                // Compare the parent with children and replace the smallest child with parent
                Heap[right] = t;
                } else {
                int t = Heap[pos];
                Heap[pos] = Heap[left];
                Heap[left] = t;
                }
                heapify(pos);                       // Continue heapify till the heap values are completely adjusted
            }
        }

        public void print() 
        { 
            for (int i = 0; i <= currentSize / 2; i++) {                // Simply print the heap
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                        Heap[2 * i+1] + " RIGHT CHILD :" + Heap[2 * i + 2]); 
                System.out.println(); 
            } 
        } 

public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
  
        minHeap.print(); 
        System.out.println("The min val is " + minHeap.extractMin()); 
    } 
} 