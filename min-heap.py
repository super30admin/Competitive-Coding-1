# The code defines a MinHeap class that implements a binary min-heap using a list.
# A min-heap is a complete binary tree where the value of each node is less than or equal to the values of its children. This property ensures that the root of the heap is always the minimum element.
# The MinHeap class includes methods to get the minimum element, insert a new key, extract the minimum, and internal methods to maintain the heap property (_bubbleUp and _heapify).

# Method Descriptions:
# - __init__(): Initializes an empty heap.
# - getMin(): Returns the root element of the heap which is the minimum, without removing it. Returns None if the heap is empty.
# - insert(key): Adds a new element to the heap. The element is initially placed at the end, and the _bubbleUp method is called to move it to the correct position in the heap based on its value.
# - _bubbleUp(index): Moves the element at the specified index up the tree until the heap property is restored. This is done by comparing and potentially swapping the element with its parent.
# - extractMin(): Removes and returns the minimum element of the heap. It places the last element of the heap at the root and then calls _heapify to adjust the new root and restore the heap property.
# - _heapify(index): Adjusts the heap starting from the index downwards to maintain the heap property. It compares the node with its children and swaps it with the smaller child if necessary.

# Time Complexity (TC):
# - getMin: O(1), as it simply accesses the root element.
# - insert: O(log n), as the element may need to be moved up from the bottom of the heap to the root in the worst case, which involves traversing up the height of the tree.
# - extractMin: O(log n), as it requires removing the root and then performing heapify from the root down to a leaf, which is height-bound.

# Space Complexity (SC):
# - All operations: O(n), where n is the number of elements in the heap. This is the space required to hold all elements in the heap.

class MinHeap:
    def __init__(self):
        self.heap = []

    def getMin(self):
        return self.heap[0] if self.heap else None

    def insert(self, key):
        self.heap.append(key)
        self._bubbleUp(len(self.heap) - 1)

    def _bubbleUp(self, index):
        parent = (index - 1) // 2
        while index > 0 and self.heap[index] < self.heap[parent]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = (index - 1) // 2

    def extractMin(self):
        if not self.heap:
            return None
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify(0)
        return root

    def _heapify(self, index):
        smallest = index
        left = 2 * index + 1
        right = 2 * index + 2
        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right
        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify(smallest)
