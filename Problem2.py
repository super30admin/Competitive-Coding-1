# MinHeap Implementation


# Time Complexity : insert(),getMin(),extractMin:: O(log n) where n is the size of the array

class MinHeap:
    def __init__(self):
        self.heap = []

    def insert(self, value):
        self.heap.append(value)
        self.__percolateUp(len(self.heap)-1)

    def getMin(self):
        if self.heap:
            return self.heap[0]
        return None

    def extractMin(self):
        if len(self.heap) > 1:
            min = self.heap[0]
            self.heap[0] = self.heap[-1]
            del self.heap[-1]
            self.__minHeapify(0)
            return min
        elif len(self.heap) == 1:
            min = self.heap[0]
            del self.heap[0]
            return min
        else:
            return None

    def __percolateUp(self, index):
        parent = (index-1)//2
        if index <= 0:
            return

        if self.heap[index] < self.heap[parent]:
            temp = self.heap[parent]
            self.heap[parent] = self.heap[index]
            self.heap[index] = temp
            self.__percolateUp(parent)

    def __minHeapify(self, index):
        smallest = index
        left = (2*index)+1
        right = (2*index)+2

        if len(self.heap) > left and self.heap[smallest] > self.heap[left]:
            smallest = left
        if len(self.heap) > right and self.heap[smallest] > self.heap[right]:
            smallest = right
        if smallest != index:
            temp = self.heap[smallest]
            self.heap[smallest] = self.heap[index]
            self.heap[index] = temp
            self.__minHeapify(smallest)


heap = MinHeap()
heap.insert(12)
heap.insert(10)
heap.insert(-10)
heap.insert(100)

print(heap.getMin())
print(heap.extractMin())
print(heap.getMin())
heap.insert(-100)
print(heap.getMin())
