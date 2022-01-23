"""
A Min-Heap is a complete binary tree in which the value in each internal node 
is smaller than or equal to the values in the children of that node. 
Mapping the elements of a heap into an array is trivial: if a node is stored an index k, 
then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

getMin(): It returns the root element of Min Heap. The Time Complexity of this operation is O(1).
extractMin(): Removes the minimum element from MinHeap. The Time Complexity of this Operation 
is O(Log n) as this operation needs to maintain the heap property (by calling heapify()) 
after removing the root.
insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. 
If a new key is larger than its parent, then we don’t need to do anything. Otherwise, 
we need to traverse up to fix the violated heap property.

"""

# Time Complexity : O(log n) for insert, O(1) for getMin and extracttMin
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class MinHeap:

    def __init__(self):
        self.heap = []

    # return first element of heap, as in sortted array first element is minimum
    def getMin(self):
        if len(self.heap):
            return self.heap[0]

    # extract(pop) first element of heap to remove or extract minimum 
    def extractMin(self):
        if len(self.heap):
            self.heap.pop(0)

    # as array is sorted, can use binary search to insert (O(log n))
    def insert(self, element):

        # base
        # if heap is empty, add element directly
        if not self.heap:
            self.heap.append(element)
            return
    
        # if element being inserted is smaller than minimum element, append element before firstt element
        if element < self.heap[0]:
            self.heap = [element] + self.heap
            return 

        # logic
        # pointers for binary search
        left = 0
        right = len(self.heap) - 1

        while left <= right:
            mid = (left+right)//2
            prev = float('-inf')
            post = float('inf')

            #  set prev and post
            if mid >= 0:
                prev = self.heap[mid]
            if mid < len(self.heap)-1:
                post = self.heap[mid + 1]

            # case 1: if element between prev and post
            if prev < element and element < post:
                self.heap.insert(mid+1, element)
                return 

            # case 2: if element lies in rightt half, increment left pointer
            elif element > self.heap[mid]:
                left += 1

            # case 3: if element lies in left half
            elif element < self.heap[mid]:
                right -= 1

s = MinHeap()
s.insert(10)
new.insert(2)
print(new.extractMin())
new.getMin()
new.insert(4)
new.insert(12)
print(new.getMin())
