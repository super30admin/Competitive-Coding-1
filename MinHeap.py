# Time complexity : O(log(n))
# Space complexity : O(n), number of elements in the heap


class minHeap:
    def __init__(self):
        self.heap = []
    # Helper functions to get appropriate indices
    def get_parent(self, index):
        return (index-1)//2
    def get_left_child(self, index):
        return 2*index + 1
    def get_right_child(self, index):
        return 2*index + 2
    
    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    # Insert new element at the end of heap and bubble it up to its correct position
    def insert(self, value):
        self.heap.append(value)

        self.heapify_up(len(self.heap) - 1)


    def remove(self):
        # Swap first and last elemenst in the heap, pop the last element and bubble down the new element at the top of the heap
        if len(self.heap) == 0 : return
        self.swap(0, -1)

        min_value = self.heap.pop()

        self.heapify_down(0)

        return min_value
    
    def get_min(self):
        if self.heap == []:return
        return self.heap[0]
    
    def heapify_up(self, child):
        # We are at the child, we need to check its value with its parent

        parent = self.get_parent(child)

        while child > 0 and self.heap[child] < self.heap[parent]:
            self.swap(child, parent)

            
            parent = self.get_parent(child)
            child = parent

    def heapify_down(self, parent):
        # We are at the parent mnode. Need to check with its child nodes
        smallest = parent
        left_child = self.get_left_child(parent)
        right_child = self.get_right_child(parent)

        if self.heap[left_child] < self.heap[smallest]:
            smallest = left_child
         
        if self.heap[right_child] < self.heap[smallest]:
            smallest = right_child

        self.swap(smallest, parent)

        self.heapify_down(smallest)


