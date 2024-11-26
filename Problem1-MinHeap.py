# Time Complexity: O(1) - get_min; O(logn) - insert, extract_min due to heapify
# Space Complexity: O(n)

from math import floor

class MinHeap:
  def __init__(self):
    # Store heap in a list 
    self.heap = []

  def get_parent(self, curr):
    return floor((curr-1)/2)
  
  def get_left_child_index(self, curr):
    return (2*curr)+1

  def get_right_child_index(self, curr):
    return (2*curr)+2

  def insert(self, value):
    # insert into the end of the list 
    print("insert " + str(value))
    self.heap.append(value)
    curr = len(self.heap) - 1
    # Heapify
    # till root node
    while self.get_parent(curr) >= 0:
      parent_index = self.get_parent(curr)
      # if lower than parent then interchange the value
      if self.heap[parent_index] > self.heap[curr]:
        self.heap[curr], self.heap[parent_index] = self.heap[parent_index], self.heap[curr]
        curr = parent_index
      else:
        # if not heap is restored hence break
        break
    print("Heap: ", self.heap)

  def get_min(self):
    if self.heap:
      return "Min: " + str(self.heap[0])
    else:
      return -(sys.maxsize - 1)
  
  def min_heapify(self, curr):
    left = self.get_left_child_index(curr)
    right = self.get_right_child_index(curr)
    if left <= len(self.heap) - 1:
      if right <= len(self.heap) - 1:
        swap = left if self.heap[left] <= self.heap[right] else right
        if self.heap[swap] < self.heap[curr]:
          self.heap[swap], self.heap[curr] = self.heap[curr], self.heap[swap]
          self.min_heapify(swap)
      else:
        if self.heap[left] < self.heap[curr]:
          self.heap[left], self.heap[curr] = self.heap[curr], self.heap[left]
          self.min_heapify[left]
  
  def extract_min(self):
    print(self.heap)
    min_value = self.heap[0]
    print("Extracted Min: ", min_value)
    self.heap[0], self.heap[len(self.heap) - 1] = self.heap[len(self.heap) - 1], self.heap[0]
    self.heap.pop(len(self.heap) - 1)
    curr = 0
    self.min_heapify(curr)
    print("After Extract Min: ", self.heap)


inst = MinHeap()
inst.insert(10)
inst.insert(9)
inst.insert(8)
inst.insert(7)
inst.insert(6)
inst.insert(5)
print(inst.get_min())
inst.extract_min()      

