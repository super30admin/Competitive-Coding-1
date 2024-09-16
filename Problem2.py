# class to implement minheap
class minheap(object):

    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.heap = [0]*(self.capacity+1)
        self.heap[0] = -float('inf')
    # function to check if minheap is empty
    def isEmpty(self):
        return self.size==0

    # function to get index of parent of given index
    def parent(self,pos):
        return pos//2
    # function to get index of right child of given index
    def rightchild(self,pos):
        return (2*pos)+1
    # function to get index of left child of given index
    def leftchild(self, pos):
        return (2*pos)
    #function to check if the given index has leaf element
    def isleaf(self,pos):
        return True if ( (pos>= (self.size)//2) and (pos <=self.size) ) else False 
    #function to swap two minheap nodes
    def swap(self, f, s): 
        self.heap[f], self.heap[s] = self.heap[s], self.heap[f]
    
    #function to rearrange the heap on given index
    def heapify(self,pos):
        if not self.isleaf(pos): 
            if (self.heap[pos] > self.heap[self.leftchild(pos)] or 
               self.heap[pos] > self.heap[self.rightchild(pos)]): 
  
               
                if self.heap[self.leftchild(pos)] < self.heap[self.rightchild(pos)]: 
                    self.swap(pos, self.leftchild(pos)) 
                    self.heapify(self.leftchild(pos)) 
  
               
                else: 
                    self.swap(pos, self.rightchild(pos)) 
                    self.heapify(self.rightchild(pos)) 
    # function to get the minimum value from heap, time - O(1)
    def getMin(self):
        if self.isEmpty():
            return "The heap is empty"
        return self.heap[1]
    # function to remove and return minimum value from heap - O(log n)
    def extractMin(self):
        popped = self.heap[1] 
        self.heap[1] = self.heap[self.size] 
        self.size-= 1
        self.heapify(1) 
        return popped 
    #function to make heap of all the elements in the heap
    def MinHeap(self):
        for pos in range(self.size//2, 0, -1): 
            self.heapify(pos)
    #function to insert an element in the minheap - O(log n)
    def insert(self, element):
		

        if self.size >= self.capacity : 
            return
        self.size+= 1
        self.heap[self.size] = element 
  
        current = self.size 
  
        while self.heap[current] < self.heap[self.parent(current)]: 
            self.swap(current, self.parent(current)) 
            current = self.parent(current) 

  