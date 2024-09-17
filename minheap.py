# Time Complexity : getMin is O(1), insert and remove are O(LogN) as worst case operations is along the height of the tree which is logN
# Space Complexity : O(N), for N elements inserted in heap 

class MinHeap:

    def __init__(self):
        self.heap = []

    def getMin(self):
        return self.heap[0]

    def insert(self, key):
        self.heap.append(key)
        self._bubbleUp(len(self.heap)-1)

    def _bubbleUp(self, idx):
        parentIdx = (idx-1)//2

        if parentIdx < 0:
            return

        if self.heap[parentIdx] < self.heap[idx]:
            return

        self.heap[parentIdx], self.heap[idx] = self.heap[idx], self.heap[parentIdx]
        self._bubbleUp(parentIdx)
        

    def extractMin(self):
        #Swap first and last and then pop last to get O(1) removal time
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        temp  = self.heap.pop()
        self._bubbleDown(0)
        return temp

    def _bubbleDown(self,idx):
        left, right = 2*idx + 1, 2*idx + 2
        temp = idx

        if left < len(self.heap) and self.heap[temp] > self.heap[left]:
            temp = left
        if right < len(self.heap) and self.heap[temp] > self.heap[right]:
            temp = right

        if temp == idx:
            return 

        self.heap[idx], self.heap[temp] = self.heap[temp], self.heap[idx]
        self._bubbleDown(temp)

h = MinHeap()
h.insert(5);
h.insert(3);
h.insert(17);
h.insert(10);
h.insert(84);
h.insert(19);
h.insert(6);
h.insert(22);
h.insert(9);
print(h.heap)
print(h.getMin())
for i in range(len(h.heap)):
    print(h.extractMin())