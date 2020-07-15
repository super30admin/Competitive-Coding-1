'''
TIME COMPLEXITY:
    getMin() : O(1)
    extractMin() : O(log(n))
    insert() : O(log(n))
SPACE COMPLEXITY: O(n)

- for extractMin, we will swap first element with the last element, remove the last element, and heapify the heap
- for insert operation, we will add the element to the end of the tree and then compare with the parent, if it is smaller, we will swap them until parent is smaller than child
'''

class minHeap:
    def __init__(self):
        self.heap=[]

    def getMin(self):
        if len(self.heap)>=0:
            return self.heap[0]
    
    def extractMin(self):
        
        self.heap[0]=self.heap.pop()
        
        i= 0
        l=2*i+1
        r= 2*i+2
        n=len(self.heap)-1
        while (r<=n and l<=n) and (self.heap[l] < self.heap[i] or self.heap[r] < self.heap[i]):
            
            l=2*i+1
            r= 2*i+2
            if self.heap[l]< self.heap[i]:
                smallest=l
            
            if self.heap[r]< self.heap[i]:
                smallest=r

            if smallest != i:
                self.heap[smallest], self.heap[i] = self.heap[i], self.heap[smallest]
                i=smallest 

    def insert(self, data):
        self.heap.append(data)
        parentIndex= len(self.heap)//2 -1
        dataIndex=len(self.heap)-1
        while parentIndex>=0 and data<self.heap[parentIndex]:

            self.heap[dataIndex], self.heap[parentIndex] = self.heap[parentIndex], self.heap[dataIndex]
            if parentIndex==0:
                break
            dataIndex=parentIndex
            parentIndex=(parentIndex)//2

        return parentIndex

    def printHeap(self):
        print(self.heap)
obj= minHeap()
print(obj.insert(10))
print(obj.insert(20))
print(obj.insert(100))
print(obj.insert(30))
print(obj.insert(7))
# print(obj.getMin())
obj.extractMin()

# print(obj.insert(50))
obj.printHeap()


