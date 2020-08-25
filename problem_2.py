# Space : O(N)

class MinHeap:
    def __init__(self):
        self.heap = []
    
    # runtime : O(1)
    def getMin(self):
        if len(self.heap):
            print('Min -> ', self.heap[0])
            return self.heap[0]
    
    #Runtime : O(1)
    def extractMin(self):
        if len(self.heap):
            self.heap.pop(0)
            print("Post extraction -> ", self.heap)
    
    # Runtime : O(longN)
    # Since the array is sorted
    # we perform a binary search to
    # find a suitable position where 
    # the new element can be inserted. 
    def insert(self, element):
        if not self.heap:
            self.heap.append(element)
            print('Inserted Element -> ' ,self.heap)
            return
        if element < self.heap[0]:
            self.heap = [element] + self.heap
            print('Inserted Element -> ' ,self.heap)
            return 

        left = 0
        right = len(self.heap) - 1

        while left <= right:
            mid = (left+right)//2
            prev = float('-inf')
            post = float('inf')

            if mid >= 0:
                prev = self.heap[mid]
            
            if mid < len(self.heap)-1:
                post = self.heap[mid + 1]
            
            if prev < element and element < post:
                self.heap.insert(mid+1, element)
                print('Inserted Element -> ' ,self.heap)
                return 
            
            elif element > self.heap[mid]:
                left += 1
            
            elif element < self.heap[mid]:
                right -= 1

new = MinHeap()

new.insert(9)
new.insert(5)
new.insert(13)
new.extractMin()
new.getMin()
new.insert(10)
new.getMin()

