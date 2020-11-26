# A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
# Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

# Time complexity: insert(): O(log(n)) ; getMin(): O(1) ; extractMin(): O(log(n))  
# Space complexity: O(n) ; storing all elements

from heapq import heappush, heappop, heapify

class Solution:
    
    def __init__(self):
        self.heap = []

    def insert(self,key):
        heappush(self.heap, key)

    def getMin(self):
        return self.heap[0]

    def extractMin(self):
        return heappop(self.heap)
    
    def printHeap(self):
        print("Heap: ", end="")
        for val in self.heap:
            print(val, end=" ")
        print()
    
hp = Solution()
hp.insert(11)
hp.insert(13)
hp.insert(25)
hp.insert(32)
hp.insert(45)
hp.insert(95)
hp.insert(40)
hp.printHeap()
print("Get min: ", hp.getMin())
print("Extract min: ", hp.extractMin())
print("Get min: ", hp.getMin())
hp.insert(2)
hp.printHeap()

