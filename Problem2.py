# Time Complexity :
# - Insert: O(log n) because we bubble up at most the height of the heap
# - Extract Min: O(log n) because we bubble down at most the height of the heap
# - Get Min: O(1) because root is always min
# Space Complexity : O(n) for storing heap elements
# Did this code successfully run on Leetcode : (Custom structure, but logic matches Leetcode heaps)
# Approach:
# 1. Represent the heap as an array where parent/child relations are derived from indices.
# 2. Insert by appending to the end and bubbling up until parent is smaller.
# 3. Extract min by swapping root with last element, removing it, then bubbling down.

class MinHeap:
    def __init__(self):
        self.heap = []   # underlying array to store heap
    
    # Get parent index
    def parent(self, i): 
        return (i - 1) // 2
    
    # Get left child index
    def left(self, i): 
        return 2 * i + 1
    
    # Get right child index
    def right(self, i): 
        return 2 * i + 2
    
    # Insert a new key
    def insert(self, key):
        self.heap.append(key)       # Step 1: add at the end
        i = len(self.heap) - 1
        # Step 2: bubble up while parent is bigger
        while i > 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.heap[i], self.heap[self.parent(i)] = self.heap[self.parent(i)], self.heap[i]
            i = self.parent(i)
    
    # Heapify (bubble down) from index i
    def heapify(self, i):
        l = self.left(i)
        r = self.right(i)
        smallest = i
        
        # Compare with left child
        if l < len(self.heap) and self.heap[l] < self.heap[smallest]:
            smallest = l
        # Compare with right child
        if r < len(self.heap) and self.heap[r] < self.heap[smallest]:
            smallest = r
        
        # If child is smaller, swap and continue
        if smallest != i:
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            self.heapify(smallest)
    
    # Extract the minimum element (root)
    def extractMin(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()
        
        # Step 1: Swap root with last element
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        # Step 2: Heapify down from root
        self.heapify(0)
        return root
    
    # Get the minimum element without removing
    def getMin(self):
        return self.heap[0] if self.heap else None
