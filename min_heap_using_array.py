"""
Problem:
Implement Min Heap using array

Mock Interview Solutions
Min Heap Implementation using Array
https://youtu.be/CR7HVlUs3ls
https://www.geeksforgeeks.org/min-heap-in-java/#

Time Complexity : O(log n) for traversing the tree for heapify
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to find the indices logic to find parent, left child, right child. Then when we insert an element we need to heapify up
and when we extract the min element, we take the last element & move it to root and apply heapify down to preserve order. Heapify up or Swim is a process where when you insert an element it 
checks against its parent whether it's small or not if not then swap and repeat the same process until it is the smallest than its
root. Heapify down or sink is a process where we check if the root is smallest or it's left child or right child, if any of its
children are smallest then we swap with the root and repeat the same process until it's children are smaller than root.

"""


class MinHeap:
    def __init__(self):
        self.heap = []
    
    def parent(self, i):
        return (i - 1) // 2
    
    def left_child(self, i):
        return 2 * i + 1
    
    def right_child(self, i):
        return 2 * i + 2
    
    def insert(self, key):
        self.heap.append(key)
        self._heapify_up(len(self.heap) - 1)

    def _heapify_up(self, i):
        while i > 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.heap[i], self.heap[self.parent(i)] = self.heap[self.parent(i)], self.heap[i]
            i = self.parent(i)

    def extract_min(self):
        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down(0)
        return root
    
    def _heapify_down(self, i):
        smallest = i
        left = self.left_child(i)
        right = self.right_child(i)

        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left

        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != i:
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self._heapify_down(smallest)

    def get_min(self):
        if len(self.heap) == 0:
            return None
        return self.heap[0]
    
    def size(self):
        return len(self.heap)
    
    def is_empty(self):
        return len(self.heap) == 0
    
    def print_heap(self):
        print(self.heap)
    


# Example usage:
heap = MinHeap()
heap.insert(3)
heap.insert(2)
heap.insert(15)
heap.insert(5)
heap.insert(4)
heap.insert(45)

print("Min Heap array:")
heap.print_heap()

print("Extract Min:", heap.extract_min())
heap.print_heap()

print("Get Min:", heap.get_min())
print("Heap size:", heap.size())
print("Is heap empty?", heap.is_empty())