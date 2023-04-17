#Time Complexity:O(1) for getMin,getSize and O(log n) for insert and delete
#Space Complexity:O(log n) 
class MinHeap:
    def __init__(self) -> None:
        self.heap=[]
    
    def getMin(self):
        return self.heap[0]
    
    def getSize(self):
        return len(self.heap)
    
    def insert(self,x):
        self.heap.append(x)
        self.bubbleUp(self.getSize()-1)

    def delete(self):
        (self.heap[0],self.heap[len(self.heap)-1])=(self.heap[len(self.heap)-1],self.heap[0])
        temp=self.heap.pop()
        self.bubbleDown(0)
        return(temp)

    def bubbleUp(self,child):
        if child==0:
            return
        parent=(child-1)//2
        if parent>=0 and self.heap[child]<self.heap[parent]:
            self.heap[child],self.heap[parent]=self.heap[parent],self.heap[child]
            self.bubbleUp(parent)

    def bubbleDown(self,parent):
        childLeft=(2*parent)+1
        childRight=(2*parent)+2
        temp=parent
        if childLeft<self.getSize() and self.heap[childLeft]<self.heap[temp]:
            temp=childLeft
        if childRight<self.getSize() and self.heap[childRight]<self.heap[temp]:
            temp=childRight
        if temp==parent:
            return
        self.heap[temp],self.heap[parent]=self.heap[parent],self.heap[temp]
        self.bubbleDown(temp)

a=MinHeap()
arr=[15,28,16,32,31,20]
for i in arr:
    a.insert(i)
    print(a.heap)

for i in arr:
    print(a.delete())
    print(a.heap)


        
        

        
      