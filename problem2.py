"""
Time Complexity: 
Space Complexity: 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
Heap is a data structure in which elements are arraged in a complete binary treee and they follwo some order which decides whether it is a Min Heap or Max Heap.

For tree to be a Heap: 1. It should be a complete Binary tree
                       2. Root node should always be either greater or less than the children

Array is use to store the elements of the binary tree in preorder traversal
"""

class MinHeap:
    def __init__(self, heap) -> None:
        #Store the elements from index 1
        self.__heap = [0]
        for num in heap:
            self.__heap.append(num)
            
        self.__size = len(self.__heap)

    def parent(self, pos):
        """
        Return the parent of the element which is at index pos
        Time Complexity: O(1)
        """
        return pos // 2
    
    def leftChild(self, pos):
        """
        Returns the left child of the element which is at index pos
        Time Complexity: O(1)
        """
        return pos * 2
    
    def rightChild(self, pos):
        """
        Returns the right child of the element which is at index pos
        Time Complexity: O(1)
        """
        return (2*pos) + 1
    
    def isLeafNode(self, pos):
        """
        Returns whether the element at index pos is leaf Node.
        Time Complexity: O(1)
        """
        return pos > self.__size // 2 and pos < self.__size
    
    def peek(self):
        """
        Returns the peek of the Min Heap
        Peek of the Min Heap is always the root node (1st element of the array)
        Time Complexity: O(1)
        """
        return self.__heap(1)
    
    def size(self):
        """
        Returns the size of the heap
        Time Complexity: O(1)
        """
        return self.__size
    
    def print(self):
        """
        Print the elements of the Min Heap
        Time Complexity: O(n) where n is the size of the heap
        """
        for i in range(self.__size):
            print(self.__heap[i])

    def heapify(self, pos):
        """
        Determine whether the element at position pos has any impact on fulfilling the specified tree as Min Heap.
        Time Complexity: O(log n) where n is the size of the heap
        """ 
        if not self.isLeafNode(pos):
            if (self.leftChild(pos) < self.__heap[pos]) or (self.rightChild(pos) < self.__heap[pos]):
                #If both left and right child are greater
                if (self.leftChild(pos) < self.__heap[pos]) and (self.rightChild(pos) < self.__heap[pos]):
                    #Swap min of the left and right with element at pos
                    minimumEle = min(self.__heap[self.leftChild(pos)], self.__heap[self.rightChild(pos)])
                    if self.leftChild(pos) == minimumEle:
                        minEleIdx = self.leftChild(pos)
                    else:
                        minEleIdx = self.rightChild(pos)
                    self.__heap[pos], self.__heap[minEleIdx] =  self.__heap[minEleIdx], self.__heap[pos]
                    pos = 5
                    self.heapify(pos)

                #If only left element is greater 
                elif self.leftChild(pos) < self.__heap[pos] :
                    #Swap the left Child with the element at index pos
                    (self.__heap[pos] , self.__heap[self.leftChild(pos)]) = (self.__heap[self.leftChild(pos)], self.__heap[pos])
                    pos = self.leftChild(pos)
                    self.heapify(pos)
                
                #If only right child is greater
                else:
                    #Swap the right Child and element at index pos
                    (self.__heap[pos] , self.__heap[self.rightChild(pos)]) = (self.__heap[self.rightChild(pos)], self.__heap[pos])
                    pos = self.rightChild(pos)
                    self.heapify(pos)
    
    def add(self, element):
        """
        Add the element such that tree will remain MinHeap 
        Time Complexity: O(log n)
        """
        current = self.__size
        parentIdx = self.parent(current)
        while(self.__heap[current] < self.__heap[parentIdx]):
            self.__heap[current], self.__heap[parentIdx] = self.__heap[parentIdx], self.__heap[current]
            current = parentIdx
            parentIdx = self.parent(current)

    def remove(self):
        """
        Min Heap pop function. Pops the element at peek
        Time Complexity: log(n)
        """
        removeElement = self.__heap[1]
        self.__heap[1] = self.__heap[size]
        self.__size -= 1
        self.heapify(1)
        return removeElement

if __name__ == "__main__":
    minHeap = MinHeap([8,25,10,20,15])
    minHeap.heapify(2)
    minHeap.print()







