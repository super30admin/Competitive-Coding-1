
class MinHeap:
    def __init__(self):
        self.heap =[]
    
    # TimeComplexity: O(1)
    def getMin(self):
        return self.heap[0]
    
    # TimeComplexity:O(logn)
    def insert(self,num):
        self.heap.append(num)
        self.__heapUp(len(self.heap) - 1)
    
     # TimeComplexity:O(logn)
    def remove(self):
        self.heap[0],self.heap[-1] = self.heap[-1],self.heap[0]
        temp = self.heap.pop()
        self.__heapDown(0)
        return temp

    # Helper function to Recursively check the for the appended node position with its parent
    def __heapUp(self,index):
        if index == 0:
            return
        root = (index-1)//2
        if root > 0 and self.heap[root] > self.heap[index]:
            self.heap[root],self.heap[index] = self.heap[index],self.heap[root]
            self.__heapUp(root)
    
    # Helper function to Recursively check the root is set correctly
    def __headDown(self,index):
        left_child = index + 1
        right_child = index + 2
        temp = index
        if self.heap[left_child]< len(self.heap) and self.heap[left_child] < self.heap[index]:
            temp = left_child
        if self.heap[right_child]< len(self.heap) and self.heap[right_child] < self.heap[index]:
            temp = right_child 
        if temp == index:
            return
        self.heap[index],self.heap[temp] = self.heap[temp],self.heap[index]
        self.__headDown(temp)

obj = MinHeap
arr = [40,90,15,30]

for a in arr:
    obj.insert(a)
    print(obj.heap)
obj.getMin()
for a in arr:
    print(obj.remove())
    print(obj.heap)

