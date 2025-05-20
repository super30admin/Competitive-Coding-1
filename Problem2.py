"""
TC -> O(log n) for push and pop, O(1) for other operations
SC -> O(n)
"""
class MinHeap:
    def __init__(self):
        self.heap = []

    def _parent(self, index):
        return (index - 1) // 2

    def _left_child(self, index):
        return 2 * index + 1

    def _right_child(self, index):
        return 2 * index + 2

    def _heapify_up(self, index):
        while index > 0 and self.heap[index] < self.heap[self._parent(index)]:
            # Swap with parent
            self.heap[index], self.heap[self._parent(index)] = self.heap[self._parent(index)], self.heap[index]
            index = self._parent(index)

    def _heapify_down(self, index):
        smallest = index
        left = self._left_child(index)
        right = self._right_child(index)

        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify_down(smallest)

    def push(self, value):
        self.heap.append(value)
        self._heapify_up(len(self.heap) - 1)

    def pop(self):
        if self.is_empty():
            return None
        if len(self.heap) == 1:
            return self.heap.pop()
        # Move last element to root and heapify down
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down(0)
        return root

    def peek(self):
        return self.heap[0] if not self.is_empty() else None

    def is_empty(self):
        return len(self.heap) == 0

    def size(self):
        return len(self.heap)


if __name__ == "__main__":
    h = MinHeap()
    h.push(10)
    h.push(4)
    h.push(15)
    h.push(1)

    print("Min element:", h.peek())

    while not h.is_empty():
        print(h.pop(), end=" ")