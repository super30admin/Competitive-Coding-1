# Time Complexity : getMin(): O(1), insert(): O(log n), extractMin(): O(log n)
# Space Complexity : O(n)
# Any problem you faced while coding this : yup, in concept and coding
import unittest


class MinHeap:

    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.size = 0
        self.Heap = [0]*(self.maxsize+1)
        self.Heap[0] = -1*self.maxsize
        self.front = 1

    def parent(self, pos):
        return pos//2

    def leftChild(self, pos):
        return 2 * pos

    def rightChild(self, pos):
        return (2 * pos) + 1

    def isLeaf(self, pos):
        if pos >= (self.size//2) and pos <= self.size:
            return True
        return False

    def swap(self, fpos, spos):
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]

    def minHeapify(self, pos):

        if not self.isLeaf(pos):
            if (self.Heap[pos] > self.Heap[self.leftChild(pos)] or self.Heap[pos] > self.Heap[self.rightChild(pos)]):
                if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]:
                    self.swap(pos, self.leftChild(pos))
                    self.minHeapify(self.leftChild(pos))
                else:
                    self.swap(pos, self.rightChild(pos))
                    self.minHeapify(self.rightChild(pos))

    def insert(self, element):
        if self.size >= self.maxsize:
            return
        self.size += 1
        self.Heap[self.size] = element
        current = self.size
        while self.Heap[current] < self.Heap[self.parent(current)]:
            self.swap(current, self.parent(current))
            current = self.parent(current)

    def Print(self):
        for i in range(1, (self.size//2)+1):
            print(" PARENT : " + str(self.Heap[i])+" LEFT CHILD : " + str(
                self.Heap[2 * i])+" RIGHT CHILD : " + str(self.Heap[2 * i + 1]))

    def minHeap(self):

        for pos in range(self.size//2, 0, -1):
            self.minHeapify(pos)

    def extractMin(self):

        popped = self.Heap[self.front]
        self.Heap[self.front] = self.Heap[self.size]
        self.size -= 1
        self.minHeapify(self.front)
        return popped

    def getMin(self):
        return self.Heap[self.front]


class MinHeapTest(unittest.TestCase):

    def testcase1(self):
        minHeap = MinHeap(12)
        minHeap.insert(1)
        minHeap.insert(3)
        minHeap.insert(12)
        minHeap.insert(6)
        minHeap.insert(44)
        minHeap.insert(19)
        self.assertEqual(minHeap.extractMin(), 1)
        self.assertEqual(minHeap.getMin(), 3)


if __name__ == "__main__":
    unittest.main(exit=False, verbosity=2)
