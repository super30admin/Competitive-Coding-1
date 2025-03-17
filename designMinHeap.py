# Time complexity:
# 1. Insertion: O(log n)
# 2. ExtractMin: O(log n)
# 3. GetMin: O(1)
# Space complexity: O(n) where n is the capacity of the heap
# Did this code run successfully on Leetcode: Yes
# Any difficulty faced: A little bit of difficulty in understanding the heapify function.

# Approach:
# I am implementing a MinHeap using an array.
# 1. I have defined the following functions:
#     a. getParent: to get the parent index of a node
#     b. getLeftChild: to get the left child index of a node
#     c. getRightChild: to get the right child index of a node
#     d. isLeaf: to check if the node is a leaf node
#     e. swap: to swap the elements at two indices
#     f. getMin: to get the minimum element in the heap
#     g. heapify: to heapify the heap
#     h. insert: to insert an element into the heap
#     i. extractMin: to extract the minimum element from the heap
#     j. printMinHeap: to print the heap


class MinHeap:
    # Initialize the heap with capacity
    def __init__(self, capacity):
        self.capacity = capacity
        # Initialize the heap with an array of size capacity with initial value 0
        self.heap = [0] * capacity
        # Initialize the size of the heap
        self.size = 0
    
    def getParent(self, index):
        # Return the parent index of the node
        return (index-1)//2
    
    def getLeftChild(slef, index):
        # Return the left child index of the node
        return (2*index) + 1
    
    def getRightChild(self, index):
        # Return the right child index of the node
        return (2*index) + 2

    def isLeaf(self, index):
        # Check if the node is a leaf node
        return (index > self.size//2)

    def swap(self, i, j):
        # Swap the elements at two indices
        tmp = self.heap[i]
        self.heap[i] = self.heap[j]
        self.heap[j] = tmp
    
    def getMin(self):
        # Get the minimum element in the heap
        return self.heap[0]
    
    def heapify(self, index):
        # if the node is not a leaf node
        if not self.isLeaf(index):
            # assign the current node as the smallest node
            smallest = index
            # if the left child is smaller than the current node, assign the left child as the smallest node
            if self.getLeftChild(index) < self.size and self.heap[self.getLeftChild(index)] < self.heap[smallest]:
                smallest = self.getLeftChild(index)
            # if the right child is smaller than the smallest node, assign the right child as the smallest node
            if self.getRightChild(index) < self.size and self.heap[self.getRightChild(index)] < self.heap[smallest]:
                smallest = self.getRightChild(index)
            # if the smallest node is not the current node, swap the elements
            if smallest != index:
                self.swap(index, smallest)
                # recursively heapify the heap
                self.heapify(smallest)

    def insert(self, value):
        # if the size of the heap is greater than or equal to the capacity, return
        if self.size >= self.capacity:
            return
        # increase the size of the heap and assign the value at the last index
        self.size += 1
        self.heap[self.size-1] = value
        # set the current index as the last index
        curr = self.size - 1
        # while the current index is greater than 0 and the parent node is greater than the current node, swap the elements
        while self.curr > 0 and self.heap[self.getParent(curr)] > self.heap[curr]:
            self.swap(self.getParent(curr), curr)
            curr = self.getParent(curr)

    def extractMin(self):
        # if the size of the heap is 0, return
        if self.size == 0:
            return
        # extract the minimum element from the heap, which will be at the root
        ext = self.heap[0]
        # assign the last element of the heap to the root
        self.heap[0] = self.heap[self.size-1]
        # and decrease the size of the heap
        self.size -= 1
        # heapify the heap
        self.heapify(0)
        return ext
    
    def printMinHeap(self):
        for i in range(self.size):
            print(self.heap[i], end=" ")
        print()

minHeap = MinHeap(10)
minHeap.insert(5)
minHeap.insert(3)
minHeap.insert(17)
minHeap.insert(10)
minHeap.insert(84)
minHeap.insert(19)
minHeap.insert(6)
minHeap.insert(22)
minHeap.insert(9)
minHeap.getMin()
minHeap.extractMin()
minHeap.printMinHeap()
print("minimum element: ", minHeap.getMin())
print("Extracted element", minHeap.extractMin())
minHeap.printMinHeap()