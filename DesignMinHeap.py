class MinHeap:

    # initialise min heap
    def __init__(self, size):
        self.heap = [None]*(size+1)
        self.heapSize = 0
        self.size = size+1

    # Here we insert the element into min heap and the list is heapifyed using
    # helper method heapifyBottomToTop(), so that min element is present at the root.
    # The new element is added at the 1st available empty space, which is pointed by heapsize.
    # Time complexity - O(logn)
    # Space complexity - O(1)
    def insert(self, val):
        if self.heapSize == self.size:
            return "Heap is full"
        if self.heapSize == 0:
            self.heapSize += 1
            self.heap[self.heapSize] = val
        else:
            self.heap[self.heapSize] = val
            self.heapifyBottomToTop()
        self.heapSize += 1
        return "val added"


    # This function heapifys the list when new element is inserted.
    # We swap the child to the parent if parent holds value greater than the
    # child node. This is done until every
    # node has value less than its children nodes.
    # Time complexity - O(logn)
    # Space complexity - O(1)
    def heapifyBottomToTop(self):
        parentIdx = self.heapSize//2
        childIndx = self.heapSize
        while parentIdx>=1 and self.heap[parentIdx]>self.heap[childIndx]:
            temp = self.heap[parentIdx]
            self.heap[parentIdx] = self.heap[childIndx]
            self.heap[childIndx] = temp
            childIndx = parentIdx
            parentIdx = childIndx//2
        return


    # This method pops the root element out and a new minimum is set as the root.
    # To do this the last child node is put in root's place and child node's place is made null.
    # Now the heap with child node at root needs to be heapifyed so that the root holds the
    # min element of the list. Helper method heapifyToptoBottom() is used.
    # Time complexity - O(logn)
    # Space complexity - O(1)
    def extractMin(self):
        if self.heapSize==0:
            return "heap empty"
        curMin = self.heap[1]
        self.heapSize -= 1
        lastElement = self.heap[self.heapSize]
        self.heap[1] = lastElement
        self.heap[self.heapSize] = None
        self.heapifyToptoBottom(1)
        return curMin


    # This function heapifys the list when root is popped out.
    # We swap the child to the parent if parent holds value greater than the
    # child node. This is done until every
    # node has value less than its children nodes.
    # Time complexity - O(logn)
    # Space complexity - O(1)
    def heapifyToptoBottom(self, index):
        parentIdx = index
        leftIdx = parentIdx*2
        rightIdx = 1+parentIdx*2

        if leftIdx<self.heapSize and rightIdx<self.heapSize and self.heap[leftIdx]<self.heap[rightIdx]:
            childIdx = leftIdx
        elif leftIdx<self.heapSize and rightIdx<self.heapSize and self.heap[leftIdx]>self.heap[rightIdx]:
            childIdx = rightIdx
        elif leftIdx<self.heapSize and rightIdx>=self.heapSize:
            childIdx = leftIdx
        elif leftIdx>=self.heapSize and rightIdx<self.heapSize:
            childIdx = rightIdx
        else:
            return

        if self.heap[parentIdx]>self.heap[childIdx]:
            temp = self.heap[parentIdx]
            self.heap[parentIdx] = self.heap[childIdx]
            self.heap[childIdx] = temp
        self.heapifyToptoBottom(childIdx)
        return


    # Here root holds the minimum element hence, we return the
    # root of heap which is present at index 1.
    # Time complexity - O(1)
    # Space complexity - O(1)
    def getMin(self):
        if self.heapSize==0:
            return "heap empty"
        return self.heap[1]


s = MinHeap(5)
s.insert(3)
s.insert(4)
s.insert(1)
print(s.extractMin())
s.insert(6)
s.insert(2)
print(s.extractMin())
print(s.heap)
