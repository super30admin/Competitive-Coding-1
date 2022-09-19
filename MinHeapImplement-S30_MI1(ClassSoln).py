# Heap: Tree based DS in which the DS is a complete binary tree.
# Insertion, Deletion: TC = O(log n)
# GetMin, Size: TC = O(1)
# Root node must be minimum among all nodes.
# Parent node is smaller than its two children nodes.
# Implementing MinHeap using python list.
# Overall SC = O(n), individual ops SC = O(1)
# You always delete/remove from top or element at 0 index or the minimum element.

class MinHeap:

    def __init__(self):
        self.heap = []

    def size(self):
        return len(self.heap)

    def getMin(self):
        if self.size() == 0:
            return "No elements present, so minimum cannot be found."
        return self.heap[0]

    def insert(self, data):
        self.heap.append(data)

        # private function as we do not want outside world to access it.
        self.__bubbleUp(self.size()-1)

    def delete(self, data):
        # we can only delete the top most element or the min element from min heap.
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        temp = self.heap.pop()
        self.__bubbleDown(0)
        return temp

    def __bubbleUp(self, ind):
        if ind == 0:
            return
        parent = (ind - 1)//2
        if parent >= 0 and self.heap[parent] > self.heap[ind]:
            self.heap[parent], self.heap[ind] = self.heap[ind], self.heap[parent]
            self.__bubbleUp(parent)

    def __bubbleDown(self, ind):
        left_child = 2*ind + 1
        right_child = 2*ind + 2
        temp = ind
        if left_child < self.size() and self.heap[left_child] < self.heap[temp]:
            temp = left_child
        if right_child < self.size() and self.heap[right_child] < self.heap[temp]:
            temp = right_child
        if temp == ind:
            return
        self.heap[ind], self.heap[temp] = self.heap[temp], self.heap[ind]
        self.__bubbleDown(temp)