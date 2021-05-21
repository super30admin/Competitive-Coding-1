"""
Design Min Heap with insert, delete, heapify, isEmpty, size, find

Runtime Complexity: O(logn)
Space Complexity: O(1)

Reference: https://www.educative.io/edpresso/heap-implementation-in-python
"""


class Solution:
    def __init__(self):
        self.heap = []
        self.size = 0

    def insert(self, num):
        self.heap.append(num)
        self.size += 1

        self.up_heapify()
        print(self.heap)

    def delete(self):
        self.heap.pop(0)
        self.size -= 1
        print(self.heap)

        self.down_heapify()
        print(self.heap)

    def up_heapify(self):
        if len(self.heap) == 1:
            return

        i = self.size-1

        while (i - 1)//2 > 0:
            if self.heap[i] < self.heap[(i - 1) // 2]:
                temp = self.heap[i]
                self.heap[i] = self.heap[(i - 1) // 2]
                self.heap[(i - 1) // 2] = temp
            i = (i-1)//2

    def down_heapify(self):
        if len(self.heap) == 1:
            pass

        self.heap.insert(0, self.heap[-1])
        self.heap.pop()
        i = 0

        while 2*i < self.size:
            if self.heap[i] > self.heap[2 * i + 1]:
                temp = self.heap[i]
                self.heap[i] = self.heap[2 * i + 1]
                self.heap[2 * i + 1] = temp
            elif self.heap[i] > self.heap[2 * i + 2]:
                temp = self.heap[i]
                self.heap[i] = self.heap[2 * i + 2]
                self.heap[2 * i + 2] = temp

    def isEmpty(self):
        return len(self.heap) == 0

    def size(self):
        return self.size

    def findMin(self):
        return self.heap[0]


obj = Solution()
# 5,3,17,10,54
# 5,6,7,9,13,11,10
obj.insert(5)
obj.insert(6)
obj.insert(7)
obj.insert(9)
obj.insert(13)
obj.insert(11)
obj.insert(10)

obj.delete()
