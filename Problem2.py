class MinHeap:
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [float('-inf')] + [0] * maxsize 
        self.FRONT = 1 

    # return's the position of the parent node
    def parent(self, pos):
        return pos // 2

    # return's the position of the left child node
    def leftChild(self, pos):
        return 2 * pos

    # return's the position of the right child node
    def rightChild(self, pos):
        return 2 * pos + 1

    # check's if the node is a leaf
    def isLeaf(self, pos):
        return pos > (self.size // 2)

    # swaps two nodes in the heap
    def swap(self, fpos, spos):
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]

    # heapify the node at given position 
    def minHeapify(self, pos):
        if not self.isLeaf(pos):
            swapPos = pos
            # Check if right child exists and finds the minimum between left and right child
            if self.rightChild(pos) <= self.size:
                swapPos = self.leftChild(pos) if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)] else self.rightChild(pos)
            else:
                swapPos = self.leftChild(pos)

            if self.Heap[pos] > self.Heap[swapPos]:
                self.swap(pos, swapPos)
                self.minHeapify(swapPos)

   
    def insert(self, element):
        if self.size >= self.maxsize:
            return

        self.size += 1
        self.Heap[self.size] = element
        current = self.size

        while self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    
    def printHeap(self):
        for i in range(1, self.size // 2 + 1):
            print(f"PARENT: {self.Heap[i]} LEFT CHILD: {self.Heap[2 * i]} RIGHT CHILD: {self.Heap[2 * i + 1]}")


    def remove(self):
        popped = self.Heap[self.FRONT]
        self.Heap[self.FRONT] = self.Heap[self.size]
        self.size -= 1
        self.minHeapify(self.FRONT)
        return popped


if __name__ == "__main__":
    print("The Min Heap is:")
    minHeap = MinHeap(15)

    # Insert elements into the Min Heap
    minHeap.insert(5)
    minHeap.insert(3)
    minHeap.insert(17)
    minHeap.insert(10)
    minHeap.insert(84)
    minHeap.insert(19)
    minHeap.insert(6)
    minHeap.insert(22)
    minHeap.insert(9)

    # Print the elements of the heap
    minHeap.printHeap()

    # Remove and print the minimum value from the heap
    print("The Min val is:", minHeap.remove())
