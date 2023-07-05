// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std;


//use vector to implement minheap functionality
class MinHeap {//O(logn)
  std::vector<int> data;

  void push(int value) {
    data.push_back(value);
    int current = data.size() - 1;
    while (current > 0 && data[current] < data[(current - 1) / 2]) {
      std::swap(data[current], data[(current - 1) / 2]);
      current = (current - 1) / 2;
    }
  }

  int pop() {//O(logn) height of the tree
    int value = data[0];
    data[0] = data.back();
    data.pop_back();
    int current = 0;
    while (current < data.size() - 1) {
      int leftChild = 2 * current + 1;
      int rightChild = 2 * current + 2;
      int smallerChild = leftChild;
      if (rightChild < data.size() && data[rightChild] < data[leftChild]) {
        smallerChild = rightChild;
      }
      if (data[current] > data[smallerChild]) {
        std::swap(data[current], data[smallerChild]);
        current = smallerChild;
      } else {
        break;
      }
    }
    return value;
  }

  bool empty() {//O(1)
    return data.empty();
  }
};
