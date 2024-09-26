class minHeap:
    def __init__ (self,items=[]):
        self.heap = [0]
        for item in items:
            self.insert(item)

    def __parent(self,pos):
        if pos >= 0:
            return pos//2
    
    def __lefttChild(self,pos):
        if pos < 0 or (pos*2) >= len(self.heap):
            return -1
        else:
            return (pos*2)
    
    def __rightChild(self,pos):
        if pos < 0 or (pos*2+1) >= len(self.heap):
            return -1
        else:
            return (pos*2 +1)
    
    def __swap(self,first,second):
        self.heap[first],self.heap[second] = self.heap[second],self.heap[first]
    
    def __bubbleUp(self,pos):
        parent = self.__parent(pos)
        if pos <=1:
            return
        elif self.heap[pos] < self.heap[parent]:
            self.__swap(pos,parent)
            self.__bubbleUp(parent)
    
    def __bubbleDown(self,pos):
        if pos >= len(self.heap)-1:
            return
        leftChild = self.__lefttChild(pos)
        rightChild = self.__rightChild(pos)
        if self.heap[leftChild] < self.heap[rightChild]:
            if self.heap[leftChild] < self.heap[pos]:
                self.__swap(pos,leftChild)
                self.__bubbleDown(leftChild)
            else:
                return
        else:
            if self.heap[rightChild] < self.heap[pos]:
                self.__swap(pos,rightChild)
                self.__bubbleDown(rightChild)
        
#log(n)
    def insert(self,item):
        self.heap.append(item)
        self.__bubbleUp(len(self.heap)-1)

    def peek(self):
        #check this
        if len(self.heap)>1:
            return self.heap[1]
        else:
            print('Empty Heap')
    
    def remove(self):
        if len(self.heap) >2:
            self.__swap(1,len(self.heap)-1)
            minNo = self.heap.pop()
            self.__bubbleDown(1)
        elif len(self.heap)==2:
            minNo = self.heap.pop()
        else:
            minNo = False
        return minNo



heap = minHeap([9,8,7,6,5,4,3,2,1])
print(heap.peek())
heap.remove()

print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()

heap.insert(5)
heap.insert(3)
heap.insert(12)
heap.insert(9)
heap.insert(2)
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
print(heap.peek())
heap.remove()
