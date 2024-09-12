# TC: insert - O(log(n)), remove - O(log(n)), getMin - O(1); SC: O(1)
class MinHeap:
    def __init__(self):
        self.heap = []

    def bubbleUp(self, idx):
        if idx == 0:
            return
        if self.heap[(idx-1)//2] > self.heap[idx]:
            self.heap[(idx-1)//2], self.heap[idx] = self.heap[idx], self.heap[(idx-1)//2]
            self.bubbleUp((idx-1)//2)

    def bubbleDown(self, idx):
        left = (2*idx) + 1
        right = (2*idx) + 2
        temp = idx
        if left < len(self.heap) and self.heap[temp] > self.heap[left]:
            temp = left
        if right < len(self.heap) and self.heap[temp] > self.heap[right]:
            temp = right
        if temp == idx:
            return
        self.heap[idx], self.heap[temp] = self.heap[temp], self.heap[idx]
        self.bubbleDown(temp)

    def getMin(self):
        return self.heap[0]

    def insert(self, value):
        self.heap.append(value)
        self.bubbleUp(len(self.heap)-1)

    def remove(self):
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        remove = self.heap.pop()
        self.bubbleDown(0)
        return remove


heap = MinHeap()
heap.insert(15)
heap.insert(28)
heap.insert(16)
heap.insert(32)
heap.insert(31)
heap.insert(20)
print(heap.heap)
for i in range(6):
    print(heap.remove())
    print(heap.heap)
