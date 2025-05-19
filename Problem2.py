from typing import List
# implement a heap min Heap implementation
class MinHeap:
    def __init__(self):
        # Initialize the heap with a dummy value
        self.heap = [0]  
    
    def push (self, value):
        self.heap.append(value)
        self.percolateUp(len(self.heap)-1)
    
    def pop(self):
        res = self.heap[1]
        self.heap[1] = self.heap[len(self.heap)-1]
        self.percolateDown(1)
        return res
    
    def top(self):
        return self.heap[1] if len(self.heap) > 1 else -1

    def heapify(self, nums):
        self.heap = [0] + nums
        for i in reversed(range(1, len(self.heap)//2 + 1 )):
            self.percolateDown(i)
    
    def percolateUp(self,index):
        parent = index//2
        while index > 1 and self.heap[parent] > self.heap[index]:
            self.heap[parent], self.heap[index] = self.heap[index], self.heap[parent]
            index = parent
            parent = index//2
    
    def percolateDown(self, index):
        child = 2*index
        while child < len(self.heap):
            if child +1 <len(self.heap) and self.heap[child] > self.heap[child+1] and self.heap[index]>self.heap[child+1]:
                child+=1
                 # swap root with right percolate down
                self.heap[index] ,self.heap[child] = self.heap[child], self.heap[index]
                index = child
                child*=2
            elif self.heap[child] < self.heap[index]:
                # swap left child 
                self.heap[index] ,self.heap[child] = self.heap[child], self.heap[index]
                index = child
                child*=2
            else:
                break



        

    

