
# Approach:
# A Min-Heap ensures the smallest element is at the root. We represent it as a complete binary tree using an array, 
# where for any index `i`, the parent is at `(i - 1) // 2`, the left child at `2 * i + 1`, and the right child at `2 * i + 2`.
# The `insert` operation adds elements and bubbles them up to maintain the heap property, while `extractMin` removes the root and restores order using `heapify`.

# Time Complexity:
# - `getMin`: O(1)
# - `insert`: O(log n)
# - `extractMin`: O(log n)

# Space Complexity: O(n) to store the elements in the heap.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class MinHeap:
    def __init__(self):
        # Initialize an empty list to store heap elements
        self.heap = []

    def getMin(self):
        # Return the root element (minimum) of the heap
        return self.heap[0] if self.heap else None

    def insert(self, key):
        # Add the new key at the end of the heap
        self.heap.append(key)
        # Move the new key up to maintain the min-heap property
        self._bubbleUp(len(self.heap) - 1)

    def _bubbleUp(self, index):
        # Move the element at index up until the heap property is satisfied
        parent = (index - 1) // 2
        while index > 0 and self.heap[index] < self.heap[parent]:
            # Swap the element with its parent
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = (index - 1) // 2

    def extractMin(self):
        if not self.heap:
            return None
        # Replace the root with the last element
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        # Restore the heap property by heapifying the root
        self._heapify(0)
        return root

    def _heapify(self, index):
        # Heapify the element at index down the tree
        smallest = index
        left = 2 * index + 1
        right = 2 * index + 2

        # Check if the left child is smaller
        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left

        # Check if the right child is smaller
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        # If the smallest is not the current element, swap and continue heapifying
        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify(smallest)

# Example usage
minHeap = MinHeap()
minHeap.insert(3)
minHeap.insert(2)
minHeap.insert(15)
print(minHeap.getMin())  # Output: 2
print(minHeap.extractMin())  # Output: 2
print(minHeap.getMin())  # Output: 3
minHeap.insert(5)
minHeap.insert(4)
print(minHeap.getMin())  # Output: 3
