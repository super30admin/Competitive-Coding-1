#Time Complexity:
   #insert: O(N)
   #extract_min: O(N)
   #peek: O(1)
   #size: O(1)
#Space Complexity: O(N)


class MinHeap:
    def __init__(self):
        self.heap = []

    def insert(self, val):
        self.heap.append(val)
        self.heapify_up(len(self.heap) - 1)

    def extract_min(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()
        
        # Swap root with last element
        self.swap(0, len(self.heap) - 1)
        min_val = self.heap.pop()
        self.heapify_down(0)
        return min_val

    def peek(self):
        return self.heap[0] if self.heap else None

    def size(self):
        return len(self.heap)

    def heapify_up(self, index):
        parent = (index - 1) // 2
        while index > 0 and self.heap[index] < self.heap[parent]:
            self.swap(index, parent)
            index = parent
            parent = (index - 1) // 2

    def heapify_down(self, index):
        smallest = index
        left = 2 * index + 1
        right = 2 * index + 2
        size = len(self.heap)

        if left < size and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < size and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index:
            self.swap(index, smallest)
            self.heapify_down(smallest)

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

  
data = MinHeap()
data.insert(1)
data.insert(5)
data.insert(0)
data.extract_min()
