class minHeap:
    def __init__(self):
        self.heap=[]

    def getMin(self):
        if len(self.heap)>=0:
            return self.heap[0]
    
    def extractMin(self):
        for i in range(1, len(self.heap)):
            self.heap[i-1]= self.heap[i]
        self.heap.pop()
        


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
# obj.extractMin()

print(obj.insert(50))
obj.printHeap()


