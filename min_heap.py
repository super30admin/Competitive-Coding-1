class MyMinHeap:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.heap = [0] * capacity 

    def parent(self, i):
        return (i - 1) // 2
    
    def left_child(self, i):
        return 2 * i + 1
    
    def right_child(self, i):
        return 2 * i + 2
    
    def is_leaf(self, i):
        return i >= self.size // 2 and i < self.size
    
    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def heapify(self, i): 
        # Maintain the heap property by ensuring that the subtree rooted at index i is a min-heap
        if self.is_leaf(i):
            return
        left = self.left_child(i)
        right = self.right_child(i)
        smallest = i
        if left < self.size and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < self.size and self.heap[right] < self.heap[smallest]:
            smallest = right
        if smallest != i:
            self.swap(i, smallest)
            self.heapify(smallest)

    def insert(self, val):
        # Insert a new value into the heap
        if self.size >= self.capacity:
            raise Exception("Heap is full")

        self.heap[self.size] = val
        current = self.size
        self.size += 1
        while current > 0 and self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def remove_min(self):
        # Remove and return the minimum element from the heap
        if self.size == 0:
            return -1
        
        min_val = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.size -= 1
        self.heapify(0)
        return min_val

    def print_heap(self):
        for i in range((self.size - 2) // 2 + 1):
            print(f"PARENT: {self.heap[i]}", end=" ")
            if self.left_child(i) < self.size:
                print(f"LEFT: {self.heap[self.left_child(i)]}", end=" ")
            if self.right_child(i) < self.size:
                print(f"RIGHT: {self.heap[self.right_child(i)]}", end=" ")
            print()

h = MyMinHeap(10)
h.insert(5)
h.insert(3)
h.insert(17)
h.insert(10)
h.insert(84)
h.insert(19)
h.insert(6)
h.insert(22)
h.insert(9)

h.print_heap()

print("Removed:", h.remove_min())
h.print_heap()
