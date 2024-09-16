// Time Complexity: 
// getMin: O(1)
// extractMin: O(1)
// insert: O(n)
// Space Complexity : O(n) 

// A Min-Heap is a complete binary tree in which the value in each internal node is less than
// or equal to the values in the children of that node. Mapping the elements of a heap into an 
// array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 
// and its right child at index 2k + 2.

// Operations on Min Heap:
// getMin(): It returns the root element of Min Heap. O(1)
// extractMin(): Removes the minimum element from MinHeap. O(log N) as this operation needs to 
// maintain the heap property after removing root.
// insert(): We add a new key at the end of the tree. If new key is larger than its parent, then 
// we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property. O(log N)

public class MinHeap {
  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node head;

  public int getMin() {
    if (head == null) {
      return -1;
    } else {
      return head.data;
    }
  }

  public int extractMin() {
    if (head == null) {
      return -1;
    } else {
      Node tmp = head;
      head = head.next;
      return tmp.data;
    }
  }

  public void insert(int data) {
    Node node = new Node(data);

    if (head == null) {
      head = node;
    } else if (head.data > data) {
      node.next = head;
      head = node;
    } else {
      Node curr = head;
      while (curr.next != null && curr.next.data < data) {
        curr = curr.next;
      }

      System.out.println("curr.data = " + curr.data);
      node.next = curr.next;
      curr.next = node;
    }
  }

  public void printHeap() {
    if (head == null) {
      return;
    } else {
      Node curr = head;
      while (curr != null) {
        System.out.print(curr.data + " ");
        curr = curr.next;
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    MinHeap minHeap = new MinHeap();
    minHeap.insert(4);
    minHeap.insert(6);
    minHeap.insert(7);
    minHeap.insert(5);

    minHeap.printHeap();
    System.out.println("Min = " + minHeap.getMin());
    System.out.println("Remove = " + minHeap.extractMin());
    System.out.println("New Min = " + minHeap.getMin());
  }
}
