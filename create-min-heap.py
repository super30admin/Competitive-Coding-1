class MinHeap:
    def __init__(self):
        self.data = []

    def _parent(self, i):
        return (i - 1) // 2

    def _left(self, i):
        return 2 * i + 1

    def _right(self, i):
        return 2 * i + 2

    def _heapify_up(self, i):
        while i > 0 and self.data[i] < self.data[self._parent(i)]:
            parent = self._parent(i)
            self.data[i], self.data[parent] = self.data[parent], self.data[i]
            i = parent

    def _heapify_down(self, i):
        smallest = i
        left = self._left(i)
        right = self._right(i)

        if left < len(self.data) and self.data[left] < self.data[smallest]:
            smallest = left
        if right < len(self.data) and self.data[right] < self.data[smallest]:
            smallest = right

        if smallest != i:
            self.data[i], self.data[smallest] = self.data[smallest], self.data[i]
            self._heapify_down(smallest)

    def push(self, val):
        self.data.append(val)
        self._heapify_up(len(self.data) - 1)

    def pop(self):
        if not self.data:
            raise IndexError("pop from empty heap")
        if len(self.data) == 1:
            return self.data.pop()

        root = self.data[0]
        self.data[0] = self.data.pop()
        self._heapify_down(0)
        return root

    def peek(self):
        if not self.data:
            raise IndexError("peek from empty heap")
        return self.data[0]

    def is_empty(self):
        return len(self.data) == 0

    def size(self):
        return len(self.data)
