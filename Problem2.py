# Time Complexity :insert - O(n), heapify-O(n), removemin-O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :No
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
#for remove min..i removed the first val, and then replaced the last with first and then heapify
#for insert..i inserted first then do at last and then check with parent and iterate
# for heapify..select an index and check with right and left child, then swap

class MyMinHeap:
    def __init__(self, capacity):
        self.maxSize = 0
        self.capacity = capacity
        self.heap = [] * capacity
    def parent(self,i):
        return (i-1/2)
    def leftChild(self,i):
        return (2*i + 1)
    def rightChild(self,i):
        return (2*i+2)
    def swap(self,i,j):
        self.heap[i], self.heap[j] = self.heap[j],self.heap[i]
    def isleaf(self,i):
        return i >= self.maxSize/2 and i < self.maxSize
        
    def insert(self,val):
        if self.maxSize >= self.capacity:
            return
        self.heap[self.maxSize] = val
        self.maxSize += 1
        curr = self.maxSize
        heap_length = len(self.heap)
        while heap_length >0:
            if self.heap[curr] < self.parent(curr):
                self.swap(val, self.parent(curr))
                curr = self.parent(curr)
    def heapify(self,i):
        if self.maxSize >= self.capacity:
            return
        if self.isleaf(i):
            return
        curr =  i
        right = self.heap[self.rightChild(curr)]
        left = self.heap[self.leftChild(curr)]
        if self.heap[curr] > right:
            curr = right
        if self.heap[curr] > left:
            curr = left
        if i != curr:
            self.swap(i,curr)
            self.heapify(curr)
    def removeMin(self):
        if self.maxSize == 0:
            return
        min_val = self.heap[0]
        self.heap[0] = self.heap[-1]
        self.size -= 1
        self.heapify(0)
        return min_val
            
        
            
        
        
        
        
        