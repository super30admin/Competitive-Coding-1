class minHeap:
    def __init__(self):
        self.heap = []
        self.size = 0
    def insert(self, data: int) -> None:
        self.heap.append(data)
        self.size += 1
        i = len(self.heap) - 1
        while (i //2 >= 0):
            if self.heap[i] < self.heap[i//2]:
                self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            else:
                break
            i = i // 2
    def removemin(self) -> int:
        if not self.heap:
            return
        i = 0
        while(i*2 < len(self.heap)-1):
            self.heap[i], self.heap[2*i + 1] = self.heap[2*i + 1], self.heap[i]
            i = 2*i + 1
        return self.heap.pop()
    def getmin(self) -> int:
        if not self.heap:
            return 
        return self.heap[0]


Heap = minHeap()

Heap.insert(3)
Heap.insert(2)
Heap.insert(1)

print(Heap.getmin())

print(Heap.removemin())

print(Heap.removemin())          
        