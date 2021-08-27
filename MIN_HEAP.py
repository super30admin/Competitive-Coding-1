# time complexity: check functions
# space complexity: check functions
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : No

class MinHeap:

    def __init__(self, array):

        self.heap = self.buildHeap(array)

    # TC O(N) | SC O(1)
    def buildHeap(self, array):

        firstParentIdx = (len(array) - 2) // 2
        for currentIdx in reversed(range(firstParentIdx + 1)):
            self.heapDown(currentIdx, len(array) - 1, array)
        return array

    # TC O(logN) | SC O(1)
    def heapDown(self, currentIdx, endIdx, heap):
        childOneIdx = (2 * currentIdx) + 1
        while childOneIdx < len(heap):
            childTwoIdx = (2 * currentIdx) + 2 if currentIdx * 2 + 2 <= endIdx else -1
            if childTwoIdx != -1 and heap[childTwoIdx] < heap[childOneIdx]:
                idxToSwap = childTwoIdx
            else:
                idxToSwap = childOneIdx
            if heap[idxToSwap] < heap[currentIdx]:
                self.swap(currentIdx, idxToSwap, heap)
                currentIdx = idxToSwap
                childOneIdx = currentIdx * 2 + 1
            else:
                break

    # TC O(logN) | SC O(1)
    def heapUp(self, currentIdx, heap):
        parent = (currentIdx - 1) // 2
        while currentIdx > 0 and heap[parent] > heap[currentIdx]:
            self.swap(parent, currentIdx, heap)
            currentIdx = parent
            parentIdx = (currentIdx - 1) // 2

    # TC O(1) | SC O(1)
    def peek(self):
        return self.heap[0]

    # TC O(logN) | SC O(1)
    def remove(self):
        self.swap(0, len(self.heap) - 1, self.heap)
        valueToRemove = self.heap.pop()
        self.heapDown(0, len(self.heap) - 1, self.heap)
        return valueToRemove

    # TC O(logN) | SC O(1)
    def insert(self, value):
        self.heap.append(value)
        self.heapUp(len(self.heap) - 1, self.heap)

    def swap(self, i, j, heap):
        heap[i], heap[j] = heap[j], heap[i]

