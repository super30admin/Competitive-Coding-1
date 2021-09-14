# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, problem not present on leetcode, ran on local
# Any problem you faced while coding this : yes


from heapq import heappush, heappop, heapify 
class MinHeap:
      
    def __init__(self):
        self.arr = [] 
  
    def getParent(self, i):
        return (i-1)//2

    def insertEle(self, e):
        heappush(self.arr, e)

    def removeMin(self):
         #removes minimum element at root of heap
        return heappop(self.arr)
  
    def changeVal(self, i, val):
        self.arr[i]  = val
        parent = self.getParent(i)
        while(i != 0 and self.arr[parent] > self.arr[i]):
            self.arr[i] , self.arr[parent] = (
            self.arr[parent], self.arr[i])
            
    
    def removeVal(self, i):
        '''removes value at index i, first changes the value to -infinity,
        then using getMin() - we pop the element from heap'''
        self.arr[i]  = float("-inf")
        parent = self.getParent(i)
        while(i != 0 and self.arr[parent] > self.arr[i]):
            self.arr[i] , self.arr[parent] = (
            self.arr[parent], self.arr[i])
        self.removeMin()
  
    
    def getMin(self):
        # Fetches the minimum element from the heap
        return self.arr[0]
  
h1 = MinHeap()
h1.insertEle(3)
h1.insertEle(2)
h1.insertEle(15)
h1.removeVal(1)
h1.insertEle(7)
h1.insertEle(1)
h1.insertEle(20) 
print(h1.removeMin())
print(h1.getMin())
h1.changeVal(2, 1)
print(h1.getMin())
