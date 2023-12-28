# Explanation: The formula used to implement push and pop is 2k+1/2k+2 for the nodes of the heap, assuming the array used will have elements
# sorted
# Time Complexcity: O(log n) for push and pop, and O(1) for getMin and getLength
# Space Complexcity: O(n)


class MinHeap:
    def __init__(self):
        self.heap = [] #a list will be the most adequate data structure to design a heap

    def push(self, value):
        self.heap.append(value)
        self._heapify_up()

    def pop(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down()
        return root

    def get_min(self):
        return self.heap[0] if self.heap else None

    def length(self):
        return len(self.heap)

    # after inserting the heap, we need to adjust the heap properly such that the new insertion get inserted at the right level of the binary heap
    def _heapify_up(self):
        index = len(self.heap) - 1
        while index > 0:
            parent_index = (index - 1) // 2
            if self.heap[index] < self.heap[parent_index]:
                self.heap[index], self.heap[parent_index] = (
                    self.heap[parent_index],
                    self.heap[index],
                )
                index = parent_index
            else:
                break

    # similarly, we need to adjust the heap such that if we pop the root, we need to replace the root with the last element
    def _heapify_down(self):
        index = 0
        while True:
            left_child_index = 2 * index + 1
            right_child_index = 2 * index + 2
            smallest = index

            if (
                left_child_index < len(self.heap)
                and self.heap[left_child_index] < self.heap[smallest]
            ):
                smallest = left_child_index

            if (
                right_child_index < len(self.heap)
                and self.heap[right_child_index] < self.heap[smallest]
            ):
                smallest = right_child_index

            if smallest != index:
                self.heap[index], self.heap[smallest] = (
                    self.heap[smallest],
                    self.heap[index],
                )
                index = smallest
            else:
                break

# Example usage:
heap = MinHeap()
heap.push(4)
heap.push(2)
heap.push(7)
heap.push(1)

print("Min Heap:", heap.heap)
print("Length of Min Heap:", heap.length())
print("Min Element:", heap.get_min())
print("Popped Element:", heap.pop())
print("Min Heap after pop:", heap.heap)
