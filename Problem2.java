//Time complexity : getMin() => O(1)
//extractMin() and insert() =>O(logn) as these operations may require traversing the whole complete binary tree height.
//space complexity : O(n)
/** approach: to insert an element, we first add element to the array and then percolate up swapping the element with its parent if the element is smaller than its parent until we reach the root of the min heap
 * to remove an element, we remove the root of the heap, replace it with the last element in the array and then percolate down , swapping the parent with child if parent element is greater than the child element 
 */

class MinHeap{
  int[] Heap;
  int size;
  int capacity;

  public MinHeap(int capacity){
      this.capacity = capacity;
      this.size = 0;
      Heap = new int[this.capacity + 1];
      Heap[0] = Integer.MAX_VALUE;
  }

  public int parent(int position){
      return (position-1)/2;
  }
  public int left(int position){
      return (position*2) +1;
  }
  public int right(int position){
      return (position*2) +2;
  }
  public void swap(int pos1, int pos2){
      int temp = Heap[pos1];
      Heap[pos1]= Heap[pos2];
      Heap[pos2] = temp; 
  }
  public boolean isLeafNode(int position){
      if(position >= (size/2) && position <= size) return true;
      return false;
  }
  public int getMin(){
      return Heap[0];
  }
  public void insert(int x){
      if(size >= capacity){
          return;
      }
      size++;
      Heap[size] = x;
      int curr = size;
      while(Heap[curr] < Heap[parent(curr)]){
          swap(curr, parent(curr));
          curr =parent(curr);
      }
  }
  public int extractMin(){
      int removed = Heap[0];
      Heap[0] = Heap[size--];
      minHeapify(0);
      return removed;
  }
  public void minHeapify(int position) 
  { 
      if (!isLeafNode(position)) { 
          if (Heap[position] > Heap[left(position)] 
              || Heap[position] > Heap[right(position)]) { 

              if (Heap[left(position)] < Heap[right(position)]) { 
                  swap(position, left(position)); 
                  minHeapify(left(position)); 
              } 
              else { 
                  swap(position, right(position)); 
                  minHeapify(right(position)); 
              } 
          } 
      } 
  } 

  public static void main(String[] args) 
  { 
      MinHeap minHeap = new MinHeap(10); 
      minHeap.insert(1);
      minHeap.insert(10);
      minHeap.insert(0);
      minHeap.insert(100);
      minHeap.insert(20);
      minHeap.insert(25);
      minHeap.insert(33);
      minHeap.insert(14); 
      System.out.println("minimum value:" + minHeap.getMin()); 
      minHeap.extractMin();
      System.out.println("minimum value:" + minHeap.getMin()); 
      minHeap.extractMin();
      System.out.println("minimum value:" + minHeap.getMin()); 
  } 



}