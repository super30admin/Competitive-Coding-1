import java.util.*;

// Time Complexity : getMin -> O(1), insert & extract : O(logn)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// The min Heap implementation is based on Arrays and also using the Heap, min properties.

import java.util.*;

public class MinHeap {

  private int[] givenHeap;
  private int index;
  private int sizeOfHeap;

  public MinHeap(int sizeOfHeap) {
    this.sizeOfHeap = sizeOfHeap;
    this.index = 0;
    givenHeap = new int[sizeOfHeap];
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int leftChild(int i) {
    return (2 * i + 1);
  }

  private int rightChild(int i) {
    return (2 * i + 2);
  }

  private void swap(int x, int y) {
    int temp;
    temp = givenHeap[x];
    givenHeap[x] = givenHeap[y];
    givenHeap[y] = temp;
  }

  private boolean isLeafCheck(int i) {
    if (rightChild(i) >= sizeOfHeap || leftChild(i) >= sizeOfHeap) {
      return true;
    }
    return false;
  }

  public void insert(int val) {
    if (index >= sizeOfHeap) {
      return;
    }
    givenHeap[index] = val;
    int current = index;

    while (givenHeap[current] < givenHeap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
    index++;
  }

  public int extractMin() {
    int extracted = givenHeap[0];
    givenHeap[0] = givenHeap[--index];
    minHeapify(0);
    return extracted;
  }

  private void minHeapify(int i) {
    if (!isLeafCheck(i)) {
      if (givenHeap[i] > givenHeap[i] ||
          givenHeap[i] > givenHeap[rightChild(i)]) {
        if (givenHeap[leftChild(i)] < givenHeap[rightChild(i)]) {
          swap(i, leftChild(i));
        } else {
          swap(i, rightChild(i));
          minHeapify(rightChild(i));
        }
      }
    }
  }

  public void minHeap() {
    for (int i = (index - 1 / 2); i >= 1; i--) {
      minHeapify(i);
    }
  }

  public static void main(String[] args) {

    MinHeap minHeap = new MinHeap(7);
    minHeap.insert(3);
    minHeap.insert(13);
    minHeap.insert(7);
    minHeap.insert(16);
    minHeap.insert(21);
    minHeap.insert(12);
    minHeap.insert(9);
    minHeap.minHeap();
    System.out.println("Before inserting in Heap: " + Arrays.toString(minHeap.givenHeap));
    System.out.println("\nThe Min Value is : " + minHeap.extractMin());
    System.out.println("\nThe Min Heap is :" + Arrays.toString(minHeap.givenHeap));

  }
}