// Problem - Design Min heap
//  Time Complexity : O(logn)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

#include <bits/stdc++.h>
#include <queue>
using namespace std;

class MinHeap {

private:
  vector<int> storage;
  int size;
  int capacity;
  int parent(int i) { return (i - 1) / 2; }
  int leftChild(int i) { return 2 * i + 1; }
  int rightChild(int i) { return 2 * i + 2; }

public:
  MinHeap(int capacity) {
    size = 0;
    this->capacity = capacity;
    storage.resize(capacity);
  }

  void push(int val) {
    if (size == capacity) {
      return;
    }
    storage[size] = val;
    size++;
    heapifyUp(size - 1);
  }

  void pop() {
    if (size <= 0) {
      return;
    }
    // replace root with the last level leaf node
    storage[0] = storage[size - 1];
    size--;
    heapifyDown(0);
  }

  int top() {
    if (size <= 0) {
      return -1;
    }
    return storage[0];
  }

  void heapifyUp(int i) {
    int parentIndex = this->parent(i);
    if (i > 0 && storage[parentIndex] > storage[i]) {
      swap(storage[parentIndex], storage[i]);
      heapifyUp(parentIndex);
    }
  }

  void heapifyUpIterative(int i) {
    while (i > 0 && storage[parent(i)] > storage[i]) {
      swap(storage[parent(i)], storage[i]);
      i = parent(i);
    }
  }

  void heapifyDown(int i) {
    int smallest = i;
    int leftC = this->leftChild(i);
    int rightC = this->rightChild(i);
    if (leftC < this->size && storage[smallest] > storage[leftC]) {
      smallest = leftC;
    }
    if (rightC < this->size && storage[smallest] > storage[rightC]) {
      smallest = rightC;
    }

    if (smallest != i) { // base condition for recursion
      swap(storage[smallest], storage[i]);
      heapifyDown(smallest);
    }
  }
};

int main() {
  MinHeap pq = MinHeap(10);
  priority_queue<int, vector<int>, greater<int>> opq;
  pq.push(10);
  pq.push(70);
  pq.push(9);
  pq.push(1);
  pq.push(91);
  pq.push(84);
  pq.pop();
  pq.pop();
  pq.pop();
  cout << pq.top() << endl;
  pq.push(36);
  cout << pq.top() << endl;

  cout << "-----" << endl;
  opq.push(10);
  opq.push(70);
  opq.push(9);
  opq.push(1);
  opq.push(91);
  opq.push(84);
  opq.pop();
  opq.pop();
  opq.pop();
  cout << opq.top() << endl;
  opq.push(36);
  cout << opq.top() << endl;
  return 0;
}
