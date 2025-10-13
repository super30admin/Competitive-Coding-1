class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, i):
        return (i - 1) // 2

    def left_child(self, i):
        return 2 * i + 1

    def right_child(self, i):
        return 2 * i + 2

    def insert(self, value):
        """Insert a new value into the heap."""
        self.heap.append(value)
        self._heapify_up(len(self.heap) - 1)

    def extract_min(self):
        """Remove and return the smallest element."""
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        root = self.heap[0]
        # Move last element to root and heapify down
        self.heap[0] = self.heap.pop()
        self._heapify_down(0)
        return root

    def get_min(self):
        """Return the smallest element without removing it."""
        return self.heap[0] if self.heap else None

    def _heapify_up(self, i):
        """Maintain heap property after insertion."""
        while i > 0 and self.heap[i] < self.heap[self.parent(i)]:
            self.heap[i], self.heap[self.parent(i)] = self.heap[self.parent(i)], self.heap[i]
            i = self.parent(i)

    def _heapify_down(self, i):
        """Maintain heap property after deletion."""
        smallest = i
        left = self.left_child(i)
        right = self.right_child(i)

        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != i:
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self._heapify_down(smallest)

    def __len__(self):
        return len(self.heap)

    def __str__(self):
        return str(self.heap)