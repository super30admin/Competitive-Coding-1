class MinHeap(object):
    heap = []
    size,maxSize = 0,0
    FRONT = 1
    def __init__(self,maxSize):
        self.maxSize = maxSize
        self.heap = [0 for x in range(self.maxSize+1)]
        self.heap[0] = -1* float('inf')

    def parent(self, pos):
        return pos / 2
    
    def leftChild(self,pos):
        return 2*pos
    
    def rightChild(self,pos):
        return (2*pos)+1
    
    def isLeaf(self,pos):
        if pos >= (self.size / 2) and pos <= self.size:
             return True
        return False
    
    def minHeapify(self,pos):
        if not self.isLeaf(pos):
            if self.heap[pos] > self.heap[self.leftChild(pos)] or self.heap[pos] > self.heap[self.rightChild(pos)]:
                if self.heap[self.leftChild(pos)] < self.heap[self.rightChild(pos)]:
                    self.swap(pos,self.leftChild(pos))
                    self.minHeapify(self.leftChild(pos))
                else:
                    self.swap(pos,self.rightChild(pos))
                    self.minHeapify(self.rightChild(pos))
                
    def insert(self,element):
        self.size += 1
        if self.size >= self.maxSize:
            return
        self.heap[self.size] = element
        current = self.size
        while self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)
        
    def remove(self):
        popped = self.heap[self.FRONT]
        self.heap[self.FRONT] = self.heap[self.size]
        self.size -= 1
        self.minHeapify(self.FRONT)
        return popped
    
    def swap(self,fpos,spos):
        temp = self.heap[fpos]
        self.heap[fpos] = self.heap[spos]
        self.heap[spos] = self.heap[fpos]
        return

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
print(minHeap.heap)
print('The Min val is ' + str(minHeap.remove()))
print(minHeap.heap)