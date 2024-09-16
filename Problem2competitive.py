

class minheap:

    def __init_(self):
        self.heap = [0]*10000
        self.size = 0
    def getmin(self,arr):
        return self.heap[0]

    def isleaf(self,pos):
        if(pos>=self.size//2 and pos<=self.size):
            return True
        return False
    def heapify(self,pos):
        if not isleaf(pos):
            if (self.heap[pos]>self.heap[(2*pos)+1] and self.heap[pos]>self.heap[(2*pos)+2]):
                if self.heap[(2*pos)+1] < self.heap[(2*pos)+2]:
                    self.heap[pos],self.heap[(2*pos)+1] = self.heap[(2*pos)+1],self.heap[pos]
                    self.heapify((2*pos)+1)
                else:
                    self.heap[pos],self.heap[(2*pos)+2] = self.heap[(2*pos)+2],self.heap[pos]
                    self.heapify((2*pos)+2)


    def extractmin(self):
        value = self.heap[0]
        self.heap[0] = self.heap[self.size-1]
        self.size = self.size - 1
        pos = 0
        self.heapify(pos)


    def insert(self,value):
        self.heap[self.size+1]=value
        self.size = self.size + 1
        current = self.size-1
        while(self.heap[current]>self.heap[self.size//2]):
            self.heap[current],self.heap[self.size//2] = self.heap[self.size//2],self.heap[current]
            current = self.size//2
