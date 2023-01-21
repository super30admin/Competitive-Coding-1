# MinHeap

class MinHeap:
    def __init__(self):
        self.heap = []
        
    # Time Complexity : O(1)
    # Space Complexity : O(1)
    def getMin(self):
        return self.heap[0]
    
    # Time Complexity : O(1)
    # Space Complexity : O(1)
    def size(self):
        return len(self.heap)
    
    # Time Complexity : O(log n)
    # Space Complexity : O(log n)
    def insert(self, num):
        self.heap.append(num)
        self.__bubbleUp(self.size() - 1)
    
    # Time Complexity : O(log n)
    # Space Complexity : O(log n)
    def remove(self):
        self.heap[0], self.heap[self.size() - 1] = self.heap[self.size() - 1], self.heap[0]
        temp = self.heap.pop()
        
        self.__bubbleDown(0)
        return temp
        
    def __bubbleUp(self, index):
        
        if index == 0:
            return
        
        parent = (index - 1) // 2
        
        if(parent >= 0 and self.heap[index] < self.heap[parent]):
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            self.__bubbleUp(parent)
            
    def __bubbleDown(self, index):
        
        left = 2 * index + 1
        right = 2 * index + 2
        
        temp = index
        
        if(left < self.size() and self.heap[left] < self.heap[temp]):
            temp = left
        if(right < self.size() and self.heap[right] < self.heap[temp]):
            temp = right
            
        if(temp == index):
            return
        
        self.heap[index], self.heap[temp] = self.heap[temp], self.heap[index]
        self.__bubbleDown(temp)
        
obj = MinHeap()
arr = [7,25,16,35,31,21]
for i in arr:
    obj.insert(i)
    print(obj.heap)
for i in arr:
    print(obj.remove())
    print(obj.heap)