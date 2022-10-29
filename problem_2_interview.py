# Python3 implementation of Min Heap
# // Time Complexity : to find min element O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


from cgitb import small
from heapq import heapify
import sys

class MinHeap:

    def __init__(self, capacity):
        self.capacity = capacity
        self.storage = [0] * capacity
        self.size = 0

    # Functions to return the index of the parent, rightChilde and left child of the current node
    def getParentIndex(self, index):
        return (index-1)//2 #floor division

    def getLeftChildIndex(self, index):
        return 2 * index + 1

    def getRightChildIndex(self, index):
        return (2 * index) + 2
    
    #return boolean value True of False for parent, rightChild, leftChild exists or not?
    def hasParent(self, index):
        return self.getParent(index) >= 0

    def hasLeftChild(self, index):
        return self.getLeftChildIndex(index) < self.size
    
    def hasRightChild(self, index):
        return self.getRightChildIndex(index) < self.size

    #to actually send parent, left child and right child of index element
    def getParent(self, index):
        return self.storage[self.getParentIndex(index)]

    def getLeftChild(self,index):
        return self.storage[self.getLeftChildIndex(index)]
    
    def getRightChild(self, index):
        return self.storage[self.getRightChildIndex(index)]

    # Function to swap two nodes of the heap
    def swap(self, index1, index2):
        self.storage[index1], self.storage[index2] = self.storage[index2], self.storage[index1]

    def isFull(self):
        if self.size == self.capacity: 
            return True
        else:
            return False

    # Function to heapify the node at index
    def minHeapify(self, index):
        if (self.hasParent(index) and self.storage[index] < self.getParent(index)):
            self.swap(index, self.getParentIndex(index))
            self.minHeapify(self.getParentIndex(index))

    #function that minHeapifies Down whenever we remove a node
    def minHeapifyDown(self, index):
        if (self.hasLeftChild(index)):
            smallerChildIndex = self.getLeftChildIndex(index)
            if (self.hasRightChild(index) and self.getRightChild(index) < self.getLeftChild(index)):
                smallerChildIndex = self.getRightChildIndex(index)
            if self.storage[index] < self.storage[smallerChildIndex]:
                return
            else:
                self.swap(index, smallerChildIndex)
            self.minHeapifyDown(smallerChildIndex)
    
    # Function to insert a node into the heap
    def insert(self, element):
        if self.isFull():
            return

        self.storage[self.size] = element
        current = self.size
        self.size+= 1

        self.minHeapify(current)

    # Function to print the contents of the heap
    def Print(self):
        for i in range(0, (self.size//2)+1):
            print(" PARENT : "+ str(self.storage[i])+" LEFT CHILD : "+
                                str(self.storage[2 * i + 1])+" RIGHT CHILD : "+
                                str(self.storage[2 * i + 2]))

    # Function to remove and return the minimum
    # element from the heap
    def remove(self):
        if self.size == 0:
            return -1
        popped = self.storage[0]
        self.storage[0] = self.storage[self.size-1]
        self.storage[self.size-1] = 0
        self.size-= 1
        self.minHeapifyDown(0)
        return popped

# Driver Code
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
    minHeap.Print()
    elem =  minHeap.remove()
    minHeap.Print()
    print("The Min val is ",elem)
