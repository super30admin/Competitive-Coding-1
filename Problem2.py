# Time Complexity : O( log n) for insert, remove and O(1) for getMin
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, did not understand minheap, had to go through solution to understand it.

# Approach: 1. insert each element and keep track of min element. 2. while removing element we keep track of the min element
# we swap the parent and child until the property of parent less than child is reached
import sys 
class MinHeap: 
  
    def __init__(self, maxsize): 
        self.maxsize = maxsize 
        self.size = 0
        self.Heap = [0]*(self.maxsize + 1) 
        self.Heap[0] = -1 * sys.maxsize 
        self.FRONT = 1

    def parent(self, pos): 
        return pos//2

    def leftChild(self, pos): 
        return 2 * pos 

    def rightChild(self, pos): 
        return (2 * pos) + 1

    def isLeaf(self, pos): 
        if pos >= (self.size//2) and pos <= self.size: 
            return True
        return False

    def swap(self, fpos, spos): 
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 
  
    def minHeapify(self, pos): 
        if not self.isLeaf(pos): 
            if (self.Heap[pos] > self.Heap[self.leftChild(pos)] or 
               self.Heap[pos] > self.Heap[self.rightChild(pos)]): 
  
                # Swap with the left child and heapify 
                # the left child 
                if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]: 
                    self.swap(pos, self.leftChild(pos)) 
                    self.minHeapify(self.leftChild(pos)) 
  
                # Swap with the right child and heapify 
                # the right child 
                else: 
                    self.swap(pos, self.rightChild(pos)) 
                    self.minHeapify(self.rightChild(pos)) 
  

    def insert(self, element): 
        if self.size >= self.maxsize : 
            return
        self.size+= 1
        self.Heap[self.size] = element 
  
        current = self.size 
  
        while self.Heap[current] < self.Heap[self.parent(current)]: 
            self.swap(current, self.parent(current)) 
            current = self.parent(current) 
  
    def Print(self): 
        for i in range(1, (self.size//2)+1): 
            print(" Parent : "+ str(self.Heap[i])+" left child : "+ 
                                str(self.Heap[2 * i])+" right child : "+
                                str(self.Heap[2 * i + 1])) 
  
    def minHeap(self): 
  
        for pos in range(self.size//2, 0, -1): 
            self.minHeapify(pos) 
  
    def remove(self): 
  
        popped = self.Heap[self.FRONT] 
        self.Heap[self.FRONT] = self.Heap[self.size] 
        self.size-= 1
        self.minHeapify(self.FRONT) 
        return popped 

if __name__ == "__main__": 
      
    print('The minHeap = ') 
    minHeap = MinHeap(5) 
    minHeap.insert(8) 
    minHeap.insert(1) 
    minHeap.insert(11) 
    minHeap.minHeap() 
  
    minHeap.Print() 
    print("The Mininum value is " + str(minHeap.remove())) 

