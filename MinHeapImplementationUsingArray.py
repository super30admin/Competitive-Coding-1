class MinHeap:
    def __init__(self):
        # Initialize an empty list to store heap elements
        self.heap = []

    def get_parent_index(self, index):
        # Returns the index of the parent node
        return (index - 1) // 2

    def get_left_child_index(self, index):
        # Returns the index of the left child
        return 2 * index + 1

    def get_right_child_index(self, index):
        # Returns the index of the right child
        return 2 * index + 2

    def has_left_child(self, index):
        # Checks if left child exists
        return self.get_left_child_index(index) < len(self.heap)

    def has_right_child(self, index):
        # Checks if right child exists
        return self.get_right_child_index(index) < len(self.heap)

    def swap(self, i, j):
        # Swaps two elements in the heap
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def insert(self, value):
        # Adds a new value to the heap
        self.heap.append(value)
        self.heapify_up(len(self.heap) - 1)

    def heapify_up(self, index):
        # Moves the value at index up to maintain heap property
        while index > 0:
            parent_index = self.get_parent_index(index)
            if self.heap[index] < self.heap[parent_index]:
                self.swap(index, parent_index)
                index = parent_index
            else:
                break

    def extract_min(self):
        # Removes and returns the minimum value (root of the heap)
        if not self.heap:
            return None
        min_value = self.heap[0]
        # Replace root with the last element
        self.heap[0] = self.heap[-1]
        self.heap.pop()
        # Restore heap property
        self.heapify_down(0)
        return min_value

    def heapify_down(self, index):
        # Moves the value at index down to maintain heap property
        while self.has_left_child(index):
            # Find the smaller child
            smaller_child_index = self.get_left_child_index(index)
            if self.has_right_child(index) and self.heap[self.get_right_child_index(index)] < self.heap[smaller_child_index]:
                smaller_child_index = self.get_right_child_index(index)

            if self.heap[index] > self.heap[smaller_child_index]:
                self.swap(index, smaller_child_index)
                index = smaller_child_index
            else:
                break

    def peek(self):
        # Returns the minimum value without removing it
        if not self.heap:
            return None
        return self.heap[0]

    def size(self):
        # Returns the number of elements in the heap
        return len(self.heap)


if __name__ == "__main__":
    h = MinHeap()
    h.insert(10)
    h.insert(5)
    h.insert(20)
    h.insert(2)

    print("Min value:", h.peek())     # Should print 2
    print("Extract min:", h.extract_min())  # Should remove and print 2
    print("New min:", h.peek())       # Should print 5
