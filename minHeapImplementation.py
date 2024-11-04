import sys

class MinHeap:
    def __init__(self, maxsize) -> None:
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0]*(maxsize+1)
        self.Heap[0] = -1 * sys.maxsize
        self.FRONT = 1

    def parent(self,pos):
        return pos//2
    
    def leftChild(self,pos):
        return 2 * pos
    
    def rightChild(self,pos):
        return (2 * pos)+1

    def size(self):
        return -1 #incomplete video error
    
    def peek(self):
        return -1
    
    def heapify(self):
        return -1
    
    def add(self):
        return -1
    
    def remove(self):
        return -1
    
    def print(self):
        return -1