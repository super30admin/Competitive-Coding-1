class MinHeap:
    def __init__(self, array=None):
        self.heap = []
        if array:
            self.heapify(array)
            
    def heapify(self, array):
        self.heap = array[:]
        n = len(self.heap)
        # Start heapifying from the last parent down to the root
        for i in range((n - 2) // 2, -1, -1):
            self._heapify_down(i)

    def insert(self, value):
        self.heap.append(value)
        self._heapify_up(len(self.heap) - 1)

    def _heapify_up(self, index):
        # swap the inserted node with its parent until the heap property is restored
        parent_index = (index - 1) // 2
        
        # if node is not the root and is smaller than its parent, swap them
        if index > 0 and self.heap[index] < self.heap[parent_index]:
            self.heap[index], self.heap[parent_index] = self.heap[parent_index], self.heap[index]
            self._heapify_up(parent_index)

    def get_min(self):
        return self.heap[0] if self.heap else None

    def remove_min(self):
        if not self.heap:
            return None
        min_value = self.heap[0]
        last_value = self.heap.pop()
        if self.heap:
            self.heap[0] = last_value
            self._heapify_down(0)
        return min_value

    def _heapify_down(self, index):
        # compare the current node with is children and swap to get the smallest value in the root
        smallest = index
        left_child = 2 * index + 1
        right_child = 2 * index + 2

        # check left child exists and is smaller than current smallest
        if left_child < len(self.heap) and self.heap[left_child] < self.heap[smallest]:
            smallest = left_child
        # check right child exists and is smaller than current smallest
        if right_child < len(self.heap) and self.heap[right_child] < self.heap[smallest]:
            smallest = right_child

        # if smallest is not the current index, swap and continue heapifying down to maintain the heap property
        if smallest != index:
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify_down(smallest)


if __name__ == "__main__":
    arr = [3, 1, 4, 1, 5, 9, 2, 6, 5]
    print(f"Original array: {arr}")
    
    min_heap = MinHeap(arr)
    print(f"Min Heap: {min_heap.heap}")
    
    print(f"Minimum element: {min_heap.get_min()}")
    
    min_heap.insert(10)
    print(f"After inserting 10: {min_heap.heap}")
    print(f"Minimum element after insertion: {min_heap.get_min()}")
    
    removed_min = min_heap.remove_min()
    print(f"Removed minimum element: {removed_min}")
    print(f"Heap after removing minimum: {min_heap.heap}")
    
    removed_min = min_heap.remove_min()
    print(f"Removed minimum element: {removed_min}")
    print(f"Heap after removing minimum: {min_heap.heap}")
    
    removed_min = min_heap.remove_min()
    print(f"Removed minimum element: {removed_min}")
    print(f"Heap after removing minimum: {min_heap.heap}")
    
