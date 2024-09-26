# Time Complexity : getMin() - O(1), extractMin() - O(log n), insert() - O(log n)
# Space complecity : O(1) for getMin(), extractMin(), insert()
# Did this code successfully run on Leetcode : Problem not on leetcode

class MinHeap:
    def __init__(self, capacity: int) -> None:
        self.storage  = [0] * capacity
        self.capacity = capacity
        self.size = 0
     
    def _getParentIndex(self, childIndex: int) -> int:
        return (childIndex - 1) // 2
    
    def _getLeftChildIndex(self, parentIndex: int) -> int:
        return (2 * parentIndex) + 1
    
    def _getRightChildIndex(self, parentIndex: int) -> int:
        return (2 * parentIndex) + 2

    def _hasParent(self, childIndex: int) -> bool:
        return self._getParentIndex(childIndex) >= 0
    
    def _hasLeftChild(self, parentIndex: int) -> bool:
        return self._getLeftChildIndex(parentIndex) < self.size

    def _hasRightChild(self, parentIndex: int) -> bool:
        return self._getRightChildIndex(parentIndex) < self.size



    def _getParent(self, childIndex):
        return self.storage[self._getParentIndex(childIndex)]
    def _getLeftChild(self, parentIndex):
        return self.storage[self._getLeftChildIndex(parentIndex)]
    def _getRightChild(self, parentIndex):
        return self.storage[self._getRightChildIndex(parentIndex)]



    def _isFull(self):
        return self.size == self.capacity
    def _swap(self, index1, index2):
        self.storage[index1], self.storage[index2] = self.storage[index2], self.storage[index1]



    def _heapifyUp(self):
        index = self.size - 1
        while(self._hasParent(index) and self._getParent(index) > self.storage[index]):
            self._swap(self._getParentIndex(index), index)
            index = self._getParentIndex(index)
    
    def _heapifyDown(self):
        index = 0
        # only need to check for left child as heap is filled from left to right. if left child does not exist, then right child does not exist
        while(self._hasLeftChild(index)):
            smallerChildIndex = self._getLeftChildIndex(index)
            if(self._hasRightChild(index) and self._getRightChild(index) < self._getLeftChild(index)):
                smallerChildIndex = self._getRightChildIndex
            
            if self.storage[index] < self.storage[smallerChildIndex]:
                break
            else:
                self._swap(index, smallerChildIndex)
            index = smallerChildIndex





    
    
    def insert(self, data):
        if self._isFull():
            raise("Heap is full")
        self.storage[self.size] = data
        self.size += 1
        self._heapifyUp()

    def getMin(self):
        if(self.size == 0):
            raise("Empty Heap")
        return self.storage[0]

    def extractMin(self):
        if(self.size == 0):
            raise("Empty Heap")
        
        data = self.storage[0]
        self.storage[0] = self.storage[self.size - 1]
        self.size -= 1
        self._heapifyDown()
        return data

    def printHeap(self):
        for i in range(self.size):
            print(self.storage[i], end = ",")
        print("")
        

heap = MinHeap(7)

heap.insert(10)
heap.insert(5)
heap.insert(20)
heap.insert(2)



heap.printHeap()

print(heap.getMin())
print(heap.extractMin())

heap.printHeap()
print(heap.getMin())


    
    