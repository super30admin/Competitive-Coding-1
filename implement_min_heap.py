# heapify method takes O(n) time and add, remove methods take O(log(n)) time where n is length of heap
#O(n) space to store heap
import heapq
class MinHeap:
    def __init__(self,array):
        self.minheap = self.heapify(array)

    def heapify(self,array):
        return heapq.heapify(array)
    
    def add(self,element):
        heapq.heappush(self.minheap,element)
    
    def remove(self):
        return heapq.heappop(self.minheap)



