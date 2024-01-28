# Min Heap
# Time Complexity
# getMin - O(1), Insert, Delete, Heapify - O(log(n))

class MinHeap:

    def __init__(self):
        self.heap = []

    def getMin(self):
        if len(self.heap) == 0:
            return float('-inf')
        return self.heap[0]

    def insert(self, val):
        self.heap.append(val)
        curIdx = len(self.heap) - 1 #length will be at least 1

        while curIdx > 0 and self.getParent(curIdx) > self.heap[curIdx]:
            self.swap(curIdx, self.getParentIdx(curIdx))
            curIdx = self.getParentIdx(curIdx)
        
        return curIdx

    def deleteMin(self):
        if len(self.heap) == 0:
            return float('-inf')
        else:
            self.swap(0, len(self.heap) - 1)
            self.heap.pop()
            self.heapify(0)

    def deleteIndex(self, index):
        if index < len(self.heap):
            self.heap[index] = self.getMin() - 1

        curIdx = index
        while curIdx > 0 and self.getParent(curIdx) > self.heap[curIdx]:
            self.swap(curIdx, self.getParentIdx(curIdx))
            curIdx = self.getParentIdx(curIdx)
        
        self.deleteMin()
        

    #considering valid calls only
    def heapify(self, index):
        smallestIdx = index

        if self.getLeftChildIdx(index) < len(self.heap) and self.getLeftChild(index) < self.heap[smallestIdx]:
            smallestIdx = self.getLeftChildIdx(index)

        if self.getRightChildIdx(index) < len(self.heap) and self.getRightChild(index) < self.heap[smallestIdx]:
            smallestIdx = self.getRightChildIdx(index)
        
        if smallestIdx != index:
            self.swap(index, smallestIdx)
            self.heapify(smallestIdx)
        



# TC
# 0, heap = [0], curIdx = 0
# -1, heap = [0, -1], curIdx = 1, parentIdx = (1-1)//2 = 0, swap!, heap = [-1 , 0]
# 2, heap = [-1, 0, 2]

    




    #helper methods

    #considering only valid calls
    def swap(self, i1, i2):
        temp = self.heap[i1]
        self.heap[i1] = self.heap[i2]
        self.heap[i2] = temp
    
    def getLeftChildIdx(self, index):
        return 2*index + 1

    def getRightChildIdx(self, index):
        return 2*index + 2

    def getParentIdx(self, index):
        return (index - 1)//2

    #considering only valid calls
    def getLeftChild(self, index):
        return self.heap[self.getLeftChildIdx(index)]

    #considering only valid calls
    def getRightChild(self, index):
        return self.heap[self.getRightChildIdx(index)]

    #considering only valid calls
    def getParent(self, index):
        return self.heap[self.getParentIdx(index)]



def main():
    minHeap = MinHeap()
    minHeap.insert(9)
    minHeap.insert(8)
    minHeap.insert(7)
    minHeap.insert(6)
    minHeap.insert(5)
    minHeap.insert(4)
    minHeap.insert(3)
    print(minHeap.getMin())
    print(minHeap.heap)
    minHeap.deleteMin()
    print(minHeap.heap)

main()
    