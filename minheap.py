"""
Time complexity: O(1)for get_min, O(logn) for insert and remove
Space complexity: O(n) to store all elements, constant space noto get_min, insertm remove
"""
class MinHeap:
    def __init__(self):
        self.heap = []
        self.count = 0

    def get_min(self):
        return self.heap[0] if self.heap else None

    def insert(self, value):
        self.heap.append(value)
        self.count+=1
        self._heapify_up(len(self.heap) - 1)

    def remove(self):
        if not self.heap:
            return None
        self.heap[0] = self.heap.pop()
        self.count-=1
        self._heapify_down(0)
        

    def _heapify_up(self, index):
        parent = (index - 1) // 2
        if index > 0 and self.heap[index] < self.heap[parent]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            self._heapify_up(parent)

    def _heapify_down(self, index):
        smallest = index
        left = 2 * index + 1
        right = 2 * index + 2

        if left < self.count and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < self.count and self.heap[right] < self.heap[smallest]:
            smallest = right
        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify_down(smallest)


mh = MinHeap()
mh.insert(10)
mh.insert(101)
mh.insert(104)
mh.insert(106)
mh.insert(110)
print(mh.get_min())
mh.remove()
print(mh.get_min())
mh.insert(34)
print(mh.get_min())