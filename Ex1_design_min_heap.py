# Time Complexity : 
#   insert(): O(log n), where n is the number of elements in the heap
#   extractMin(): O(log n)
#   getMin(): O(1)
# Space Complexity : O(n), for storing n elements in the heap
# Did this code successfully run on Leetcode : Not applicable (custom DS)
# Any problem you faced while coding this : No

class MinHeap:
    def __init__(self):
        # Initialize an empty list to store heap elements
        self.heap = []

    def insert(self, val):
        # Add the new value to the end of the heap
        self.heap.append(val)
        # Restore the min-heap property by moving the new value up to its correct position
        self._heapify_up(len(self.heap) - 1)

    def getMin(self):
        # Return the minimum element, which is at the root (index 0)
        # Return None if heap is empty
        return self.heap[0] if self.heap else None

    def extractMin(self):
        # Remove and return the minimum element (root of the heap)
        if len(self.heap) == 0:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        root = self.heap[0]
        # Move the last element to the root position and remove the last element
        self.heap[0] = self.heap.pop()
        # Restore the min-heap property by moving the new root down to its correct position
        self._heapify_down(0)
        return root

    def _heapify_up(self, i):
        # Move the element at index i up until min-heap property is restored
        parent = (i - 1) // 2
        # If current element is smaller than its parent, swap and recurse up
        if i > 0 and self.heap[i] < self.heap[parent]:
            self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]
            self._heapify_up(parent)

    def _heapify_down(self, i):
        # Move the element at index i down until min-heap property is restored
        smallest = i
        left = 2 * i + 1      # Left child index
        right = 2 * i + 2     # Right child index

        # Check if left child exists and is smaller than current smallest
        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left
        # Check if right child exists and is smaller than current smallest
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        # If smallest is not the current node, swap and recurse down
        if smallest != i:
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self._heapify_down(smallest)


# --------------------------------------------------------------------------------------

if __name__ == "__main__":
    min_heap = MinHeap()

    min_heap.insert(10)
    min_heap.insert(5)
    min_heap.insert(8)
    min_heap.insert(1)
    min_heap.insert(6)
    min_heap.insert(20)

    print(min_heap.getMin())    # Output: 1
    print(min_heap.extractMin()) # Output: 1
    print(min_heap.getMin())    # Output: 5
    print(min_heap.extractMin()) # Output: 5
    print(min_heap.getMin())    # Output: 6
