# Time Complexity :    Insert, Remove, Heapify_Insert, Heapify_Delete : O(log n)
# Space Complexity : O(n)


class MinHeap:
    def __init__(self):
        self.heap = []

    def isEmpty(self):
        if len(self.heap) == 0:
            return -1
        else:
            return 1

    def peek(self):

        if self.isEmpty() == -1:
            return "Heap is empty"

        return self.heap[0]

    def size(self):
        return len(self.heap)

    def parent(self, i):
        return (i - 1) // 2

    def left_child(self, i):
        return 2 * i + 1

    def right_child(self, i):
        return 2 * i + 2

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def insert(self, value):
        self.heap.append(value)
        self.heapify_insert(len(self.heap) - 1)

    def heapify_insert(self, i):
        while i > 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.swap(i, self.parent(i))
            i = self.parent(i)

    def heapify_delete(self, i):

        min_index = i
        left = self.left_child(i)
        right = self.right_child(i)

        if left < len(self.heap) and self.heap[left] < self.heap[min_index]:
            min_index = left

        if right < len(self.heap) and self.heap[right] < self.heap[min_index]:
            min_index = right

        if i != min_index:
            self.swap(i, min_index)
            self.heapify_delete(min_index)

    def remove(self):
        if len(self.heap) == 0:
            return None
        elif len(self.heap) == 1:
            return self.heap.pop()

        min_val = self.heap[0]
        self.heap[0] = self.heap.pop()
        self.heapify_delete(0)
        return min_val


min_heap = MinHeap()


data = [5, 3, 8, 2, 9, 1]
for value in data:
    min_heap.insert(value)

print("Heap after insertion:", min_heap.heap)
min_value = min_heap.remove()
print("Heap after deletion:", min_value)

# Test inserting more values
min_heap.insert(4)
min_heap.insert(0)
print("Heap after inserting more values:", min_heap.heap)

min_value = min_heap.remove()
print("Heap after deletion:", min_heap.heap)

print("Peak element :", min_heap.peek())
