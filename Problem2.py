# Design minheap, using array

'''
Heap shall have 3 operations:
    1. Extract root (min for minheap, max for maxheap)
    2. extractMin: remove the min/max element from minheap/maxheap
    3. Insert: insert a new element (use heapify up)
    4. Remove: remove an element (use heapify down)
Function assume a heap is input as an array with root node as minimum,
and the inputs are numbers (no other data types allowed)
'''

class MinHeap:
    
    def __init__(self):
        self.heap = [] # initiate the heap with empty list
        
    def ExtractRoot(self):
        if len(self.heap) == 0: return None
        else:
            return self.heap[0]
        
    def Insert(self, value): # Time complexicity O(Log n)
        self.heap.append(value)
        parent_index = (len(self.heap)-1-1)//2
        value_index = len(self.heap)-1
        parent = self.heap[parent_index]
        while self.heap[0] != value and value < self.heap[parent_index]:
            self.heap[parent_index], self.heap[value_index] = \
                self.heap[value_index], self.heap[parent_index]
            value_index = parent_index
            parent_index = (value_index-1)//2

    
    def ExtractMin(self): # Time complexicity O(Log n)
        if len(self.heap) < 1: return [] # for min heap with length 0 or 1
        else:
            temp, last = self.heap[0], self.heap[len(self.heap)-1]
            self.heap.pop()
            parent_index = 0
            left_index, right_index = 1, 2
            min_child = min(self.heap[left_index], self.heap[right_index])
            while last > min_child and right_index < (len(self.heap)-1)//2:
                self.heap[parent_index] = last 
                min_index = left_index if self.heap[left_index] < \
                            self.heap[right_index] else right_index
                self.heap[parent_index], self.heap[min_index] = \
                    self.heap[min_index], self.heap[parent_index]
                parent_index = min_index
                left_index, right_index = 2*min_index + 1, 2*min_index + 2   
                min_child = min(self.heap[left_index], self.heap[right_index])  
    
    def Print(self):
        print(self.heap)
        
# Test the code:

min_heap = MinHeap()

array = [45, 99, 63, 27, 29, 57, 42, 35, 12, 24]

for item in array:
    min_heap.Insert(item)

print("Min Heap from given array:")
min_heap.Print()
print("Min Heap after extracting the root node")
min_heap.ExtractMin()
min_heap.Print()         