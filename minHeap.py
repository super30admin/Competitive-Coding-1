# A Min-Heap is a complete binary tree in which the value in each internal node is less than or equal to the values in the children of that node.
# Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.
# getMin(): It returns the root element of Min Heap. O(1)
# extractMin(): Removes the minimum element from MinHeap. 
#               O(log N) as this operation needs to maintain the heap property after removing root.
# insert(): We add a new key at the end of the tree. 
#           If new key is larger than its parent, then we don’t need to do anything. 
#             Otherwise, we need to traverse up to fix the violated heap property. O(log N)
# Time Complexity and Space: getMin is O(1) time and space ||  extractMin() is O(lgN) time and O(1) space || 
#                   insert is O(lgN) time and O(1) space
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class minHeap():
    def __init__(self):
        self.heap = []
        self.size = 0

    def getMin(self):
        if self.heap:
            return self.heap[0]
        return -1 

    def extractMin(self):
        if not self.heap:
            return -1
        minVal = self.heap[0]
        #copy val then delete
        self.heap[0] = self.heap[self.size-1]
        self.size -= 1
        self.heap.pop() 
        #maintain heap property
        self.bubbleDown()
        return minVal

    def insert(self, x):
        self.heap.append(x)
        self.size += 1 

        index = self.size-1
        #if the value < parent Element then we swap
        while self.hasParent(index) and self.heap[(index-1)//2] > self.heap[index]:
            self.swap(index, (index-1)//2)
            index = (index-1)//2
        return 
        
    #swaps two elements
    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i] 
    
    #check for parents
    def hasParent(self, index):
        if ((index-1)//2) >= 0:
            return True
        return False

    def bubbleDown(self):
        index = 0 

        #need to swap current index with the smallest of the children
        while (index*2 + 1) < self.size:
            smallestChild = 2*index+1 
            
            if 2*index+2 < self.size:
                if self.heap[2*index+2] < self.heap[2*index+1]:
                    smallestChild = 2*index+2
            #check validity
            if self.heap[index] < self.heap[smallestChild]:
                break 
            else:
                self.swap(index, smallestChild)
        return 



heap = minHeap() 
heap.insert(9)
print(heap.heap)
heap.insert(20)
print(heap.heap)
heap.insert(2)
print(heap.heap)
heap.insert(21)
print(heap.heap)
heap.insert(25)
print(heap.heap)
print(heap.getMin())
print(heap.extractMin())
print(heap.getMin())
print(heap.heap)
print(heap.extractMin())
print(heap.getMin())
print(heap.extractMin())
print(heap.heap)
print(heap.extractMin())
print(heap.extractMin())
print(heap.extractMin())

