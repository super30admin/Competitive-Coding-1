class MinHeap:
    def __init__(self):
        self.heap = []
    # TC: O(1) 
    def getMin(self):
        return self.heap[0]

    # TC: O(n) where n is the number of elements in the heap.
    def size(self):
        return len(self.heap)
    
    def insert(self, num):
        self.heap.append(num)
        self.bubbleUp(self.size() - 1)  # Bubble up the last element up.
        
    def remove(self):
        self.heap[0], self.heap[self.size() - 1] = self.heap[self.size() - 1], self.heap[0]
        popped = self.heap.pop()
        self.bubbleDown(0)      # Bubble down the swapped element root
        return popped
        
    def bubbleUp(self, idx):
        if idx == 0:
            return
        parent = (idx - 1) // 2
        if parent >= 0 and self.heap[idx] < self.heap[parent]:
            self.heap[idx], self.heap[parent] = self.heap[parent], self.heap[idx]
            self.bubbleUp(parent)
    
    def bubbleDown(self, idx):
        left = 2 * idx + 1
        right = 2 * idx + 2
        temp = idx
        if left < self.size() and self.heap[temp] > self.heap[left]:
            temp = left
        if right < self.size() and self.heap[temp] > self.heap[right]:
            temp = right
        if temp == idx:
            return
        self.heap[idx], self.heap[temp] = self.heap[temp], self.heap[idx]
        self.bubbleDown(temp)

ob = MinHeap()
nums = [4, 6, 3, 9, 0, 1]
for num in nums:
    ob.insert(num)
    print(ob.heap)
for num in nums:
    print(ob.remove())
    print(ob.heap)

        
        
        