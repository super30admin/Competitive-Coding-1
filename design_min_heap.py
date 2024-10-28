class MinHeap:
    def __init__(self):

        self.heap = []

    def getMin(self):

        if not self.heap:
            return None  # If heap is empty
        return self.heap[0]

    def extractMin(self):

        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        # Swap the root with the last element and remove the last element
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self.minHeapify(0)  # Restore the heap property
        return root

    def insert(self, key):
        """
        Inserts a new key into the heap.
        Time Complexity: O(log N)
        """
        self.heap.append(key)  # Add the new key at the end
        index = len(self.heap) - 1
        self.bubbleUp(index)  # Move up to maintain heap property

    def minHeapify(self, i):
        """
        Helper function to maintain the heap property.
        Time Complexity: O(log N)
        """
        smallest = i
        left = 2 * i + 1
        right = 2 * i + 2

        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != i:
            # Swap and continue heapifying
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self._minHeapify(smallest)

    def bubbleUp(self, index):
        parent = (index - 1) // 2
        while index > 0 and self.heap[parent] > self.heap[index]:
            # Swap with parent and update index
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = (index - 1) // 2
