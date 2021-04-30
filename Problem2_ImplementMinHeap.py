# Time Complexity: 1. Insert() --> O(logN) [since after inserting, we need to heapify down the tree] 
#                  2. Remove() --> O(logN) [since after removing, we need to heapify up the tree]
#                  3. getMin() --> O(1) [accessing the top element in complete binary tree/ accessing the first element in array representation takes constant time]
# 
# Space Complexity: 1. O(N) --> size of array to represent the min heap 

import sys

class MinHeap:
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.heap = [0]*(self.maxsize + 1)
        self.FRONT = 1
        self.heap[0] = -1 * sys.maxsize
    
    def getParent(self, idx):
        return idx >> 1
    
    def getLeftChild(self, idx):
        return idx << 1
    
    def getRightChild(self, idx):
        return (idx << 1) + 1
        
    def isLeaf(self, idx):
        if idx > (self.size >> 1) and idx <= self.maxsize:
            return True
        return False
    
    def swap(self, idx1, idx2):
        self.heap[idx1], self.heap[idx2] = self.heap[idx2], self.heap[idx1]
    
    def heapify(self, idx):
        if not self.isLeaf(idx):
            if self.heap[idx] > self.heap[self.getLeftChild(idx)] or self.heap[idx] > self.heap[self.getRightChild(idx)]:
                if self.heap[self.getLeftChild(idx)] > self.heap[self.getRightChild(idx)]:
                    self.swap(self.getRightChild(idx), idx)
                    self.heapify(self.getRightChild(idx))
                
                else:
                    self.swap(self.getLeftChild(idx), idx)
                    self.heapify(self.getLeftChild(idx))
            
    def Print(self):
        for i in range(1, (self.size >> 1) + 1):
            print(self.heap[i])
    
    def insert(self, element):
        if self.size > self.maxsize:
            return
        self.size += 1
        self.heap[self.size] = element
        curr = self.size
        
        while self.heap[curr] < self.heap[self.getParent(curr)]:
            self.swap(curr, self.getParent(curr))
            curr = self.getParent(curr)
    
    def remove(self):
        min = self.heap[self.FRONT]
        self.heap[self.FRONT] = self.heap[self.size]
        self.size -= 1
        return min
    
    def minHeap(self):
        for i in range(self.size >> 1, 0, -1):
            self.heapify(i)
    
if __name__ == "__main__":
    print('The minHeap is ')
    
    minHeap = MinHeap(15)
    minHeap.insert(5)
    minHeap.insert(3)
    minHeap.insert(17)
    minHeap.insert(10)
    minHeap.insert(84)
    minHeap.insert(19)
    minHeap.insert(6)
    minHeap.insert(22)
    minHeap.insert(9)
    minHeap.minHeap()
 
    minHeap.Print()
    print("The Min val is " + str(minHeap.remove()))
