#Time Complexity : O(log n) ... n is number of elements 
#Space Complexity : O(1)
#Any problem you faced while coding this : faced some issue with the bubble down operation

#Used a list to implement the minHeap. The get size and get min element operations were straightforward as we have to fetch the size of the list and the very first element. Now, for the insert operation, initially the new element is added at the end and it is then compared with all the parent elements and eventually the final root element is decided. For removal, we initially swap the first and last element and perform bubble down operation where we compare the root with children and eventually end up comparing parent with children to determine the final root value. 

class MinHeap:
    def __init__(self):
        self.heap = []
        
    def getSize(self):
        return len(self.heap)
    
    def getMin(self):
        return self.heap[0]
    
    def insert(self, element):
        self.heap.append(element)
        self.__bubbleUp(self.getSize()-1)
        
    def remove(self):
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        popped = self.heap.pop()
        print(self.heap)
        self.__bubbleDown(0)
        return popped
        
    def __bubbleUp(self, idx):
        if idx == 0:
            return
        else:
            parent = (idx - 1)//2
            if parent >= 0 and self.heap[idx] < self.heap[parent]:
                self.heap[idx], self.heap[parent] = self.heap[parent], self.heap[idx]
                self.__bubbleUp(parent)
                
    def __bubbleDown(self, idx):           
        leftChild = (2 * idx) + 1
        rightChild = (2 * idx )+ 2
        
        curr = idx
        print("left, right = ", leftChild, rightChild)
        if leftChild < self.getSize() and self.heap[leftChild] < self.heap[curr]:
            curr = leftChild
            
        elif rightChild < self.getSize() and self.heap[rightChild] < self.heap[curr]:
            curr = rightChild
        print("curr", curr)
        if curr == idx:
            return
        else:
            curr = self.heap.index(min(self.heap[leftChild], self.heap[rightChild]))
        print(self.heap[idx], self.heap[curr])
        self.heap[idx], self.heap[curr] = self.heap[curr], self.heap[idx]
        self.__bubbleDown(curr)
        

heapObj = MinHeap()
heapObj.insert(10)
heapObj.insert(30)
heapObj.insert(13)
heapObj.insert(14)
heapObj.insert(4)
heapObj.insert(40)
heapObj.insert(1)
print(heapObj.getMin())
print(heapObj.getSize())
print(heapObj.heap)
print(heapObj.remove())
print(heapObj.heap)
