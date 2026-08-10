# https://www.geeksforgeeks.org/dsa/introduction-to-min-heap-data-structure/

class MinHeap:
    def __init__(self):
        self.heap = []

    # O(1)
    def getMin(self):
        if not self.heap:
            return None
        return self.heap[0]

    # O(log n)
    def insert(self, value):
        # 1. Add to end
        self.heap.append(value)

        # 2. Bubble up
        i = len(self.heap) - 1

        while i > 0:
            parent = (i - 1) // 2

            if self.heap[parent] <= self.heap[i]:
                break

            self.heap[parent], self.heap[i] = self.heap[i], self.heap[parent]
            i = parent

    # O(log n)
    def extractMin(self):
        if not self.heap:
            return None

        # Only one element
        if len(self.heap) == 1:
            return self.heap.pop()

        minimum = self.heap[0]

        # Move last element to root
        self.heap[0] = self.heap.pop()

        # Bubble down
        i = 0

        while True:
            left = 2 * i + 1
            right = 2 * i + 2
            smallest = i

            if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
                smallest = left

            if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
                smallest = right

            # Heap property satisfied
            if smallest == i:
                break

            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            i = smallest

        return minimum
