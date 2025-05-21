# Approach: We use a list to represent the binary heap, maintaining the min-heap property where each parent node is less than its children.
# Insertion adds the new element at the end and percolates it up to restore the heap property.
# Extracting the minimum swaps the root with the last element, removes it, and heapifies down from the root to maintain the min-heap.

# Time Complexity : O(log n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Could not find the problem on Leetcode
# Any problem you faced while coding this : No

class MinHeap:
    def __init__(self):
        self.heap = []
    def parent(self, i):
        return (i - 1) // 2

    def left(self, i):
        return 2 * i + 1

    def right(self, i):
        return 2 * i + 2

    def insert(self, key):
        self.heap.append(key)
        i = len(self.heap) - 1
        while i != 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.heap[i], self.heap[self.parent(i)] = self.heap[self.parent(i)], self.heap[i]
            i = self.parent(i)

    def heapify(self, i):
        l = self.left(i)
        r = self.right(i)
        smallest = i
        if l < len(self.heap) and self.heap[l] < self.heap[smallest]:
            smallest = l
        if r < len(self.heap) and self.heap[r] < self.heap[smallest]:
            smallest = r
        if smallest != i:
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self.heapify(smallest)

    def extract_min(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self.heapify(0)
        return root

    def get_min(self):
        if not self.heap:
            return None
        return self.heap[0]

    def __str__(self):
        return str(self.heap)

# Example usage:
if __name__ == "__main__":
    h = MinHeap()
    h.insert(3)
    h.insert(2)
    h.insert(15)
    h.insert(5)
    h.insert(4)
    h.insert(45)
    print("Heap array:", h)
    print("Extracted min:", h.extract_min())
    print("Heap array after extract_min:", h)
    print("Current min:", h.get_min())
