# Time Complexity : O(log n) for operations insert() and extractMin. O(1) for getMin which is just the root of the heap itself
# Space Complexity : O(1) auxiliary space needed
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import sys

class MinHeap:
  
    def __init__(self, maxsize):
        self.maxsize = maxsize # Give the maximum size of the min heap
        self.size = 0 # Initially the size is 0
        self.Heap = [0]*(self.maxsize + 1) # Initialize a heap array of size maxsize+1
        self.Heap[0] = -1 * sys.maxsize # The first element of heap is -sys.maxsize (like its negative infinite)
        self.FRONT = 1
    # In a heap, for a given index i, arr[(i-1)/2] is its parent node, arr[(2*i)+1] is the left child and arr[(2*i)+1] is its right child
    def parent(self,pos):
        return pos//2 # To find parent perform division on pos with 2 and round it down
        # Ideally it should be (pos-1)//2 but we are using the 0th element to store -sys.maxsize as its the lowest element 
    def leftChild(self, pos):
        return 2 * pos # Again, its 2*pos and not 2*pos + 1 because we are uwsing 0 th element to store -sys.maxsize
    def rightChild(self, pos):
        return (2 * pos) + 1 
    
    def isLeaf(self, pos):
        return pos*2 > self.size # If pos*2 is greater than size then there is no level below pos and it is a leaf node
  
    def swap(self, fpos, spos):
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]
    
    def minHeapify(self,pos):
        # Important function, it is used to adjusgt the heap in such a way that it maintains the property of min heap
        # i.e this method will make sure that heap at node pos follows heap property that parent node has greater value than its children
        if not self.isLeaf(pos):
            # If the node is not a leaf node
            if( self.Heap[pos]>self.Heap[self.leftChild(pos)] or self.Heap[pos]>self.Heap[self.rightChild(pos)]):
                # If the node has greater value than either of its children

                if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]:
                    # If left child is less than right child, then we make the left child an parent by swapping current pos with left child
                    self.swap(pos, self.leftChild(pos))
                    self.minHeapify(self.leftChild(pos)) # Now we recursively call minHeapify on the left child of pos (which was parent previously before getting swapped with its left child in earlier step)
                    #  We call minHeapify recursively because we need to make sure that the nodes on the leftchild side follow the min heap properties
                else:
                    # If left child is not less than right child, then we swap pos with the right child instead
                    # We know pos is greater than left child as otherwise we would not enter this if statement in the first place
                    self.swap(pos, self.rightChild(pos))
                    self.minHeapify(self.rightChild(pos)) # After swapping, call minheapify on the new right child
    def minHeap(self):
        for i in range(self.size//2,0,-1):
            # Start at the root node and apply minHeapify to the root node and keep going down
            self.minHeapify(i)
    def insert(self, element):
        if self.size >= self.maxsize :
            return # If current size is already at capacity or greater than our defined max size, then we can noyt add elements to the heap
        self.size+= 1 # Add size by 1 counting the new element we are inserting
        self.Heap[self.size] = element # Give value at the last node i.e Heap[size]
  
        current = self.size # Initialize current wil size which is where the inserted element is at
  
        while self.Heap[current] < self.Heap[self.parent(current)]:
            # Iterate through all the time current is less than its parent and swap the values
            self.swap(current, self.parent(current))
            current = self.parent(current) # Update current after swapping
        # At the end, element will reach its correct place in the min heap

    def extractMin(self):
        popped = self.Heap[self.FRONT] # The popped element will be Heap[1]
        self.Heap[self.FRONT] = self.Heap[self.size] # Take the last element which is a leaf node and make it as root
        # Since we are popping root, put the leaf node at the root and apply minHeapify to it and it will balance out after a few steps
        self.size-= 1 # Reduce size since we removed an element. This will ensure that element at Heap[size], which we moved to root will not come again in the leaf nodes
        self.minHeapify(self.FRONT)
        return popped # Return the popped element which is the min of the heap
    
    def Print(self):
        # Print the min heap
        for i in range(1, (self.size//2)+1):
            print(" PARENT : "+ str(self.Heap[i])+" LEFT CHILD : "+ 
                                str(self.Heap[2 * i])+" RIGHT CHILD : "+
                                str(self.Heap[2 * i + 1]))
    def getMin(self):
        return self.Heap[self.FRONT]
    
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
    minHeap.minHeap()
  
    minHeap.Print()
    print("The Min val is " + str(minHeap.extractMin()))
    print("The Min value after extractMin is " + str(minHeap.getMin()))
    minHeap.Print()
