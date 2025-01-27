# tc O(log n), for insert, extract_min, heapify_up, heapify_down, O(1) for get_min, size, is_empty,
# sc O(n).
class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, idx):
        return (idx-1) // 2

    def left_child(self, idx):
        return 2 * idx + 1

    def right_child(self, idx):
        return 2 * idx + 2

    def insert(self, item):
        self.heap.append(item)
        self._heapify_up(len(self.heap)-1)

    def extract_min(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()
        self.heap[0] = self.heap.pop()
        self._heapify_down(0)

    def _heapify_up(self, idx):
        while idx > 0 and self.heap[idx] < self.heap[self.parent(idx)]:
            self.heap[idx], self.heap[self.parent(idx)] = self.heap[self.parent(idx)], self.heap[idx]
            idx = self.parent(idx)

    def _heapify_down(self,index):
        smallest = index
        left = self.left_child(index)
        right = self.right_child(index)

        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
                smallest = left
            if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
                smallest = right

            if smallest != index:
                self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
                self._heapify_down(smallest)

    def get_min(self):
        return self.heap[0] if self.heap else None

    def size(self):
        return len(self.heap)

    def is_empty(self):
        return not self.heap