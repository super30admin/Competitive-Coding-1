// Design Min Heap
// What is a heap ? - DS in which elemnets are arranged in complete binary tree an they follow some order
// that order decides if its min heap or max heap
// 1. It should be complete binary tree
// min heap = value of root is smaller than its children
// max heap = value of root is larger than its children
// TC: 
// getMin() - O(1), extractMin() - O(logn), insert() - O(logn)

public class DesignHeap {

  private int[] heap;
  private int size;
  private int maxSize;

  private static final int FRONT = 1;

  public DesignHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    heap = new int[this.maxSize + 1];
    heap[0] = Integer.MIN_VALUE;
  }

  private int parent(int pos) {
    return pos / 2;
  }

  private int leftChild(int pos) {
    return (2 * pos);
  }

  private int rightChild(int pos) {
    return (2 * pos) + 1;
  }

  private boolean isLeaf(int pos) {
    if (pos > (size / 2)) {
      return true;
    }
    return false;
  }

  private void swap(int fpos, int spos) {
    int temp;
    temp = heap[fpos];
    heap[fpos] = heap[spos];
    heap[spos] = temp;
  }

  private void minHeapify(int pos) {
    if (!isLeaf(pos)) {
      int swapPos = pos;
      if (rightChild(pos) <= size) {
        swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
      } else
        swapPos = leftChild(pos);

      if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
        swap(pos, swapPos);
        minHeapify(swapPos);
      }
    }
  }

  public void insert(int element) {
    if (size >= maxSize) {
      return;
    }

    heap[++size] = element;
    int current = size;

    while (heap[current] < heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  public void print() {
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

  public int remove() {

    int popped = heap[FRONT];
    heap[FRONT] = heap[size--];
    minHeapify(FRONT);

    return popped;
  }

  public static void main(String[] args) {
    System.out.println("The Min Heap is ");
    DesignHeap minHeap = new DesignHeap(15);

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

    System.out.println("The Min val is "
        + minHeap.remove());
  }
}