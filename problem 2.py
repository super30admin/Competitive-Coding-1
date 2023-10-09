class MinHeap:
    def __init__(self, heap, capacity):
        self.heap = heap
        self.capacity = capacity
        self.size = 0
    
    #O(1)                
    def rightChild(self, pos):
        return 2*pos + 1
    
    #O(1)
    def leftChild(self, pos):
        return 2*pos
    
    #O(1)    
    def parent(self, pos):
        if pos > 1:
            return pos//2
        else:
            return 1
        
    def isLeafNode(self, pos):
        return True if (self.size//2 < pos <= self.size) else False
    
    #O(1)
    def swap(self,pos1, pos2):
        self.heap[pos1], self.heap[pos2] = self.heap[pos2], self.heap[pos1]
        
    #O(1)
    def size(self):
        return self.size
    
    #O(logN)
    def add(self, value):
        if (self.size >= self.capacity):
            print("no more elements can be added")
            return
        self.size += 1
        current = self.size
        self.heap.append(value)
        parentIn = self.parent(current)
        while(self.heap[current] < self.heap[parentIn]):
            self.swap(current, parentIn)
            current = parentIn
            parentIn = self.parent(current)
     
    #O(logN)    
    def remove(self):
        if self.size == 0:
            print("Heap is empty")
        removedElement = self.heap[1]
        self.heap[1] = self.heap[self.size - 1]
        self.size -= 1
        self.heapify(1)
        return removedElement
        
    #O(1)
    def peek(self):
        return self.heap[1]
    
    #O(logN)
    def heapify(self, pos):
        if(not self.isLeafNode(pos)):
            if(self.heap[pos] > self.heap[self.leftChild(pos)]) or (self.heap[pos] > self.heap[self.rightChild(pos)]):
                if(self.heap[self.rightChild(pos)] < self.heap[self.leftChild(pos)]):
                    self.swap(pos, self.rightChild(pos))
                    pos = self.rightChild(pos)
                    self.heapify(pos)
                else:
                    self.swap(pos, self.leftChild(pos))
                    pos = self.leftChild(pos)
                    self.heapify(pos)

    def __repr__(self):
        return str(self.array)
        
obbj = MinHeap([4294967295], 10)
obbj.add(25)
obbj.add(8)
obbj.add(10)
print(obbj.heap)
print(obbj.peek())
obbj.add(20)
obbj.add(15)
print(obbj.heap)
print(obbj.peek())
obbj.add(7)
print(obbj.heap)
print(obbj.peek())
