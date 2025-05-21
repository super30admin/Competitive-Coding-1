class Minheap:
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
        self.percolate_up(len(self.heap) - 1)

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

    def percolate_up(self, index):
        while index > 0:
            parent_idx = self.parent(index)
            if self.heap[index] < self.heap[parent_idx]:
                self.heap[index], self.heap[parent_idx] = self.heap[parent_idx], self.heap[index]
                index = parent_idx
            else:
                return

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
    heap = Minheap()
    heap.add(10)
    heap.add(4)
    heap.add(15)
    heap.add(1)
    heap.print_heap()       
    print(heap.peek())      
    print(heap.remove()) 
    heap.print_heap()       
    print("Size:", h.size())