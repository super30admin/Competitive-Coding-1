# Time Complexity: Given in Function
# Space Complexity: O(n)

class Minheap:
    def __init__(self):
        self.heap = []

    def insert(self, elem):
        # O(log(n))
        self.heap.append(elem)
        if len(self.heap) != 1:
            n = len(self.heap) - 1
            i = (n - 1) // 2
            while i >= 0:
                if self.heap[i] >= self.heap[n]:
                    self.heap[n], self.heap[i] = self.heap[i], self.heap[n]
                    n = i
                i = (i - 1) // 2

    def getMin(self):
        # O(1)
        if len(self.heap):
            return self.heap[0]
        return -1

    def extractMin(self):
        # O(log(n))
        if len(self.heap):
            n = len(self.heap) - 1
            self.heap[0], self.heap[n] = self.heap[n], self.heap[0]
            elem = self.heap.pop()
            n = n - 1
            i = 0
            while i <= ((n - 1) // 2):
                left = (2 * i) + 1
                right = (2 * i) + 2
                if left <= n and right <= n and (self.heap[left] <= self.heap[i] or self.heap[right] <= self.heap[i]):
                    if self.heap[left] <= self.heap[right]:
                        self.heap[left], self.heap[i] = self.heap[i], self.heap[left]
                        i = left
                    else:
                        self.heap[right], self.heap[i] = self.heap[i], self.heap[right]
                        i = right
                elif left <= n and self.heap[left] <= self.heap[i]:
                    self.heap[left], self.heap[i] = self.heap[i], self.heap[left]
                    i = left
                else:
                    break
            return elem
        return -1

    def show(self):
        print(self.heap)

heap = Minheap()
heap.insert(9)
heap.show()
heap.insert(8)
heap.show()
heap.insert(7)
heap.show()
heap.insert(6)
heap.show()
heap.insert(5)
heap.show()
heap.insert(4)
heap.show()
heap.insert(3)
heap.show()
heap.insert(2)
heap.show()
heap.insert(1)
heap.show()
print(heap.getMin())
heap.show()
print(heap.getMin())
heap.show()
print(heap.getMin())
heap.show()
print(heap.extractMin())
heap.show()
print(heap.extractMin())
heap.show()
print(heap.extractMin())
heap.show()
print(heap.extractMin())
heap.show()
print(heap.extractMin())
heap.show()
print(heap.extractMin())
heap.show()