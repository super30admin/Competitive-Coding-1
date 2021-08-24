# Time Complexity : O(logN) for insert, delete, decrease and extractMin 
# Space Complexity : O(N) for N nodes
# Did this code successfully run on Leetcode : I did not find this exact question on LC
# Any problem you faced while coding this : It took some time to understand the logic of this problem


from heapq import heappush, heappop, heapify

class MinHeap:

    def __init__(self):
        self.heap = []
    
    def parent(self, pos):
        return (pos-1) / 2

    def insertKey(self, k):
        heappush(self.heap, k)
    
    # decrease value of key i to new_val
    # assuming new_val < heap[i]
    def decreaseKey(self, i, new_val):
        self.heap[i] = new_val
        while (i != 0 and self.heap[self.parent(i)] > self.heap[i]):
            # swap heap[i] with heap[parent(i)]
            self.heap[i], self.heap[parent(i)] = self.heap[parent(i)], self.heap[i]

    def extractMin(self):
        return heappop(self.heap) 

    # first reduce value at pos to -inf, then extractMin()
    def deleteKey(self, pos):
        self.decreaseKey(pos, float("-inf"))
        self.extractMin()
    
    def getMin(self):
        return self.heap[0]
