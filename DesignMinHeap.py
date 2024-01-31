

class Heap:
    def __init__(self) -> None:
        self.realSize = 0
        self.heap = [None]

    # Time complexity: o(1)
    # Space complexity: o(1)

    def parent(self, index):
        return index // 2

    # Time complexity: o(1)
    # Space complexity: o(1)
    def leftChild(self, index):
        if index * 2 > self.realSize:
            return 0
        return index * 2

    # Time complexity: o(1)
    # Space complexity: o(1)
    def rightChild(self, index):

        if index * 2 + 1 > self.realSize:
            return 0
        return index * 2 + 1

    # Time complexity: o(1)
    # Space complexity: o(1)
    def isLeaf(self, index):
        if index > self.realSize // 2:
            return True
        return False

    # Time complexity: o(1)
    # Space complexity: o(1)
    def peek(self):
        return self.heap[1]

    # Time complexity: o(n)
    # Space complexity: o(1)
    def print(self):
        print(self.heap)
        for i in range(1, self.realSize//2 + 1):
            print("node  ", self.heap[i])
            print("left Child ", self.heap[self.leftChild(i)])
            print("right child ", self.heap[self.rightChild(i)])

    # Time complexity: o(log(n))
    # Space complexity: o(n)
    def minHeapify(self, index):
        if index > 0:
            leftChild = self.leftChild(index)
            rightChild = self.rightChild(index)
            if rightChild or leftChild:
                if self.heap[leftChild] < self.heap[rightChild]:
                    if self.heap[leftChild] < self.heap[index]:
                        self.heap[index], self.heap[leftChild] = self.heap[leftChild], self.heap[index]
                        self.minHeapify(leftChild)
                elif self.heap[leftChild] > self.heap[rightChild]:
                    if self.heap[index] > self.heap[rightChild]:
                        self.heap[index], self.heap[rightChild] = self.heap[rightChild], self.heap[index]
                        self.minHeapify(rightChild)
            else:
                return
        else:
            return

    # Time complexity: o(log(n))
    # Space complexity: o(n)
    def add(self, ele):

        self.heap.append(ele)
        self.realSize += 1
        parentIndex = self.realSize // 2
        while parentIndex > 0 and self.heap[self.realSize] < self.heap[parentIndex]:
            self.heap[self.realSize], self.heap[parentIndex] = self.heap[parentIndex], self.heap[self.realSize]
            parentIndex = parentIndex//2

    # Time complexity: o(log(n))
    # Space complexity: o(n)
    def remove(self):

        if self.realSize > 0:
            self.heap[1] = self.heap.pop(-1)
            self.realSize -= 1
            self.minHeapify(1)


h = Heap()

h.add(1)
h.add(2)
h.add(4)
h.add(5)
h.add(6)
h.add(7)
h.add(3)
h.remove()

h.print()
