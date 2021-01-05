class MinHeap:
    def __init__(self):
        # initialize data structure: array with size parameter
        self.heap_list = [0]
        self.current_size = 0
 
    def sift_up(self, i):
        # This function handles if an element is added and we need to move the element to its rightful position
        # While the element is not the root or the left element
        while i // 2 > 0:
            # If the element is less than its parent swap the elements
            if self.heap_list[i] < self.heap_list[i // 2]:
                self.heap_list[i], self.heap_list[i // 2] = self.heap_list[i // 2], self.heap_list[i]
            # Move the index to the parent to keep the properties
            i = i // 2
 
    def insert(self, k):
        # Append the element to the heap
        self.heap_list.append(k)
        # Increase the size of the heap.
        self.current_size += 1
        # Move the element to its rightful position
        self.sift_up(self.current_size)
 
    def sift_down(self, i):
        # if the current node has at least one child
        while (i * 2) <= self.current_size:
            # Get the index of the min child of the current node
            mc = self.min_child(i)
            # Swap the values of the current element is greater than its min child
            if self.heap_list[i] > self.heap_list[mc]:
                self.heap_list[i], self.heap_list[mc] = self.heap_list[mc], self.heap_list[i]
            i = mc
 
    def min_child(self, i):
        # If the current node has only one child, return the index of the unique child
        if (i * 2)+1 > self.current_size:
            return i * 2
        else:
            # Return the index of the min child if two children
            if self.heap_list[i*2] < self.heap_list[(i*2)+1]:
                return i * 2
            else:
                return (i * 2) + 1
 
    def delete_min(self):
        # Alert empty heap if last element deleted
        if len(self.heap_list) == 1:
            return '**Empty heap**'
        # root of the heap
        root = self.heap_list[1]
        # Move the last value of the heap to the root and pop the last value
        self.heap_list[1] = self.heap_list[self.current_size]
        *self.heap_list, _ = self.heap_list
        # Decrease the size of the heap
        self.current_size -= 1
        # Move down the root to maintain heap property
        self.sift_down(1)
        # Return the min value of the heap
        return root

minHeap = MinHeap()
minHeap.insert(5)
minHeap.insert(6)
minHeap.insert(7)
minHeap.insert(9)
minHeap.insert(13)
minHeap.insert(11)
minHeap.insert(10)
print(minHeap.delete_min()) 
print(minHeap.heap_list)

 