class MinHeap:
    def __init__(self):
        self.heap=[]
    #Time complexity: O(1)
    #Space complexity: O(1)   
    def getMin(self):
        return self.heap[0]
    #Time complexity: O(logn)
    #Space complexity: O(1)
    def insert(self,ele):
        self.heap.append(ele)
        self.bubbleUp(self.size()-1)
    #Time complexity: O(logn)
    #Space complexity: O(1)
    def remove(self):
        self.heap[0],self.heap[self.size()-1]=self.heap[self.size()-1],self.heap[0]
        temp=self.heap.pop()
        self.bubbleDown(0)
        return temp
    def size(self):
        return len(self.heap)
    def bubbleUp(self,idx):
        if idx==0:
            return
        par=(idx-1)//2
        if par>=0 and self.heap[idx]<self.heap[par]:
            self.heap[idx],self.heap[par]=self.heap[par],self.heap[idx]
            self.bubbleUp(par)
    def bubbleDown(self,idx):
        left=2*idx+1
        right=2*idx+2
        temp=idx
        if left < self.size() and self.heap[left] < self.heap[temp]:
            temp=left
        if right < self.size() and self.heap[right] < self.heap[temp]:
            temp=right
        if temp==idx:
            return
        self.heap[idx],self.heap[temp]=self.heap[temp],self.heap[idx]
        self.bubbleDown(temp)
obj=MinHeap()
arr=[15,28,16,32,31,20]
for i in arr:
    obj.insert(i)
    print(obj.heap)
for i in arr:
    print(obj.remove())
    print(obj.heap)
