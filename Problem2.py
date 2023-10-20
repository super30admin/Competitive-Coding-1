# Min Heap Implementation using Array
# # // Time Complexity : push O(1)
# # // Space Complexity : O()
# # // Did this code successfully run on Leetcode : No
# # // Any problem you faced while coding this :No


# # // Your code here along with comments explaining your approach
class heapq:
    def __init__(self) -> None:
        self.heap = []
        print(self.heap)

    def push(self, element):
        self.heap.append(element)
        self.shiftUp(element)

    def shiftUp(self, element):
        pos = len(self.heap) - 1
        while pos > 0:
            parent = (pos - 1) >> 1
            if self.heap[parent] > element:
                self.heap[pos] = self.heap[parent]
            else:
                break
            pos = parent
        self.heap[pos] = element

    def shiftdown(self, item):
        pos = 0
        child = pos*2 + 1
        while child < len(self.heap):
            right = child + 1
            if right < len(self.heap) and not self.heap[child] < self.heap[right]:
                child = right
            if self.heap[child] < self.heap[pos]:
                self.heap[pos], self.heap[child] = self.heap[child], self.heap[pos]
            pos = child
            child = pos*2 + 1

    # always pop the top one
    def pop(self):
        pop_item = self.heap[0]
        self.heap[0] = self.heap.pop()
        self.shiftdown(self.heap[0])
        return pop_item


# Binary Tree Representation
# of input array
# 1
# / \
# 3	 5
# / \	 / \
# 4	 6 13 10
# / \ / \
# 9 8 15 17
heap = heapq()
arr = [1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17]
for ele in arr:
    heap.push(ele)
print(heap)
