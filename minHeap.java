// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: For the insert we insert the element at the end of the array and keep swapping it with the parent if it is less that the parent. 
//If it swapped at its parents position, we again swap with is parent if smaller to satisfy the min heap properties.
//for the remove we remove the first element store it in a variable and return it but to maintain the min heap property we swap the element 
//with left child or right child whichever is smaller and we recursively do this.
public class minHeap {

    int size;
    int maxsize;
    int [] heap;
    minHeap(int maxsize){
        this.size= 0;
        this.maxsize = maxsize;
        heap = new int [this.maxsize];
        heap[0] = Integer.MIN_VALUE;

    }

    private void swap(int fpos, int spos){
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;

    }
    private int parent (int pos){
        return pos/2;
    }

    private int leftchild(int pos){
        return (2*pos);
    }

    private int rightchild(int pos){
        return (2*pos) + 1;
    }

    private boolean isLeaf(int pos){
        if (pos > size/2) {
            return true;
        }
        return false;
    }
    private void insert(int val){  //insert in the array
        
        if (size >= maxsize) {
            return;
        }
        heap[++size] = val;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    private void bubbleDown(int pos){     
        if(!isLeaf(pos)){
        int swapPos= pos;
        // swap with the minimum of the two children
        // to check if right child exists. Otherwise default value will be '0'
        // and that will be swapped with parent node.
        if(rightchild(pos)<=size)
            swapPos = heap[leftchild(pos)]<heap[rightchild(pos)]?leftchild(pos):rightchild(pos);
        else
            swapPos= leftchild(pos);
            
        if(heap[pos]>heap[leftchild(pos)] || heap[pos]> heap[rightchild(pos)]){
            swap(pos,swapPos);
            bubbleDown(swapPos);
        }
            
        }      
    }
    private int remove(){  //remove the mininum or the root element 
        int temp = heap[1];
        heap[1] = heap[size--];
        bubbleDown(1);
        return temp;
    }

    private void print(){
        
        for (int i = 1; i <= size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i]
                + " RIGHT CHILD :" + heap[2 * i + 1]);
 
            // By here new line is required
            System.out.println();
        }
    }


   
        public static void main(String[] args) {
            
            minHeap Heap = new minHeap(15);
            Heap.insert(5);
            Heap.insert(3);
            Heap.insert(17);
            Heap.insert(10);
            Heap.insert(84);
            Heap.insert(19);
            Heap.insert(6);
            Heap.insert(22);
            Heap.insert(9);
    
            // Print all elements of the heap
            Heap.print();
    
            // Removing minimum value from above heap
            // and printing it
            int min = Heap.remove();
            System.out.println("The Min val is " + min );
                            
        }
    
}

