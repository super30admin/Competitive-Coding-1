#Heapified with functions dicussed in the video and it takes O(logn) since we are traversing up the binary tree
#For add function recursively used heapify up to heapify the appended element

class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, index):
        return (index - 1) // 2 if index > 0 else None

    def left_child(self, index):
        return 2 * index + 1 if 2 * index + 1 < len(self.heap) else None

    def right_child(self, index):
        return 2 * index + 2 if 2 * index + 2 < len(self.heap) else None

    def size(self):
        return len(self.heap)

    def print_heap(self):
        print(self.heap)

    def peek(self):
        return self.heap[0] if self.heap else None

    def heapify_down(self, index):
        smallest = index
        left = self.left_child(index)
        right = self.right_child(index)

        if left is not None and self.heap[left] < self.heap[smallest]:
            smallest = left

        if right is not None and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self.heapify_down(smallest)

    def heapify_up(self, index):
        while index > 0 and self.heap[index] < self.heap[self.parent(index)]:
            parent_index = self.parent(index)
            self.heap[index], self.heap[parent_index] = self.heap[parent_index], self.heap[index]
            index = parent_index

    def add(self, element):
        self.heap.append(element)
        self.heapify_up(len(self.heap) - 1)

    def remove(self):
        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self.heapify_down(0)
        return root

    def build_heap(self, tree):
        self.heap = tree[:]
        for i in range(len(self.heap) // 2 - 1, -1, -1):
            self.heapify_down(i)
