'''
Min Heap
'''

from heapq import heappush, heappop, heapify

class Solution:
    def __init__(self):
        self.myHeap = []
        heapify(self.myHeap)
        
    def insert(self, item):
        # Time complexity: O(logn)
        heappush(self.myHeap, item)
        
    def getMin(self):
        # Time complexity: O(1)
        return self.myHeap[0]
        
    def extractMin(self):
        # Time complexity: O(logn)
        return heappop(self.myHeap)
        
    def printHeap(self):
        print(self.myHeap)

sol = Solution()
sol.insert(10)
sol.insert(11)
sol.insert(12)

print("Minimum: ", end=" ")
print(sol.getMin())

print("Before extracting min: ")
sol.printHeap()

sol.extractMin()
print("After extracting min: ")
sol.printHeap()