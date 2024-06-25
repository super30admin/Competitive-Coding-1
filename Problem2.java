// Time Complexity : Insert, extractMin - O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class MinHeap {
  int[] minHeap;
  int capapcity;
  int size;

  //Constructor
  MinHeap(int capapcity) {
    this.capapcity = capapcity;
    this.size = 0;
    minHeap = new int[capacity];
  }

  // Getting parent, left and right child if given an index.
  int getParent(int pos) return pos/2;
  int getLeftChild(int pos) return 2*pos;
  int getRightChild(int pos) return 2*pos+1;

  // Checking if an index is a left node.
  boolean isLeafChild(int pos) return pos > (size/2) && pos < size;

  // Swapping two elements
  void swap(int first, int second) {
    int temp = minHeap[first];
    minHeap[first] = minHeap[second];
    minHeap[second] = temp;
  }

  // Inserting an element into the minHeap
  void insert(int element) {
    if(size>=capapcity) throw new IllegalStateException("Heap is full");
    minHeap[size] = element;
    int currentSize = size;
    size++;
    while(currentSize!=0 && minHeap[currentSize] < minHeap[getParent(currentSize)]) {
      swap(currentSize, getParent(currentSize));
      currentSize = getParent(currentSize);
    }
  }

  // Extracting the first value from a minHeap
  int extractMin() {
    if(size == 0) throw new IllegalStateException("Heap is Empty");
    int result = minHeap[0];
    minHeap[0] = minHeap[--size];
    heapify(0);
    return result;
  }

  // To make sure the heap is a minHeap.
  void heapify(int pos) {
    if(!isLeafChild(pos)) {
      int left = getLeftChild(pos);
      int right = getRightChild(pos);
      int smallest = pos;
      if(left<size && minHeap[left]<minHeap[smallest]) smallest = left;
      if(right<size && minHeap[right]<minHeap[smallest]) smallest = right;
      if(smallest!=pos) {
        swap(smallest, pos);
        heapify(smallest);
      }
    }
  }

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(10);
    minHeap.insert(10);
    minHeap.insert(15);
    minHeap.insert(20);
    minHeap.insert(17);

    System.out.println(minHeap.extractMin()); // 10
    System.out.println(minHeap.extractMin()); // 15
  }

}
