/*
A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)
*/

// Time Complexity :
  //getMin: O(log n)  n = total number of elements.
  //insert: O(log n) n = total number of elements.

// Space Complexity :
  // O(n)  n = length of the heap.
// Any problem you faced while coding this :
  //Nope
// Your code here along with comments explaining your approach
  //for insert, insert at lastindx and push the value up if parent val greater.
  //for get min, get value at indx 0, then move val at lastindx to indx 0.
  //keep pushing this value down if its greater than children.
class Problem2{
  int heap[];
  int lastIndx;
  int heapSize;

  Problem2(int len){
    heap = new int[len];
    lastIndx = -1;
    heapSize = len;
  }

  private int getLeftChildIndx(int pindx){
    return (2*pindx) + 1;
  }
  private int getRightChildIndx(int pindx){
    return (2*pindx) + 2;
  }
  private int getParentIndx(int indx){
    if(indx == 0)
      return 0;
    return (indx - 1)/2;
  }

  public int getMin(){
    if(lastIndx < 0)
      return Integer.MIN_VALUE;
    int min = heap[0];
    //put last elem in strt indx and decrement lastindx by 1.
    heap[0] = heap[lastIndx--];
    //normalize heap, so min value is at top.
    extractMin(heap[0], 0);
    return min;
  }

  private void extractMin(int val, int indx){
    int leftindx = getLeftChildIndx(indx);
    int rightindx = getRightChildIndx(indx);

    //if both rightindx and leftindx are greater than lastindx.
    //can not push down val.
    if(leftindx > lastIndx && rightindx > lastIndx)
      return;
    //if rightindx > lastindx, pushdown val to leftindx.
    //only if heap[leftindx] < heap[indx].
    else if(rightindx > lastIndx){
      //chk left and parent.
      if(heap[leftindx] < val){
        heap[indx] = heap[leftindx];
        heap[leftindx] = val;
        extractMin(val, leftindx);
      }
    }
    else{
      //chk both heap[leftindx] and heap[rightindx].
        //then chk heap[indx] with lower of the above two.
        //if heap[indx] > then the lower of the two, replace vals,
        //and again do push down on val with new indx.
      if(heap[rightindx] < heap[leftindx]){
        if(heap[rightindx] < val){
          heap[indx] = heap[rightindx];
          heap[rightindx] = val;
          extractMin(val, rightindx);
        }
      }
      else{
        if(heap[leftindx] < val){
          heap[indx] = heap[leftindx];
          heap[leftindx] = val;
          extractMin(val, leftindx);
        }
      }
    }
  }

  private void pushUp(int val, int indx){
    int pindx = getParentIndx(indx);
    if(pindx == indx)
      return;

    //chk if heap[pindx] > heap[indx].
    //if so swap values, and pushup val with new indx.
    if(heap[pindx] > val){
      heap[indx] = heap[pindx];
      heap[pindx] = val;
      pushUp(val, pindx);
    }
    return;
  }

  public void insert(int val){
    if(lastIndx == heapSize-1){
      System.out.println("heap full can not add "+val+".");
      return;
    }
    //increment lastindx and add val to last position.
    heap[++lastIndx] = val;
    pushUp(val, lastIndx);
  }

  public static void main(String[] args) {
    Problem2 pb = new Problem2(10);

    //test case.
    int arr[] = {56,1,43, 12, 4, 0};
    for(int i = 0; i < arr.length ; i++){
      pb.insert(arr[i]);
    }
    for(int i = 0; i < 15; i++){
      System.out.println(pb.getMin());
    }
  }
}
