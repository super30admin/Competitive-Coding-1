class Heap:
    def __init__(self):
        self.storage = [None]
        self.heapSize = 0

    def swapElementsAt(self, idx1, idx2):
        self.storage[idx1], self.storage[idx2] = self.storage[idx2], self.storage[idx1]
    

    def siftDown(self, currIdx):
            left = currIdx * 2
            right = currIdx * 2 + 1
            while left <= self.heapSize or right <= self.heapSize:
                if right <= self.heapSize:
                    swapIdx = left if self.storage[left] > self.storage[right] else right
                else:
                    swapIdx = left
                
                if self.storage[currIdx] >= self.storage[swapIdx]:
                    break
                else:
                    self.swapElementsAt(currIdx, swapIdx)
                    currIdx = swapIdx
                    left = swapIdx * 2 
                    right = swapIdx * 2 + 1
    
    def displayHeap(self):
        if self.heapSize == 0:
            print("Heap is Empty!")
            return
        print(self.storage[1:self.heapSize + 1])

    def cleanseHeap(self):
        self.heapSize = 0
        self.storage = [None]

    def insert(self, val):
        self.storage.append(val)
        self.heapSize += 1
        currIdx = self.heapSize
        parentIdx = currIdx // 2
        while parentIdx > 0 and self.storage[currIdx] > self.storage[parentIdx]:
            self.swapElementsAt(currIdx, parentIdx)
            currIdx = parentIdx
            parentIdx = currIdx // 2
    
    def delete(self):
        if self.heapSize == 0:
            print("Heap is empty!")
            return -1
        
        deletedEle = self.storage[1]
        placeHolderEle = self.storage[self.heapSize]
        self.heapSize -= 1
        self.storage[1] = placeHolderEle
        
        currIdx = 1
        self.siftDown(currIdx)
        return deletedEle

    def getMin(self):
        if self.heapSize == 0:
            print("Heap is Empty")
            return -1
        
        else:
            return self.storage[1]
    
    def heapSort(self, elements, reverse = False):
        
        if not elements:
            return elements
        
        for ele in elements:
            self.insert(ele)

        while self.heapSize > 0:
            deletedEle = self.delete()
            elements[self.heapSize] = deletedEle
        
        if reverse:
            elements.reverse()

        self.cleanseHeap()

    def heapify(self, elements):
        self.cleanseHeap()
        n = len(elements)
        self.heapSize = n - 1
        currIdx = n - 1
        self.storage = elements
        while currIdx > -1:
            self.siftDown(currIdx)
            
            currIdx -= 1


heap = Heap()
heap.insert(10)
heap.insert(23)
heap.insert(3)
heap.insert(13)
heap.insert(31)
heap.insert(123)

print("Constructed Heap")
heap.displayHeap()

print("Deleted Element", heap.delete())
print("Deleted Element", heap.delete())
print("Deleted Element", heap.delete())
heap.cleanseHeap()
print("-" * 50)

elements = [10,2,11,32,34,11,2,5,3]
print("Input List: ", elements)
heap.heapSort(elements)
print("Sorted Output List: ", elements)
print("-" * 50)

elements = [10,2,11,32,34,11,2,5,3]
print("Input List: ", elements)
heap.heapSort(elements, reverse=True)
print("Reverse Sorted List: ", elements)
print("-" * 50)


print("-"*50)
print("Heapify Test")
newHeap = Heap()
elements = [10,2,11,32,34,11,2,5,3]
newHeap.heapify(elements)
newHeap.displayHeap()
print(newHeap.delete())
print(newHeap.delete())
print(newHeap.delete())
print(newHeap.delete())