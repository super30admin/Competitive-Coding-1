"""
Insert elements at the end and move up to maintain the heap property.
Remove the min viz the root, replace with last element, then heapify down.
We need to alwyas have parent ≤ children to maintain min-heap.
"""
"""
Time Complexity:
add(), remove() - O(log n)
peek(), size() - O(1)
Space Complexity:
Overall heap - O(n)
"""

class Problem2:
    def __init__(self):
        self.heap = []

    def parent(self, i):
        return (i - 1) // 2

    def leftChild(self, i):
        return 2 * i + 1

    def rightChild(self, i):
        return 2 * i + 2

    def add(self, val):
        self.heap.append(val)
        self._bubble_up(len(self.heap) - 1)

    def remove(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()

        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self.heapify(0)
        return root

    def peek(self):
        return self.heap[0] if self.heap else None

    def size(self):
        return len(self.heap)

    def print_heap(self):
        print(self.heap)

    def _bubble_up(self, index):
        while index > 0:
            parent_idx = self.parent(index)
            if self.heap[index] < self.heap[parent_idx]:
                self.heap[index], self.heap[parent_idx] = self.heap[parent_idx], self.heap[index]
                index = parent_idx
            else:
                break

    def heapify(self, index):
        smallest = index
        left = self.leftChild(index)
        right = self.rightChild(index)

        if left < self.size() and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < self.size() and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self.heapify(smallest)

if __name__ == "__main__":
    h = Problem2()
    h.add(10)
    h.add(4)
    h.add(15)
    h.add(1)
    h.print_heap()       
    print(h.peek())      
    print(h.remove()) 
    h.print_heap()       
    print("Size:", h.size())

