# Time Complexity : insert() - > log(n), remove() - > log(n), get_min() - O(1), where n is number of entries in heap
# Space Complexity : O(n) where n is number of entries in heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

import sys
class min_heap:

    # Initializing the heap as a list 
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0] * (self.maxsize+1)
        self.Heap[0] = -1 * sys.maxsize
        self.FRONT = 1

    # parent node
    def parent(self,index):
        return index//2
    # left node
    def left_child(self,index):
        return index*2
    # right node
    def right_child(self,index):
        return (index*2) + 1

    # Leaf node
    def is_leaf(self,index):
        return index > self.size//2

    # swapping values
    def swap(self, index1, index2):
        self.Heap[index1], self.Heap[index2] = self.Heap[index2], self.Heap[index1]

    # we need to have min value after after insert or removal ooperation
    def min_heapify(self, index):

        # check the conditions and swap accordingly 
        if not self.is_leaf(index):
            if (self.Heap[index] > self.Heap[self.left_child(index)]) or (self.Heap[index] > self.Heap[self.right_child(index)]):
                if self.Heap[index] < self.Heap[self.right_child(index)]:
                    self.swap(index, self.left_child(index))
                    self.min_heapify(self.left_child(index))
                else:
                    self.swap(index, self.right_child(index))
                    self.min_heapify(self.right_child(index))

    # insert and swap to maintain heap property
    def insert(self, value):
        if self.size > self.maxsize:
            return

        self.size+=1
        self.Heap[self.size] = value

        current = self.size

        while self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)


    # Calling the heapify function, starting the last non-leaf node
    def min_heapify(self):
        for pos in range(self.size//2,0,-1):
            self.min_heapify(pos)

    def remove(self):
        popped = self.Heap[self.FRONT]
        self.Heap[self.FRONT] = self.Heap[self.size]
        self.size-= 1
        self.minHeapify(self.FRONT)
        return popped

    # first element is always minimum 
    def get_min(self):
        return self.Heap[self.FRONT]
