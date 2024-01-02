/*
 * Time Complexity :
 *      - insert: O(log(n))
 *      - pop: O(log(n))
 *      - empty: O(1)
 *      - heapifyUp: O(log(n))
 *      - heapifyDown: O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <iostream>
#include <vector>

class MinHeap {
public:
  // Constructor
  MinHeap() {}

  // Destructor
  ~MinHeap() {}

  // Inserts a new element into the heap.
  void insert(int value) {
    // Add the new element to the end of the heap.
    heap_.push_back(value);

    // Heapify the heap to maintain the min heap property.
    heapifyUp(heap_.size() - 1);
  }

  // Removes and returns the smallest element in the heap.
  int pop() {
    // The smallest element is always at the root of the heap.
    int smallest = heap_[0];

    // Replace the smallest element with the last element in the heap.
    heap_[0] = heap_[heap_.size() - 1];

    // Remove the last element from the heap.
    heap_.pop_back();

    // Heapify the heap to maintain the min heap property.
    heapifyDown(0);

    return smallest;
  }

  // Returns true if the heap is empty, false otherwise.
  bool empty() {
    return heap_.empty();
  }

private:
  // A vector to store the elements in the heap.
  std::vector<int> heap_;

  // Heapify the heap upwards from the given index.
  void heapifyUp(int index) {
    // Get the parent index.
    int parentIndex = (index - 1) / 2;

    // If the current element is smaller than its parent, swap them.
    if (heap_[index] < heap_[parentIndex]) {
      std::swap(heap_[index], heap_[parentIndex]);

      // Heapify the heap upwards from the parent index.
      heapifyUp(parentIndex);
    }
  }

  // Heapify the heap downwards from the given index.
  void heapifyDown(int index) {
    // Get the left and right child indices.
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;

    // Find the smallest child index.
    int smallestChildIndex = leftChildIndex;
    if (rightChildIndex < heap_.size() && heap_[rightChildIndex] < heap_[leftChildIndex]) {
      smallestChildIndex = rightChildIndex;
    }

    // If the current element is greater than its smallest child, swap them.
    if (heap_[index] > heap_[smallestChildIndex]) {
      std::swap(heap_[index], heap_[smallestChildIndex]);

      // Heapify the heap downwards from the smallest child index.
      heapifyDown(smallestChildIndex);
    }
  }
};

int main() {
  // Create a new min heap.
  MinHeap heap;

  // Insert some elements into the heap.
  heap.insert(10);
  heap.insert(5);
  heap.insert(3);
  heap.insert(7);

  // Pop the smallest element from the heap.
  int smallest = heap.pop();

  // Print the smallest element.
  std::cout << "The smallest element is: " << smallest << std::endl;

  // Pop the remaining elements from the heap.
  while (!heap.empty()) {
    int smallest = heap.pop();
    std::cout << "The smallest element is: " << smallest << std::endl;
  }

  return 0;
}

