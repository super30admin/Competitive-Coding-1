# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MeanHeap:
    def __init__(self):
        self.heap = []
    
    # Time Complexity :O(log N) N is numbers of elements in the heap
    def heapPush(self, val):
        self.heap.append(val)
        last = self.heapSize() - 1
        parent = (last - 1) // 2
        while parent >=0  and self.heap[last] <= self.heap[parent]:
            self.heap[last], self.heap[parent] = self.heap[parent], self.heap[last]
            last = parent
            parent = (last - 1) // 2
    
    # Time Complexity :O(log N) N is numbers of elements in the heap
    def heapPop(self):
        last = self.heapSize() - 1
        self.heap[last], self.heap[0] = self.heap[0], self.heap[last]
        removed =  self.heap.pop()
        
        curr = 0
        while curr < self.heapSize() and self.heapSize() > 0:
            left = 2 * curr + 1
            right = 2 * curr + 2
            
            temp = curr
            
            if left < self.heapSize() and self.heap[left] <= self.heap[temp]:
                temp = left
            
            if right < self.heapSize() and self.heap[right] <= self.heap[temp]:
                temp = right
                
            if temp == curr:
                return
            
            self.heap[temp], self.heap[curr] = self.heap[curr], self.heap[temp]
            
            curr = temp
            
        return removed
        
    def heapSize(self):
        return len(self.heap)
    
    
mh = MeanHeap()
nums = [13, 46, 12, 6, 17, 20]
for num in nums:
    mh.heapPush(num)
    print(mh.heap)
    
for i in range(len(nums)):
    mh.heapPop()
    print(mh.heap)

    