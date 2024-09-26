from heapq import heappush,heappop,heapify
class Minheap:
    def __init__(self):
        self.heap=[]
    def insertKey(self,k):
        heappush(self.heap,k)
    def extractMin(self):
        return heappop(self.heap)
    def getMin(self):
        return self.heap[0]