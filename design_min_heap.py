# Time Complexity:
#     - Insertion: O(log n) - may need to bubble up through the height of the tree
#     - Removal: O(log n) - requires heapify operation with height of the tree
#     - Get Min: O(1) - the minimum is always at the root
#     - Heapify: O(log n) - may need to traverse down the height of the tree
#     - Build Heap: O(n) - when building from an array
    
# Space Complexity:
#     - Overall: O(n) - where n is the number of elements in the heap

# Didn't have this in mock interview

class MinHeap:
    
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        # Using 1-based indexing for simplicity, so index 0 is filled with minimum value
        self.Heap = [float('-inf')] * (self.maxsize + 1)
        self.FRONT = 1  # The root element index
    
    def parent(self, pos):
        return pos // 2
    
    def left_child(self, pos):
        return 2 * pos
    
    def right_child(self, pos):
        return (2 * pos) + 1
    
    def is_leaf(self, pos):
        return pos > (self.size // 2)
    
    def swap(self, fpos, spos):
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]
    
    def min_heapify(self, pos):
        if not self.is_leaf(pos):
            swap_pos = pos
            
            # Determine which child to potentially swap with
            if self.right_child(pos) <= self.size:
                # Both children exist, find the smaller one
                if self.Heap[self.left_child(pos)] < self.Heap[self.right_child(pos)]:
                    swap_pos = self.left_child(pos)
                else:
                    swap_pos = self.right_child(pos)
            else:
                # Only left child exists
                swap_pos = self.left_child(pos)
            
            # Check if swap is needed
            if (self.Heap[pos] > self.Heap[self.left_child(pos)] or 
                (self.right_child(pos) <= self.size and self.Heap[pos] > self.Heap[self.right_child(pos)])):
                self.swap(pos, swap_pos)
                self.min_heapify(swap_pos)
    
    def insert(self, element):
        if self.size >= self.maxsize:
            return
        
        self.size += 1
        self.Heap[self.size] = element
        
        current = self.size
        
        # Bubble up the element if needed
        while self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)
    
    def print_heap(self):
        for i in range(1, (self.size // 2) + 1):
            print(f" PARENT: {self.Heap[i]} LEFT CHILD: {self.Heap[2 * i]} RIGHT CHILD: {self.Heap[2 * i + 1]}")
    
    def remove(self):
        popped = self.Heap[self.FRONT]
        self.Heap[self.FRONT] = self.Heap[self.size]
        self.size -= 1
        self.min_heapify(self.FRONT)
        return popped


# Main function to demonstrate the Min Heap
if __name__ == "__main__":
    print("The Min Heap is ")
    
    # Create a Min Heap with maximum size 15
    min_heap = MinHeap(15)
    
    # Insert elements
    min_heap.insert(43)
    min_heap.insert(25)
    min_heap.insert(36)
    min_heap.insert(11)
    min_heap.insert(16)
    min_heap.insert(15)
    min_heap.insert(64)
    min_heap.insert(80)
    min_heap.insert(66)
    
    # Print the heap
    min_heap.print_heap()
    
    # Remove and print the minimum value
    print("The Min val is", min_heap.remove())