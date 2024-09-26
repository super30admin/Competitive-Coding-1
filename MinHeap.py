class MinHeap:
    def __init__(self):
        self.heap=[]
        
    def getMin(self):
        return self.heap[0]
        
    def size(self):
        return len(self.heap)
        
    def insert(self,val):
        self.heap.append(val)
        self.__bubbleup(self.size() - 1)
        
    def remove(self):
        self.heap[0], self.heap[-1]= self.heap[-1],self.heap[0]
        temp=self.heap.pop()
        self.__bubbledown(0)
        return temp
        
    def __bubbleup(self,idx):
        if idx != 0:
            parent = (idx-1)//2
            if parent > 0 and self.heap[idx] < self.heap[parent]:
                self.heap[parent], self.heap[idx]= self.heap[idx],self.heap[parent]
                self.__bubbleup(parent)
                
    def __bubbledown(self, idx):
        l= 2*idx + 1
        r = 2*idx +2
        lower=idx
        if l < self.size() and self.heap[l] < self.heap[lower]:
            lower = l
        
        if r < self.size() and self.heap[r] < self.heap[lower]:
            lower =r
            
        if lower != idx:
            self.heap[idx], self.heap[lower]=self.heap[lower],self.heap[idx]
            self.__bubbledown(lower)
            
obj=MinHeap()
arr=[15,28,16,32,31,20]
for i in arr:
    obj.insert(i)
    
for i in arr:
    print(obj.remove())
    

    
