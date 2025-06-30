#Space complexity = O(n) for the heap storage
#Time complexity = O(log n) for insert and removeMin operations
class MyMinHeap:
    def __init__(self, capacity):
        self.maxSize = capacity
        self.size = 0
        self.heap = [0] * capacity

    def parent(self, i):
        return (i - 1) // 2

    def leftChild(self, i):
        return 2 * i + 1

    def rightChild(self, i):
        return 2 * i + 2

    def isLeaf(self, i):
        return i >= self.size // 2 and i < self.size

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def heapify(self, i): 
        if self.isLeaf(i):
            return
        left = self.leftChild(i)
        right = self.rightChild(i)
        smallest = i
        # If the left child exists and is smaller than the current node
        # then update smallest to be the left child
        if left < self.size and self.heap[left] < self.heap[smallest]:
            smallest = left
        # If the right child exists and is smaller than the smallest found so far
        # then update smallest to be the right child
        if right < self.size and self.heap[right] < self.heap[smallest]:
            smallest = right
        # If the smallest is not the current index, swap and continue heapifying
        if smallest != i:
            self.swap(i, smallest)
            self.heapify(smallest)

    def insert(self, val): #O(log n)
        # Check if the heap is full
        if self.size >= self.maxSize:
            return
        self.heap[self.size] = val
        current = self.size
        self.size += 1
        # Bubble up the new value to maintain the heap property
        # Compare the newly added value with its parent and swap if necessary
        while current > 0 and self.heap[current] < self.heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def removeMin(self): #O(log n)
        if self.size == 0:
            return -1
        # Remove the root of the heap (the minimum element)
        # and replace it with the last element in the heap
        # heapify the root to maintain the heap property
        min_val = self.heap[0]
        self.heap[0] = self.heap[self.size - 1]
        self.size -= 1
        self.heapify(0)
        return min_val

    def printHeap(self):
        for i in range((self.size - 2) // 2 + 1):
            print(f"PARENT: {self.heap[i]}", end="")
            if self.leftChild(i) < self.size:
                print(f"LEFT: {self.heap[self.leftChild(i)]}", end="")
            if self.rightChild(i) < self.size:
                print(f"RIGHT: {self.heap[self.rightChild(i)]}", end="")
            print()

# Main driver
if __name__ == "__main__":
    heap = MyMinHeap(15)
    for val in [5, 3, 17, 10, 84, 19, 6, 22, 9]:
        heap.insert(val)

    print("Min Heap:")
    heap.printHeap()
    print("Removed Min:", heap.removeMin())
