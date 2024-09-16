"""
Implement Min-Heap
Functions to implement are:

1.getMin(): returns root element of MinHeap
2.extractMin():removes the minimum 
3. insert(): adding new key at bottom - Need to check if this is less than root
"""

class MinHeap:
    def __init__(self):
        self.heap_list = [0] #adding dummy at position 0, to ensure heap is constructred from position-1
        self.size = 0
    
    #def heapify()


    def parent(self,position):
        return position//2

    def isEmpty(self):
        return len(self.heap_list)==0

    def getMin(self):
        if self.heap_list.isEmpty():
            return None
        return self.heap_list[0]
    
    def insert(self,element):
        self.size+=1
        self.heap_list[size] = element
        
        curr_size = self.size
        #The inserted element might be smaller than the parent, hence we need to check 
        #this condition as well.
        while self.heap_list[curr_size] < self.heap_list[self.parent(curr_size)]:
            self.swap(curr_size,self.parent(curr_size))
            current = self.parent(curr_size)
    
    def extractMin(self):
        node = self.heap_list[1]
        self.heap_list[1] = self.heap_list[self.size]
        self.size-=1
        self.heapify()
        return node