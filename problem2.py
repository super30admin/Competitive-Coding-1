class MinHeap:
    def __init__(self):
        self.heap = []

    def getMin(self):
        if len(self.heap) == 0:
            return "This heap is Empty"
        return self.heap[0]

    def extractMin(self):
        if len(self.heap) == 0:
            return "This heap is Empty"
        if len(self.heap) == 1:
            return self.heap.pop()
        min_val = self.heap.pop(0)
        self.heapify()
        return min_val

    def insert(self, num):
        self.heap.append(num)
        self.heapify()

    def heapify(self):
        if len(self.heap) == 0:
            return "This heap is Empty"
        self.heap.sort()

# Driver code
heap = MinHeap()

# Inserting values
heap.insert(10)
heap.insert(20)
heap.insert(5)
heap.insert(17)
heap.insert(3)

# Display current heap
print("Heap after inserts:", heap.heap)

# Get minimum element
print("Minimum element:", heap.getMin())

# Extract minimum element
print("Extracted minimum:", heap.extractMin())

# Heap after extraction
print("Heap after extracting minimum:", heap.heap)

# Extract again
print("Extracted minimum again:", heap.extractMin())
print("Heap after second extraction:", heap.heap)
