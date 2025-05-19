class MinHeap:
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0] * maxsize  

    def parent(self, i):
        return (i - 1) // 2

    def leftChild(self, i):
        return 2 * i + 1

    def rightChild(self, i):
        return 2 * i + 2

    def isLeaf(self, i):
        return i >= self.size // 2 and i < self.size

    def swap(self, i, j):
        self.Heap[i], self.Heap[j] = self.Heap[j], self.Heap[i]

    def insert(self, element):
        if self.size >= self.maxsize:
            return
        self.Heap[self.size] = element
        current = self.size
        self.size += 1

        while current > 0 and self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def minHeapify(self, i):
        left = self.leftChild(i)
        right = self.rightChild(i)
        smallest = i

        if left < self.size and self.Heap[left] < self.Heap[smallest]:
            smallest = left
        if right < self.size and self.Heap[right] < self.Heap[smallest]:
            smallest = right

        if smallest != i:
            self.swap(i, smallest)
            self.minHeapify(smallest)

    def remove(self):
        if self.size == 0:
            return None
        popped = self.Heap[0]
        self.Heap[0] = self.Heap[self.size - 1]
        self.size -= 1
        self.minHeapify(0)
        return popped

    def printHeap(self):
        for i in range(self.size // 2):
            left = self.leftChild(i)
            right = self.rightChild(i)
            left_val = self.Heap[left] if left < self.size else "None"
            right_val = self.Heap[right] if right < self.size else "None"
            print(f"PARENT: {self.Heap[i]}; LEFT CHILD: {left_val}; RIGHT CHILD: {right_val}")