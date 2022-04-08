from math import log2

# Time Complexity : O(log(N)) - extractMin() and insert()
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinHeap:
    def __init__(self) -> None:
        self.heap = []
        self.size = 0

    
    def getLeftChildIndex(self, i):
        return 2*i+1

    
    def getRightChildIndex(self, i):
        return 2*i+2


    def getParentIndex(self, i):
        return int((i-1)/2)

    
    def hasLeftChild(self, i):
        return self.getLeftChildIndex(i) < self.size
    
    
    def hasRightChild(self, i):
        return self.getRightChildIndex(i) < self.size


    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    
    def heapifyUp(self, i) -> None:
        while self.getParentIndex(i) >= 0 and self.heap[self.getParentIndex(i)] > self.heap[i]:
            self.swap(self.getParentIndex(i), i)
            i = self.getParentIndex(i)
        

    def getMin(self) -> int:
        return None if self.size == 0 else self.heap[0]

    
    def extractMin(self) -> int:
        min = self.getMin()
        if min is None: return None

        self.heap[0] = self.heap[self.size-1]
        del self.heap[self.size-1]
        self.size -= 1
        i = 0
        while self.hasLeftChild(i):
            minChildIndex = self.getLeftChildIndex(i)
            if self.hasRightChild(i) and self.heap[self.getRightChildIndex(i)] < self.heap[minChildIndex]:
                minChildIndex = self.getRightChildIndex(i)
            if self.heap[i] > self.heap[minChildIndex]:
                self.swap(i, minChildIndex)
                i = minChildIndex
            else:
                break
        
        return min

            
    def print(self):
        print(self.heap)


    def insert(self, n: int) -> None:
        self.heap.append(n)
        self.size += 1
        self.heapifyUp(self.size-1)
        


if __name__ == '__main__':
    minHeap = MinHeap()
    for i in range(8, 0, -1):
        print("--", i)
        minHeap.insert(i)


    minHeap.print()
    for _ in range(minHeap.size):
        print('popped: ', minHeap.extractMin())