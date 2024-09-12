'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
# A Min-Heap is a complete binary tree in which the value in each internal 
# node is less than or equal to the values in the children of that node.

# Mapping the elements of a heap into an array is trivial: if a node is stored
# a index k, then its left child is stored at index 2k + 1 and its right child
# at index 2k + 2.

# Operations on Min Heap:

# getMin(): It returns the root element of Min Heap. O(1)
# extractMin(): Removes the minimum element from MinHeap. O(log N) as this 
# operation needs to maintain the heap property after removing root.
# insert(): We add a new key at the end of the tree. If new key is larger than 
# its parent, then we don’t need to do anything. Otherwise, we need to traverse 
# up to fix the violated heap property. O(log N)
# Example of Min Heap:

#-----------------
# Time Complexity: 
#-----------------
# getMin()    : O(1) - Simple look up
# extractMin(): O(log N) - Need to run minheapify
# insert()    : O(log N) - Same as above
#------------------
# Space Complexity: 
#------------------
# O(n) : To store the individual elements in the array

import sys
class MinHeap:
    #Value to store lowest Integer
    INT_MIN_VALUE = -(sys.maxsize)
    
    #Starting index of the elements added to the heap
    FRONT = 1
    
    def __init__(self, maxsize):
        # Current size of the heap
        self.size = 0
        
        # Maximum allowed size of the heap
        self.max_size = maxsize
        
        # Initializing the heap with 0s of maximum allowed length
        self.heap = [0] * self.max_size
        
        # Set the lowest index (0)
        self.heap[0] = MinHeap.INT_MIN_VALUE
 
    def parent(self, pos: int) -> int:
        return pos//2

    def leftChild(self, pos: int) -> int:
        return 2*pos

    def rightChild(self, pos: int) -> int:
        return (2*pos) + 1

    def isLeaf(self, pos: int) -> bool:
        
        # Due to the nature of the array translation,
        # Element at k has left child at 2k+1 and right child at 2k+2
        if (pos >= (self.size//2)) and (pos <= self.size):
            return True
        else:
            return False

    def swap(self, pos1: int, pos2: int) -> None:
        temp_item = self.heap[pos2]
        self.heap[pos2] = self.heap[pos1]
        self.heap[pos1] = temp_item

    # Converts the Min Hap to array representation based on the definition 
    def minHeapify(self, pos: int) -> None:

        # If it is a leaf, then there's nothing to minHeapify.
        if not self.isLeaf(pos):
            # If the current node is > left or right child
            if self.heap[pos] > self.heap[self.leftChild(pos)] or \
               self.heap[pos] > self.heap[self.rightChild(pos)]:

                if self.heap[self.leftChild(pos)] < \
                   self.heap[self.rightChild(pos)]:
                    
                    # Keep swapping and recursively call minHeapify based on
                    # the updated values in the array
                    self.swap(pos, self.leftChild(pos))
                    self.minHeapify(self.leftChild(pos))

                else:
                    self.swap(pos, self.rightChild(pos))
                    self.minHeapify(self.rightChild(pos))

    def insert(self, element: int) -> None:
        if self.size >= self.max_size:
            return

        self.size += 1
        self.heap[self.size] = element
        current = self.size

        # Keep swapping new element until parent < children holds for the 
        # entire subtree information that is added
        while self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def printMinHeap(self) -> None:
        i = 1
        while i <= self.size//2:
            print(f'''PARENT: {self.heap[i]} LEFT CHILD: {self.heap[2*i]} RIGHT CHILD: {self.heap[2*i+1]}''')
            i += 1
    
    def minHeap(self) -> None:
        pos = self.size//2
        while pos >= 1:
            self.minHeapify(pos)
            pos -= 1

    def remove(self) -> int:
        popped_element = self.heap[MinHeap.FRONT]
        self.heap[MinHeap.FRONT] = self.heap[self.size]
        self.size -= 1
        self.minHeapify(MinHeap.FRONT)
        return popped_element


if __name__ == "__main__":
    minheap_obj = MinHeap(15)
    minheap_obj.insert(5)
    minheap_obj.insert(3)
    minheap_obj.insert(17)
    minheap_obj.insert(10)
    minheap_obj.insert(84)
    minheap_obj.insert(19)
    minheap_obj.insert(6)
    minheap_obj.insert(22)
    minheap_obj.insert(9)
    minheap_obj.minHeap()

    minheap_obj.printMinHeap()

    print(f"The minimum value is: {minheap_obj.remove()}")


