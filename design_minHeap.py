class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, index):
        return (index - 1) // 2

    def left_child(self, index):
        return 2 * index + 1

    def right_child(self, index):
        return 2 * index + 2

    def has_left_child(self, index):
        return self.left_child(index) < len(self.heap)

    def has_right_child(self, index):
        return self.right_child(index) < len(self.heap)

    def has_parent(self, index):
        return self.parent(index) >= 0

    def swap(self, index1, index2):
        self.heap[index1], self.heap[index2] = self.heap[index2], self.heap[index1]

    def peek(self):
        if not self.heap:
            raise IndexError("Heap is empty")
        return self.heap[0]

    def poll(self):
        if not self.heap:
            raise IndexError("Heap is empty")
        item = self.heap[0]
        self.heap[0] = self.heap[-1]
        self.heap.pop()
        self.heapify_down(0)
        return item

    def add(self, item):
        self.heap.append(item)
        self.heapify_up(len(self.heap) - 1)

    def heapify_up(self, index):
        while self.has_parent(index) and self.heap[self.parent(index)] > self.heap[index]:
            self.swap(self.parent(index), index)
            index = self.parent(index)

    def heapify_down(self, index):
        while self.has_left_child(index):
            smaller_child_index = self.left_child(index)
            if self.has_right_child(index) and self.heap[self.right_child(index)] < self.heap[smaller_child_index]:
                smaller_child_index = self.right_child(index)

            if self.heap[index] <= self.heap[smaller_child_index]:
                break

            self.swap(index, smaller_child_index)
            index = smaller_child_index

# Example usage:
min_heap = MinHeap()
min_heap.add(10)
min_heap.add(15)
min_heap.add(20)
min_heap.add(17)

print(min_heap.peek())  # Output: 10
print(min_heap.poll())  # Output: 10
print(min_heap.peek())  # Output: 15