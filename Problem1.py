#Time Complexity: Insert and Remove - O(logn)
#getmin - O(1)
#Space Complexity: O(n)
class min_heap:
    
    def __init__(self):
        self.heap = []
        
    def add(self,element):
        self.heap.append(element)
        self.bubble_up(len(self.heap) - 1)
        
    def getmin(self):
        return self.heap[0]
    
    def size(self):
        return len(self.heap)
        
    def remove(self):
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        temp = self.heap.pop()
        self.bubble_down(0)
        return temp
        
    def bubble_up(self,ind):
        if ind == 0:
            return
        
        parent = (ind - 1)// 2
        if parent >= 0 and self.heap[parent] > self.heap[ind]:
            self.heap[ind], self.heap[parent] = self.heap[parent], self.heap[ind]
            self.bubble_up(parent)
            
    def bubble_down(self,ind):
        left = 2 * ind + 1
        right = 2 * ind + 2
        
        temp  = ind
        
        if left < self.size() and self.heap[left] < self.heap[temp]:
            temp = left
            
        if right < self.size() and self.heap[right] < self.heap[temp]:
            temp = right
        
        if ind == temp:
            return
        
        self.heap[temp], self.heap[ind] = self.heap[ind], self.heap[temp]
        
        self.bubble_down(temp)
        

obj = min_heap() 
arr = [15,28,16,32,31,20]

for i in arr:
    obj.add(i)
    print(obj.heap)
    
for i in arr:
    obj.remove()
    print(obj.heap)
    
    

        
        
        
        
        
        