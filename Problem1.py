#Design min heap

class minHeap:
    def __init__(self) -> None:
        self.heap = []
#Time Complexity : O(logn)
#Space Complexity : O(1)
    def insert(self, value):
        self.heap.append(value)
        self._heapify_up()
#Time Complexity : O(logn)
#Space Complexity : O(1)
    def pop(self):
         if len(self.heap) == 0:
              return None
         if len(self.heap) == 1:
              return self.heap.pop()
         root = self.heap[0]
         self.heap[0] = self.heap.pop()
         self._heapify_down()
         return root
    def _heapify_up(self):
        index = len(self.heap)-1
        while index >0:
            parentIndex = (index-1)//2
            if self.heap[index] < self.heap[parentIndex]:
                 self.heap[index], self.heap[parentIndex] = self.heap[parentIndex], self.heap[index]
            else:
                 break

    def _heapify_down(self):
        index = 0
        while index < len(self.heap):
            leftChildIndex = 2*index +1
            rightChildIndex = 2*index +2
            smallIndex = index
            if leftChildIndex < len(self.heap) and self.heap[index] > self.heap[leftChildIndex]:
                smallIndex = leftChildIndex
            if rightChildIndex < len(self.heap) and self.heap[index] > self.heap[rightChildIndex]:
                smallIndex = rightChildIndex
            if smallIndex != index:
                self.heap[index], self.heap[smallIndex] = self.heap[smallIndex], self.heap[index]
                index = smallIndex
            else:
                break



heap = minHeap()
heap.insert(2)
heap.insert(3)
heap.insert(4)
print(heap.pop())  # Should print 2
heap.insert(1)
print(heap.pop())  # Should print 1