# Time Complexity : O(logn) for insert, O(logn) for extracting min and O(1) for getMin
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Used heapq library to implement heap operations

from heapq import heapify, heappush, heappop

class MinHeap:

    def __init__(self):
        self.heap=[]
        heapify(self.heap)
    
    def extractMin(self):
        return heappop(self.heap)

    def insert(self, value):
        heappush(self.heap,value)
    
    def getMin(self):
        return self.heap[0]

obj=MinHeap()
obj.insert(5)
obj.insert(10)
obj.insert(4)
obj.insert(1)
obj.insert(8)
obj.extractMin()
obj.getMin()

