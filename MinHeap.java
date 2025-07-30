
public class MinHeap {

     private int[] heap;
     private int size;
     private int maxsize;
 
      //heap starts from 1st element in the array
     public MinHeap(int maxsize)
     {
          this.maxsize = maxsize;
          this.size = 0;

          heap = new int[this.maxsize+1];
          heap[0] = Integer.MIN_VALUE;
     }

     
    //Time Complexity: O(1)
    // Space Complexity: O(1)
     public int parent(int index)
     {return index/2;}

    //Time Complexity: O(1)
    // Space Complexity: O(1)     
     public int leftChild(int index)
     {
          return 2*index;
     }


    //Time Complexity: O(1)
    // Space Complexity: O(1)
     public int rightChild(int index)
     {
          return 2*index+1;
     }


    //Time Complexity: O(1)
    // Space Complexity: O(1)
     public boolean isLeaf(int index)
     {
          if(index>(size/2)) return true; // All elements with index > size/2 are leaf elements
          return false;
     }


    //Time Complexity: O(1)
    // Space Complexity: O(1)     
     public void swap(int index1, int index2)
     {
          int temp;
          temp = heap[index1];
          heap[index1] = heap[index2];
          heap[index2] = temp;
     }


     //Time Complexity: O(log(n))
    // Space Complexity: O(1)

     //MinHeapify is used for maintaining the minheap property.
     // It works by comparing the element at given index with smaller value child element(if both left and right childs are present)
     // or only left child and do a swap if index element is greater than smaller child value and continue till the elements are in proper place
     public void minHeapify(int index)
     {
       if(!isLeaf(index)){
       int swapPos= index;
 
       if(rightChild(index)<=size)
          swapPos = heap[leftChild(index)]<heap[rightChild(index)]?leftChild(index):rightChild(index);
       else
         swapPos= leftChild(index);
       
       if(heap[index]>heap[leftChild(index)] || heap[index]> heap[rightChild(index)]){
         swap(index,swapPos);
         minHeapify(swapPos);
       }
       
     }   
     }


     //Time Complexity: O(log(n))
    // Space Complexity: O(1)

     // Used to add / insert an element to MinHeap
     // Inserts element at last location and swap with its parent element 
     // if the value is lower and continue till the element is inserted in its correct location
     public void insert(int element)
     {
          
        if (size >= maxsize) {
            return;
        }

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
     }

     

}