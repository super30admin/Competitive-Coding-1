"""
A Min-Heap is a complete binary tree in which the value in each internal node is 
less than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a 
index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)
extractMin(): Removes the minimum element from MinHeap. O(log N) as this 
operation needs to maintain the heap property after removing root.
insert(): We add a new key at the end of the tree. If new key is larger 
than its parent, then we don’t need to do anything. Otherwise, we need to
 traverse up to fix the violated heap property. O(log N)
Example of Min Heap:


"""

class minHeap:
    def __init__(self, capacity):
        self.storage= [0] * capacity
        self.capacity = capacity
        self.size = 0

    #helper methods
    def getParentIndex(index):
        return index - 1 // 2
    def getLeftIndex(index):
        return index * 2 + 1
    def getRightIndex(index):
        return 2 * index + 2
    def hasParents(self,index) -> bool:
        return self.getParentIndex(index) >= 0
    def hasLeft(self,index) -> bool:
        return self.getLeftIndex(index) < self.size
    def hasRight(self,index) -> bool:
        return self.getRightIndex(index) < self.size

    #helper methods to get right storage of left parent child
    def parent(self, index):
        return self.storage[self.getParentIndex]
    def leftChild(self, index):
        return self.storage[self.getLeftIndex]
    def rightChild(self, index):
        return self.storage[self.getRightIndex]

    #check if full before insertion
    def isFull(self):
        return self.size > self.capacity
    #used after Heapify or add Remove element
    def swap(self, index1, index2):
        self.storage[index1], self.storage[index2] = self.storage[index2], self.storage[index1]

    def insert(self, data):
        if self.isFull():
            raise("heap is full") 
        self.storage[self.size] = data
        self.size += 1
        self.heapifyUp()

    def heapifyUp(self):
        #start at new node size 
        index = self.size - 1
        while self.hasParents(index) and self.getParentIndex(index) > self.storage[index]:
            self.swap(self.getParentIndex(index),index)
            #move up the index towards root node
            index = self.getParentIndex
        
    def extractMin(self):
        if self.size == 0:
            raise("empty heap")
        #use data to pop min element
        data = self.storage[0]
        #replace root with last element
        self.storage[0] = self.storage[self.size - 1]
        self.size -= 1
        self.heapifyDown()

    def heapifyDown(self):
        index = 0
        while self.hasLeft[index]:
            smallerChildIndex = self.getLeftIndex(index)
            if self.hasRight(index) and self.rightChild(index) > self.leftChild(index):
                smallerChildIndex = self.getRightIndex(index)
            if self.storage[index] < self.storage[smallerChildIndex]:
                # min is good
                break
            else:
                self.swap(index, smallerChildIndex)
                index = smallerChildIndex
                




