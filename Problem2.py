# Problem Name: Interview Problem: Design Min Heap

# Source Link: https://www.geeksforgeeks.org/min-heap-in-java/

class MinHeap:

    def __init__(self):
        self.heap = []

    def _left_child(self, index):
        return 2 * index + 1

    def _right_child(self, index):
        return 2 * index + 2

    def _parent(self, index):
        return (index - 1) // 2

    def _swap(self, index1, index2):
        self.heap[index1], self.heap[index2] = self.heap[index2], self.heap[index1]

    def insert(self, value):
        self.heap.append(value)
        current = len(self.heap) - 1

        # Adjust the comparisons for a min-heap
        while current > 0 and self.heap[current] < self.heap[self._parent(current)]:
            self._swap(current, self._parent(current))
            current = self._parent(current)

    def remove(self):
        if len(self.heap) == 0:
            return None

        if len(self.heap) == 1:
            return self.heap.pop()

        min_value = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._sink_down(0)
        return min_value

    def _sink_down(self, index):
        min_index = index
        while True:
            left_index = self._left_child(index)
            right_index = self._right_child(index)

            # Adjust the comparisons for a min-heap
            if left_index < len(self.heap) and self.heap[left_index] < self.heap[min_index]:
                min_index = left_index

            if right_index < len(self.heap) and self.heap[right_index] < self.heap[min_index]:
                min_index = right_index

            if min_index != index:
                self._swap(index, min_index)
                index = min_index
            else:
                return


def main():
    min_heap = MinHeap()

if __name__ == "__main__":
    main()