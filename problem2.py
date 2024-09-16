class MinHeap:
    def __init__(self):
        self.heap = []
    
    # O(1)
    def getMin(self):
        if(len(self.heap)==0):
            return -1
        else:
            return self.heap[0]
    
    # O(log(n))
    def heapify_up(self,i):
        # compare with parent element and swap if parent is greater than child
        while(i>0):
            parent = (i-1)//2
            if(self.heap[i]<self.heap[parent]):
                self.heap[i],self.heap[parent] = self.heap[parent],self.heap[i]
                i = parent
            else:
                return

    # O(log(n))
    def heapify_down(self,i):
        # compare with child and swap if child is smaller than parent
        while(i<=(len(self.heap)-1)//2):
            child1 = 2*i+1
            child2 = 2*i+2
            child = child1
            if(child1>=len(self.heap)):
                return
            if(child2<len(self.heap)):
                if(self.heap[child1]>=self.heap[child2]):
                    child = child2
            
            if(self.heap[i]>self.heap[child]):
                self.heap[i],self.heap[child] = self.heap[child],self.heap[i]
                i = child
            else:
                return

    # O(log(n))
    def insert(self,key):
        self.heap.append(key)
        self.heapify_up(len(self.heap)-1)

    # O(log(n))
    def extractMin(self):
        if(len(self.heap)==0):
            return -1
        self.heap[0],self.heap[-1] = self.heap[-1],self.heap[0]
        min1 = self.heap.pop()
        self.heapify_down(0)
        return min1


heapObj = MinHeap() 
heapObj.insert(3) 
heapObj.insert(2) 
print(heapObj.getMin())
heapObj.insert(15) 
heapObj.insert(5) 
heapObj.insert(4) 
heapObj.insert(45) 

print(heapObj.extractMin())
print(heapObj.getMin()) 
print(heapObj.extractMin())
print(heapObj.getMin()) 
print(heapObj.extractMin())
print(heapObj.extractMin())
print(heapObj.extractMin())
print(heapObj.extractMin())
print(heapObj.extractMin())