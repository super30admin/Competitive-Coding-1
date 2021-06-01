'''
for k'th index in arr[]
parent  - arr[(k-1)/2]
left child - arr[2k+1]
right child - arr[2k+2]


Operations on Min Heap:

getMin(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Log n) as this operation needs to maintain the heap property (by calling heapify()) after removing root.
insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

'''

class Solution:
    def Heap(self):
        self.heap = []

    def Parent(self,i):
        return (i-1)//2
    
    def left(self,i):
        return 2*i+1
    
    def right(self,i):
        return 2*i+2
    
    def minheapify(self,pos):
        if self.heap[pos]>self.heap[self.left(pos)] or self.heap[pos]>self.heap[self.right(pos)]:
            if self.heap[self.left(pos)]<self.heap[self.right(pos)]:
                self.heap[pos],self.heap[self.left(pos)] = self.heap[self.left(pos)],self.heap[pos]
                self.minheapify(self.left(pos))
            else:
                self.heap[pos],self.heap[self.right(pos)] = self.heap[self.right(pos)],self.heap[pos]
                self.minheapify(self.right(pos))
    

    def insert(self,ele):
        self.heap.append(ele)
        cur = len(self.heap)
        while self.heap[cur-1]<self.heap[self.Parent(cur-1)]:
            self.heap[cur-1],self.heap[self.Parent(cur-1)] = self.heap[self.Parent(cur-1)],self.heap[cur-1]
            pos = cur-1
            pos = self.Parent(cur-1)
        
    def getMin(self):
        return self.heap[0]

    def extractMin(self):
        x = self.heap[0]
        self.minheapify(0)
        return x

    def printHeap(self):
        for i in range(len(self.heap)):
            print(self.heap[i])

obj = Solution()
obj.Heap()
obj.insert(15)
obj.insert(5)
print(obj.getMin())
obj.insert(3)
obj.insert(17)
obj.insert(10)
obj.insert(84)
obj.insert(19)
print(obj.getMin())
print(obj.extractMin())

