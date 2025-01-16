#  Problem - Min Heap implementation using array.
#  Time Complexity: O(log n) for add and pop operations
#  Space Complexity: O(n) for storing n elements in heap

class MinHeap:
    def __init__(self, heap_size):
        self.heap_size = heap_size
        self.min_heap = [0] * (heap_size + 1)
        self.current_size = 0

    def parent(self, i):
        return (i // 2)
    
    def left_child(self, i):
        return 2 * i
    
    def right_child(self, i):
        return (2 * i) + 1
    
    def is_leaf(self, i):
        return i > self.current_size // 2 and i <= self.current_size
    
    def add(self, element):
        self.current_size += 1
        if self.current_size > self.heap_size:
            self.current_size -= 1
            return False
        
        self.min_heap[self.current_size] = element
        current = self.current_size

        while self.min_heap[current] < self.min_heap[self.parent(current)] and current > 1: 
            self.min_heap[current], self.min_heap[self.parent(current)] = self.min_heap[self.parent(current)], self.min_heap[current]
            current = self.parent(current)
    
        return True
    
    def peek(self):
        return self.min_heap[1]
    
    def pop(self):
        if self.current_size == 0:
            return False
        
        #  Heap has to remain complete binary tree, so we replace the root with the last element 
        # and then heapify

        popped = self.min_heap[1]
        self.min_heap[1] = self.min_heap[self.current_size]
        current = 1
        self.current_size -= 1

        #  while deleted element is not leaf node:
        while current > 1 and self.is_leaf(current) == False:

            if self.min_heap[current] > self.min_heap[self.left_child(current)] or self.min_heap[current] > self.min_heap[self.right_child(current)]:
                if self.min_heap[self.left_child(current)] < self.min_heap[self.right_child(current)]:
                    self.min_heap[current], self.min_heap[self.left_child(current)] = self.min_heap[self.left_child(current)], self.min_heap[current]
                    current = self.left_child(current)
                else:
                    self.min_heap[current], self.min_heap[self.right_child(current)] = self.min_heap[self.right_child(current)], self.min_heap[current]
                    current = self.right_child(current)
            else:
                break
        
        return popped
    
    def size(self):
        return self.current_size
    
    def __str__(self):
        return str(self.min_heap[1:self.current_size + 1])
    