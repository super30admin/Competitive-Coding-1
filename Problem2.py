# Time Complexity
# getMin(): O(1) - Array lookup is O(1)
# extractMin(): O(log N) - We always swap the last element to the top then move it down so we would need to traverse the entire tree - hence logN
# insert(): O(log N) - Best case O(1) - Worst case logN when new min value is inserted

class MinHeap:
    def __init__(self):
        self.heap = []
    def getMin(self):
        return self.heap[0]

    def extractMin(self):
        # Swap root with last node
        res = self.getMin()
        self.heap[0] = self.heap[len(self.heap) - 1]
        # Propagate down
        left_idx = 1
        right_idx = 2
        curr = 0
        while curr < len(self.heap) and (self.heap[curr] > self.heap[left_idx] or self.heap[curr] > self.heap[right_idx]):
            if self.heap[left_idx] <= self.heap[right_idx]:
                self.heap[curr], self.heap[left_idx] = self.heap[left_idx], self.heap[curr]
                curr = left_idx
            else:
                self.heap[curr], self.heap[right_idx] = self.heap[right_idx], self.heap[curr]
                curr = right_idx
            left_idx = self.getLeft(curr)
            right_idx = self.getRight(curr)
            if left_idx >= len(self.heap) or right_idx >= len(self.heap):
                break


        return res

    def insert(self, val):
        if len(self.heap) == 0:
            self.heap.append(val)
            return

        next_idx = len(self.heap)
        self.heap.append(val)
        parent_idx = self.getParent(next_idx)
        if val >= self.heap[parent_idx]:
            return
        # Need to re-heapify / bubble up
        while parent_idx >= 0 and self.heap[parent_idx] > val:
            self.heap[parent_idx], self.heap[next_idx] = self.heap[next_idx], self.heap[parent_idx]
            next_idx = parent_idx
            parent_idx = self.getParent(next_idx)

    def getParent(self, idx):
        return (idx - 1) // 2
    def getLeft(self, idx):
        return (2 * idx) + 1

    def getRight(self, idx):
        return (2 * idx) + 2


if __name__ == "__main__":
    heap = MinHeap()
    heap.insert(30)
    heap.insert(10)
    heap.insert(15)
    heap.insert(5)
    heap.insert(16)
    heap.insert(40)
    heap.insert(41)
    heap.insert(32)
    heap.insert(34)
    print(heap.extractMin())
    print(heap.heap)
    print(heap.extractMin())
    print(heap.heap)
    print(heap.extractMin())
    print(heap.heap)
    # print(heap.extractMin())
    # print(heap.extractMin())
    # print(heap.extractMin())
