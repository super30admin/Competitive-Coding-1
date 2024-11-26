# Min Heap
# https://www.geeksforgeeks.org/min-heap-in-java/

class MinHeap:
    def __init__(self):
        self.l = 0
        self.heap = [-1000]

    def insert(self,item):
        # Time Complexity: O(log n)
        self.heap.append(item)
        self.l += 1
        i = self.l

        # Heapify
        while self.heap[i] < self.heap[i//2] and i > 1:
            self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i//2

    def extractMin(self):
        # Time Complexity: O(log n)
        temp = self.heap[1]
        self.heap[1] = self.heap[self.l]
        self.l -= 1
        self.heap.pop()

        i = 1
        left_child = (2*i)+1
        right_child = (2*i)+2

        while self.heap[i] > self.heap[left_child] or self.heap[i] > self.heap[right_child]:
            if self.heap[i] > self.heap[left_child] and self.heap[i] > self.heap[right_child]:
                if self.heap[left_child] < self.heap[right_child]:
                    self.heap[i], self.heap[left_child] = self.heap[left_child], self.heap[i]
                else:
                    self.heap[i], self.heap[right_child] = self.heap[right_child], self.heap[i]
            elif self.heap[i] > self.heap[left_child]:
                self.heap[i], self.heap[left_child] = self.heap[left_child], self.heap[i]
            else:
                self.heap[i], self.heap[right_child] = self.heap[right_child], self.heap[i]

        return temp

    def getMin(self):
        # Time Complexity: O(1)
        if not self.isEmpty():
            return self.heap[1]

    def isEmpty(self):
        # Time Complexity: O(1)
        if len(self.heap) == 1 and self.heap[0] == -1000:
            return True
        return False

obj = MinHeap()
print(obj.isEmpty())
obj.insert(5)
obj.insert(4)
obj.insert(14)
obj.insert(40)
obj.insert(1)
obj.insert(2)
obj.insert(6)
print(obj.isEmpty())
print(obj.getMin())
print(obj.extractMin())
print(obj.extractMin())
print(obj.getMin())