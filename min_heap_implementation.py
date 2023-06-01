class MinHeap:
    def __init__(self) :
        self.heap = []

    def getMin(self):
        return self.heap[0]
    
    def size(self):
        return len(self.heap)
    
    def insert(self,num):
        self.heap.append(num)
        self.__bubbleUp(self.size()-1)
    
    def remove(self):
        self.heap[0],self.heap[-1] = self.heap[-1],self.heap[0]
        poppedElement = self.heap.pop()
        self.__bubbleDown(0)
        return poppedElement

    def __bubbleUp(self,ind):
        if ind == 0:
            return
        parent = (ind-1)//2
        if (parent>=0 and self.heap[ind]<self.heap[parent]): #if the parent element is greater than its child, swap both.
            self.heap[ind],self.heap[parent] = self.heap[parent],self.heap[ind] 
            self.__bubbleUp(parent)     #Recursively check its parent and its parent if any.

    def __bubbleDown(self,ind):
        child1 = 2*ind+1
        child2 = 2*ind+2
        temp = ind
        if child1<self.size() and self.heap[child1]<self.heap[ind]:
            temp = child1
        if child2<self.size() and self.heap[child2]<self.heap[ind]:
            temp = child2
        if temp == ind:
            return
        self.heap[ind],self.heap[temp] = self.heap[temp],self.heap[ind]
        self.__bubbleDown(temp)

obj = MinHeap()
        
arr = [15,28,16,32,31,20]

for i  in arr:
    obj.insert(i)
    print(obj.heap)

for i in  arr:
    print(obj.remove())
    print(obj.heap)