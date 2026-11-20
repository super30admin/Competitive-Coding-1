
class MinHeap:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.heap = [0 for _ in range(capacity + 1)]   # index 0 unused

    def parent(self, i): #derive by writing out a minheap in array format
        return i // 2

    def leftChild(self, i): #derive by writing out a minheap in array format
        return 2 * i

    def rightChild(self, i): #derive by writing out a minheap in array format
        return 2 * i + 1

    def isLeaf(self, i): #derive by writing out a minheap in array format
        return i > self.size // 2

    def getSize(self):
        return self.size

    def peek(self):
        if self.size == 0:
            return "error"
        return self.heap[1]

    def printHeap(self):
        for i in range(1, self.size // 2 + 1):
            l, r = self.leftChild(i), self.rightChild(i)
            left = self.heap[l] if l <= self.size else None
            right = self.heap[r] if r <= self.size else None
            print(f"parent {self.heap[i]}, left and right children: {left} and {right}")

    def add(self, val): #idea is add at last position, then swap the new ele upwards in the minheap complete binary tree
        if self.size >= self.capacity:
            return "error"
        self.size += 1
        self.heap[self.size] = val
        i = self.size
        while i > 1 and self.heap[i] < self.heap[self.parent(i)]: #we swap till we have parent greater than new ele
            self.swap(i, self.parent(i))
            i = self.parent(i) #remember to switch i to parent's index for the while loop to work

    def swap(self, a, b):
        self.heap[a], self.heap[b] = self.heap[b], self.heap[a]

    def heapify(self, i): #from root compare its 2 kids if they exist and find smallest and swap smallest to the root - keep doing 
      #this till root ele finds its correct space
      
        # base
        if self.isLeaf(i): #if you reach leaf return
            return

        # recurse
        l, r = self.leftChild(i), self.rightChild(i) #get the children indexes
        smallest = i #57 to 61 is finding smallest
        if self.heap[l] < self.heap[smallest]: 
            smallest = l
        if r <= self.size and self.heap[r] < self.heap[smallest]:
            smallest = r

        if smallest != i: #if curr is already smallest we done here else swap curr with smallest and then start next level of 
          #heapify till either we reach leaf or we find right space for the new curr.
            self.swap(i, smallest)
            self.heapify(smallest)

    def remove(self): #idea is remove root, swap last ele to root and heapify 
        if self.size == 0:
            return "error"
        root = self.heap[1]
        self.heap[1] = self.heap[self.size]
        self.size -= 1
        self.heapify(1)
        return root


# ---------- tests ----------

def is_valid(h):
    """Check every parent <= its children."""
    for i in range(2, h.size + 1):
        if h.heap[h.parent(i)] > h.heap[i]:
            return False
    return True


# 1. add + peek
h = MinHeap(10)
for x in [5, 3, 8, 1, 9, 2, 7]:
    h.add(x)
    assert is_valid(h)
assert h.peek() == 1
assert h.getSize() == 7

# 2. print the structure
h.printHeap()

# 3. remove everything → should come out sorted
out = []
while h.getSize() > 0:
    out.append(h.remove())
    assert is_valid(h)
assert out == [1, 2, 3, 5, 7, 8, 9]

# 4. empty heap
assert h.peek() == "error"
assert h.remove() == "error"

# 5. full heap
small = MinHeap(2)
small.add(4)
small.add(2)
assert small.add(1) == "error"
assert small.peek() == 2

# 6. duplicates
d = MinHeap(5)
for x in [3, 3, 1, 1]:
    d.add(x)
assert [d.remove() for _ in range(4)] == [1, 1, 3, 3]

# 7. isLeaf with size 5 → indexes 3, 4, 5 are leaves
e = MinHeap(5)
for x in [1, 2, 3, 4, 5]:
    e.add(x)
assert [e.isLeaf(i) for i in range(1, 6)] == [False, False, True, True, True]

print("all tests passed")
