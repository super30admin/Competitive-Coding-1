class Solution:
    def __init__(self):
        self.heap = []

    def insert(self, key):
        ## bubbling up
        self.heap.append(key)
        idx = len(self.heap)-1

        while idx > 0:
            par = idx//2
            if self.heap[par] > self.heap[idx]:
                self.heap[par], self.heap[idx]= self.heap[idx],self.heap[par]
                idx = par
            else:
                return 

    def remove(self):
        ## bubling down
        self.help[0], self.help[-1] = self.help[-1], self.help[0]
        self.heap.pop()
        idx = 0

        while idx < len(self.heap):
            left_child = self.heap[idx*2 +1]
            right_child = self.heap[idx*2+2]

            larger = idx*2+2 if right_child > left_child else idx*2 +1

            if self.heap[idx]> self.heap[larger]:
                self.heap[larger],self.heap[idx] = self.heap[idx], self.heap[larger]
                idx = larger
            
            else:
                return 
    
    def getMin(self):
        return self.heap[0]
    
    def getSize(self):
        return len(self.heap)

