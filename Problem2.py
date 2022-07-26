# Time complexity : it's different for each function
# Space complexity : O(n) - n is the max size
import sys
class minHeap:
    
    # Initializing the default value and also the Heap array, we have the starting index at 1, and the first element as the negative inf
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0] * (self.maxsize+1)
        self.Heap[0] = -1 * sys.maxsize
        self.FRONT = 1
    
    # parent of any node would be at position which is the half of the current index
    def parent(self,index):
        return index//2
    # left child of a node is at index * 2
    def left_child(self,index):
        return index*2
    # right child of a node is at index * 2 + 1
    def right_child(self,index):
        return (index*2) + 1
    
    # Leaf node is the one which has no child nodes, so the nodes which are at index more than the half the size of the array
    def isLeaf(self,index):
        return index > self.size//2
    
    # This function is to swap or inter-change the values in the array
    def swap(self, index1, index2):
        self.Heap[index1], self.Heap[index2] = self.Heap[index2], self.Heap[index1]
    
    # In order to preserved the property of min Heap, we use this function to swap the position of the values so that we always have a min heap
    # after insertion and removal of any value
    def minHeapify(self, index):
      
        # check if the node is a leaf node, then check if the parent node has value greater than either of it's child node, so that we can then swap
        # If the right child has value lesser than the parent, then swap with right child, else with left child
        if not self.isLeaf(index):
            if (self.Heap[index] > self.Heap[self.left_child(index)]) or (self.Heap[index] > self.Heap[self.right_child(index)]):
                if self.Heap[index] < self.Heap[self.right_child(index)]:
                    self.swap(index, self.left_child(index))
                    self.minHeapify(self.left_child(index))
                else:
                    self.swap(index, self.right_child(index))
                    self.minHeapify(self.right_child(index))
    
    # we always insert the value at the last available position. After insertion, we swap the elements to get the array into a min heap
    def insert(self, value):
        if self.size > self.maxsize:
            return
        
        self.size+=1
        self.Heap[self.size] = value
        
        current = self.size
        
        while self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)
    
    # printing the elements in the Heap in the array format
    def print(self):
        for i in range(self.size):
            print(self.Heap[i], end=" ")
    
    # Calling the heapify function, starting the last non-leaf node
    def minHeapf(self):
        for pos in range(self.size//2,0,-1):
            self.minHeapify(pos)
    
    # removal of nodes happen from the front of the array, which is the root element, so after removing, we take the last element from the array
    # to be the root, then call the heapofy function to get the array in minHeap order
    def remove(self):
        popped = self.Heap[self.FRONT]
        self.Heap[self.FRONT] = self.Heap[self.size]
        self.size-= 1
        self.minHeapify(self.FRONT)
        return popped
    
    # In MinHeap, the root element will always be the minimum out of the given array or List
    def getMin(self):
        return self.Heap[self.FRONT]

if __name__ == "__main__":
      
    print('The minHeap is ')
    minHeap = minHeap(15)
    minHeap.insert(5)
    minHeap.insert(3)
    minHeap.insert(17)
    minHeap.insert(10)
    minHeap.insert(84)
    minHeap.insert(19)
    minHeap.insert(6)
    minHeap.insert(22)
    minHeap.insert(9)
    minHeap.minHeapf()
  
    minHeap.print()
    print("The Min val is " + str(minHeap.remove()))
    print("Min is" + str(minHeap.getMin()))
                
