"""
Problem : 2

Time Complexity : 
getMin - O(1)
insert - O(logn)
extractMin - O(logn)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

using the heapq library to performing the minheap implementation

"""

import heapq

class MinHeap:
    def __init__(self):
        self.heap=[]

    def insert(self,val):
        heapq.heapify(self.heap)
        heapq.heappush(self.heap,val)

    def getMin(self):
        return self.heap[0]
    
    def extractMin(self):
        return heapq.heappop(self.heap)