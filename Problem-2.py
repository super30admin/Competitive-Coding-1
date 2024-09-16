# min-heap


class minHeap:
    def __init__(self, capacity):
        self.storage = [0] * capacity
        self.capacity = capacity
        self.size = 0

    # helper methods

    def getParentIndex(self, index):
        return (index-1)//2

    def getLeftChildIndex(self, index):
        return (2*index)+1
    def getRightChildIndex(self, index):
        return (2*index)+2
    
    def hasParent(self,index):
        if self.getParentIndex(index) < 0:
            return False
        else:
            return True

    def hasLeftChild(self,index):
        if self.getLeftChildIndex(index) >= self.size:
            return False
        else:
            return True
    
    def hasRightChild(self,index):
        if self.getRightChildIndex(index) >= self.size:
            return False
        else:
            return True
    
    def isFull(self):
        if self.size == self.capacity:
            return True
        else:
            return False

    def parent(self, index):
        if self.hasParent(index):
            return self.storage[self.getParentIndex(index)] 

    def leftChild(self, index):
        if self.hasLeftChild(index):
            return self.storage[self.getLeftChildIndex(index)] 

    def rightChild(self, index):
        if self.hasRightChild(index):
            return self.storage[self.getRightChildIndex(index)] 

    def swap(self, index1, index2):
        temp = self.storage[index1]
        self.storage[index1] = self.storage[index2]
        self.storage[index2] = temp

    def heapifyUp(self):
        index = self.size - 1

        while(self.hasParent(index) and self.parent(index) > self.storage[index]):
            self.swap(index,self.getParentIndex(index))
            index = self.getParentIndex(index)
    
    def insert(self, data):
        if self.isFull():
            raise("Heap is Full")
        else:
            self.storage[self.size] = data
            self.size += 1
            self.heapifyUp()

    def heapifyDown(self):
        index = 0
        while self.hasLeftChild(index):
            smallerChildIndex = self.getLeftChildIndex(index)
            if self.hasRightChild(index) and self.rightChild(index) < self.leftChild(index):
                smallerChildIndex = self.getRightChildIndex(index)
            if self.storage[index] < self.storage[smallerChildIndex]:
                break
            else:
                self.swap(index,smallerChildIndex)
            index = smallerChildIndex

    def removeMin(self):
        if self.size == 0:
            raise("Empty Heap")
        else:
            data = self.storage[0]
            self.storage[0] = self.storage[self.size - 1]
            self.size -= 1
            self.heapifyDown()
            return data
    def getMin(self):
        if self.size == 0:
            return None
        else:
            return self.storage[0]

obj = minHeap(5)
obj.insert(10)
obj.insert(20)
obj.insert(6)
print(obj.getMin())
obj.removeMin()
print(obj.getMin())
