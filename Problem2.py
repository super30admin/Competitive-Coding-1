
'''
Problem: Design Minheap
Time Complexity: O(log n), where n is given elements
Space Complexity: O(n) for heap
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        insert: add element at end, bubble up
        remove: swap 0 element with last index, pop then bubble down  
'''

class MinHeap:
    def __init__(self):
        self.heap = []
        
    def swap(self,a, b):
        self.heap[a],self.heap[b] = self.heap[b], self.heap[a]
        
    def heappush(self, element):
        #add to end
        self.heap.append(element)
        
        #bubble up
        idx = len(self.heap) - 1
        if idx == 0:
            return
        parent = (idx - 1) // 2 if idx % 2 != 0 else (idx - 2) // 2
        curr = idx
        while self.heap[parent] > self.heap[curr]:
            self.swap(parent, curr)
            curr = parent
            if curr!=0:
                parent  = (curr - 1) // 2 if curr % 2 != 0 else (curr - 2) // 2
            else:
                break
        
    def heapmin(self):
        return self.heap[0]
    
    def heappop(self):        
        #swap with end'
        self.swap(0, len(self.heap) - 1)
        
        #remove end
        self.heap.pop()
        
        #bubble down
        self.bubbledown(0)
            
    def bubbledown(self, i):
        left = 2 * i +1
        right = 2 * i + 2
        
        curr = i
        
        if left < len(self.heap) and self.heap[left] <self.heap[curr]:
            curr = left
        if right < len(self.heap) and self.heap[right] <self.heap[curr]:
            curr = right
            
        if curr == i :
            return
        self.swap(i, curr)
        
        self.bubbledown(curr)
                                   
        
heap = MinHeap()
heap.heappush(3)
heap.heappush(4)
heap.heappush(6)
heap.heappush(8)
print('Current heap:', heap.heap)
print('Min in heap: ', heap.heapmin())

heap.heappush(9)
print('Current heap:', heap.heap)
heap.heappop()
print('Heap after pop:', heap.heap)
heap.heappush(2)
print('Heap after push 2:', heap.heap)