  
# Import the heap functions from python library 
from heapq import heappush, heappop  
  
# heappop - pop and return the smallest element from heap 
# heappush - push the value item onto the heap, maintaining 
#             heap invarient 
  
# A class for Min Heap 
class MinHeap: 
      
    # Constructor to initialize a heap 
    def __init__(self): 
        self.heap = []  
      
    # Inserts a new key 'k' 
    def insertKey(self, k): 
        heappush(self.heap, k)            
              
    # Method to remove minium element from min heap 
    def extractMin(self): 
        return heappop(self.heap) 
  
    # Get the minimum element from the heap 
    def getMin(self): 
        return self.heap[0] 
  
# Driver program to test above function 
heapObj = MinHeap() 
heapObj.insertKey(3) 
heapObj.insertKey(2) 
heapObj.insertKey(15) 
heapObj.insertKey(5) 
heapObj.insertKey(4) 
heapObj.insertKey(45) 
# 2,3,15,5,4,45
#              2
#          /       \
#         3         15
#       /    \      |
#      5       4    45
  
print (heapObj.extractMin())
print (heapObj.extractMin())
print (heapObj.getMin())