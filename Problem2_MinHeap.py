class MinHeap:

    def __init__(self):
        self.heap = [0]


    def insert(self, value):
        self.heap.append(value)
        ind = len(self.heap) - 1
        while ind // 2 > 0 and self.heap[ind] < self.heap[ind // 2]:
            self.heap[ind], self.heap[ind // 2] = self.heap[ind // 2], self.heap[ind]
            ind = ind // 2

    def getMin(self):
        return self.heap[1]

    def getMinChild_pos(self, ind):
        if (2 * ind + 1) > len(self.heap):
            return 2 * ind
        else:
            if self.heap[2 * ind] < self.heap[2 * ind + 1]:
                return 2 * ind
            else:
                return 2 * ind + 1

    def heapify(self, ind):
        while 2 * ind < len(self.heap):
            min_child = self.getMinChild_pos(ind)
            if self.heap[min_child] < self.heap[ind]:
                self.heap[min_child], self.heap[ind] = self.heap[ind], self.heap[min_child]
            ind = min_child

    def extractMin(self):
        self.heap[1] = self.heap[-1]
        self.heap.pop(-1)
        self.heapify(1)


# my_heap = MinHeap()
# my_heap.insert(15)
# my_heap.insert(5)
# my_heap.insert(3)
# my_heap.insert(17)
# my_heap.insert(10)
# my_heap.insert(84)
# my_heap.insert(19)
# my_heap.insert(6)
# my_heap.insert(22)
# my_heap.insert(9)
# 
# print("Min element is: ", my_heap.getMin())
# print(my_heap.heap)
# my_heap.extractMin()
# print(my_heap.heap)
# print("Min element is: ", my_heap.getMin())
# 
