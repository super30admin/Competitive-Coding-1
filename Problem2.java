// The insertion and removal from MinHeap would take O(log n) times as we need to heapify
// only by comparing with the parent element. retrieving the min element would be O(1) as it is the root node.
//The space complexity is the maximum size which we allocate probabably O(n)

public class Problem2 {

  int[] heap = new int[20];
  int size = 0;
  int top = 1;

  private int parent(int pos)
  {
    return pos / 2;
  }

  private int leftChild(int pos)
  {
    return (2 * pos);
  }

  private int rightChild(int pos)
  {
    return (2 * pos) + 1;
  }

  private boolean isLeaf(int pos)
  {
    if (pos >= (size / 2) && pos <= size) {
      return true;
    }
    return false;
  }

  private void swap(int first, int second)
  {
    int temp = heap[first];
    heap[first] = heap[second];
    heap[second] = temp;
  }

  private void minHeapify(int pos)
  {
    if (!isLeaf(pos)) {
      if (heap[pos] > heap[leftChild(pos)]
              || heap[pos] > heap[rightChild(pos)]) {
        if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
          swap(pos, leftChild(pos));
          minHeapify(leftChild(pos));
        }
        else {
          swap(pos, rightChild(pos));
          minHeapify(rightChild(pos));
        }
      }
    }
  }

  public void insert(int element)
  {
    if (size >= heap.length - 1) {
      return;
    }
    heap[++size] = element;
    int current = size;

    while (heap[current] < heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  public void minHeap()
  {
    for (int pos = (size / 2); pos >= 1; pos--) {
      minHeapify(pos);
    }
  }

  public int remove()
  {
    int popped = heap[top];
    heap[top] = heap[size--];
    minHeapify(top);
    return popped;
  }

  public static void main(String[] arg)
  {
    Problem2 minHeap = new Problem2();
    minHeap.heap[0] = Integer.MIN_VALUE;
    minHeap.insert(10);
    minHeap.insert(11);
    minHeap.insert(20);
    minHeap.insert(4);
    minHeap.minHeap();

    System.out.println("Minimum value in the heap is " + minHeap.remove());
  }
}
