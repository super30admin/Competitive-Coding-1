class MinHeap:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.heap = [0] * capacity

    def left_child_index(self, parent_index):
        return 2 * parent_index + 1

    def right_child_index(self, parent_index):
        return 2 * parent_index + 2

    def peek(self):
        if self.size == 0:
            return -1  # The heap is currently empty
        return self.heap[0]

    def print_heap(self):
        print(self.heap[:self.size])

    def add(self, value):
        if self.size == self.capacity:
            return -1  # The heap is at full capacity

        self.heap[self.size] = value
        self.size += 1
        self.heapify_up()

    def remove(self):
        if self.size == 0:
            return -1  # The heap is empty

        min_value = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.size -= 1
        self.heapify_down(0)

        return min_value

    def heapify_up(self):
        index = self.size - 1

        while index > 0 and self.heap[index] < self.heap[(index - 1) // 2]:
            self.heap[index], self.heap[(index - 1) // 2] = self.heap[(index - 1) // 2], self.heap[index]
            index = (index - 1) // 2

    def heapify_down(self, index):
        while self.left_child_index(index) < self.size:
            smaller_child_index = self.left_child_index(index)

            if self.right_child_index(index) < self.size and self.heap[self.right_child_index(index)] < self.heap[self.left_child_index(index)]:
                smaller_child_index = self.right_child_index(index)

            if self.heap[index] < self.heap[smaller_child_index]:
                break
            else:
                self.heap[index], self.heap[smaller_child_index] = self.heap[smaller_child_index], self.heap[index]

            index = smaller_child_index
