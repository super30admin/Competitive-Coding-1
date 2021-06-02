"""
Approach:

using a complete binary tree, the goal is to have the min element at the root of the tree.
This would help us get the min element in constant time.

1) The max element of the tree is maintained at the last node (top to bottom, left to right)
2) when the root is popped, we replace the root with the max element. Then heapify, meaning
    bubble up the min element of the tree:
    a) To do this, we compare the parent element with its children, pick the min of the 3
    and swap with the parent
    b) Although we consider the operation on a tree, we can use our parent Data Structure
    as an array and apply the index conversion as follows:
        parent index = ((child index + 1)/2) -1
        left child index = (parent index * 2) + 1
        left child index = (parent index * 2) + 2
3) When we push a new element into the tree, we always do it at the end node (top to bottom,
    left to right). Then heapify, so that the max element of the tree can be bubbled down

"""


from collections import deque
class minHeap:
    def __init__(self,maxsize):
        self.heap = deque()
        self.size = 0
        self.max_size = maxsize

    def swap_(self, a,b):
        self.heap[a], self.heap[b] = self.heap[b], self.heap[a]

    def push(self, key):
        if self.size >= self.max_size:
            print ("max limit reached")
            return
        self.heap.append(key)
        curr = self.size
        self.size += 1

        while curr > 0:
            parent = (curr+1)//2 - 1
            if self.heap[parent] < self.heap[curr]:
                break
            self.swap_(parent,curr)
            curr = parent

    def pop(self):
        if self.size < 1:
            print ("no elements in heap")
            return

        out = self.heap[0]
        self.heap[0] = self.heap[-1]
        self.heap.pop()
        self.size -= 1
        curr = 0

        while curr < self.size//2:
            left_child = (curr * 2) + 1
            right_child = left_child + 1
            if (right_child < self.size) and self.heap[right_child]< self.heap[left_child] :
                self.swap_(curr, right_child)
                curr = right_child
            elif (left_child < self.size) and self.heap[left_child] < self.heap[curr]:
                self.swap_(curr, left_child)
                curr = left_child
            else:
                break
        return out

    def show(self):
        print (self.heap)

    def peak(self):
        return self.heap[0]


min_heap =  minHeap(5)

min_heap.push(10)
min_heap.push(5)
min_heap.push(7)
min_heap.show()
print(min_heap.peak())
min_heap.push(2)
min_heap.push(8)
print(min_heap.peak())
min_heap.show()
min_heap.pop()
print(min_heap.peak())

"""
Time Complexity:
    push: O(log n)
    pop: O(log n)
    get/peak min: O(1)
    
Space Complexity: O(n)
"""