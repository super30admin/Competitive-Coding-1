'''
This implementation supports inserting elements, extracting the minimum element, 
and maintaining the heap structure using heapify operations. 
The insert operation ensures that the smallest element stays at the root, and extraction removes the 
smallest element while reordering the heap to maintain its properties.

Insertion: O(log n) -> heapify_up
Extact min: O(log n) -> heapify_down
Getting min: O(1)
'''
class MinHeap:
    def __init__(self):
        self.heap = []

    def get_min(self):
        """Returns the minimum element (root of the heap)"""
        return self.heap[0] if self.heap else None

    def insert(self, value):
        """Inserts a new value into the heap"""
        self.heap.append(value)
        self._heapify_up(len(self.heap) - 1)

    def extract_min(self):
        """Removes and returns the minimum element from the heap"""
        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        min_value = self.heap[0]
        self.heap[0] = self.heap.pop()  # Move last element to root
        self._heapify_down(0)
        return min_value

    def _heapify_up(self, index):
        """Moves the element at index up to maintain the heap property"""
        parent = (index - 1) // 2
        while index > 0 and self.heap[index] < self.heap[parent]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = (index - 1) // 2

    def _heapify_down(self, index):
        """Moves the element at index down to maintain the heap property"""
        size = len(self.heap)
        smallest = index

        left_child = 2 * index + 1
        right_child = 2 * index + 2

        if left_child < size and self.heap[left_child] < self.heap[smallest]:
            smallest = left_child
        if right_child < size and self.heap[right_child] < self.heap[smallest]:
            smallest = right_child

        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify_down(smallest)

    def display(self):
        """Displays the heap as an array"""
        print(self.heap)


# Example Usage
heap = MinHeap()
heap.insert(10)
heap.insert(5)
heap.insert(15)
heap.insert(1)
heap.insert(7)

print("Min Heap:", heap.heap)
print("Extract Min:", heap.extract_min())
print("Min Heap after extraction:", heap.heap)
